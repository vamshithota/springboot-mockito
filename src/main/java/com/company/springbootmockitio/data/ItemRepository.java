package com.company.springbootmockitio.data;

import org.springframework.data.jpa.repository.JpaRepository;

import com.company.springbootmockitio.model.Item;

public interface ItemRepository extends JpaRepository<Item, Integer>{


}
