package io.muic.zork.enemy;

public abstract class Enemy {

    private int maxHP;
    private int hp;
    private int attackPower;

    void initialize(int maxHP, int attackPower) {
        this.maxHP = maxHP;
        this.hp = maxHP;
        this.attackPower = attackPower;
    }

    int retaliate() {
        return attackPower;
    }

}
