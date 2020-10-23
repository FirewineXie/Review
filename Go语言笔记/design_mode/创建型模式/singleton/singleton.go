package singleton

import "sync"

//Singleton 是单例模式类
type Singleton struct{}



var singleton *Singleton
var once sync.Once


//GetInstance 用于获取单例模式对象
func GetInstance() *Singleton{
	// 程序运行，once.do 只运行一次
	once.Do(func() {
		singleton = &Singleton{}
	})
	return singleton
}