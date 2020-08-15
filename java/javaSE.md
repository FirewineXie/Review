# java基础



## 1. 请你讲讲数组(Array)和列表(ArrayList)的区别？什么时候应该使用Array而不是ArrayList？

Array和ArrayList的不同点： 
 Array可以包含基本类型和对象类型，ArrayList只能包含对象类型。 
 Array大小是固定的，ArrayList的大小是动态变化的。 
 ArrayList提供了更多的方法和特性，比如：addAll()，removeAll()，iterator()等等。 
 对于基本类型数据，集合使用自动装箱来减少编码工作量。但是，当处理固定大小的基本数据类型的时候，这种方式相对比较慢。



## 2. 请你解释什么是值传递和引用传递？

值传递是对基本型变量而言的,传递的是该变量的一个副本,改变副本不影响原变量. 
 引用传递一般是对于对象型变量而言的,传递的是该对象地址的一个副本, 并不是原对象本身 。 所以对引用对象进行操作会同时改变原对象. 
 一般认为,java内的传递都是值传递. 



## 3. 你知道java8的新特性吗，请简单介绍一下

  Lambda 表达式 − Lambda允许把函数作为一个方法的参数（函数作为参数传递进方法中。 

  方法引用− 方法引用提供了非常有用的语法，可以直接引用已有Java类或对象（实例）的方法或构造器。与lambda联合使用，方法引用可以使语言的构造更紧凑简洁，减少冗余代码。 

  默认方法− 默认方法就是一个在接口里面有了一个实现的方法。 

  新工具− 新的编译工具，如：Nashorn引擎 jjs、 类依赖分析器jdeps。 

  Stream API −新添加的Stream API（java.util.stream） 把真正的函数式编程风格引入到Java中。 

  Date Time API − 加强对日期与时间的处理。 

  Optional 类 − Optional 类已经成为 Java 8 类库的一部分，用来解决空指针异常。 

  Nashorn, JavaScript 引擎 − Java 8提供了一个新的Nashorn javascript引擎，它允许我们在JVM上运行特定的javascript应用。 

## 4. == 与equals  的区别

1、功能不同

"=="是判断两个变量或实例是不是指向同一个内存空间。

"equals"是判断两个变量或实例所指向的内存空间的值是不是相同。

2、定义不同

"equals"在JAVA中是一个方法。

"=="在JAVA中只是一个运算符合。

# 关键字

## final

当用final修饰一个类时，表明这个类不能被继承。

final类中的成员变量可以根据需要设为final，但是要注意final类中的所有成员方法都会被隐式地指定为final方法。 

“使用final方法的原因有两个。第一个原因是把方法锁定，以防任何继承类修改它的含义；第二个原因是效率。在早期的Java实现版本中，会将final方法转为内嵌调用。但是如果方法过于庞大，可能看不到内嵌调用带来的任何性能提升。在最近的Java版本中，不需要使用final方法进行这些优化了。“ 

对于一个final变量，如果是基本数据类型的变量，则其数值一旦在初始化之后便不能更改；如果是引用类型的变量，则在对其初始化之后便不能再让其指向另一个对象。 

## 请你谈谈关于Synchronized和lock

Lock是一个接口，而synchronized是Java中的关键字，synchronized是内置的语言实现；synchronized在发生异常时，会自动释放线程占有的锁，因此不会导致死锁现象发生；而Lock在发生异常时，如果没有主动通过unLock()去释放锁，则很可能造成死锁现象，因此使用Lock时需要在finally块中释放锁；Lock可以让等待锁的线程响应中断，而synchronized却不行，使用synchronized时，等待的线程会一直等待下去，不能够响应中断；通过Lock可以知道有没有成功获取锁，而synchronized却无法办到。 



## 请你介绍一下volatile？    

volatile关键字是用来保证有序性和可见性的。

其中有条就是volatile变量规则：对一个变量的写操作先行发生于后面对这个变量的读操作；有序性实现的是通过插入内存屏障来保证的。可见性：首先Java内存模型分为，主内存，工作内存。比如线程A从主内存把变量从主内存读到了自己的工作内存中，做了加1的操作，但是此时没有将i的最新值刷新会主内存中，线程B此时读到的还是i的旧值



## 请你介绍一下Syncronized锁，如果用这个关键字修饰一个静态方法，锁住了什么？如果修饰成员方法，锁住了什么？

synchronized修饰静态方法以及同步代码块的synchronized (类.class)用法锁的是类，线程想要执行对应同步代码，需要获得类锁。
 synchronized修饰成员方法，线程获取的是当前调用该方法的对象实例的对象锁。



# 面向对象

