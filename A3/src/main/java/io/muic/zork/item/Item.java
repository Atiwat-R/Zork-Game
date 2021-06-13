package io.muic.zork.item;

public abstract class Item {

    // Attack power modifier and HP modifier
    private int attackMod;
    private int hpMod;

    public void initialize(int hpMod, int attackMod) {
        this.attackMod = attackMod;
        this.hpMod = hpMod;
    }


    // Getters
    public int getAttackMod() {
        return attackMod;
    }
    public int getHpMod() {
        return hpMod;
    }
}
