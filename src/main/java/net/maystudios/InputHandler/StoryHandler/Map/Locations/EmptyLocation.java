package net.maystudios.InputHandler.StoryHandler.Map.Locations;

import net.maystudios.InputHandler.StoryHandler.Map.Location;
import net.maystudios.InputHandler.StoryHandler.Map.Map;

public class EmptyLocation extends Location {


    public EmptyLocation(String name, String description, Coord coord, Map map) {
        super(name, description, coord, map);
    }

    @Override
    public void enter() {

    }

    @Override
    public void leave() {

    }

    @Override
    public boolean isAccessible() {
        return false;
    }
}
