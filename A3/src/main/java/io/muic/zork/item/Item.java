package io.muic.zork.item;

public abstract class Item {

    // Attack power modifier and HP modifier
    private int attackMod;
    private int hpMod;

    /**
     * Return String representation of the item. Very useful for parser.
     * Must be in lowercase.
     * @return
     */
    public abstract String getItemString();

    public void initialize(int hpMod, int attackMod) {
        this.attackMod = attackMod;
        this.hpMod = hpMod;
    }

    // Getters
    public int getAttackMod() { //TODO: can be overridden for special weapon effects?
        return attackMod;
    }
    public int getHpMod() {
        return hpMod;
    }
}
