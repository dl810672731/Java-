package com.wangwenjun.concurrent.chapter02;
/*
 * 第2章
 * 深入理解Thread构造函数
 * 
 * 2.3 Thread与ThreadGroup 
 * 在Thread的构造函数中，可以显示地指定线程的Group
 * 如果在构造Thread的时候没有显示地指定一个ThreadGroup ，
 * 那么子线程会被加入父线程所在的线程组
 * 本例代码是一个简单的测试代码
 */

/*
 * 代码清单2-1 ThreadConstruction.java
 */
public class ThreadConstruction {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// (1)
		Thread t1 = new Thread("t1");
		// (2)
		ThreadGroup group = new ThreadGroup("TestGroup");	
		// (3)
		Thread t2 = new Thread(group,"t2");		
		ThreadGroup mainThreadGroup = Thread.currentThread().getThreadGroup();		
		System.out.println("Main thread belong group:" + mainThreadGroup.getName());	
		// 以下下写法，dl（我）认为有些不严谨  因为线程和线程组之间是属于和不属于的关系  而线程组与线程组之间并没有属于关系，而是等于和不等于的关系
		// 后面的2个输出语句中 t2 thread group应该改为 t2 thread吧
		System.out.println("t1 and main  belong the same group:" + (mainThreadGroup == t1.getThreadGroup()));
		System.out.println("t2 thread group not belong main group:" + (mainThreadGroup == t2.getThreadGroup()));
		System.out.println("t2 thread group belong main TestGroup group:" + (group == t2.getThreadGroup()));
	}
}
