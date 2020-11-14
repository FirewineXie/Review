# gradle 学习



## Gradle 基础

### Gradle 的基础概念

#### Distribution

> 

#### Wrapper

#### GradleUserHome

#### Daemon

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

#### Task

#### Lifecycle 与 Hook