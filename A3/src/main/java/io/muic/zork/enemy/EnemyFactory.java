package io.muic.zork.enemy;

import java.util.HashMap;
import java.util.Map;

public class EnemyFactory {


    // HashMap housing all entity's class.
    private static Map<EnemyType, Class> enemyClassMap = new HashMap<>() {{
        // Initiate and fill up HashMap
        EnemyType[] enemyTypes = EnemyType.values();
        for (int i = 0; i < enemyTypes.length; i++) {
            put(enemyTypes[i], enemyTypes[i].getEnemyClass());
        }
    }};

    public static Enemy createEnemy(EnemyType enemyType) { // eg. enemyType.SKELETON
        Class enemyClass = enemyClassMap.get(enemyType);
        if (enemyClass != null) {
            try {
                // If enemyClass is valid, create and initiate them
                Enemy enemy = (Enemy) enemyClass.newInstance();
                enemy.initialize(enemyType.getMaxHP(), enemyType.getAttackPower());
                return enemy;
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            }
        }
        throw new IllegalArgumentException("Unknown enemyType");
    }



}
