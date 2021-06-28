package io.muic.zork.command;

import io.muic.zork.Game;
import io.muic.zork.Room;
import io.muic.zork.enemy.Enemy;
import io.muic.zork.item.Item;

import java.io.IOException;
import java.util.List;

public class AttackWithCommand implements Command{

    @Override
    public int numArgs() {
        return 1;
    }

    @Override
    public String getCommandString() {
        return "attack with";
    }

    @Override
    public void execute(Game game, List<String> args) throws IOException {
        // This command is only available at Gameplay
        if (game.isStartScreen()) {
            System.out.println("!!! Only avalable during Gameplay !!!");
            return;
        }
        Item weapon = game.getPlayer().getInventory().getItem(args.get(0)); // Weapon to attack with

        // If player did not possess the weapon or it didn't exists
        if (weapon == null) {
            System.out.println("!!! Weapon not found !!!");
            return;
        }

        int pRow = game.getPlayer().getpRow();
        int pCol = game.getPlayer().getpCol();
        Room currentRoom = game.getGameMap().getRoomAt(pRow, pCol); // Get current room the player is in
        Enemy enemy = currentRoom.getEnemy(); // Enemy in current room

        // If there's no enemy
        if (enemy == null) {
            System.out.println("!!! There's no enemy here !!!");
            return;
        }

        // Calculating Enemy's new HP
        int playerAttackDamage = game.getPlayer().getAttackPower() + weapon.getAttackMod(); // Damage the player deals to the enemy. BaseDmg + WeaponMod.
        enemy.takeDamage(playerAttackDamage); // enemy got hit
        System.out.printf("%s has taken %d damage! [%d/%d]\n", enemy.getEnemyString(), playerAttackDamage, enemy.getHp(), enemy.getMaxHP()); //TODO: It somehow links back to the same enemy!?

        // Check if the enemy's dead yet
        if (!currentRoom.removeDeadEnemy()) {
            // Enemy isn't dead; it retaliates. Calculating Player's new HP
            int enemyAttackDamage = enemy.retaliate();
            game.getPlayer().takeDamage(enemyAttackDamage);
            System.out.printf("Player has taken %d damage! [%d/%d]\n", enemyAttackDamage, game.getPlayer().getHp(), game.getPlayer().getMaxHP());
        }

        // If Player hp reaches 0, dies.
        if (!game.getPlayer().isAlive()) {
            game.gameOver();
        }


    }

}
