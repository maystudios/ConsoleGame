package net.maystudios.InputHandler.StoryHandler.Map.Locations;

import net.maystudios.InputHandler.StoryHandler.Map.Location;
import net.maystudios.InputHandler.StoryHandler.Map.Map;

public class SimpleLocation extends Location {


    public SimpleLocation(String name, String description, Coord coord, Map map) {
        super(name, description, coord, map);
    }

    @Override
    public void enter() {
       setRevealed(true);

       // reveal all neighbors
         for (Location neighbor : this.getNeighbors()) {
             if (neighbor != null) neighbor.setRevealed(true);
         }
    }

    @Override
    public void leave() {

    }

    @Override
    public boolean isAccessible() {
        return true;
    }
}
