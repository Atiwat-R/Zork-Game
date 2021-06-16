package io.muic.zork.item;

import io.muic.zork.command.AttackWithCommand;
import io.muic.zork.command.Command;
import io.muic.zork.command.ExitCommand;
import io.muic.zork.command.InfoCommand;
import io.muic.zork.enemy.Enemy;
import io.muic.zork.enemy.EnemyType;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ItemFactory {

    private static final List< Class<? extends Item> > REGISTERED_ITEM = Arrays.asList(
            Longsword.class
    );

    private static final Map<String, Item> ITEM_MAP = new HashMap<>();

    static {{
        for (Class<? extends Item> itemClass: REGISTERED_ITEM) {
            try {
                Item item = itemClass.getDeclaredConstructor().newInstance();
//                item.initialize(itemType.getHpMod(), itemType.getAttackMod()); ???
                ITEM_MAP.put(item.getItemString(), item);
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }}


    public static Item get(String item) {
        return ITEM_MAP.get(item);
    }

    public static List<String> getAllItem() {
        return ITEM_MAP.keySet().stream().collect(Collectors.toList());
    }








//    // HashMap housing all entity's class.
//    private static Map<ItemType, Class> itemClassMap = new HashMap<>() {{
//        // Initiate and fill up HashMap
//        ItemType[] itemTypes = ItemType.values();
//        for (int i = 0; i < itemTypes.length; i++) {
//            put(itemTypes[i], itemTypes[i].getItemClass());
//        }
//    }};
//
//    public static Item createItem(ItemType itemType) { // eg. itemType.LONGSWORD
//        Class itemClass = itemClassMap.get(itemType);
//        if (itemClass != null) {
//            try {
//                // If itemClass is valid, create and initiate them
//                Item item = (Item) itemClass.newInstance();
//                item.initialize(itemType.getHpMod(), itemType.getAttackMod());
//                return item;
//            } catch (IllegalAccessException e) {
//                e.printStackTrace();
//            } catch (InstantiationException e) {
//                e.printStackTrace();
//            }
//        }
//        throw new IllegalArgumentException("Unknown itemType");
//    }


}
