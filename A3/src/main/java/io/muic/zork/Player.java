package io.muic.zork;

import io.muic.zork.item.Item;

public class Player {

    private int maxHP;
    private int hp;
    private int attackPower;
    private Item item;

    // For Singleton pattern, lazy initialization.
    private static Player player_instance = null;

    // Private Constructor
    private Player() {
        this.maxHP = 100;
        this.hp = this.maxHP;
        this.attackPower = 20;
    }

    // Method to return the singular instance of Player
    public static Player getInstance() {
        if (player_instance == null) {
            player_instance = new Player();
        }
        return player_instance;
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
