package io.muic.zork.item;

// As it goes currently, this provides easier way to create new items, but be less useful in parsing
// EDIT: Combined both.
public enum ItemType {
    LONGSWORD(Longsword.class, 10, 5),
    BATTLEAXE(Battleaxe.class, 25, 3);


    private Class itemClass;
    private int attackMod;
    private int hpMod;

    ItemType(Class itemClass, int attackMod, int hpMod) {
        this.itemClass = itemClass;
        this.attackMod = attackMod;
        this.hpMod = hpMod;
    }

    // Getters
    public Class getItemClass() {
        return itemClass;
    }
    public int getAttackMod() {
        return attackMod;
    }
    public int getHpMod() {
        return hpMod;
    }
}
