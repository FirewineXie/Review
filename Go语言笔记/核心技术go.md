# go 核心技术

## 工作区和GOPATH

- GOROOT ： go语言安装根目录的路径，也就是go语言的安装路径
- GOPATH ： 若干工作区目录的路径，是自己行医的工作空间
- GOBIN：go程序生成的可执行文件 的路径

1. 设置gopath

   现在来说，无意义，采用模块化开发，类似于maven 将依赖归于一个文件夹下，不需要重复下载



### 命令源码文件

> 源码文件分为三种：
>
> 1. 命令源码文件
> 2. 库源码文件
> 3. 测试源码文件

## container 容器

> 里面包含链表，循环列表ring



go中的 数据结构或者变量 都是具有初始化默认值

`延迟初始化`： 是在要调用的时候，才进行初始化





## 字典的操作和约束

go语言的字典类型其实一个哈希表hash table 的特定实现





## 通道

> Don’t communicate by sharing memory; share memory by communicating. （不要通过共享内存来通信，而应该通过通信来共享内存。）

**一个通道相当于一个先进先出（FIFO）的队列。也就是说，通道中的各个元素值都是严格地按照发送的顺序排列的，先被发送通道的元素值一定会先被接收。元素值的发送和接收都需要用到操作符`<-`。我们也可以叫它接送操作符。一个左尖括号紧接着一个减号形象地代表了元素值的传输方向。**





通道的发送和接收基本特性如下。

1. 对于同一个通道，发送操作之间是互斥的，接收操作之间也是互斥的。
2. 发送操作和接收操作中对元素值的处理都是不可分割的。
3. 发送操作在完全完成之前会被阻塞。接收操作也是如此。







通道进入的值，是副本，



对于一个已初始化，但并未关闭的通道来说，收发操作一定不会引发panic。但是通道一旦关闭，再对它进行发送操作，就会引发panic。





单通道的作用：

`单向通道最主要的用途就是约束其他代码的行为`

```go
func SendInt(ch chan<- int) {
	ch <- rand.Intn(1000)
}
```

这个函数只接受一个chan<- int类型的参数。在这个函数中的代码只能向参数ch发送元素值，而不能从它哪里接收元素值。就是约束函数行为的作用

```go
type Notifier interface {
	SendInt(ch chan<- int)
}
```

约束一般出现在接口类型声明中的某个方法定义上。

`Notifier`接口中的`SendInt`方法只会接受一个发送通道作为参数，所以，在该接口的所有实现类型中的`SendInt`方法都会受到限制。这种约束方式还是很有用的，尤其是在我们编写模板代码或者可扩展的程序库的时候。

传送可以是双向通道，程序会自动将转换函数所需要的单通道

**问题2：`select`语句的分支选择规则都有哪些？**

规则如下面所示。

1. 对于每一个`case`表达式，都至少会包含一个代表发送操作的发送表达式或者一个代表接收操作的接收表达式，同时也可能会包含其他的表达式。比如，如果`case`表达式是包含了接收表达式的短变量声明时，那么在赋值符号左边的就可以是一个或两个表达式，不过此处的表达式的结果必须是可以被赋值的。当这样的`case`表达式被求值时，它包含的多个表达式总会以从左到右的顺序被求值。

   

2. `select`语句包含的候选分支中的`case`表达式都会在该语句执行开始时先被求值，并且求值的顺序是依从代码编写的顺序从上到下的。结合上一条规则，在`select`语句开始执行时，排在最上边的候选分支中最左边的表达式会最先被求值，然后是它右边的表达式。仅当最上边的候选分支中的所有表达式都被求值完毕后，从上边数第二个候选分支中的表达式才会被求值，顺序同样是从左到右，然后是第三个候选分支、第四个候选分支，以此类推。

   

3. 对于每一个`case`表达式，如果其中的发送表达式或者接收表达式在被求值时，相应的操作正处于阻塞状态，那么对该`case`表达式的求值就是不成功的。在这种情况下，我们可以说，这个`case`表达式所在的候选分支是不满足选择条件的。

   

4. 仅当`select`语句中的所有`case`表达式都被求值完毕后，它才会开始选择候选分支。这时候，它只会挑选满足选择条件的候选分支执行。如果所有的候选分支都不满足选择条件，那么默认分支就会被执行。如果这时没有默认分支，那么`select`语句就会立即进入阻塞状态，直到至少有一个候选分支满足选择条件为止。一旦有一个候选分支满足选择条件，`select`语句（或者说它所在的goroutine）就会被唤醒，这个候选分支就会被执行。

   

