package net.maystudios.Game.Entity;

import net.maystudios.InputHandler.StoryHandler.Map.Location;

public abstract class Entity {

    int HP;
    int DEF;
    int ATK;
    int SPD;
    int LVL;
    int EXP;
    int MAX_HP;
    String name;

    LevelCalculator levelCalculator;

    private Location.Coord coord = new Location.Coord(0, 0);

    public Location.Coord getCoord() {
        return coord;
    }

    public Entity(String name, int HP, int ATK, int DEF, int SPD, int LVL, int EXP) {
        this.name = name;
        this.HP = HP;
        this.ATK = ATK;
        this.DEF = DEF;
        this.SPD = SPD;
        this.LVL = LVL;
        this.EXP = EXP;
        this.MAX_HP = HP;
    }

    public Entity(String name, int HP, int ATK, int DEF, int SPD, int LVL, int EXP, Location.Coord coord) {
        this.name = name;
        this.HP = HP;
        this.ATK = ATK;
        this.DEF = DEF;
        this.SPD = SPD;
        this.LVL = LVL;
        this.EXP = EXP;
        this.MAX_HP = HP;
        this.coord = coord;
    }

    public void getDamage(int damage) {
        damage -= this.DEF;
        if (HP - damage < 0) {
            this.HP = 0;
            return;
        }
        this.HP -= damage;
    }

    public void heal(int heal) {
        this.HP += heal;
        if (this.HP > this.MAX_HP) {
            this.HP = this.MAX_HP;
        }
    }

    public void levelUp() {
        this.LVL++;
        this.MAX_HP = this.levelCalculator.calculateNewStat(this.MAX_HP, this.LVL);
        this.HP = this.MAX_HP; // heal to full
        this.ATK = this.levelCalculator.calculateNewStat(this.ATK, this.LVL);
        this.DEF = this.levelCalculator.calculateNewStat(this.DEF, this.LVL);
        this.SPD = this.levelCalculator.calculateNewStat(this.SPD, this.LVL);
    }

    public void gainExp(int exp) {
        this.EXP += exp;
        if (this.EXP >= 100) {
            this.EXP -= 100;
            this.levelUp();
        }
    }

    public String getName() {
        return this.name;
    }

    public int getHP() {
        return this.HP;
    }

    public int getATK() {
        return this.ATK;
    }

    public int getDEF() {
        return this.DEF;
    }

    public int getSPD() {
        return this.SPD;
    }

    public int getLVL() {
        return this.LVL;
    }

    public int getEXP() {
        return this.EXP;
    }

    public int getMAX_HP() {
        return this.MAX_HP;
    }

    public void setLevelCalculator(LevelCalculator levelCalculator) {
        this.levelCalculator = levelCalculator;
    }

    public boolean isDead() {
        return this.HP <= 0;
    }

    public abstract void attack(Entity target);


    @Override
    public String toString() {
        return "HP: " + this.HP;
    }


    public void move(Location newLocation) {
        this.coord = newLocation.getCoord();
    }
}
