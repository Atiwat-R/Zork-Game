package io.muic.zork;


import io.muic.zork.item.Item;
import io.muic.zork.item.ItemFactory;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        Game game = new Game();
        game.run();

//        Enemy aa = EnemyFactory.createEnemy(EnemyType.DREAD_WORM);

//        Item cc = ItemFactory.createItem("maSaMuNe");
//        System.out.println(cc.getAttackMod());

//        Enemy dd = EnemyFactory.getEnemy("AgamEmNon");
//        System.out.println(dd.getMaxHP());
    }
}
