# docker-Elasticsearch 集群搭建

## 先搭建测试环境

### 1. 关闭防火墙

### 2. 同步每个节点的配置文件(只标注改动部分)

###### 1. node184

```yml
cluster.name: bigdata
node.master: true
node.data: true
node.name: node184
network.host: 0.0.0.0
network.publish_host: 192.168.20.184
# 每个节点中，是要补充其余节点的ip地址(为了方便可以都写)
discovery.seed_hosts: ["192.168.20.114","192.168.20.190"]
cluster.initial_master_nodes: ["192.168.20.184:9300"] #可以 不用指定端口号
discovery.zen.minimum_master_nodes: 1
# 配置数据收集
xpack.monitoring.collection.enabled: true
#下面是head插件的所需要的
http.cors.enabled: true
http.cors.allow-origin: "*"
```

######  2. node190

```yml
cluster.name: bigdata
node.master: true
node.data: true
node.name: node190
network.host: 0.0.0.0
network.publish_host: 192.168.20.190 
discovery.seed_hosts: ["192.168.20.184","192.168.20.114"]
cluster.initial_master_nodes: ["192.168.20.114"]
discovery.zen.minimum_master_nodes: 1
http.cors.enabled: true
http.cors.allow-origin: "*"
```

###### node114

```yml
cluster.name: bigdata
node.master: true
node.data: true
node.name: node190
network.host: 0.0.0.0
network.publish_host: 192.168.20.190 
discovery.seed_hosts: ["192.168.20.184","192.168.20.190"]
cluster.initial_master_nodes: ["192.168.20.114"]
# 发现集群中，最小master 的数量
discovery.zen.minimum_master_nodes: 1
http.cors.enabled: true
http.cors.allow-origin: "*"
```



### 3. 启动命令

```shell
docker run \
        -p 9200:9200 \
        -p 9300:9300 \
    -v /data/elasticsearch/config/:/usr/share/elasticsearch/config/  \
    -v /data/elasticsearch/data:/usr/share/elasticsearch/data \
    -v /data/elasticsearch/logs:/usr/share/elasticsearch/logs \
    -v /data/elasticsearch/plugins:/usr/share/elasticsearch/plugins \
    --name elasticsearch    \
    elasticsearch:7.7.0
```

### 4. 注意事项

#### 1) 节点版本必须保持一致

#### 2) 配置文件，保持一致（除了必须要改动的ip地址等）

#### 3) 尽量使用IP地址填写，填写node-name查找集群，不能查找到

###### 4) 启动出现限制问题,添加如下配置

```conf
1. vi /etc/security/limits.conf
* soft nofile 65536
* hard nofile 65536
2. vi /etc/security/limits.conf
* soft nproc 4096
* hard nproc 4096
3. vi /etc/sysctl.conf (添加配置文件，没有生效，可以命令设置)
vm.max_map_count=262144
执行命令：
sysctl -w vm.max_map_count=262144
查看结果：
sysctl -a|grep vm.max_map_count
```
###### 5) 注意，不要删除节点运行的data，logs 映射到本机的文件夹，如果删除，会出现无权限写入，只能手动更改

###### 6) 报错uuid不一致，删除data下的nodes 数据。

### 5. 开发环境配置（防火墙）

1. 需要增加rich - rules,不然，结点无法访问到端口数据(这种是锁死ip地址)

   ```shell
   firewall-cmd --permanent --add-rich-rule 'rule family=ipv4 source address=192.168.20.114 port port=9300 protocol=tcp accept'
   
   firewall-cmd --permanent --add-rich-rule 'rule family=ipv4 source address=192.168.20.190 port port=9300 protocol=tcp accept'
   ```

2. rich-rules 通过开发端口，容许所有ip 都可以访问

#  kibana-docker 配置

## 1. 配置文件

```yml
server.name: kibana
server.host: "0.0.0.0"
elasticsearch.hosts: ["http://172.17.0.1:9200"]
```

## 2. 启动命令

```shell
docker run -p 5601:5601    -v /data/kibana/config/:/usr/share/kibana/config/   -v /data/kibana/logs/:/usr/share/kibana/logs/ --name kibana kibana:7.7.0
```

### 3. 注意事项

1. 连接es的结点的ip地址，可以监听docker 的网卡，也可以监听物理网卡，视情况而定