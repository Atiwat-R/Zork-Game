package io.muic.zork;


import io.muic.zork.enemy.Enemy;
import io.muic.zork.enemy.EnemyFactory;
import io.muic.zork.enemy.EnemyType;
import io.muic.zork.item.Item;
import io.muic.zork.item.ItemFactory;
import io.muic.zork.item.ItemType;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        Game game = new Game();
        game.run();

//        Enemy aa = EnemyFactory.createEnemy(EnemyType.DREAD_WORM);

//        Item cc = ItemFactory.getItem("BATTLEaxe");
//        System.out.println(cc.getHpMod());

//        Enemy dd = EnemyFactory.getEnemy("AgamemNon");
//        System.out.println(dd.getMaxHP());
    }
}
