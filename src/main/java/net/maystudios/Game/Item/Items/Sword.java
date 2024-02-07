package net.maystudios.Game.Item.Items;

import net.maystudios.Game.Item.Item;

public class Sword implements Item {

    String name = "Sword";
    int cost = 100;
    int effect = 10;
    String description = "A sword that increases your attack by 10";


    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getCost() {
        return cost;
    }

    @Override
    public int getEffect() {
        return effect;
    }

    @Override
    public String getDescription() {
        return description;
    }
}
