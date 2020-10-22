# gRPC 学习



处理json请求使用iris框架，一是生成api接口，而是远程调用发现rpc

使用zookeeper 单机来作为服务发现，

远程服务使用原生goRPC来创建服务注册和业务处理

## 客户端

### 首先根据数据要求构建proto文件

例如：

```proto
syntax = "proto3";


package companyIntro;
//option go_package= "";
service companyIntro{
  rpc GetI (RequestGetI) returns (ResponseGetI){}
  rpc GetAll(RequestGetAll) returns (ResponseGetAll){}
}



// getAll 的req 和resp
message RequestGetAll{
  int32 Status = 1;
  Page page = 2;
}

message ResponseGetAll{
  repeated CompanyIntro companyIntro = 1;
  Page page = 2;
}


// 分页数据
message Page{
  int32 PageNum = 1;
  int32 PageSize = 2;
  int32 Total = 3;
  int32 PageTotal = 4;
}

// 结构体
message CompanyIntro{
  int64  Id = 1;
  string Title = 2;
  string Content =3;
  int32 Status = 4;
  int64 SeqNo = 5;
}

// GetI 的 req and resp
message RequestGetI{

}


message ResponseGetI{
  repeated CompanyIntro companyIntro = 1;
  Page page = 2;

}

```

上面这个proto文件，包含了两个远程调用方法，而每个远程调用方法都必须含有req和res 作为请求和返回的载体。

### 实现远程调用

1. basePath 为zookeeper的路径，而GetI为你想要调用的方法。，
2. 这个只要与服务端保持一致就可以了

```go

var (
	zkAddr   = flag.String("zkAddr", "192.168.60.190:2181", "zookeeper address")
	basePath = flag.String("base", "/home/companyIntro", "prefix path")
	xclient  client.XClient
)


func GetI(ctx iris.Context) {
	flag.Parse()
	d := client.NewZookeeperDiscovery(*basePath, "GetI", []string{*zkAddr}, nil)

	xclient = client.NewXClient("GetI", client.Failtry, client.RandomSelect, d, client.DefaultOption)

	args := &example.RequestGetI{}
	reply := &example.ResponseGetI{}
	err := xclient.Call(context.Background(), "GetI", args, reply)
	if err != nil{
		log.Println("failed to call: %v",err)
		xclient.Close()
	}
	defer xclient.Close()
	log.Println(reply.String())
	marshal, err := json.Marshal(reply.String())
	//log.Println(reply.CompanyIntro,marshal)
	log.Println(marshal)
	ctx.JSON(reply.String())

}
func GetAll(ctx iris.Context) {
	flag.Parse()
	d := client.NewZookeeperDiscovery(*basePath, "GetAll", []string{*zkAddr}, nil)

	xclient = client.NewXClient("GetAll", client.Failtry, client.RandomSelect, d, client.DefaultOption)

	args := &example.RequestGetAll{
		Status: 1,
		Page: &example.Page{
			PageNum: 1,
			PageSize: 20,
		},
	}
	reply := &example.ResponseGetAll{}
	err := xclient.Call(context.Background(), "GetAll", args, reply)
	if err != nil{
		log.Println("failed to call: %v",err)
		xclient.Close()
	}
	defer xclient.Close()
	log.Println(reply.String())
	marshal, err := json.Marshal(reply.String())
	//log.Println(reply.CompanyIntro,marshal)
	log.Println(marshal)
	ctx.JSON(reply.String())

}

```

## 服务端

1. main方法代码，主要作用为服务注册到zookeeper中，
2. 我这里为了方便，地址都是写死的，可以使用yml文件读取，可以实现灵活配置

```go

var (
	addr     = flag.String("addr", "localhost:8972", "server address")
	zkAddr   = flag.String("zkAddr", "192.168.60.190:2181", "zookeeper address")
	basePath = flag.String("base", "/home/companyIntro", "prefix path")
)

func main() {

	db := mysql.DB
	defer func() {
		_ = db.Close()
	}()

	repo.Intro = repo.NewCompanyIntro(db)
	flag.Parse()

	s := server.NewServer()
	addRegistryPlugin(s)

	if err := s.RegisterFunctionName("GetI", "GetI", repo.GetI,"");err != nil{
		log.Println(err)
	}
	if err := s.RegisterFunctionName("GetAll", "GetAll",repo.GetAll, "");err != nil{
		log.Println(err)
	}
}
func addRegistryPlugin(s *server.Server) {

	r := &serverplugin.ZooKeeperRegisterPlugin{
		ServiceAddress:   "tcp@" + *addr,
		ZooKeeperServers: []string{*zkAddr},
		BasePath:         *basePath,
		Metrics:          metrics.NewRegistry(),
		UpdateInterval:   time.Minute,
	}
	err := r.Start()
	if err != nil {
		log.Fatal(err)
	}
	s.Plugins.Add(r)
}
```

```go

var Intro *CompanyIntroRepo

/*type GetI int
type GetAll int*/
func  GetI(ctx context.Context, args *example.RequestGetI, reply *example.ResponseGetI) error {

	all, err := Intro.SelectIAll()
	if err != nil {
		log.Fatal(err)
	}
	reply.CompanyIntro = all
	fmt.Printf("call: request - %v ,\n response - %v", args, reply)
	return nil
}
```



