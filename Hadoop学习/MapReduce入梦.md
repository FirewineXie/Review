# MapRuce 入梦

## 第一章： MapReduce 概述

### 1.1 MapReduce 定义

> mapReduce 是一个==分布式运算程序的编程框架==，是用户开发“基于hadoop的数据分析应用的”核心框架
>
> 核心功能  是将==用户编写的业务逻辑代码==和==自带默认组件==整合成一个完整的==分布式运算程序==，并发运行在一个hadoop集群中。

### 1.2 mapReduce 优缺点

#### 优点

1. mapreduce 易于编程

   > ==简单的是实现一些借口，就可以完成一个分布式程序，==这个分布式程序可以分布到大量廉价的机器上运行 ，就是相当于写一个串行的程序一样

2. 良好的扩展性

   > 当计算资源不能得到满足的时候，就增加机器就完事了

3. 高容错性

   > 其中一台机器挂掉的话，它可以把上面的计算任务转移到另外一个结点上运行，不至于任务运行失败 

4. 适合PB级以上海量数据的离线处理 

#### 缺点

1. 不擅长实时计算

2. 不擅长流式计算

   > 流式计算的输入数据是动态的，而mapreduce 是数据数据是静态的

3. 不擅长DAG（有向图）计算

   > 多个应用 程序存在依赖关系，后一个应用程序的输入为前一个的输出，在这种情况下，MapReduce并不是不能做，而是使用后，==每个MapReduce作业的输出结果都会写入到磁盘，会造成大量的磁盘IO，导致性能非常的低下==

### 1.3  MapReduce 核心思想

> 案例需求 ： 统计其中每一个单词出现的总次数（查询结果：a-p一个文件，q-z一个文件）

![image-20201031130656938](img/image-20201031130656938.png)



### 1.4 MapReduce 进程

一个完整的MapReduce 程序在分布式运行时有三类实例进程：

1. MrAppMaster ： 负责整个程序的过程调度及状态协调
2. MapTask ： 负责Map阶段的整个数据处理流程
3. ReduceTask ： 负责Reduce 阶段的整个处理流程

### 1.5 官方的wordCount 的源码

### 1.6 常用的数据序列化类型

![image-20201031163455741](img/image-20201031163455741.png)

### 1.7 MapReduce 编程规范

#### mapper 阶段

1. 用户自定义的mapper 要继承自己的类
2. mapper 的输入数据是KV对的形式（KV类型可自定义）
3. mapper 中的业务逻辑写在map（）方法中
4. mapper 的输出数据是KV对的形式（可自定义）
5. ==map()方法（MapTASk）对每一个<K,V>调用一次==

#### Reducer 阶段

1. 用户自定义的mapper 要继承自己的类
2. Reducer的输入数据类型对应Mapper的输出数据类型，也是KV
3. Reducer的业务逻辑写在reduce方法中
4. ==ReduceTask进程对每一组相同的k的<k,V>组调用一次的reduce方法==

#### Driver 阶段

相当于YARN集群的客户端，用于提交我们整个程序到YARN集群，提交的是封装了MapReduce程序相关运行参数的job对象

![image-20201031191026231](img/image-20201031191026231.png)

### 1.8 wordCount 案例实操

> 统计单词出现次数，空格为分隔符

1. 新增maven 项目，添加依赖

   ```xml
     <dependencies>
           <dependency>
               <groupId>junit</groupId>
               <artifactId>junit</artifactId>
               <version>4.13</version>
               <scope>test</scope>
           </dependency>
           <dependency>
               <groupId>org.apache.logging.log4j</groupId>
               <artifactId>log4j</artifactId>
               <version>2.13.3</version>
               <type>pom</type>
           </dependency>
           <dependency>
               <groupId>org.apache.hadoop</groupId>
               <artifactId>hadoop-common</artifactId>
               <version>3.3.0</version>
           </dependency>
           <dependency>
               <groupId>org.apache.hadoop</groupId>
               <artifactId>hadoop-client</artifactId>
               <version>3.3.0</version>
           </dependency>
           <dependency>
               <groupId>org.apache.hadoop</groupId>
               <artifactId>hadoop-hdfs</artifactId>
               <version>3.3.0</version>
           </dependency>
       </dependencies>
   ```

