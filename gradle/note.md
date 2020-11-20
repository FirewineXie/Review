# gradle 学习



## Gradle 基础

### Gradle 的基础概念

#### Distribution 安装包

> gradle 有三种安装包
>
> 1. bin 只有执行
> 2. all  所有
> 3. src 包含源代码

#### Wrapper

>获得的好处：
>
>- 在给定的Gradle版本上标准化项目，从而实现更可靠，更可靠的构建。
>- 向不同的用户和执行环境（例如IDE或Continuous Integration服务器）提供新的Gradle版本就像更改包装器定义一样简单。

>目的： 
>
>- 是将项目的中使用的gradle版本固定住
>- 自动下载所需要的gradle 版本

#### GradleUserHome

> 默认 的路径是   /.gradle/
>
> - 放到init.d   将脚本放到这里，会全局替换，例如替换依赖源
> - caches 类似是maven 的.m2 但是不只有依赖（但是会自动清理）

#### Daemon

> 目的： 不用重新读取大量的依赖jar，只需要client JVM 连接Deamon JVM，减少开销

>具有一定的兼容性质：
>
>- 在一定的条件下，可以连接同一个。
>- 例如 需要内容5G，daemon 只有2G ，这样的变化，才会重新生成一个deamon
>
>Deamon 空闲的Deamon 会在3个小时消耗
>
>如果不喜欢Damon 
>
>使用参数 --no-daemon 来不使用deamon—建议使用

### Groovy基础

> groovy in action 2  推荐书本

> groovy 就是 运行在JVM 上的脚本语言
>
> 是强类型但是是动态调用的


#### 动态调用与MOP
Groovy 使用

```groovy
List l = []
Map m = [a:1]
class A{
	int a
    void printA(){
    	printLn(a)
    }
}
// java ： invokedynamic
new A(a:1).printA()
// Groovy :MOP
def a  = new A(a:1)

@CompileStatic //不加是动态调用，加了是跟java一样静态调用
invokeMethod(a,"printA",[])

a['printA']()
```

#### 闭包

```groovy
List a = [1,2,3,4,5]
//过滤奇数
// java 不用流
for ()int e:list){
    if (e%2 != 0){
    result.add(e)
    }
}

list.stream().fiter().collect()//使用流


groovy 闭包
def closure = {param -> return param + 1}

println(closure{2})


list.findALL(it % 2 != 0 )



```



## Gradle 构建

### Gradle 的核心模型

#### Project

> 项目： 每一个构建都是由一个或多个projects 构成的，一个project 代表一个jar或者一个网页应该，是代表一件要做的事情

#### Task

> 每一个project 是由一个或多个tasks构成的，一个task 代表一些更加细化的构建。可能是编译一些classes，创建一个jar，生成javadoc

#### Lifecycle 与 Hook





## 插件编写（就是逻辑的打包）

### 一个基础的java项目

```gradle
apply plugin: 'java'
```

它将会把 Java 插件加入到你的项目中,  这意味着许多预定制的任务会被自动加入到你的项目里

> Gradle 默认在 **src/main/java** 目录下寻找到你的正式（生产）源码, 在 **src/test/java** 目录下寻找到你的测试源码, 并在**src/main/resources**目录下寻找到你准备打包进jar的资源文件。测试代码会被加入到环境变量中设置的目录里运行。所有的输出文件都会被创建在构建目录里, 生成的JAR文件会被存放在 **build/libs** 目录下

### 外部的依赖

```gradle
// 加入maven仓库
repositories{
	mavenCentral()  // maven 的中央仓库
}
// 加入依赖
dependencies {
	testCompile group: 'junit', name: 'junit', version: '4.+'
}
```



### 定制项目

#### 定制MANIFEST.MF 文件

```gradle
sourceCompatibility = 1.5
version = '1.0'
jar {
    manifest {
        attributes 'Implementation-Title': 'Gradle Quickstart', 'Implementation-Version': version
    }
}
```

#### 发布jar 文件

```gradle
uploadArchives {
    repositories {
       flatDir {
           dirs 'repos'
       }
    }
}
```

### 多项目的java构建



#### 构建布局

```txt
multiproject/
	api/
	service/webservice/
	shard/
```



#### 设置setting.gradle

```gradle
include "shared" ,"api","services:webservice","services:shared"
```

#### 项目之间的依赖

```gradle
dependencies {
    compile project(':shared')
}
```

