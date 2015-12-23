package com.zdj.demo.controller;

import java.io.StringReader;
import java.util.List;

import javax.annotation.Resource;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;

import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.zdj.demo.bean.Employee;
import com.zdj.demo.bean.EmployeeList;
import com.zdj.demo.ds.EmployeeDS;


@Controller
public class EmployeeController {

	@Resource
	private EmployeeDS employeeDS;
	
	@Resource
	private Jaxb2Marshaller jaxb2Mashaller;
	
	private static final String XML_VIEW_NAME = "employees";
	
	@RequestMapping(method=RequestMethod.GET, value="/employee/{id}")
	public ModelAndView getEmployee(@PathVariable String id) {
		Employee e = employeeDS.get(Long.parseLong(id));
		return new ModelAndView(XML_VIEW_NAME, "object", e);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/employee/{id}")
	public ModelAndView updateEmployee(@RequestBody String body) {
		Source source = new StreamSource(new StringReader(body));
		Employee e = (Employee) jaxb2Mashaller.unmarshal(source);
		employeeDS.update(e);
		return new ModelAndView(XML_VIEW_NAME, "object", e);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/employee")
	public ModelAndView addEmployee(@RequestBody String body) {
		Source source = new StreamSource(new StringReader(body));
		Employee e = (Employee) jaxb2Mashaller.unmarshal(source);
		employeeDS.add(e);
		return new ModelAndView(XML_VIEW_NAME, "object", e);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/employee/{id}")
	public ModelAndView removeEmployee(@PathVariable String id) {
		employeeDS.remove(Long.parseLong(id));
		List<Employee> employees = employeeDS.getAll();
		EmployeeList list = new EmployeeList(employees);
		return new ModelAndView(XML_VIEW_NAME, "employees", list);
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/employees")
	public ModelAndView getEmployees() {
		List<Employee> employees = employeeDS.getAll();
		EmployeeList list = new EmployeeList(employees);
		return new ModelAndView(XML_VIEW_NAME, "employees", list);
	}
	
}
