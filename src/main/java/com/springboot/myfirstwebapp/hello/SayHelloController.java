package com.springboot.myfirstwebapp.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SayHelloController {
	
	@RequestMapping("say-hello")
	@ResponseBody
	public String sayHello() {
		return "Hello! How are you doing?";
	}

	@RequestMapping("say-html-hello")
	@ResponseBody
	public String sayHelloHTML() {
		StringBuffer sb = new StringBuffer();
		sb.append("<html>\n"
				+ "<html>\n"
				+ "<body>\n"
				+ "\n"
				+ "<h1>My First Heading</h1>\n"
				+ "<p>My first paragraph.</p>\n"
				+ "\n"
				+ "</body>\n"
				+ "</html> ");
		return sb.toString();
	}

	@RequestMapping("say-hello-jsp")
	public String sayHelloJSP() {
		return "sayHello";
	}
}
