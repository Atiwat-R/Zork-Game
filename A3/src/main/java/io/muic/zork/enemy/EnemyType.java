package io.muic.zork.enemy;

import java.awt.*;

public enum EnemyType {
    SKELETON(Skeleton.class, 50, 10),
    DREAD_WORM(DreadWorm.class, 40, 20),
    AGAMEMNON(Agamemnon.class, 1000, 50);


    private Class enemyClass;
    private int maxHP;
    private int attackPower;
//     private String stringName; //TODO: Using this, you can make it so that the enemy's String name is declared here instead of having to manually Override it again at its class. But should you?

    // Constructor
    EnemyType(Class enemyClass, int maxHP, int attackPower) {
        this.enemyClass = enemyClass;
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

}



