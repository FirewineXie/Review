# go微服务入门到容器化实战



## 微服务基础介绍

### 什么是微服务

1. 是一种架构模式
2. 相比较单体架构，为微服务架构更独立，能够单独更新和发布
3. 微服务里面的服务仅仅用于某一个特定的业务功能

###  为什么需要微服务

1. 逻辑清晰
2. 快速迭代
3. 多语言灵活组合

### 微服务中的DDD是什么

1. 领域驱动设计（Domain Driven Design ，简称DDD ）
2. 还有个定律 ： 康威定律

#### DDD 的作用

> 真正决定软件复杂性的是设计方法

- 有助于指导我们确定系统边界
- 能够聚焦在系统核心元素上
- 帮助我们拆分系统

##### DDD 常用概念-领域

- 领域 ： 领域是有范围界限的，也可以说是有边界的
- 核心域 ： 核心域是业务系统的核心价值
- 通用子域的消费者，提供着通用服务
- 支撑子域： 专注于业务系统的某一重要的业务

##### DDD常用概念-界限上下文

- 理解 ： 语文中的语境的意思
- 方式： 领域 + 界限上下文
- 目的 ： **不在于如何划分边界，而在于如何控制边界**



##### DDD常用概念-领域模型

-  理解： 领域模型是对我们软件系统中要解决问题的抽象表达
- 领域： 反应的是我们业务上需要解决的问题
- 模型 ：我们针对该问题提供的解决方案



#### 微服务的设计原则上

- 要领域驱动设计，而不是数据驱动设计，也不是界面驱动设计
- 要边界清晰的微服务，而不是泥球小单体
- 要职能清晰的分层，而不是什么都放的大箩筐
- 要做自己能hold住的微服务，而不是过度拆分的微服务





## go-micro



### 基础： Grpc 和ProtoBuf



#### RPC 和gRPC 介绍

##### RPC 是什么

- RPC 代指远程过程调用
- 包含了传输协议和编码（对象序列号）协议
- 容许运行于一台计算机的程序调用另一台计算机的子程序

##### 使用RPC 的好处是什么

- 简单
- 通用
- 安全
- 效率

##### gRPC 是什么

- gRPC 是一个高性能、开源、通用的RPC 框架
- 基于HTTP2.0 协议标准开发
- 支持多语言，默认采用Protocol Buffers 数据序列化协议

##### 什么是Protocol Buffers

- 是一种轻便高效的序列化结构化数据的协议
- 通常用在存储数据和需要远程数据通信的程序上
- 跨语言，更小，更快，也更简单

##### 为什么使用Protocol BUffers

- 加速站点之间数据传输速度
- 解决数据传输不规范的问题

##### Protocol Buffers 常用概念

- Message定义： 描述了一个请求或响应的消息格式
- 字段标识： 消息的定义中，每个字段都有一个唯一的数值标签
- 常用数据类型 ： double ， float ， int32/64, bool , string ,bytes
- Service 服务定义： 在Service 中可以定义一个RPC 服务接口

ProtoBuf 及详细语法介绍

##### Protocol Buffers Message 中字段修饰符

- `singular` ： 表示成员有0个或者一个，一般省略不写
- `repeated` :  表示该字段可以包含0-N个元素

| **protobuf**属性 | **C++**属性 | **java**属性 | **备注**                                                     |
| ---------------- | ----------- | ------------ | ------------------------------------------------------------ |
| double           | double      | double       | 固定8个字节                                                  |
| float            | float       | float        | 固定4个字节                                                  |
| int32            | int32       | int32        | 使用变长编码，对于负数编码效率较低，如果经常使用负数，建议使用sint32 |
| int64            | int64       | int64        | 使用变长编码，对于负数编码效率较低，如果经常使用负数，建议使用sint64 |
| uint32           | uint32      | int          | 使用变长编码                                                 |
| uint64           | uint64      | long         | 使用变长编码                                                 |
| sint32           | int32       | int          | 采用zigzag压缩，对负数编码效率比int32高                      |
| sint64           | int64       | long         | 采用zigzag压缩，对负数编码效率比int64高                      |
| fixed32          | uint32      | int          | 总是4字节，如果数据>2^28，编码效率高于unit32                 |
| fixed64          | uint64      | long         | 总是8字节，如果数据>2^56，编码效率高于unit32                 |
| sfixed32         | int32       | int          | 总是4字节                                                    |
| sfixed64         | int64       | long         | 总是8字节                                                    |
| bool             | bool        | boolean      |                                                              |
| string           | string      | String       | 一个字符串必须是utf-8编码或者7-bit的ascii编码的文本          |
| bytes            | string      | ByteString   | 可能包含任意顺序的字节数据                                   |

#### 

#### Docker 使用Proto 生成go 文件

#### 动手实践