5. 如果`select`语句发现同时有多个候选分支满足选择条件，那么它就会用一种伪随机的算法在这些分支中选择一个并执行。注意，即使`select`语句是在被唤醒时发现的这种情况，也会这样做。

   

6. 一条`select`语句中只能够有一个默认分支。并且，默认分支只在无候选分支可选时才会被执行，这与它的编写位置无关。

   

7. `select`语句的每次执行，包括`case`表达式求值和分支选择，都是独立的。不过，至于它的执行是否是并发安全的，就要看其中的`case`表达式以及分支中，是否包含并发不安全的代码了。

## 函数用法

函数是一等公民

函数不但可以用于封装代码，分隔功能，解耦逻辑，还可以化身普通的值，在其他函数间传递、赋予变量、做类型判断和转换等等。

更深层次的含义： 函数值可以由此成为能够随意传播的独立逻辑组件（或者功能模块）



### 高阶函数

> 满足条件：
>
> 1. 接收其他的函数作为参数传入
> 2. 把其他的函数作为结果返回
>
> 三者只需要满足一个，就是高阶函数，也是函数式编程中的重要概念和特征

**函数类型属于引用类型，他的值可以为nil，而这种类型的恰恰就是nil**

> ==卫述语句==是指被用来检查关键的先决条件的合法性，并在检查未通过的情况下立即终止当前代码块执行的语句。在Go语言中，if 语句常被作为卫述语句。

把其他函数作为结果返回

```go
package main

import (
	"errors"
	"fmt"
)

/*
@Time : 2020/10/17 17:22
@Author : Firewine
@File : main
@Software: GoLand
@Description:
*/
type operate func(x, y int) int
type calculateFunc func(x,y int) (int ,error)

func main() {
	x, y := 56, 78

	op := func(x ,y int) int {
		return y * x
	}
	add, _ := genCalculator(op)
	result, err := add(x, y)
	fmt.Printf("The result: %d (error: %v)\n", result, err)
}
// 闭包函数，
// 变量op 既不代表它的任何参数或结果也不是他自己声明的，而是定义他的genCalculator函数的参数，所以是一个自由变量
//
func genCalculator(op operate) (calculateFunc, error) {
	return func(x int, y int) (int, error) {
		if op == nil {
			return 0, errors.New("invalid operation")
		}
		return op(x, y), nil
	}, nil
}


```

genCalculaaror 根据自由变量，来确定这个函数功能的作用，不同的op提供不同的功能





## 接口

> 接口类型声明中的这些方法所代表的就是该接口的方法集合。一个集合的方法集合就是它的全部特征

如何判断是否实现某个接口类型中的某个方法：

1. 两个方法的签名需要完全一致，
2. 两个方法的名称要一样

==如果我们使用一个变量给另外一个变量赋值，那么真正赋给后者的，并不是前者持有的那个值，而是该值的一个副本。==

### 知识扩展

1. 接口变量的值什么情况下才真正为nil

   对于引用类型的变量，他的值是否为nil 完全取决于我们赋给它了什么 

2. 使用接口，要先弄清楚的是，接口变量的动态值，动态类型和静态类型都代表了什么

3. 接口变量的值并不等同于这个可被称为动态值的副本 。它会包含两个指针，一个指针指向动态值，一个指针指向类型信息

## 关于指针的有限操作

###  值是不可以寻址的

- 常量的值
- 基本类型的字面值
- 算数操作的结果值
- 对各种字面量的索引表达式和切片表达式的结果值。不过有一个例外，对切片字面量的索引结果值却是可以寻址的
- 对字符串变量的所有表达式和切片表达式的结果值
- 对字段变量的索引表达式的结果值
- 函数字面值和方法字面值，以及对他们的调用表达式的结果值
- 结构体字面量的字段值，也就是对结构体字面量的选择表达式的结果值
- 类型转换表达式的结果值
- 类型断言表达式的结果值
- 接收表达式的结果值

解析

函数在Go语言中是一等公民，所以我们可以把代表函数或方法的字面量或标识符赋给某个变量、传给某个函数或者从某个函数传出。但是，这样的函数和方法都是不可寻址的。一个原因是函数就是代码，是不可变的。

另一个原因是，拿到指向一段代码的指针是不安全的。此外，对函数或方法的调用结果值也是不可寻址的，这是因为它们都属于临时结果

总结

