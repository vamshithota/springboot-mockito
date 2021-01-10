package com.company.springbootmockitio.buisness;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import com.company.springbootmockitio.data.ItemRepository;
import com.company.springbootmockitio.model.Item;

@ExtendWith(MockitoExtension.class)
public class ItemBuisnessTest {
	
	@InjectMocks
	private ItemBuisnessTest buisnessTest;
	
	@Mock
	private ItemRepository itemRepository;
	
	@Test
	public void findAllTest() {
		when(itemRepository.findAll()).thenReturn((Arrays.asList(new Item(2,"Item2",10,10),
				new Item(3,"Item3",20,20))));
		List<Item> items = itemRepository.findAll();
		assertEquals(10, items.get(0).getQuantity());
		assertEquals(20, items.get(1).getPrice());
	}
	
	

}