```cmd
$ docker pull cap1573/cap-protoc
$ docker run --rm -v ${PWD}:${PWD} -w ${PWD} \
-e ICODE=CF388DF1EF1C5EB cap1573/cap-protoc \ 
-I ./ --go_out=./ --micro_out=./ ./*.proto
# 使用docker 根据proto 文件生成微服务文件
```

##### 或者采用Proto 生成go文件，

```protobuf
syntax = "proto3"; //版本

// 常用顺序位置为1-15，超过15 以两个字节去存储

// 定义的服务
service Greeter {
	rpc Hello(Request) returns (Response) {}
}

message Request {
	string name = 1;
}

message Response {
	string greeting = 2;
}

```

```cmd
// 执行命令生成go文件
    protoc --proto_path=$GOPATH/src:. --micro_out=. --go_out=. greeter.proto
```





### go-micro 组件架构及通讯原理



#### micro 是什么

- 用来构建和管理分布式程序的系统
- Runtime(运行时)  ： 用来管理配置，认证，网络等
- Framework（程序开发框架） ： 用来方便编写微服务
- Clients(多语言客户端) ： 支持多语言访问客户端

##### Runtime（运行时） 介绍

- 他是工具集，工具名称是“micro”
- 官方docker 版本是 docker pull  micro/micro
- 课程扩展版本是 docker pull cap1573/cap-micro

##### Runtime(运行时) 组成

- api ： api网关
- broker ： 允许异步消息的消息代理
- network ： 通过为网络服务构建多云网络
- new ： 服务模板生成器
- proxy ： 建立在go MICRO 上的透明服务代理
- registry ： 一个服务资源管理器
- store ： 简单的状态存储
- web ： web 仪表盘容许你浏览服务

  
#### go-micro 有哪些核心知识点

##### Framework(go-micro) 介绍

- 他是对分布式系统的高度抽象
- 提供分布式系统开发的核心库
- 可插拔的架构，按需使用

##### Framework 组件

- 注册 ： 提供了服务发现机制
- 选择器 ： 能够实现负载均衡
- 传输： 服务与服务之间通信接口
- Broker ： 提供异步通信的消息发布/订阅接口
- 编码（Codec) : 消息传输到两端时进行编码与解码
- Server（服务端） ，Client 客户端

##### Framework 组件架构图

###### service

| client   |          | service   |
| -------- | -------- | --------- |
| Registry | Selector | transport |
| broker   |          | Codec     |
|          |          |           |

![20210223204950](G:\Review\Go容器化开发从入门到实战\img\20210223204950.png)



#### go-micro 简单Hello World

`server.go` 服务端

```go
package main

import (
	"context"
	"github.com/asim/go-micro/v3"
	"google.golang.org/grpc"
	"log"
	"time"

	pb "newmicro/proto"

)

type StreamGreeterH struct{}

//需要实现的方法
func (c *StreamGreeterH) Hello(ctx context.Context,
	req *pb.Request, resp *pb.Response) error {
	// 业务逻辑代码
	resp.Greeting = "我们的口号是 ：\" " + req.Name + "\""

	return nil
}

func main() {
	go func() {
		for {
			grpc.DialContext(context.Background(), "127.0.0.1:9091")
			time.Sleep(time.Second)
		}
	}()
	service := micro.NewService(
		micro.Name("helloWorld"),
	)

	service.Init()

	pb.RegisterGreeterHandler(service.Server(), new(StreamGreeterH))


	if err := service.Run(); err != nil {
		log.Fatal(err)
	}
}

```

`client.go`客户端

```go
package main

import (
	"context"
	"fmt"
	"github.com/asim/go-micro/v3"
	"time"
	pb "newmicro/proto"

)

func main() {
	// 创建并初始化一个新的服务
	service := micro.NewService()

	service.Init()
	// create the proto client for helloWorld
	client := pb.NewGreeterService("helloWorld", service.Client())

	// call an endpoint on the service
	rsp, err := client.Hello(context.Background(), &pb.Request{
		Name: "John",
	})
	if err != nil {
		fmt.Println("Error calling helloWorld: ", err)
		return
	}

	// 打印响应内容
	fmt.Println("Response: ", rsp.Greeting)

	// let's delay the process for exiting for reasons you'll see below
	time.Sleep(time.Second * 5)
}
```





#### micro new 和项目目录搭建



1. 从官网下载`micro.exe` 文件

2. 运行命令

   >  micro new user

   

## 用户功能梳理及开发

### 用户领域需求分析

#### 用户信息管理

#### 用户登录，注册

#### 用户鉴权



## dockerfile 打包user功能

### dockerfile是什么

> 1. 是用来构建镜像的文本文件
> 2. 文本内容包含了构建镜像所需的指令和说明

### DockerFile 常用的指令

- FROM ： 定制的镜像都是基于FROM的镜像，后序的操作都是基于这个镜像
- RUN ： 用于执行后面跟着的命名行命令
- COPY，ADD ： 复制指令，从文件或者目录到容器里指定路径
- CMD，ENTRYPOINT ： 用于运行程序
- ENV ： 设置环境变量
- EXPOSE ： 声明端口
- WORKDIR ： 指定工作目录
- USER ：指定执行后序命令的用户和用户组