1. **不可变的**值不可寻址。常量、基本类型的值字面量、字符串变量的值、函数以及方法的字面量都是如此。其实这样规定也有安全性方面的考虑。
2. 绝大多数被视为**临时结果**的值都是不可寻址的。算术操作的结果值属于临时结果，针对值字面量的表达式结果值也属于临时结果。但有一个例外，对切片字面量的索引结果值虽然也属于临时结果，但却是可寻址的。
3. 若拿到某值的指针可能会破坏程序的一致性，那么就是**不安全的**，该值就不可寻址。由于字典的内部机制，对字典的索引结果值的取址操作都是不安全的。另外，获取由字面量或标识符代表的函数或方法的地址显然也是不安全的。

#### unsafe.Pointer 操纵可寻址的值

可以绕过go语言的编辑器和其他工具的重重检查，并达到嵌入内存修改数据的目的，但是这不是安全的操作，可能存在安全隐患。

尽量是使用api接口去编写程序



## go语句及其执行规则

**不过别担心，Go语言不但有着独特的并发编程模型，以及用户级线程goroutine，还拥有强大的用于调度goroutine、对接系统级线程的调度器。**

这个调度器是Go语言运行时系统的重要组成部分，它主要负责统筹调配Go并发编程模型中的三个主要元素，即：G（goroutine的缩写）、P（processor的缩写）和M（machine的缩写）。

```go
func main() {
	for i := 0; i < 10; i++ {
		go func() {
			fmt.Println(i)
		}()
	}
}
// 为什么，没有数据打印出来
// 首先 主goroutine  已经运行完了，，线程还没有线程，就已经停止了
// 要想打印出来东西，必须要让主线程等待子线程运行完成

```

### 知识扩展

#### 怎么才能让主goroutine 等待其他的goroutine

1. 通过主线程暂时休眠，但是休眠多长时间确实不知道的
2. 特殊的点，空结构体 **struct{}** 是内存空间是0字节，在整个程序里面只有一份，但是可以无数次使用，却是同一个值



#### 怎么样启动有顺序的goroutine 运行

```go

for i := 0; i < 10; i++ {
	go func(i int) {
		fmt.Println(i)
	}(i)
}

// 将 i 传入 协程里，确保每个goroutine 都可以拿到一个唯一的整数，，
//就是遍历，先出来才会给协程，协程才开始云心
```

##  对于错误的处理方法

### 惯用法

1. 对于类型在已知范围内的一系列错误值，一般使用类型断言表达式或类型switch 语句来判断
2. 对于已有相应变量且类型相同的一些列错误值，一般直接使用判等操作来判断
3. 对于没有相应变量且来兴位置的一些列错误值，只能使用其错误信息的字符串表示形式来做判断

```go
switch err := err.(type) {
	case *os.PathError:
		return err.Err
	case *os.LinkError:
		return err.Err
	case *os.SyscallError:
		return err.Err
	case *exec.Error:
		return err.Err
	}
	return err



if err == nil {
		fmt.Println("nil error")
		return
	}
	err = underlyingError(err)
```



## panic 函数 recover 函数与defer 语句

### panic

这种异常 只会在 程序运行的时候被抛出来

一般程序，没有对错误进行处理，那么panic 就会停止程序

####  从panic 被引发到程序终止运行的大致过程是什么

> 某个函数中的某行代码有意或无意地引发了一个panic。这时，初始的panic详情会被建立起来，并且该程序的控制权会立即从此行代码转移至调用其所属函数的那行代码上，也就是调用栈中的上一级。

### 知识扩展

1. 怎么样让panic 包含一个值，以及应该让它包含什么样的值

   在调用`panic`函数时，把某个值作为参数传给该函数就可以了。由于`panic`函数的唯一一个参数是空接口（也就是`interface{}`）类型的，所以从语法上讲，它可以接受任何类型的值。

2.  怎样施加应对panic的保护措施，从而避免程序崩溃？

   Go语言的内建函数`recover`专用于恢复panic，或者说平息运行时恐慌。`recover`函数无需任何参数，并且会返回一个空接口类型的值

3. defer 函数调用都会在它即将结束执行的那一刻执行，

4. 如果一个函数中有多条`defer`语句，那么那几个`defer`函数调用的执行顺序是怎样的？

   在同一个函数中，`defer`函数调用的执行顺序与它们分别所属的`defer`语句的出现顺序（更严谨地说，是执行顺序）完全相反





## 测试的流程及规则

> 分为三类 ： 功能测试test，基准测试benchmark 也叫性能测试
>
> 示例测试example

一般测试文件是以源码文件为主，文件名称是源码文件后面跟_test为后缀。

### go语言对测试函数的名称和签名都有哪些规定