## 若对一个类不重写，它的equals()方法是如何比较的？    

比较的是对象的地址



## 请解释hashCode 和 equal 方法有什么联系

  Java对象的eqauls方法和hashCode方法是这样规定的： 

  ➀相等（相同）的对象必须具有相等的哈希码（或者散列码）。 

  ➁如果两个对象的hashCode相同，它们并不一定相同。 

##  请解释Java中的概念，什么是构造函数？什么是构造函数重载？什么是复制构造函数？

当新对象被创建的时候，构造函数会被调用。每一个类都有构造函数。在程序员没有给类提供构造函数的情况下，Java编译器会为这个类创建一个默认的构造函数。 
 Java中构造函数重载和方法重载很相似。可以为一个类创建多个构造函数。每一个构造函数必须有它自己唯一的参数列表。 
 Java不支持像C++中那样的复制构造函数，这个不同点是因为如果你不自己写构造函数的情况下，Java不会创建默认的复制构造函数。 

## 请说明Query接口的list方法和iterate方法有什么区别？

①list()方法无法利用一级缓存和二级缓存（对缓存只写不读），它只能在开启查询缓存的前提下使用查询缓存；iterate()方法可以充分利用缓存，如果目标数据只读或者读取频繁，使用iterate()方法可以减少性能开销。
 ② list()方法不会引起N+1查询问题，而iterate()方法可能引起N+1查询问题 

## 请你谈一下面向对象的"六原则一法则"。

\- 单一职责原则：一个类只做它该做的事情。

\-  开闭原则：软件实体应当对扩展开放，对修改关闭。（在理想的状态下，当我们需要为一个软件系统增加新功能时，只需要从原来的系统派生出一些新类就可以，不需要修改原来的任何一行代码。要做到开闭有两个要点：①抽象是关键，一个系统中如果没有抽象类或接口系统就没有扩展点；②封装可变性，将系统中的各种可变因素封装到一个继承结构中，如果多个可变因素混杂在一起，系统将变得复杂而换乱，如果不清楚如何封装可变性，）

\- 依赖倒转原则：面向接口编程。

\- 接口隔离原则：接口要小而专，绝不能大而全。

\- 合成聚合复用原则：优先使用聚合或合成关系复用代码。

\- 迪米特法则：迪米特法则又叫最少知识原则，一个对象应当对其他对象有尽可能少的了解。

## 请你讲讲abstract class和interface有什么区别?

  声明方法的存在而不去实现它的类被叫做==抽象类==（abstract  class），它用于要创建一个体现某些基本行为的类，并为该类声明方法，但不能在该类中实现该类的情况。不能创建abstract  类的实例。然而可以创建一个变量，其类型是一个抽象类，并让它指向具体子类的一个实例。不能有抽象构造函数或抽象静态方法。Abstract  类的子类为它们父类中的所有抽象方法提供实现，否则它们也是抽象类为。取而代之，在子类中实现该方法。知道其行为的其它类可以在类中实现这些方法。 

   ==接口==（interface）是抽象类的变体。在接口中，`所有方法都是抽象的`。多继承性可通过实现这样的接口而获得。接口中的所有方法都是抽象的，没有一个有程序体。==接口只可以定义static  final成员变量==。接口的实现与子类相似，除了该实现类不能从接口定义中继承行为。当类实现特殊接口时，它定义（即将程序体给予）所有这种接口的方法。然后，它可以在实现了该接口的类的任何对象上调用接口的方法。由于有抽象类，它允许使用接口名作为引用变量的类型。通常的动态联编将生效。引用可以转换到接口类型或从接口类型转换，==instanceof 运算符可以用来决定某对象的类是否实现了接口。==

## 请说明一下final, finally, finalize的区别。

final 用于声明属性，方法和类，分别表示属性不可变，方法不可覆盖，类不可继承。
 finally是异常处理语句结构的一部分，表示总是执行。
 finalize是Object类的一个方法，在垃圾收集器执行的时候会调用被回收对象的此方法，可以覆盖此方法提供垃圾收集时的其他资源
 回收，例如关闭文件等。 

## 接口和抽象类的区别是什么？

接口中所有的方法隐含的都是抽象的。而抽象类则可以同时包含抽象和非抽象的方法。 

类可以实现很多个接口，但是只能继承一个抽象类 
 类可以不实现抽象类和接口声明的所有方法，当然，在这种情况下，类也必须得声明成是抽象的。 
 抽象类可以在不提供接口方法实现的情况下实现接口

Java接口中声明的变量默认都是final的。抽象类可以包含非final的变量。 
 Java接口中的成员函数默认是public的。抽象类的成员函数可以是private，protected或者是public。 
 接口是绝对抽象的，不可以被实例化。抽象类也不可以被实例化，但是，如果它包含main方法的话是可以被调用的。 

