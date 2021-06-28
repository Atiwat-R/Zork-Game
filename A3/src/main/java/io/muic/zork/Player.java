package io.muic.zork;

import io.muic.zork.item.Item;

public class Player {

    // Basic variables
    private int maxHP;
    private int hp;
    private int attackPower;
    private int pRow;
    private int pCol;
    private boolean alive;
    private Item itemSlot;
    private Inventory inventory;

    // Default stats at initialization. Position are to be given at the start
    public Player(int pRow, int pCol) {
        this.maxHP = 100;
        this.hp = this.maxHP;
        this.attackPower = 20;
        this.alive = true;
        this.itemSlot = null;
        this.inventory = new Inventory();
        this.setPlayerPosition(pRow, pCol);
    }

    // Player utilities
    public void takeDamage(int amount) { //TODO: Override this method to give overheal passives (heal over maxHP) to some enemy
        hp = hp - amount;
        if (hp < 0) alive = false;
        else if (hp > maxHP) hp = maxHP;
    }


    // Equip the given Item. Stat modifier from the gear is also applied here.
    public void equipItem(Item item) {
        unequipItem();
        maxHP = maxHP + item.getHpMod();
        attackPower = attackPower + item.getAttackMod();
        itemSlot = item;
    }

    // Remove equipped item and its passives
    public void unequipItem() {
        if (itemSlot != null) {
            maxHP = maxHP - itemSlot.getHpMod();
            attackPower = attackPower - itemSlot.getAttackMod();
            itemSlot = null;
        }
    }

    public void printCurrentStatus() {
        System.out.println("-----------------------");
        System.out.println("PLAYER STATUS:");

        // Stats
        System.out.printf("HP: %d/%d\n", hp, maxHP);
        System.out.printf("Attack Power: %d\n", attackPower);

//        // Item TODO: Equippable weapon system. Work in progress.
//        String itemString;
//        if (itemSlot != null) itemString = itemSlot.getItemString();
//        else itemString = "None";
//        System.out.printf("Item Equipped: %s\n", itemString);

        // Inventory
        String inventoryContent = inventory.getInventory().keySet().toString();
        System.out.printf("Inventory: %s\n", inventoryContent);

        // Position
        System.out.printf("[Row,Column]: (%d,%d)\n", pRow, pCol);
        System.out.println("-----------------------");
    }




    // Getters
    public int getMaxHP() {
        return maxHP;
    }
    public int getHp() {
        return hp;
    }
    public int getAttackPower() {
        return attackPower;
    }
    public int getpRow() {
        return pRow;
    }
    public int getpCol() {
        return pCol;
    }
    public boolean isAlive() {
        return alive;
    }
    public Item getItemSlot() {
        return itemSlot;
    }
    public Inventory getInventory() {
        return inventory;
    }

    // Setter

    /**
     * Completely set player's coordinate to the input coordinate.
     * @param row
     * @param col
     */
    public void setPlayerPosition(int row, int col) {
        pRow = row;
        pCol = col;
    }

//    /**
//     * Simply increment player's position by a certain amount.
//     * North (0,-1)
//     * South (0,1)
//     * East (1,0)
//     * West (-1,0)
//     * @param rowIncre
//     * @param colIncre
//     */
//    public void incrementPlayerPosition(int rowIncre, int colIncre) {
//        pRow = pRow + rowIncre;
//        pCol = pRow + colIncre;
//    }





}


/*
 *  Singleton version of Player. Discontinued since it seems unecessary.
 *  Left here just in case.
 */
//public class Player {
//
//    // Basic variables
//    private int maxHP;
//    private int hp;
//    private int attackPower;
//    private int pRow;
//    private int pCol;
//    private Item itemSlot;
//    //TODO: private Inventory inventory;
//
//    // For Singleton pattern, lazy initialization.
//    private static Player player_instance = null;
//
//    // For Singleton pattern, Private Constructor
//    private Player() {
//        this.maxHP = 100;
//        this.hp = this.maxHP;
//        this.attackPower = 20;
//        this.itemSlot = null;
//        pRow = null;
//        pCol = null; //TODO: deal with how reset is gonna go. Eanna make this non-singleton?
//    }
//
//    // For Singleton pattern, a method to return the singular instance of Player
//    public static Player getInstance() {
//        if (player_instance == null) {
//            player_instance = new Player();
//        }
//        return player_instance;
//    }
//
//    // Custom method for Singleton Design, a way to reset the player.
//    private Player resetSingletonPlayer() {
//        if (player_instance != null) {
//            player_instance = null;
//            return Player.getInstance();
//        }
//        return null;
//    }
//
//
//    // Equip the given Item. Stat modifier from the gear is also applied here.
//    public void equipItem(Item item) {
//        unequipItem();
//        maxHP = maxHP + item.getHpMod();
//        attackPower = attackPower + item.getAttackMod();
//        itemSlot = item;
//    }
//    // Remove equipped item and its passives
//    public void unequipItem() {
//        if (itemSlot != null) {
//            maxHP = maxHP - itemSlot.getHpMod();
//            attackPower = attackPower - itemSlot.getAttackMod();
//            itemSlot = null;
//        }
//    }
//
//
//
//    // Getters
//    public int getMaxHP() {
//        return maxHP;
//    }
//    public int getHp() {
//        return hp;
//    }
//    public int getAttackPower() {
//        return attackPower;
//    }
//
//    // Setter
//    public void setPlayerPosition(int row, int col) {
//        pRow = row;
//        pCol = col;
//    }
//}