- 对于功能测试函数来说，其名称必须以`Test`为前缀，并且参数列表中只应有一个`*testing.T`类型的参数声明。
- 对于性能测试函数来说，其名称必须以`Benchmark`为前缀，并且唯一参数的类型必须是`*testing.B`类型的。
- 对于示例测试函数来说，其名称必须以`Example`为前缀，但对函数的参数列表没有强制规定

## sync.Mutex 与sync.RwMutex

> sync 是同步的意思
>
> 这个与大多数语言一样，采用共享数据的方式来传递信息和协调线程运行的做法更加主流，

一旦数据被多个线程共享，那么就很可能会产生争用和冲突。这种情况也被称为**竞态条件** ，这往往会破坏共享数据的一致性

共享数据的一致性代表着某种约定，即：多个线程对共享数据的操作总是可以达到它们各自预期的效果。

概括来讲，**同步的用途有两个，一个是避免多个线程在同一时刻操作同一个数据块，另一个是协调多个线程，以避免它们在同一时刻执行同一个代码块。**





在go语言中，最重要且最常用的同步工具当属互斥量mutex



使用 mu.lock,  mu.unlock  进行互斥锁



#### 使用互斥锁的注意事项

1. 不要重复锁定互斥锁；
2. 不要忘记解锁互斥锁，必要时使用`defer`语句；
3. 不要对尚未锁定或者已解锁的互斥锁解锁；
4. 不要在多个函数之间直接传递互斥锁。



而产生死锁，程序必然崩溃





## 原子操作atomic

条件变量主要是用于协调想要访问共享资源的那些线程 

真正能够保证原子性执行的只有原子操作。原子操作是不容许中断的。



**更具体的说，正是因为原子操作不能被中断，所以他需要足够简单，并且要求快速**



go语言中，提供的包为 sync/atomic 

`sync/atomic`包中的函数可以做的原子操作有：加法（add）、比较并交换（compare and swap，简称CAS）、加载（load）、存储（store）和交换（swap）。

因为原子操作函数需要的是被操作值的指针，而不是这个值本身；被传入函数的参数值都会被复制，像这种基本类型的值一旦被传入函数，就已经与函数外的那个值毫无关系了。

value 新类型，，相当于一个容器，可以用来“原子地”存储和加载任意的值

atomic.Value 类型是开箱即用的，我们声明一个该类型的变量之后就可以使用了，

但是还是有类型判断的，首次存储的值，往后存储的值都必须是相同的类型，并且不能存储nil

==尽量不要向原子值中存储引用类型的值。==





## sync.WaitGroup 和sync.Once

> 印子； 声明一个通道，使它的容量与我们手动启用的goroutine 的数量相同，之后再利用这个通道，让主goroutine 等待其他的goroutine 的运行结束
>
> 具体来书：让其他的goroutine在运行结束之前，都向这个通道发送一个元素值，并且，让主goroutine在最后从这个通道中接收元素值，接收的次数需要与其他的goroutine的数量相同

```go
func coordinateWithChan() {
 sign := make(chan struct{}, 2)
 num := int32(0)
 fmt.Printf("The number: %d [with chan struct{}]\n", num)
 max := int32(10)
 go addNum(&num, 1, max, func() {
  sign <- struct{}{}
 })
 go addNum(&num, 2, max, func() {
  sign <- struct{}{}
 })
 <-sign
 <-sign
}
```



上述代码，看起来非常的丑陋，

另外一个同步工具, 即 ： sync 包的waitGroup 类型。他比通道更加适合实现这种一对多的goroutine 协作流程

这个是开箱急用的，也是并发安全的。同时一旦使用，就不能被复制了



waitGroup 类型拥有三个指针方法 add ,done ,wait

就相当于 有一个计数器，通过add 和done 来相加减

> 例如 开启一个goroutine 就add 一个，一个运行完成就要done一次

```go
func coordinateWithWaitGroup() {
 var wg sync.WaitGroup
 wg.Add(2)
 num := int32(0)
 fmt.Printf("The number: %d [with sync.WaitGroup]\n", num)
 max := int32(10)
 go addNum(&num, 3, max, wg.Done)
 go addNum(&num, 4, max, wg.Done)
 wg.Wait()
}
```

如果在一个此类值的`Wait`方法被执行期间，跨越了两个计数周期，**那么就会引发一个panic**

例如，在当前的goroutine因调用此类值的`Wait`方法，而被阻塞的时候，另一个goroutine调用了该值的`Done`方法，并使其计数器的值变为了`0`



总结： **不要把增加其计数器值的操作和调用其`Wait`方法的代码，放在不同的goroutine中执行。换句话说，要杜绝对同一个`WaitGroup`值的两种操作的并发执行。**