## 请你谈谈如何通过反射创建对象？

\- 方法1：通过类对象调用newInstance()方法，例如：String.class.newInstance()
 \-  方法2：通过类对象的getConstructor()或getDeclaredConstructor()方法获得构造器（Constructor）对象并调用其newInstance()方法创建对象，例如：String.class.getConstructor(String.class).newInstance("Hello"); 



## 请解释一下extends 和super 泛型限定符

  （1）泛型中上界和下界的定义 

  上界<? extend Fruit> 

  下界<? super Apple> 

  （2）上界和下界的特点 

  上界的list只能get，不能add（确切地说不能add出除null之外的对象，包括Object） 

  下界的list只能add，不能get 

##  请你谈谈StringBuffer和StringBuilder有什么区别，底层实现上呢？

StringBuffer线程安全，StringBuilder线程不安全，底层实现上的话，StringBuffer其实就是比StringBuilder多了Synchronized修饰符。 





## 请说明”static”关键字是什么意思？Java中是否可以覆盖(override)一个private或者是static的方法？  

“static”关键字表明一个成员变量或者是成员方法可以在没有所属的类的实例变量的情况下被访问。 

Java中static方法不能被覆盖，因为方法覆盖是基于运行时动态绑定的，而static方法是编译时静态绑定的。static方法跟类的任何实例都不相关，所以概念上不适用。 



## Java中static方法不能被覆盖，因为方法覆盖是基于运行时动态绑定的，而static方法是编译时静态绑定的。static方法跟类的任何实例都不相关，所以概念上不适用。 

Object()默认构造方法。clone() 创建并返回此对象的一个副本。equals(Object obj)  指示某个其他对象是否与此对象“相等”。finalize()当垃圾回收器确定不存在对该对象的更多引用时，由对象的垃圾回收器调用此方法。getClass()返回一个对象的运行时类。hashCode()返回该对象的哈希码值。 notify()唤醒在此对象监视器上等待的单个线程。  notifyAll()唤醒在此对象监视器上等待的所有线程。toString()返回该对象的字符串表示。wait()导致当前的线程等待，直到其他线程调用此对象的 notify() 方法或 notifyAll() 方法。wait(long timeout)导致当前的线程等待，直到其他线程调用此对象的  notify() 方法或 notifyAll() 方法，或者超过指定的时间量。wait(long timeout, int nanos)  导致当前的线程等待，直到其他线程调用此对象的 notify() 方法或 notifyAll()  方法，或者其他某个线程中断当前线程，或者已超过某个实际时间量。 

## 阐述ArrayList、Vector、LinkedList的存储性能和特性

ArrayList  和Vector都是使用数组方式存储数据，此数组元素数大于实际存储的数据以便增加和插入元素，它们都允许直接按序号索引元素，但是插入元素要涉及数组元素移动等内存操作，所以索引数据快而插入数据慢，Vector中的方法由于添加了synchronized修饰，因此Vector是线程安全的容器，但性能上较ArrayList差，因此已经是Java中的遗留容器。LinkedList使用双向链表实现存储（将内存中零散的内存单元通过附加的引用关联起来，形成一个可以按序号索引的线性结构，这种链式存储方式与数组的连续存储方式相比，内存的利用率更高），按序号索引数据需要进行前向或后向遍历，但是插入数据时只需要记录本项的前后项即可，所以插入速度较快。Vector属于遗留容器（Java早期的版本中提供的容器，除此之外，Hashtable、Dictionary、BitSet、Stack、Properties都是遗留容器），已经不推荐使用，但是由于ArrayList和LinkedListed都是非线程安全的，如果遇到多个线程操作同一个容器的场景，则可以通过工具类Collections中的synchronizedList方法将其转换成线程安全的容器后再使用（这是对装潢模式的应用，将已有对象传入另一个类的构造器中创建新的对象来增强实现）。

## 请说明Collection 和 Collections的区别。

Collection是集合类的上级接口，继承与他的接口主要有Set 和List.
 Collections是针对集合类的一个帮助类，他提供一系列静态方法实现对各种集合的搜索、排序、线程安全化等操作。

##  请你说明HashMap和Hashtable的区别？ 

HashMap和Hashtable都实现了Map接口，因此很多特性非常相似。但是，他们有以下不同点： 
 HashMap允许键和值是null，而Hashtable不允许键或者值是null。 
 Hashtable是同步的，而HashMap不是。因此，HashMap更适合于单线程环境，而Hashtable适合于多线程环境。 
 HashMap提供了可供应用迭代的键的集合，因此，HashMap是快速失败的。另一方面，Hashtable提供了对键的列举(Enumeration)。 
 一般认为Hashtable是一个遗留的类。 

