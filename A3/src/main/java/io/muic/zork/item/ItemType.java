package io.muic.zork.item;

// As it goes currently, this provides easier way to create new items, but be less useful in parsing
// EDIT: Combined both.
public enum ItemType {
    LONGSWORD(Longsword.class,"longsword", 10, 5),
    BATTLEAXE(Battleaxe.class,"battleaxe", 25, 3),
    MASAMUNE(Masamune.class, "masamune", 100, 12);


    private Class itemClass;
    private int attackMod;
    private int hpMod;
    private String stringName;

    ItemType(Class itemClass, String stringName, int attackMod, int hpMod) {
        this.itemClass = itemClass;
        this.attackMod = attackMod;
        this.hpMod = hpMod;
        this.stringName = stringName;
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
    public String getStringName() {
        return stringName;
    }
}
