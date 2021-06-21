package io.muic.zork.enemy;

public abstract class Enemy {

    private boolean alive;
    private int maxHP;
    private int hp;
    private int attackPower;

    /**
     * Return String representation of the enemy. Very useful for GameMap.
     * Must be in lowercase.
     * @return
     */
    public abstract String getEnemyString();

    /**
     * Initialize enemy's basic parameters upon creation.
     * @param maxHP
     * @param attackPower
     */
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
    public void calculateNewHP(int amount) { //TODO: Override this method to give overheal passives (heal over maxHP) to some enemy
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

    /**
     * Return status of the enemy.
     * @return
     */
    public boolean isAlive() {
        return alive;
    }

    // Getters
    public int getMaxHP() { return maxHP; }
    public int getHp() {
        return hp;
    }
    public int getAttackPower() {
        return attackPower;
    }
}