## 请你说说Iterator和ListIterator的区别？

Iterator和ListIterator的区别是： 
 Iterator可用来遍历Set和List集合，但是ListIterator只能用来遍历List。 
 Iterator对集合只能是前向遍历，ListIterator既可以前向也可以后向。 
 ListIterator实现了Iterator接口，并包含其他的功能，比如：增加元素，替换元素，获取前一个和后一个元素的索引，等等。 

## 请解释为什么集合类没有实现Cloneable和Serializable接口？

克隆(cloning)或者是序列化(serialization)的语义和含义是跟具体的实现相关的。因此，应该由集合类的具体实现来决定如何被克隆或者是序列化。
 实现Serializable序列化的作用：将对象的状态保存在存储媒体中以便可以在以后重写创建出完全相同的副本；按值将对象从一个从一个应用程序域发向另一个应用程序域。 
 实现 Serializable接口的作用就是可以把对象存到字节流，然后可以恢复。所以你想如果你的对象没有序列化，怎么才能进行网络传输呢？要网络传输就得转为字节流，所以在分布式应用中，你就得实现序列化。如果你不需要分布式应用，那就没必要实现实现序列化。

# 线程

## 请你简要说明一下线程的基本状态以及状态之间的关系？

其中Running表示运行状态，Runnable表示就绪状态（万事俱备，只欠CPU），Blocked表示阻塞状态，阻塞状态又有多种情况，可能是因为调用wait()方法进入等待池，也可能是执行同步方法或同步代码块进入等锁池，或者是调用了sleep()方法或join()方法等待休眠或其他线程结束，或是因为发生了I/O中断。

## 线程池

\-  newSingleThreadExecutor：创建一个单线程的线程池。这个线程池只有一个线程在工作，也就是相当于单线程串行执行所有任务。如果这个唯一的线程因为异常结束，那么会有一个新的线程来替代它。此线程池保证所有任务的执行顺序按照任务的提交顺序执行。
 \- newFixedThreadPool：创建固定大小的线程池。每次提交一个任务就创建一个线程，直到线程达到线程池的最大大小。线程池的大小一旦达到最大值就会保持不变，如果某个线程因为执行异常而结束，那么线程池会补充一个新线程。
 \-  newCachedThreadPool：创建一个可缓存的线程池。如果线程池的大小超过了处理任务所需要的线程，那么就会回收部分空闲（60秒不执行任务）的线程，当任务数增加时，此线程池又可以智能的添加新线程来处理任务。此线程池不会对线程池大小做限制，线程池大小完全依赖于操作系统（或者说JVM）能够创建的最大线程大小。
 \- newScheduledThreadPool：创建一个大小无限的线程池。此线程池支持定时以及周期性执行任务的需求。
 \- newSingleThreadExecutor：创建一个单线程的线程池。此线程池支持定时以及周期性执行任务的需求。 



## 同步和异步

如果系统中存在临界资源（资源数量少于竞争资源的线程数量的资源），

例如正在写的数据以后可能被另一个线程读到，或者正在读的数据可能已经被另一个线程写过了，那么这些数据就必须进行==同步存取==（数据库操作中的排他锁就是最好的例子）。

当应用程序在对象上调用了一个需要花费很长时间来执行的方法，并且不希望让程序等待方法的返回时，就应该使用==异步编程==，在很多情况下采用异步途径往往更有效率。

==事实上，所谓的同步就是指阻塞式操作，而异步就是非阻塞式操作==。





## 请使用内部类实现线程设计4个线程，其中两个线程每次对j增加1，另外两个线程对j每次减少1。

```java
public class ThreadTest1{
	private int j;
    
	public static void main(String args[]){
		ThreadTest1 tt=new ThreadTest1();
		Inc inc=tt.new Inc();
		Dec dec=tt.new Dec();
		for(int i=0;i<2;i++){
			Thread t=new Thread(inc);
			t.start();
			t=new Thread(dec);
			t.start();
		}
	}
	private synchronized void inc(){
		j++;
		System.out.println(Thread.currentThread().getName()+"-inc:"+j);
	}
	private synchronized void dec(){
		j--;
	System.out.println(Thread.currentThread().getName()+"-dec:"+j);
	}
class Inc implements Runnable{
	public void run(){
		for(int i=0;i<100;i++){
			inc();
		}
	}
}
class Dec implements Runnable{
	public void run(){
		for(int i=0;i<100;i++){
			dec();
		}
	}
}
}
```

