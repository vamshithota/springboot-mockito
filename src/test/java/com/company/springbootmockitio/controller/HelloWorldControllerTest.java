package com.company.springbootmockitio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;

@WebMvcTest(HelloWorldController.class)
public class HelloWorldControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void helloWorldTest() throws Exception {
	RequestBuilder builder = MockMvcRequestBuilders.get("/hello-world").accept(MediaType.APPLICATION_JSON);
	MvcResult result = mockMvc.perform(builder).andExpect(status().isOk()).andExpect(content().string("Hello World")).andReturn();
	assertEquals("Hello World", result.getResponse().getContentAsString());
	}

}
