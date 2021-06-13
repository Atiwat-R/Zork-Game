package io.muic.zork.enemy;

public abstract class Enemy {

    private boolean alive;
    private int maxHP;
    private int hp;
    private int attackPower;

    public void initialize(int maxHP, int attackPower) {
        alive = true;
        this.maxHP = maxHP;
        this.hp = maxHP;
        this.attackPower = attackPower;
    }

    /**
     * Calculate new hp after it took damage or got healed.
     * If amount is positive, it damages the entity. Die if hp reaches 0.
     * If amount is negative, it heals the entity.
     * @param amount
     * @return
     */
    public void calculateNewHP(int amount) { //TODO: Override this method to give overheal passives to some enemy
        hp = hp - amount;
        if (hp < 0) alive = false;
        else if (hp > maxHP) hp = maxHP;
    }

    /**
     * Return enemy's reaction to player's attack as amount to damage
     * it deals to player.
     * By default, it returns base attackPower
     */
    public int retaliate() {
        return attackPower;
    }

    public boolean isAlive() {
        return alive;
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
