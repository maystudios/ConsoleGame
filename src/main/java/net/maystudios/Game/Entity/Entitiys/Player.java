package net.maystudios.Game.Entity.Entitiys;

import net.maystudios.Game.Entity.Entity;
import net.maystudios.Game.Item.Item;
import net.maystudios.InputHandler.StoryHandler.Map.Location;

public class Player extends Entity {

    Item weapon;

    public Player(String name, int HP, int ATK, int DEF, int SPD, int LVL, int EXP) {
        super(name, HP, ATK, DEF, SPD, LVL, EXP);
    }

    @Override
    public void attack(Entity target) {
        if (weapon == null) {
            target.getDamage(this.getATK());
            System.out.println("Player attacked -> " + target + " for " + this.getATK() + " damage");
            return;
        }
        target.getDamage(this.getATK() + weapon.getEffect());
        System.out.println("Player attacked -> " + target + " for " + (this.getATK() + weapon.getEffect()) + " damage");
    }

    public void equip(Item weapon) {
        this.weapon = weapon;
    }

    @Override
    public String toString() {
        return "Player: " + super.toString();
    }

    @Override
    public void move(Location location) {
        super.move(location);
        location.enter();
    }
}
