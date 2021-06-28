package io.muic.zork.enemy;

import java.awt.*;

public enum EnemyType {
    SKELETON(Skeleton.class, "skeleton", 50, 10),
    DREAD_WORM(DreadWorm.class, "dreadworm", 40, 20),
    AGAMEMNON(Agamemnon.class, "agamemnon",1000, 50);


    private Class enemyClass;
    private String stringName; //TODO: Using this, you can make it so that the enemy's String name is declared here instead of having to manually Override it again at its class. But should you?
    private int maxHP;
    private int attackPower;

    // Constructor
    EnemyType(Class enemyClass, String stringName, int maxHP, int attackPower) {
        this.enemyClass = enemyClass;
        this.stringName = stringName;
        this.maxHP = maxHP;
        this.attackPower = attackPower;
    }

    // Getters
    public Class getEnemyClass() {
        return enemyClass;
    }
    public int getMaxHP() {
        return maxHP;
    }
    public int getAttackPower() {
        return attackPower;
    }
    public String getStringName() {
        return stringName;
    }
}



