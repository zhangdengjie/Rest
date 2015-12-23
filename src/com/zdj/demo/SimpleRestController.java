package com.zdj.demo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zdj.demo.bean.Person;
import com.zdj.demo.bean.PersonList;

@RestController
public class SimpleRestController {

	// Logger instance
	private static final Logger logger = Logger.getLogger(SimpleRestController.class);

	/**
	 * restful 接口的get请求demo 如果返回值是void的话，则不遵循
	 * 请求头的限制：Accept不匹配，返回值为void的方法不是返回406状态码
	 * text/xml:返回类型必须是由@XmlRootElement注解的对象
	 * application/xml:url以.xml结尾才会返回xml格式，所以
	 * headers 设置为headers = { "Accept=application/xml,application/json" }即可json xml灵活切换
	 * @author dengjie created at 2015年12月22日 上午10:49:03
	 * @param request
	 * @param version
	 * @return
	 */
	@RequestMapping(value = "/firstGet", method = RequestMethod.GET, headers = { "Accept=application/xml,application/json" })
	public PersonList getSomething(@RequestParam(value = "request", required = false) String request,
			@RequestParam(value = "version", required = false, defaultValue = "1") int version) {
		Person person = new Person();
		person.setAge(25);
		person.setName("zdj");
		List<Person> persons = new ArrayList<>();
		persons.add(person);
		persons.add(person);
		persons.add(person);
		if (logger.isDebugEnabled()) {
			logger.debug("Start getSomething");
			logger.debug("data: '" + request + "'");
		}

		String response = null;
		PersonList personList = new PersonList(persons);
		try {
			switch (version) {
			case 1:
				if (logger.isDebugEnabled())
					logger.debug("in version 1");
				// TODO: add your business logic here
				response = "Response from Spring RESTful Webservice : " + request;
				break;
			default:
				throw new Exception("Unsupported version: " + version);
			}
		} catch (Exception e) {
			response = e.getMessage().toString();
		}

		if (logger.isDebugEnabled()) {
			logger.debug("result: '" + response + "'");
			logger.debug("End getSomething");
		}
		// return new ModelAndView("person", "persons", personList);
		return personList;

	}

	@RequestMapping(value = "/firstPost", method = RequestMethod.POST)
	public String postSomething(@RequestParam(value = "request") String request,
			@RequestParam(value = "version", required = false, defaultValue = "1") int version) {

		if (logger.isDebugEnabled()) {
			logger.debug("Start postSomething");
			logger.debug("data: '" + request + "'");
		}

		String response = null;

		try {
			switch (version) {
			case 1:
				if (logger.isDebugEnabled())
					logger.debug("in version 1");
				// TODO: add your business logic here
				response = "Response from Spring RESTful Webservice : " + request;

				break;
			default:
				throw new Exception("Unsupported version: " + version);
			}
		} catch (Exception e) {
			response = e.getMessage().toString();
		}

		if (logger.isDebugEnabled()) {
			logger.debug("result: '" + response + "'");
			logger.debug("End postSomething");
		}
		return response;
	}

	@RequestMapping(value = "/firstPut", method = RequestMethod.PUT)
	public String putSomething(@RequestBody String request,
			@RequestParam(value = "version", required = false, defaultValue = "1") int version) {

		if (logger.isDebugEnabled()) {
			logger.debug("Start putSomething");
			logger.debug("data: '" + request + "'");
		}

		String response = null;

		try {
			switch (version) {
			case 1:
				if (logger.isDebugEnabled())
					logger.debug("in version 1");
				// TODO: add your business logic here
				response = "Response from Spring RESTful Webservice : " + request;

				break;
			default:
				throw new Exception("Unsupported version: " + version);
			}
		} catch (Exception e) {
			response = e.getMessage().toString();
		}

		if (logger.isDebugEnabled()) {
			logger.debug("result: '" + response + "'");
			logger.debug("End putSomething");
		}
		return response;
	}

	@RequestMapping(value = "/firstDelete", method = RequestMethod.DELETE)
	public void deleteSomething(@RequestBody String request,
			@RequestParam(value = "version", required = false, defaultValue = "1") int version) {

		if (logger.isDebugEnabled()) {
			logger.debug("Start putSomething");
			logger.debug("data: '" + request + "'");
		}

		String response = null;

		try {
			switch (version) {
			case 1:
				if (logger.isDebugEnabled())
					logger.debug("in version 1");
				// TODO: add your business logic here

				break;
			default:
				throw new Exception("Unsupported version: " + version);
			}
		} catch (Exception e) {
			logger.info(e.getMessage());
		}

		if (logger.isDebugEnabled()) {
			logger.debug("result: '" + response + "'");
			logger.debug("End putSomething");
		}
	}
}
