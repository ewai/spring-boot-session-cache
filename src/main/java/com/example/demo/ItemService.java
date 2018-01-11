package com.example.demo;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class ItemService {

    @Cacheable(cacheNames = "item")
    public Item getItem(String itemCode) {
        Item item = ItemDao.getItem("test");
        return item;
    }

}