#### sync.Once  的do方法是怎么保证只执行参数函数一次的

once 类型 也是结构体类型，同样是开箱即用和并发安全的。并且里面包含sync.mutex类型的字段，所以复制该类型的值也会导致该功能失效





do方法 只支持 func（），，即无参数声明和结果声明的函数。

==该方法的功能不是对每一种参数方法函数都执行一次，而是只执行“首次被调用时传入的”的那个函数，并且之后不会在执行任何参==

**可以看下GOF设计模式**





##### do 方法在功能方面的两个特点

1. **第一个特点**，由于`Do`方法只会在参数函数执行结束之后把`done`字段的值变为`1`，因此，如果参数函数的执行需要很长时间或者根本就不会结束（比如执行一些守护任务），那么就有可能会导致相关goroutine的同时阻塞。
2. **第二个特点**，`Do`方法在参数函数执行结束后，对`done`字段的赋值用的是原子操作，并且，这一操作是被挂在`defer`语句中的。因此，不论参数函数的执行会以怎样的方式结束，`done`字段的值都会变为`1`







总结， 使用waitGroup ：

**我们最好用“先统一`Add`，再并发`Done`，最后`Wait`”这种标准方式，来使用`WaitGroup`值**



`WaitGroup`值是可以被复用的，但需要保证其计数周期的完整性。尤其是涉及对其`Wait`方法调用的时候，它的下一个计数周期必须要等到，与当前计数周期对应的那个`Wait`方法调用完成之后，才能够开始。

```go
func coordinateWithWaitGroup() {
 total := 12
 stride := 3
 var num int32
 fmt.Printf("The number: %d [with sync.WaitGroup]\n", num)
 var wg sync.WaitGroup
 for i := 1; i <= total; i = i + stride {
  wg.Add(stride)
  for j := 0; j < stride; j++ {
   go addNum(&num, i+j, wg.Done)
  }
  wg.Wait()
 }
 fmt.Println("End.")
}
```



## context.Context 类型

> 怎么使用context包中的程序实体，实现一对多的goroutine协作流程
>
> 使用context 包模仿上面coordinateWithWaitGroup 函数相同的功能

```go
func coordinateWithContext() {
 total := 12
 var num int32
 fmt.Printf("The number: %d [with context.Context]\n", num)
 cxt, cancelFunc := context.WithCancel(context.Background())
 for i := 1; i <= total; i++ {
  go addNum(&num, i, func() {
   if atomic.LoadInt32(&num) == int32(total) {
    cancelFunc()
   }
  })
 }
 <-cxt.Done()
 fmt.Println("End.")
}
```

更具体地说，`Context`类型可以提供一类代表上下文的值。此类值是并发安全的，也就是说它可以被传播给多个goroutine。



## 临时对象池sync.pool

go 语言 特有的几个同步工具：

1. sync/atomic.Value
2. sync.Once
3. sync.WaiteGroup
4. context.context
5. sync.Pool



`sync.Pool`类型可以被称为临时对象池，它的值可以被用来存储临时的对象。与Go语言的很多同步工具一样，`sync.Pool`类型也属于结构体类型，它的值在被真正使用之后，就不应该再被复制了。



临时对象的意思 ： 不需要持久使用的某一类值，这类值对于程序来说可有可无，但如果有的话会明显更好。他们的创建和销毁可以在任何时候发生，并发完全不会影响到程序的功能。

同时，它们也应该是无需被区分的，其中的任何一个值都可以代替另一个。如果你的某类值完全满足上述条件，那么你就可以把它们存储到临时对象池中。

sync.Pool 类型只有两个方法——put和get .Put用于在当前的池中存放临时对象，它接受一个interface{} 类型的参数，而Get则被用于从当前的池中获取临时对象，它会返回一个interface{}类型的值



## sync.cond

条件变量怎么样与互斥锁配合使用

答 ： 条件变量的初始化离不开互斥锁，并且它的方法有的也是基于互斥锁的

条件变量提供的方法有三个：等待通知，单发通知和广播通知

```go
var mailbox uint8
var lock sync.RWMutex
sendCond := sync.NewCond(&lock)
recvCond := sync.NewCond(lock.RLocker())
```


## 并发安全的sync.Map ，已知 go自带的map结构不是并发安全的



sync.map 对键的要求： 不能是函数类型、字典类型和切片类型

我们必须保证键的类型是可比较的（或者说可判等的）。如果你实在拿不准，那么可以先通过调用`reflect.TypeOf`函数得到一个键值对应的反射类型值（即：`reflect.Type`类型的值），然后再调用这个值的`Comparable`方法，得到确切的判断结果。



