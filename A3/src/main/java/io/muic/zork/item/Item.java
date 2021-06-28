package io.muic.zork.item;

public abstract class Item {

    // Attack power modifier and HP modifier
    private int attackMod;
    private int hpMod;
    private String stringName;

    /**
     * Return String representation of the item. Very useful for parser.
     * Must be in lowercase.
     * @return
     */
    public String getItemString() {return stringName;}

    /**
     * Initialize item's basic parameters upon creation.
     * @param hpMod
     * @param attackMod
     */
    public void initialize(String stringName, int hpMod, int attackMod) {
        this.stringName = stringName;
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
