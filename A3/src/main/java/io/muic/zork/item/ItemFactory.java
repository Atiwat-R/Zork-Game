package io.muic.zork.item;

import io.muic.zork.enemy.Enemy;
import io.muic.zork.enemy.EnemyType;

import java.util.HashMap;
import java.util.Map;

public class ItemFactory {

    // HashMap housing all entity's class.
    private static Map<ItemType, Class> itemClassMap = new HashMap<>() {{
        // Initiate and fill up HashMap
        ItemType[] itemTypes = ItemType.values();
        for (int i = 0; i < itemTypes.length; i++) {
            put(itemTypes[i], itemTypes[i].getItemClass());
        }
    }};

    public static Item createItem(ItemType itemType) { // eg. itemType.LONGSWORD
        Class itemClass = itemClassMap.get(itemType);
        if (itemClass != null) {
            try {
                // If itemClass is valid, create and initiate them
                Item item = (Item) itemClass.newInstance();
                item.initialize(itemType.getHpMod(), itemType.getAttackMod());
                return item;
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            }
        }
        throw new IllegalArgumentException("Unknown itemType");
    }


}
