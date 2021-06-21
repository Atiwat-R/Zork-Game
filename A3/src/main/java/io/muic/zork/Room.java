package io.muic.zork;

import io.muic.zork.enemy.Enemy;
import io.muic.zork.item.Item;

public class Room {

    // All traversable passages. True if the direction is passable.
    private boolean northDoor = false;
    private boolean southDoor = false;
    private boolean eastDoor = false;
    private boolean westDoor = false;
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
        if (openDoor.indexOf('n') > 0) northDoor = true;
        if (openDoor.indexOf('s') > 0) southDoor = true;
        if (openDoor.indexOf('e') > 0) eastDoor = true;
        if (openDoor.indexOf('w') > 0) westDoor = true;

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
        if (enemy == null) {
            System.out.println("No enemy");
        } else {
            System.out.println(enemy.getEnemyString());
        }
        if (item == null) {
            System.out.println("No item");
        } else {
            System.out.println(item.getItemString());

        }
        System.out.println("-------------------");

    }



}
