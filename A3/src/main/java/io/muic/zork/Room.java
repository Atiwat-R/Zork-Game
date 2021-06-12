package io.muic.zork;

import io.muic.zork.enemy.Enemy;
import io.muic.zork.item.Item;

public class Room {

    // All traversable passages. True if the direction is passable.
    private boolean northDoor;
    private boolean southDoor;
    private boolean eastDoor;
    private boolean westDoor;
    // This room's enemy
    private Enemy enemy;
    // This room's item
    private Item item;

    public Room(boolean north, boolean south, boolean east, boolean west) {
        northDoor = north;
        southDoor = south;
        eastDoor = east;
        westDoor = west;
    }



}
