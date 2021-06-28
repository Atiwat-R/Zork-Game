package io.muic.zork;

import io.muic.zork.item.Item;
import io.muic.zork.item.ItemFactory;

import java.util.HashMap;
import java.util.Map;

public class Inventory {

    private Map<String, Item> inventory;

    // Constructor
    public Inventory() {
        inventory = new HashMap<>();
    }

    // Inventory operations
    /**
     * Add item into inventory
     * @param item item to be added
     * @return true if item is added into inventory, false if not added
     */
    public boolean addItem(Item item) {
        if (item == null) { // Check if there is such item in this Game
            //System.out.println("!!! No such item exists !!!");
            return false;
        }
        else if (inventory.containsKey(item.getItemString())) { // If item's already in inventory
            System.out.println("!!! Item already in inventory !!!");
            return false;
        }
        else { // Item exists, add it to inventory
            inventory.put(item.getItemString(), item);
            return true;
        }
    }
    // For string input version
    public boolean addItem(String itemString) {
        Item item = ItemFactory.createItem(itemString);
        return addItem(item);
    }


    /**
     * Remove item from inventory
     * @param itemString String representation of an item.
     * @return true if item is removed into inventory, false if not removed
     */
    public boolean removeItem(String itemString) {
//        Item item = ItemFactory.createItem(itemString);
//        Item removedItem = inventory.remove(item.getItemString());

        Item removedItem = inventory.remove(itemString.trim().toLowerCase());

        if (removedItem == null) {
            System.out.println("!!! No such item in inventory !!!");
            return false;
        }
        else {
            return true;
        }
    }


    // Getters
    public Map<String, Item> getInventory() {
        return inventory;
    }
}
