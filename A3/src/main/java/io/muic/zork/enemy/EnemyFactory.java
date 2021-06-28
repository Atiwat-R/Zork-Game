package io.muic.zork.enemy;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class EnemyFactory {

    private static final List<EnemyType> REGISTERED_ENEMY = Arrays.asList(
            EnemyType.values()
    );


    private static final Map<String, Enemy> ENEMY_MAP = new HashMap<>();

    static {{
        for (EnemyType enemyType: REGISTERED_ENEMY) {
            try {
                Enemy enemy = (Enemy) enemyType.getEnemyClass().getDeclaredConstructor().newInstance();
                enemy.initialize(enemyType.getStringName(), enemyType.getMaxHP(), enemyType.getAttackPower());
                ENEMY_MAP.put(enemy.getEnemyString(), enemy);
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }}

    /**
     * From the String name of an enemy, return Enemy
     * @param enemy
     * @return
     */
    public static Enemy createEnemy(String enemy) throws CloneNotSupportedException {
        Enemy original = ENEMY_MAP.get(enemy.trim().toLowerCase());
        return (Enemy) original.clone();
    }

    public static List<String> getAllEnemy() {
        return ENEMY_MAP.keySet().stream().collect(Collectors.toList());
    }





















//
//    // HashMap housing all entity's class.
//    private static Map<EnemyType, Class> enemyClassMap = new HashMap<>() {{
//        // Initiate and fill up HashMap
//        EnemyType[] enemyTypes = EnemyType.values();
//        for (int i = 0; i < enemyTypes.length; i++) {
//            put(enemyTypes[i], enemyTypes[i].getEnemyClass());
//        }
//    }};
//
//    public static Enemy createEnemy(EnemyType enemyType) { // eg. enemyType.SKELETON
//        Class enemyClass = enemyClassMap.get(enemyType);
//        if (enemyClass != null) {
//            try {
//                // If enemyClass is valid, create and initiate them
//                Enemy enemy = (Enemy) enemyClass.newInstance();
//                enemy.initialize(enemyType.getMaxHP(), enemyType.getAttackPower());
//                return enemy;
//            } catch (IllegalAccessException e) {
//                e.printStackTrace();
//            } catch (InstantiationException e) {
//                e.printStackTrace();
//            }
//        }
//        throw new IllegalArgumentException("Unknown enemyType");
//    }



}
