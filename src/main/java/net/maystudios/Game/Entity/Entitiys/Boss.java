package net.maystudios.Game.Entity.Entitiys;

import net.maystudios.Game.Entity.Entity;
import net.maystudios.InputHandler.StoryHandler.Map.Location;
import net.maystudios.Main;

public class Boss extends Entity {

    public Boss(String name, int HP, int ATK, int DEF, int SPD, int LVL, int EXP) {
        super(name, HP, ATK, DEF, SPD, LVL, EXP);
    }

    public Boss(String name, int HP, int ATK, int DEF, int SPD, int LVL, int EXP, Location.Coord coord) {
        super(name, HP, ATK, DEF, SPD, LVL, EXP, coord);
    }

    @Override
    public void attack(Entity target) {
        int damage = (int) ((int) this.getATK() * (Math.random() * 3));
        target.getDamage(damage);
        System.out.println("Boss attacked -> " + target  + " for " + damage + " damage");
    }

    @Override
    public String toString() {
        return "Boss: " + super.toString();
    }
}