2. log4j 输出

   ```properties
   log4j.rootLogger=INFO, stdout
   log4j.appender.stdout=org.apache.log4j.ConsoleAppender
   log4j.appender.stdout.layout=org.apache.log4j.PatternLayout
   log4j.appender.stdout.layout.ConversionPattern=%d %p [%c] - %m%n
   log4j.appender.logfile=org.apache.log4j.FileAppender
   log4j.appender.logfile.File=target/spring.log
   log4j.appender.logfile.layout=org.apache.log4j.PatternLayout
   log4j.appender.logfile.layout.ConversionPattern=%d %p [%c] - %m%n
   
   ```

3. 编写mapper类

   ```java
   package com.example.mr.wordcount;
   
   import org.apache.hadoop.io.IntWritable;
   import org.apache.hadoop.io.LongWritable;
   import org.apache.hadoop.io.Text;
   import org.apache.hadoop.mapreduce.Mapper;
   
   import java.io.IOException;
   
   /**
    * Created by IntelliJ IDEA.
    *
    * @author Firewine
    * @version 1.0
    * @ProgramName: WordcountMapper
    * @Create 2020/10/31
    * @Description: map 阶段
    *
    *  keyin 输入数据的key
    *  valuein 输入数据的value
    *   keyout 输出数据的类型
    *   valueOUT 输出的数据的value类型
    */
   
   public class WordCountMapper extends Mapper<LongWritable, Text, Text, IntWritable> {
       Text k = new Text();
       IntWritable v = new IntWritable(1);
   
       @Override
       protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
           //    ss ss
           //    1. 获取一行
           String line = value.toString();
           //    切割单词
           String[] words = line.split(" ");
   
           //    循环写出
           for (String word : words) {
   
               k.set(word);
               context.write(k, v);
           }
       }
   }
   
   ```

4. 编写reducer类

   ```java
   package com.example.mr.wordcount;
   
   import org.apache.hadoop.io.IntWritable;
   import org.apache.hadoop.io.Text;
   import org.apache.hadoop.mapreduce.Reducer;
   
   import java.io.IOException;
   
   /**
    * Created by IntelliJ IDEA.
    *
    * @author Firewine
    * @version 1.0
    * @ProgramName: WordCountReducer
    * @Create 2020/11/1
    * @Description:
    *
    * keyin ,valueIn map阶段输出的key和value
    */
   public class WordCountReducer extends Reducer<Text, IntWritable,Text,IntWritable> {
       IntWritable v = new IntWritable();
       @Override
       protected void reduce(Text key, Iterable<IntWritable> values, Context context) throws IOException, InterruptedException {
       //    ss 1
       //    ss 1
       //    1. 累加求和
           int sum= 0 ;
           for(IntWritable value:values){
               sum += value.get();
           }
           v.set(sum);
           //    2. 写出ss 2
           context.write(key,v);
       }
   }
   ```

5. 编写driver类

   ```java
   package com.example.mr.wordcount;
   
   import org.apache.hadoop.conf.Configuration;
   import org.apache.hadoop.fs.Path;
   import org.apache.hadoop.io.IntWritable;
   import org.apache.hadoop.io.Text;
   import org.apache.hadoop.mapreduce.Job;
   import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
   import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
   
   import java.io.IOException;
   
   /**
    * Created by IntelliJ IDEA.
    *
    * @author Firewine
    * @version 1.0
    * @ProgramName: WordCountDriver
    * @Create 2020/11/1
    * @Description:
    */
   public class WordCountDriver {
   
     public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
   
       args = new String[]{"F:/wordCount.txt","F:/demo"};
       Configuration conf = new Configuration();
       //    1. 获取job 对象
       Job job = Job.getInstance();
       //    2. 设置jar存储位置
       job.setJarByClass(WordCountDriver.class);
       //    3. 关联map和reduce类
       job.setMapperClass(WordCountMapper.class);
       job.setReducerClass(WordCountReducer.class);
       //    4. 设置mapper 阶段输出数组的key和value类型
       job.setMapOutputKeyClass(Text.class);
       job.setMapOutputValueClass(IntWritable.class);
   
       //    5. 设置最终数据输出的key 和value 类型
       job.setOutputKeyClass(Text.class);
       job.setOutputValueClass(IntWritable.class);
       //    6. 设置输入路径和输出路径
       FileInputFormat.setInputPaths(job,new Path(args[0]));
       FileOutputFormat.setOutputPath(job,new Path(args[1]));
       //    7. 调教job
       // job.submit();
       boolean result = job.waitForCompletion(true);
       System.exit(result ? 0 : 1);
     }
   }
   ```

