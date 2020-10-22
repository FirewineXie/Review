package simplefactory

import "fmt"

//工厂模式 ;
// 创建对象时不会对客户端暴露创建逻辑，并且是通过使用一个共同接口来指向新创建额对象
// 类似于spring 的bean创建对象

// 主要解决接口选择问题

//API is interface
type API interface {
	Say(name string) string
}

//Demo 创建实现接口的类
type Demo struct {}

//Say 创建实现接口
func (c *Demo)Say(name string) string {
	return fmt.Sprintf("demo : %s",name)
}

//Demo1 创建实现接口的类
type Demo1 struct {}

//Say 创建实现接口
func (c *Demo1)Say(name string) string {
	return fmt.Sprintf("demo1 : %s",name)
}

//Demo2 创建实现接口的类
type Demo2 struct {}

//Say 创建实现接口
func (c *Demo2)Say(name string) string {
	return fmt.Sprintf("demo2 : %s",name)
}


//
func NewApi(demoN int) API {

	if demoN == 0{
		return &Demo{}
	}else if demoN == 1{
		return &Demo1{}
	}else if demoN ==3 {
		 return &Demo2{}
	}
	return nil
}