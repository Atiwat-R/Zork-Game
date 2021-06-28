package io.muic.zork;

import io.muic.zork.enemy.Enemy;
import io.muic.zork.item.Item;

import java.util.Arrays;

public class Room {

    // All traversable passages. True if the direction is passable.
    private boolean northDoor = false;
    private boolean southDoor = false;
    private boolean eastDoor = false;
    private boolean westDoor = false;
    // All traversable passages in String.
    private String allOpenDoors;
    // This room's enemy
    private Enemy enemy;
    // This room's item
    private Item item;


    /**
     * Constructor.
     * @param openDoor
     * @param enemy
     * @param item
     */
    public Room(String openDoor, Enemy enemy, Item item) {
        openDoor = openDoor.toLowerCase();

        // Stored sorted version for further use
        char charArray[] = openDoor.toCharArray();
        Arrays.sort(charArray);
        allOpenDoors = new String(charArray);

        if (allOpenDoors.indexOf('n') > 0) northDoor = true;
        if (allOpenDoors.indexOf('s') > 0) southDoor = true;
        if (allOpenDoors.indexOf('e') > 0) eastDoor = true;
        if (allOpenDoors.indexOf('w') > 0) westDoor = true;

//        if (enemy != null) this.enemy = enemy;
//        if (item != null) this.item = item;

        this.enemy = enemy;
        this.item = item;
    }
    public Room(String openDoor) {
        this(openDoor, null, null);
    }


    public void removeDeadEnemy() {
        if (!enemy.isAlive()) this.enemy = null;
    }

    public void printRoomContent() {
        String enemyString;
        String itemString;

        if (enemy != null) enemyString = enemy.getEnemyString();
        else enemyString = "No enemy";
        if (item != null) itemString = item.getItemString();
        else itemString = "No item";

        System.out.printf("Doors Open: %s\n", allOpenDoors.toUpperCase());
        System.out.printf("Enemy: %s\n", enemyString);
        System.out.printf("Item: %s\n", itemString);
        System.out.println("-----------------------");



//        if (enemy == null) {
//            System.out.println("Enemy: No enemy");
//        } else {
//            System.out.printf("Enemy: ", enemy.getEnemyString());
//        }
//        if (item == null) {
//            System.out.println("No item");
//        } else {
//            System.out.println(item.getItemString());
//        }
    }




    // Getter
    public String getAllOpenDoors() {
        return allOpenDoors;
    }

    public Enemy getEnemy() {
        return enemy;
    }

    public Item getItem() {
        return item;
    }

    //Setter
    public void setEnemy(Enemy enemy) {
        this.enemy = enemy;
    }

    public void setItem(Item item) {
        this.item = item;
    }

}
