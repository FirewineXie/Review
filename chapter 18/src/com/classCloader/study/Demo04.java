package com.classCloader.study;

/**
 * 测试简单加密解密(取反)操作
 * @author 尚学堂高淇 www.sxt.cn
 *
 */
public class Demo04 {
	public static void main(String[] args) throws Exception {
		//测试取反操作
//		int a = 3; //0000011
//		System.out.println(Integer.toBinaryString(a^0xff));

		//加密后的class文件，正常的类加载器无法加载，报classFormatError
//		FileSystemClassLoader loader = new FileSystemClassLoader("d:/myjava/temp");
//		Class<?> c = loader.loadClass("HelloWorld");
//		System.out.println(c);

		DecrptClassLoader loader = new DecrptClassLoader("d:/myjava/temp");
		Class<?> c = loader.loadClass("HelloWorld");
		System.out.println(c);

	}
}
