package com.company.springbootmockitio.data;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.company.springbootmockitio.model.Item;

@DataJpaTest
public class ItemRepositoryTest {
	@Autowired
	private ItemRepository repository;
	
	@Test
	public void findAllTest() {
		List<Item> items = repository.findAll();
		assertEquals(3,items.size());
	}
	@Test
	public void getItemNameTest() {
		List<Item> items = repository.findAll();
		assertEquals("Item1", items.get(0).getName());
	}
	
}