6. 打包

   ```xml
     <build>
           <plugins>
               <plugin>
                   <artifactId>maven-compiler-plugin</artifactId>
                   <version>3.8.1</version>
                   <configuration>
                       <source>11</source>
                       <target>11</target>
                   </configuration>
               </plugin>
               <plugin>
                   <artifactId>maven-assembly-plugin</artifactId>
                   <configuration>
                       <descriptorRefs>
                           <descriptorRef>jar-with-dependencies</descriptorRef>
                       </descriptorRefs>
                       <archive>
                           <manifest>
                               <mainClass>com.example.mr.wordcount.WordCountDriver</mainClass>
                           </manifest>
                       </archive>
                   </configuration>
                   <executions>
                       <execution>
                           <id>make-assembly</id>
                           <phase>package</phase>
                           <goals>
                               <goal>single</goal>
                           </goals>
                       </execution>
                   </executions>
               </plugin>
           </plugins>
       </build>
       <properties>
           <!--编译编码-->
           <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
       </properties>
   ```

7. 执行

   ```shell
   hadoop jar wc.jar com.example.mr.wordcount.WordCountDriver inputpath outPath
   ```

## 第二章： Hadoop序列化

### 2.1 序列号概述

#### 什么是序列化

> 序列化就是把==内存中的对象，转换成字节序列==，（或其他数据传输协议）以便存储到磁盘和网络传输

> 反序列化就是将收到的字节序列（或其他数据传输协议）或者是==磁盘的持久化数据，转换成内存中对象==

#### 为什么要序列化

> 一般来说，活的对象只生存在内存里，关机断电就没有了，而且活的对象只能由本地的进程使用，不能被发送到网络上的另外一台计算。然而==序列化可以存储“活的”对象，可以将活的对象发送到远程计算机==

#### 为什么不用java序列化

> java 序列化是一个重量级序列化框架Serializable，会增加很多额外的数据，，
>
> hadoop 开发序列化机制Writable

##### hadoop序列化特点：

1. 紧凑 ： 高效实用存储空间
2. 快速：读写数据的额外开销小
3. 可扩展 ： 可以随着通信协议升级而升级
4. 互操作性 ： 多语言交互

### 2.2自定义bean对象实现序列化接口（Writable）

#### 具体实现bean独享序列化步骤如下7步：

1. 必须实现Writable 接口

2. 反序列化时，需要反射调用空参构造函数， 

3. 重写序列化方法

   ```java 
   @Override
   public void write(DataOutput out) throws IOException {
   	out.writeLong(upFlow);
   	out.writeLong(downFlow);
   	out.writeLong(sumFlow);
   }
   ```

4. 重写反序列化方法

   ```java 
   @Override
   public void readFields(DataInput in) throws IOException {
   	upFlow = in.readLong();
   	downFlow = in.readLong();
   	sumFlow = in.readLong();
   }
   ```

5. ==注意反序列化的顺序和序列化的顺序完全一致==

6. 要想把结果显示在文件中，需要重写toString()，可用”\t”分开，方便后续用。

7. 如果需要将自定义的bean放在key中传输，则还需要实现Comparable接口，因为MapReduce框中的Shuffle过程要求对key必须能排序。详见后面排序案例。

   ```java
   @Override
   public int compareTo(FlowBean o) {
   	// 倒序排列，从大到小
   	return this.sumFlow > o.getSumFlow() ? -1 : 1;
   }
   ```

### 2.3 序列化实操

#### 1. 需求

统计每一个手机号耗费的总上行流量，下行流量，总流量

![image-20201101233641913](img/image-20201101233641913.png)

#### 2. 实操