### 知识扩展

1. 保证并发安全字段中的键和值的类型正确性

   - 使用类型断言表达式或者反射操作来保证他们类型正确性

   1. 第一种方案 ： 让并发安全字典只能存储某个特定类型的值

      ```go
      type IntStrMap struct {
       m sync.Map
      }
      
      func (iMap *IntStrMap) Delete(key int) {
       iMap.m.Delete(key)
      }
      
      func (iMap *IntStrMap) Load(key int) (value string, ok bool) {
       v, ok := iMap.m.Load(key)
       if v != nil {
        value = v.(string)
       }
       return
      }
      
      func (iMap *IntStrMap) LoadOrStore(key int, value string) (actual string, loaded bool) {
       a, loaded := iMap.m.LoadOrStore(key, value)
       actual = a.(string)
       return
      }
      
      func (iMap *IntStrMap) Range(f func(key int, value string) bool) {
       f1 := func(key, value interface{}) bool {
        return f(key.(int), value.(string))
       }
       iMap.m.Range(f1)
      }
      
      func (iMap *IntStrMap) Store(key int, value string) {
       iMap.m.Store(key, value)
      }
      ```

   2. 方案二：重写sync.map 类型的所有方法，但是另写类型检查

      ```go
      type ConcurrentMap struct {
       m         sync.Map
       keyType   reflect.Type
       valueType reflect.Type
      }
      
      // 类型代表的是 ： 可自定义键类型和值类型的并发安全字段。
      // m代表这内部使用的并发安全字典
      // key value type  分别用于保存键类型和值类型，这两个字段都是反射类型
      // 例如  reflect.TypeOF
      func (cMap *ConcurrentMap) Load(key interface{}) (value interface{}, ok bool) {
       if reflect.TypeOf(key) != cMap.keyType {
        return
       }
       return cMap.m.Load(key)
      }
      ```

2. 并发安全字典如何做到尽量避免使用锁

   sync.Map 类型在内部使用了大量的原子操作来获取键和值，并使用了两个原始的map 作为存储介质

   - 第一个原生map 被存在了sync.map 的read字段中，字段类型为sync/atomic.value类型。相当于一个快照，每次保存sync.map里面的数据
   - 另一个原生字典是dirty字段代表，他存储键值对的方式与read字段中的原生字典一直，他的键类型为interface{} ，并且同样是把值先做转换和封装后再进行存储的。



## unicode与字符编码

### go语言经典知识总结

> 基于混合线程的并发编程模型

#### 数据类型方法

- 基于底层数组的切片
- 用来传递数据的通道
- 作为一等类型的函数
- 可实现面向对象的结构体
- 能无侵入实现的接口等

#### 语法

1. 异步编程神器go语句
2. 函数的最后关卡defer语句
3. 可做类型判断的switch语句
4. 多通道操作力气select语句
5. 非常有特色的异常处理函数panic 和recover

#### 测试go程序

1. 独立的测试源码文件
2. 三种功用不同的测试函数
3. 专用的testing代码包
4. 功能强大的go test命令



#### 同步工具

1. 经典的互斥锁
2. 读写锁
3. 条件变量
4. 原子操作

#### 特有的数据类型

1. 单此执行小助手sync.Once
2. 临时对象池sync.Pool
3. 帮助我们实现多goroutine协作流程的sync.WaitGroup、context.Context
4. 一种高效的并发安全字典sync.Map





### go语言的字符编程基础

go语言中的标识符可以包含“任何Unicode 编码可以表示的字母字符”。

当一个 string 类型的值被转换为[]rune 类型值的时候，其中的字符串会被拆分成一个一个unicode字符

即 ： go 语言，必须使用utf-8 格式进行保存，不然构建会发生错误



#### 问题

1. 一个string 类型的值，如何在底层是怎么表达的

   > 是在底层，一个string类型的值是由一系列相对应的unicode代码点的utf-8编码值来表达式

   总之，一个`string`类型的值会由若干个Unicode字符组成，每个Unicode字符都可以由一个`rune`类型的值来承载。

2. 使用range 子句的for语句遍历字符串值的时候应该注意什么

   > 带有range子句的for语句，会先把被遍历的字符串拆成一个字节序列，然后使用找出这个字节序列中包含每一个utf-8编码值，也就是unicode字符



## strings 包与字符串操作

> 与string值相比，strings.Builder 类型的值有哪些优势

strings.builder 类型的值 优势有下面的三种：

1. 已存在的内容不可变，但可以拼接更多的内容
2. 减少了内存分配和内容拷贝的次数
3. 可将内容重置，可重用值



