package com.zdj.demo.bean;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * All Right Reserved, Copyright (C) 2015, dengjie, Ltd.<br/>
 * 
 * @author dengjie created at 2015年12月22日 下午8:44:45
 */
@XmlRootElement(name = "person") // 支持Jaxb2RootElementHttpMessageConverter
									// HTTP信息转换器对@XmlRootElement注解的对象之间写出和写入
public class Person {
	private String name;
	private int age;

	public Person() {
		super();
	}

	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}

}
