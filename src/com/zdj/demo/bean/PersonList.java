package com.zdj.demo.bean;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * All Right Reserved, Copyright (C) 2015, dengjie, Ltd.<br/>
 * @author dengjie
 * created at 2015年12月22日  下午9:13:22
 */
@XmlRootElement(name="persons")
public class PersonList {
	
	private int count;
	private List<Person> persons;
	public PersonList() {
	}
	public PersonList(List<Person> persons) {
		this.count = persons.size();
		this.persons = persons;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	@XmlElement(name="person")
	public List<Person> getPersons() {
		return persons;
	}
	public void setPersons(List<Person> persons) {
		this.persons = persons;
	}
	@Override
	public String toString() {
		return "PersonList [count=" + count + ", persons=" + persons + "]";
	}
	
	

}