string 是众所周知 ，，是采用 一连续的内存空间进行保存，如果进行字符串改变，会增加内存压力，



而 builder  的优势就是字符串拼接方面，

Builder 值中有一个用于承载内容的容器，。他是一个以byte为元素类型的切片

实际上：他们都是通过一个unsafe.Pointer 类型的字段来持有那个指向底层字节数组的指针值的，同样拥有高效利用内存的前提条件。

**虽然字节切片本身可以肆意修改，但是builder值不容许这样做，其中的内容只能够拼接或者完全重置**

扩容就是; 就是原容器容量的二倍再加上n，然后将原数据拷贝新容器中



#### strings.Reader 类型的值可以高效的读取字符串

> 在读取的机制上，它封装了很多用于在string值上读取内容的最佳实践，在读取的过程中，Reader 值会保存已读取的字节的计数（已读计数）

Reader





## io包中的接口和工具

**`strings.Builder`类型主要用于构建字符串**，它的指针类型实现的接口有`io.Writer`、`io.ByteWriter`和`fmt.Stringer`。另外，它其实还实现了一个`io`包的包级私有接口`io.stringWriter`（自Go 1.12起它会更名为`io.StringWriter`）。

**`strings.Reader`类型主要用于读取字符串**，它的指针类型实现的接口比较多，包括：

1. `io.Reader`；
2. `io.ReaderAt`；
3. `io.ByteReader`；
4. `io.RuneReader`；
5. `io.Seeker`；
6. `io.ByteScanner`；
7. `io.RuneScanner`；
8. `io.WriterTo`；

**`bytes.Buffer`是集读、写功能于一身的数据类型，它非常适合作为字节序列的缓冲区。** 

更具体地说，该指针类型实现的读取相关的接口有下面几个。

1. `io.Reader`；
2. `io.ByteReader`；
3. `io.RuneReader`；
4. `io.ByteScanner`；
5. `io.RuneScanner`；
6. `io.WriterTo`；

共有6个。而其实现的写入相关的接口则有这些。

1. `io.Writer`；
2. `io.ByteWriter`；
3. `io.stringWriter`；
4. `io.ReaderFrom`；

共4个。此外，它还实现了导出相关的接口`fmt.Stringer`。





拷贝数据的包

在`io`包中，有这样几个用于拷贝数据的函数，它们是：

- `io.Copy`；
- `io.CopyBuffer`；
- `io.CopyN`。

在实际的面试中，只要应聘者能够从某一个方面出发，说出`io.Reader`的扩展接口及其存在意义，或者说清楚该接口的三五个实现类型，那么就可以算是基本回答正确了。

比如，从读取、写入、关闭这一些列的基本功能出发，描述清楚：

- `io.ReadWriter`；
- `io.ReadCloser`；
- `io.ReadWriteCloser；`

这几个接口。

又比如，说明白`io.LimitedReader`和`io.SectionReader`这两个类型之间的异同点。

再比如，阐述`*io.SectionReader`类型实现`io.ReadSeeker`接口的具体方式，等等。不过，这只是合格的门槛，应聘者回答得越全面越好。

我在示例文件demo82.go中写了一些代码，以展示上述类型的一些基本用法，供你参考。

==核心接口： reader,writer,close==

简单接口分为四大类  ： 读取 ，写入，关闭和读写位置设定



## 使用os包的api

os.file 下面是所实现的接口

首先，对于`io`包中最核心的3个简单接口`io.Reader`、`io.Writer`和`io.Closer`，`*os.File`类型都实现了它们。

其次，该类型还实现了另外的3个简单接口，即：`io.ReaderAt`、`io.Seeker`和`io.WriterAt`。



#### File值的操作模式都有哪些

操作模式 ：  只读模式、只写模式，读写模式

这些模式分别由常量`os.O_RDONLY`、`os.O_WRONLY`和`os.O_RDWR`代表。在我们新建或打开一个文件的时候，必须把这三个模式中的一个设定为此文件的操作模式。

- `os.O_APPEND`：当向文件中写入内容时，把新内容追加到现有内容的后边。
- `os.O_CREATE`：当给定路径上的文件不存在时，创建一个新文件。
- `os.O_EXCL`：需要与`os.O_CREATE`一同使用，表示在给定的路径上不能有已存在的文件。
- `os.O_SYNC`：在打开的文件之上实施同步I/O。它会保证读写的内容总会与硬盘上的数据保持同步。
- `os.O_TRUNC`：如果文件已存在，并且是常规的文件，那么就先清空其中已经存在的任何内容。