1. mapper 类

   ```java
   package com.example.mr.flowsum;
   
   import org.apache.hadoop.io.LongWritable;
   import org.apache.hadoop.io.Text;
   import org.apache.hadoop.mapreduce.Mapper;
   
   import java.io.IOException;
   
   /**
    * Created by IntelliJ IDEA.
    *
    * @author Firewine
    * @version 1.0 @ProgramName: FlowCountMapper @Create 2020/11/2 @Description:
    */
   public class FlowCountMapper extends Mapper<LongWritable, Text, Text, FlowBean> {
     Text k = new Text();
     FlowBean v = new FlowBean();
   
     @Override
     protected void map(LongWritable key, Text value, Context context)
         throws IOException, InterruptedException {
       // 7  phone  ip  1116 954  200
       //    1. 获取一行
       String line = value.toString();
   
       //    2. 切割\t
       String[] fields = line.split("\t");
   
       //    3. 封装对象
       //封装手机号
       k.set(fields[1]);
   
       long upFlow =Long.parseLong( fields[fields.length -3]);
       long downFlow =Long.parseLong( fields[fields.length -2]);
       v.setUpFlow(upFlow);
       v.setDownFlow(downFlow);
       // v.set(upFlow,downFlow);
   
       //    5. 写出
       context.write(k,v);
     }
   }
   
   ```

   

2. 序列化bean 类

   ```java
   package com.example.mr.flowsum;
   
   import org.apache.hadoop.io.Writable;
   
   import java.io.DataInput;
   import java.io.DataOutput;
   import java.io.IOException;
   
   /**
    * Created by IntelliJ IDEA.
    *
    * @author Firewine
    * @version 1.0 @ProgramName: FlowBean @Create 2020/11/2 @Description:
    */
   public class FlowBean implements Writable {
     /** 上行流量 */
     private long upFlow;
     /** 下行流量 */
     private long downFlow;
     /** 总流量 */
     private long sumFlow;
   
     /** 空参构造，为了后序反射 */
     public FlowBean() {
       super();
     }
   
     public FlowBean(long upFlow, long downFlow) {
       super();
       this.upFlow = upFlow;
       this.downFlow = downFlow;
       sumFlow = upFlow + downFlow;
     }
   
     /**
      * 序列化方法
      *
      * @param dataOutput
      * @throws IOException
      */
     @Override
     public void write(DataOutput dataOutput) throws IOException {
       dataOutput.writeLong(upFlow);
       dataOutput.writeLong(downFlow);
       dataOutput.writeLong(sumFlow);
     }
   
     /**
      * 反序列化方法
      *
      * @param dataInput
      * @throws IOException
      */
     @Override
     public void readFields(DataInput dataInput) throws IOException {
       //  必须和序列化方法顺序一致
       upFlow = dataInput.readLong();
       downFlow = dataInput.readLong();
       sumFlow = dataInput.readLong();
     }
   
     @Override
     public String toString() {
       return "FlowBean{"
           + "upFlow="
           + upFlow
           + ", downFlow="
           + downFlow
           + ", sumFlow="
           + sumFlow
           + '}';
     }
   
     public long getUpFlow() {
       return upFlow;
     }
   
     public void setUpFlow(long upFlow) {
       this.upFlow = upFlow;
     }
   
     public long getDownFlow() {
       return downFlow;
     }
   
     public void setDownFlow(long downFlow) {
       this.downFlow = downFlow;
     }
   
     public long getSumFlow() {
       return sumFlow;
     }
   
     public void setSumFlow(long sumFlow) {
       this.sumFlow = sumFlow;
     }
   
     public void set(long upFlow1, long downFlow1) {
   
      upFlow = upFlow1;
       downFlow = downFlow1;
       sumFlow = upFlow + downFlow;
     }
   }
   
   ```

   

3. reducer 类

   ```java
    package com.example.mr.flowsum;
   
   import org.apache.hadoop.io.Text;
   import org.apache.hadoop.mapreduce.Reducer;
   
   import java.io.IOException;
   
   /**
    * Created by IntelliJ IDEA.
    *
    * @author Firewine
    * @version 1.0
    * @ProgramName: FlowCountReducer
    * @Create 2020/11/2
    * @Description:
    */
   public class FlowCountReducer extends Reducer<Text,FlowBean,Text,FlowBean> {
       FlowBean v = new FlowBean();
       @Override
       protected void reduce(Text key, Iterable<FlowBean> values, Context context) throws IOException, InterruptedException {
   
           long sum_upFlow = 0;
           long sum_downFlow = 0;
       //    1. 累加求和
           for (FlowBean flowBean : values){
               sum_upFlow += flowBean.getUpFlow();
               sum_downFlow += flowBean.getDownFlow();
           }
   
           v.set(sum_upFlow,sum_downFlow);
           //    2. 写出
           context.write(key,v);
       }
   }
   
   ```

   