###  在window下编译linux 下的执行文件go

> CGO_ENABLED=0 GOOS=linux GOARCH=amd64 go build --o user *.go





## 微服务必备注册中心和配置中心



### 注册中心和配置中心原理介绍

#### 注册中心Consul 原理介绍

##### Consul 基本介绍

- Consul 是一种服务网格解决方案
- 提供具有 服务发现，配置和分段功能的全功能控制平面
- Consul 附带一个简单的内置代理，可以开箱即用

##### Consul 关键功能

- 服务发现： 客户端可以注册服务，程序可以轻松找到他们所依赖的服务
- 运行状况检查： Consul 客户端可以提供任意数量的运行状况检查
- KV存储  ： 应用程序可以将Consul 的层级建/值存储用于任何目的，包括动态配置，功能标记，协调，领导者选举等。
- 安全服务通信： Consul 可以为服务生成和分发TLS正式，建立相互的TLS连接
- 多数据中心：Consul 支持多个数据中心

##### 集群架构

![2](G:\Review\Go容器化开发从入门到实战\img\2.png)

##### 两个重要协议

###### Gossip Protocol  八卦协议

1. 协议局域网池 LAN Pool

   > - 让lcient 自动发现Server 结点，减少所需的配置量
   > - 分布式故障检测在某几个Server 机上执行
   > - 能够用来快速的广播事件

2. 协议广域网池 WAN Pool

   > - WAN Pool 全局唯一的
   > - 不同数据中心的Server  都会加如 WAN Pool
   > - 允许服务器执行跨数据中心请求

- Raft Protocol  选举协议

### 代码演示

Catagory

## 链路追踪 jaeger

> 用来监视和诊断基于微服务的分布式系统

- 用于服务依赖性分析，辅助性能优化

### 主要特性

- 高扩展性
- 原生支持 `OpenTracing`
- 可观察性

#### 术语- Span

- Jaeger 中的逻辑工作单元
- 具有操作名称，操作的开始时间和持续时间
- 跨度可以嵌套并排序以建立因果关系模型

##### 术语- Span 抱含的对象

- Operation  name 
- `and so on`

### 五个重要组件

- Jaeger-client 客户端库
- Agent 客户端代理
- Collector  数据收集处理
- Data Store  数据存储
- UI  数据查询与前端界面显示

### 端口说明

| 端口  | 协议 | 所属模块  | 功能                                            |
| ----- | ---- | --------- | ----------------------------------------------- |
| 5775  | UDP  | agent     | 通过兼容性Thrift协议，介绍Zipkin thrift类型数据 |
| 6831  | UDP  | agent     | 通过兼容性Thrift协议，介绍Zipkin thrift类型数据 |
| 6832  | UDP  | agent     | 通过兼容性Thrift协议，介绍Zipkin thrift类型数据 |
| 5778  | HTTP | query     | 配置控制服务接口                                |
| 16686 | HTTP | collector | 客户端前端界面展示端口                          |
| 14268 | HTTP | collector | 接收客户端Zipkin thrift 类型数据                |
| 14267 | HTTP | collector | 接收客户端Jaeger thrift 类型数据                |
| 9411  | HTTP | collector | zipkin 兼容endpoint                             |



### 代码演示

product







## 熔断器：熔断、限流、负载均衡



### 微服务熔断 - （hystrix-go)



#### 熔断的作用



##### 什么是服务雪崩效应？

> 当一个服务不可用的时候，引起连锁反应，导致多个服务不可使用



##### 熔断的目标

1. 阻止故障的连锁反应
2. 快速失败并迅速恢复
3. 回退并优雅降级
4. 提供近实时的监控与告警

##### 使用过程中一些原则

1. 防止任何单独的依赖耗尽资源（线程）
2. 过载立即切断并快速失败，防止排队
3. 尽可能提供回退以保护用户免受故障
4. 通过近实时的指标，监控和告警，确保故障被及时发现

##### 熔断的请求原理

![请求原理图](G:\Review\Go容器化开发从入门到实战\img\请求原理图.jpg)



### 微服务限流

#### 限流的作用

1. 限制流量，在服务端生效
2. 保护后端服务
3. 与熔断互补

#### 限流（uber/limit) 漏桶算法原理



### 微服务负载均衡

#### 负载均衡作用

1. 提高系统扩展性
2. 支持：HTTP、HTTPS、TCP、UDP 请求
3. 主要算法： 循环算法和随机算法，默认随机算法



### 微服务API网关

#### 架构图

![QQ图片20210303205424](G:\Review\Go容器化开发从入门到实战\img\QQ图片20210303205424.jpg)

1. 第一层 ： micro api网关
2. 第二层： 聚合业务层
3. 第三层： 基础服务层

### 主要代码

CartAPi

