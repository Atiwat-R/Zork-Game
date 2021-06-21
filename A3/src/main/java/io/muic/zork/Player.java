package io.muic.zork;

import io.muic.zork.item.Item;

public class Player {

    // Basic variables
    private int maxHP;
    private int hp;
    private int attackPower;
    private int pRow;
    private int pCol;
    private Item itemSlot;
    //TODO: private Inventory inventory;

    // For Singleton pattern, lazy initialization.
    private static Player player_instance = null;

    // For Singleton pattern, Private Constructor
    private Player() {
        this.maxHP = 100;
        this.hp = this.maxHP;
        this.attackPower = 20;
        this.itemSlot = null;
    }

    // For Singleton pattern, a method to return the singular instance of Player
    public static Player getInstance() {
        if (player_instance == null) {
            player_instance = new Player();
        }
        return player_instance;
    }

    // Custom method for Singleton Design, a way to reset the player.
    private Player resetSingletonPlayer() {
        if (player_instance != null) {
            player_instance = null;
            return Player.getInstance();
        }
        return null;
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
}
