package com.example.demo;

public class ItemDao {

    public static Item getItem(String itemCode) {
        Item item = new Item();
        item.setItemCode(itemCode);

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
        }

        return item;
    }
}
