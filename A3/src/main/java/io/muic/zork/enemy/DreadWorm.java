package io.muic.zork.enemy;


/**
 * A carnivorous worm-like creature, as large as a small child.
 * Not very resilient but its bite can be especially damaging.
 */
public class DreadWorm extends Enemy {

    @Override
    public String getEnemyString() {
        return "dreadworm";
    }

    // Extra percent
//    @Override
//    public int retaliate() {
//        return attackPower;
//    }

}
