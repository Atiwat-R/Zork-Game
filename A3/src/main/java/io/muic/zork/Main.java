package io.muic.zork;


import io.muic.zork.enemy.Enemy;
import io.muic.zork.enemy.EnemyFactory;
import io.muic.zork.enemy.EnemyType;
import io.muic.zork.item.Item;
import io.muic.zork.item.ItemFactory;
import io.muic.zork.item.ItemType;

public class Main {

    public static void main(String[] args) {
        Game game = new Game();
//        game.run();

        Enemy aa = EnemyFactory.createEnemy(EnemyType.DREAD_WORM);
        Item bb = ItemFactory.createItem(ItemType.LONGSWORD);
        System.out.println(bb.getAttackMod());
    }
}
