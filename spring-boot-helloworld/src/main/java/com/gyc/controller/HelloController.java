package com.gyc.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author guo
 * @date 2020/10/2
 */
@RestController
public class HelloController {

	@RequestMapping("/hello")
	public String hello() {
		return "hello";
	}

}
