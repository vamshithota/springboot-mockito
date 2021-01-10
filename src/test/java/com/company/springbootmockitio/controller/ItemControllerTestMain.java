package com.company.springbootmockitio.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;

import com.company.springbootmockitio.buisness.ItemBusinessService;
import com.company.springbootmockitio.model.Item;

import static org.mockito.Mockito.when;
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
	
	//testing item-from-business-service service url 
	@Test
	public void itemFromBusinessServiceTest() throws Exception{
		when(businessService.retreiveHardcodedItem()).thenReturn(new Item(2,"Item2",10,10));
		RequestBuilder builder = MockMvcRequestBuilders.get("/item-from-business-service").accept("application/json");
		MvcResult result =  mockMvc.perform(builder).andExpect(status().isOk()).andExpect(content().json("{id:2,name:Item2,price:10}")).andReturn();
		
	}
	//testing all-items-from-database service url
	@Test
	public void allItemsFromDatabase() throws Exception {
		when(businessService.retrieveAllItems()).thenReturn(Arrays.asList(new Item(2,"Item2",10,10),
				new Item(3,"Item3",20,20)));
		RequestBuilder builder = MockMvcRequestBuilders.get("/all-items-from-database").accept("application/json");
		MvcResult result = mockMvc.perform(builder).andExpect(status().isOk())
		.andExpect(content().json("[{id:3,name:Item3,price:20}, {id:2,name:Item2,price:10}]")).andReturn();
							  
	}
	//testing /all-items-from-database service url to return no data
	@Test
	public void allItemsServiceReturnNoValuesTest() throws Exception {
		when(businessService.retrieveAllItems()).thenReturn(Arrays.asList());
		RequestBuilder builder = MockMvcRequestBuilders.get("/all-items-from-database").accept("application/json");
		MvcResult result = mockMvc.perform(builder).andExpect(status().isOk()).andExpect(content().json("[]")).andReturn();
		
		
	}
}
