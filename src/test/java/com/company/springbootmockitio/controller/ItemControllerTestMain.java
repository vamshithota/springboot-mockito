package com.company.springbootmockitio.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import com.company.springbootmockitio.buisness.ItemBusinessService;

@WebMvcTest(ItemController.class)
public class ItemControllerTestMain {

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private ItemBusinessService businessService;
	
	@Test
	public void retrieveAllItemsTest() throws Exception {
	RequestBuilder requestBuilder =	MockMvcRequestBuilders.get("/dummy-item").accept("application/json");
	MvcResult result = mockMvc.perform(requestBuilder).andExpect(status().isOk())
	.andExpect(content().json("{\"id\": 1,\"name\":\"Ball\",\"price\":10,\"quantity\":100}")).andReturn();
	}
	
	
}