#### 如何设置常规文件的访问权限

实际上，在一个`os.FileMode`类型的值（以下简称`FileMode`值）中，只有最低的9个比特位才用于表示文件的权限。当我们拿到一个此类型的值时，可以把它和`os.ModePerm`常量的值做按位与操作。

**从高到低，这3组分别表示的是文件所有者（也就是创建这个文件的那个用户）、文件所有者所属的用户组，以及其他用户对该文件的访问权限。而对于每个组，其中的3个比特位从高到低分别表示读权限、写权限和执行权限。**

==与linux文件权限管理一致==

## 访问网络服务



### 前导内容 socket 和IPC

#### socket

> socket是一种IPC方法。IPC 也为进程间通信，换句话说就是多个进程之间，相互通信的方法
>
> 这些方法主要包括; 系统信号signal，管道pipe，套接字socket  ，文件锁file lock，消息队列message queue ， 信号灯 semaphore 。
>
> 而包名 就是 os.signal  或者os.pipe 管道

==众多IPC方法中，socket 是最为通用和灵活的一种==

支持socket的操作系统一般都会对外提供一套API。**跑在它们之上的应用程序利用这套API，就可以与互联网上的另一台计算机中的程序、同一台计算机中的其他程序，甚至同一个程序中的其他线程进行通信。**

> 所谓的系统调用，你可以理解为特殊的C语言函数。它们是连接应用程序和操作系统内核的桥梁，也是应用程序使用操作系统功能的唯一渠道。

**今天的问题是：`net.Dial`函数的第一个参数`network`有哪些可选值？**

这道题的**典型回答**是这样的。

`net.Dial`函数会接受两个参数，分别名为`network`和`address`，都是`string`类型的。

参数`network`常用的可选值一共有9个。这些值分别代表了程序底层创建的socket实例可使用的不同通信协议，罗列如下。

- `"tcp"`：代表TCP协议，其基于的IP协议的版本根据参数`address`的值自适应。
- `"tcp4"`：代表基于IP协议第四版的TCP协议。
- `"tcp6"`：代表基于IP协议第六版的TCP协议。
- `"udp"`：代表UDP协议，其基于的IP协议的版本根据参数`address`的值自适应。
- `"udp4"`：代表基于IP协议第四版的UDP协议。
- `"udp6"`：代表基于IP协议第六版的UDP协议。
- `"unix"`：代表Unix通信域下的一种内部socket协议，以SOCK_STREAM为socket类型。
- `"unixgram"`：代表Unix通信域下的一种内部socket协议，以SOCK_DGRAM为socket类型。
- `"unixpacket"`：代表Unix通信域下的一种内部socket协议，以SOCK_SEQPACKET为socket类型。

**Unix域**，指的是一种类Unix操作系统中特有的通信域。在装有此类操作系统的同一台计算机中，应用程序可以基于此域建立socket连接。

以上三种通信域分别可以由`syscall`代码包中的常量`AF_INET`、`AF_INET6`和`AF_UNIX`表示。

Socket的类型一共有4种，分别是：`SOCK_DGRAM`、`SOCK_STREAM`、`SOCK_SEQPACKET`以及`SOCK_RAW`。`syscall`代码包中也都有同名的常量与之对应。前两者更加常用一些。

而`SOCK_STREAM`这个socket类型，恰恰与`SOCK_DGRAM`相反。**它没有消息边界，但有逻辑连接，能够保证传输的可靠性和数据的有序性，同时还可以实现数据的双向传输。**众所周知的基于TCP协议的网络通信就属于此类。

> 这样的网络通信传输数据的形式是字节流，而不是数据报文。字节流是以字节为单位的。内核程序无法感知一段字节流中包含了多少个消息，以及这些消息是否完整，这完全需要应用程序自己去把控。
>
> 不过，此类网络通信中的一端，总是会忠实地按照另一端发送数据时的字节排列顺序，接收和缓存它们。所以，应用程序需要根据双方的约定去数据中查找消息边界，并按照边界切割数据，仅此而已。

`syscall.Socket`函数的第三个参数用于表示socket实例所使用的协议。

通常，只要明确指定了前两个参数的值，我们就无需再去确定第三个参数值了，一般把它置为`0`就可以了。这时，内核程序会自行选择最合适的协议。

比如，当前两个参数值分别为`syscall.AF_INET`和`syscall.SOCK_DGRAM`的时候，内核程序会选择UDP作为协议。

又比如，在前两个参数值分别为`syscall.AF_INET6`和`syscall.SOCK_STREAM`时，内核程序可能会选择TCP作为协议。