4. driver 类

   ```java
   package com.example.mr.flowsum;
   
   import org.apache.hadoop.conf.Configuration;
   import org.apache.hadoop.fs.Path;
   import org.apache.hadoop.io.Text;
   import org.apache.hadoop.mapreduce.Job;
   import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
   import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
   
   import java.io.IOException;
   
   /**
    * Created by IntelliJ IDEA.
    *
    * @author Firewine
    * @version 1.0 @ProgramName: FlowSumDriver @Create 2020/11/2 @Description:
    */
   public class FlowSumDriver {
   
     public static void main(String[] args)
         throws IOException, ClassNotFoundException, InterruptedException {
       args = new String[] {"F:/wordCount.txt", "F:/demo"};
       Configuration conf = new Configuration();
       // 1. 获取job对象
       Job job = Job.getInstance(conf);
       //    2. 设置jar路径
       job.setJarByClass(FlowSumDriver.class);
       //    3. 关联mapper ，reducer
       job.setMapperClass(FlowCountMapper.class);
       job.setReducerClass(FlowCountReducer.class);
       //    4. 设置mapper输出的key 和value
       job.setMapOutputKeyClass(Text.class);
       job.setMapOutputValueClass(FlowBean.class);
       //    5 设置最终输出的key和value类型
       job.setOutputKeyClass(Text.class);
       job.setOutputValueClass(FlowBean.class);
       //    6 设置输入输出路径
       FileInputFormat.setInputPaths(job, new Path(args[0]));
       FileOutputFormat.setOutputPath(job, new Path(args[1]));
       //    7 调价job
       boolean result = job.waitForCompletion(true);
   
       System.exit(result ? 0 : 1);
     }
   }
   
   ```

   

## 第三章 ： MapReduce框架原理

### 3.1 InputFormat 数据输入

#### 切片与MapTask 并行度决定机制

1. 问题引出

   > MapTask 的并行度决定Map阶段的任务处理并发度，进而应用到整个job的处理速度
   >
   > 但是并不是说开的越多越好，是根据数据的大小来合适匹配

2. MapTask 并行度决定机制

   - 数据块 ： Block 是HDFS 物理上把数据分成一块一块的
   - 数据切片： 数据切片只是在逻辑上对输入进行切片，并不会在磁盘上进行切片存储

   ![image-20201102213128061](img/image-20201102213128061.png)

   

#### job 提交流程源码和切片源码详解

1. job提交流程源码详解

```java
waitForCompletion()

submit();

// 1建立连接
	connect();	
		// 1）创建提交Job的代理
		new Cluster(getConfiguration());
			// （1）判断是本地yarn还是远程
			initialize(jobTrackAddr, conf); 

// 2 提交job
submitter.submitJobInternal(Job.this, cluster)
	// 1）创建给集群提交数据的Stag路径
	Path jobStagingArea = JobSubmissionFiles.getStagingDir(cluster, conf);

	// 2）获取jobid ，并创建Job路径
	JobID jobId = submitClient.getNewJobID();

	// 3）拷贝jar包到集群
copyAndConfigureFiles(job, submitJobDir);	
	rUploader.uploadFiles(job, jobSubmitDir);

// 4）计算切片，生成切片规划文件
writeSplits(job, submitJobDir);
		maps = writeNewSplits(job, jobSubmitDir);
		input.getSplits(job);

// 5）向Stag路径写XML配置文件
writeConf(conf, submitJobFile);
	conf.writeXml(out);

// 6）提交Job,返回提交状态
status = submitClient.submitJob(jobId, submitJobDir.toString(), job.getCredentials());

```

![image-20201102223101038](img/image-20201102223101038.png)

2. FileInputFormat 切片源码解析(input.getSplits(job))

   ![image-20201102223459365](img/image-20201102223459365.png)

   

#### FileInputFormat 切片机制

![image-20201102223757625](img/image-20201102223757625.png)

![image-20201102223827501](img/image-20201102223827501.png)

