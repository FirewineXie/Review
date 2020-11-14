# Gradle 学习



## 定制项目

### 修改项目和插件属性

```groovy
version = 0.1   //定义项目版本
sourceCOmpatibility = 1.6   // 设置java版本编译兼容
jar {
    manifest {
    	attributes 'Main-Calss': 'mainPackage' //将main-class头添加到JaR文件代码清单中
    }
}
```

### 改变项目默认结构

```groovy
sourceSets {
    main {
        java {
            srcDirs = {'src'}  //用不同目录的列表代替约定的源代码目录
        }
    }
    test {
        java {
            srcDirs = {'test'}  //用不同目录的列表代替约定的测试代码目录
        }
    }
}
buildDir = 'out'  //改变项目输出路径到out目录下
```

### 配置和使用外部依赖

#### 定义仓库

```groovy
repositoris {
	mavenCentral() //配置对maven中央仓库的访问快捷方式
}
```

#### 定义依赖

```grooovy
dependencies {
	compile group : 'org.apache.commons','name':'commons-lang3',version:'3.1'
}
```





## Gradle 包装器

> 是Gradle 的核心特定，能够让机器在没有安装Gradle 运行时的情况下运行Gradle构建，

### 配置包管理器

```groovy
task wrapper (type : Wrapper){
	gradleVersion = '1.7'  //将包装器任务添加到构建脚本中
}
war
jar
tasks.withType(JavaCompile) {
    options.encoding = "UTF-8"
}
```

### 使用包装器

> 使用叫一个 gradlew  的名称 ，使用他们运行构建和使用已安装的Gradle 运行时运行构建时一样的



### 定制包装器

```groovy
task wrapper(type :Wrapper){
	gradleVersion = '1.2'  // 请求gradle 版本
    distributionUrl = 'http://myenterprise.com/gradle/dists' //获取gradle 包装器的url
    distributionPath = 'gradle-dists' //包装器被解压缩后存放的相对路径
}
```

