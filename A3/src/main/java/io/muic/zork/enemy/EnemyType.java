package io.muic.zork.enemy;

import java.awt.*;

public enum EnemyType {
    SKELETON(Skeleton.class, 50, 10),
    DREAD_WORM(DreadWorm.class, 40, 20);


    private Class enemyClass;
    private int maxHP;
    private int attackPower;

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



