package com.company.springbootmockitio.buisness;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.company.springbootmockitio.data.ItemRepository;
import com.company.springbootmockitio.model.Item;
@Component
public class ItemBusinessService {

	
	@Autowired
	private ItemRepository repository;
	
	public Item retreiveHardcodedItem() {
		return new Item(1, "Ball", 10, 100);
	}
	
	public List<Item> retrieveAllItems() {
		List<Item> items = repository.findAll();
		
		for(Item item:items) {
			item.setValue(item.getPrice() * item.getQuantity());
		}
		
		return items;	
	}
}
