package net.maystudios.InputHandler.StoryHandler.Map;

import net.maystudios.Game.Entity.Entitiys.Player;
import net.maystudios.InputHandler.Message.MessageHandler.MessageHandler;
import net.maystudios.InputHandler.StoryHandler.Map.Locations.EmptyLocation;
import net.maystudios.InputHandler.StoryHandler.Map.Locations.SimpleLocation;

public class Map {

    Location[][] map;

    public int getX() {
        return map.length;
    }

    public int getY() {
        return map[0].length;
    }
    Player player;

    public Map(int x, int y) {
        this.map = new Location[x][y];
        player = null;
    }

    public Map(int x, int y, Player player) {
        this.map = new Location[x][y];
        this.player = player;
    }

    public void addLocation(Location location) {
        this.map[location.getX()][location.getY()] = location;
    }

    public Location getLocationByName(String name) {
        for (Location[] locations : this.map) {
            for (Location location : locations) {
                if (location != null && location.getName().equals(name)) {
                    return location;
                }
            }
        }
        return null;
    }

    public void printMapBox(MessageHandler.Color color, MessageHandler.Color playerColor) {
        // Fixed dimensions for location boxes
        final int width = 12;  // Width of each location box
        final int height = 5;  // Height of each location box including borders

// Print the map, location by location, and the player's location
        for (int i = 0; i < this.map.length; i++) {
            for (int h = 0; h < height; h++) {
                for (int j = 0; j < this.map[i].length; j++) {
                    Location loc = this.map[i][j];
                    // Print top border
                    if (h == 0) {
                        System.out.print(color.getColorCode() + "┎" + "─".repeat(width - 2) + "┒");
                    } else if (h == height - 1) { // Print bottom border
                        System.out.print(color.getColorCode() + "┖" + "─".repeat(width - 2) + "┚");
                    } else if (h == height / 2 && loc != null) { // Center the location name
                        String name = (loc.isRevealed() ? loc.getName() : "???");
                        int nameLength = name.length();
                        int padding = (width - 2 - nameLength) / 2;
                        String leftPad = " ".repeat(padding);
                        String rightPad = " ".repeat(width - 2 - padding - nameLength);
                        System.out.print(color.getColorCode() + "┃" + leftPad + (!loc.isAccessible() ? MessageHandler.Color.RED.getColorCode() : "") + name + (!loc.isAccessible() ? color.getColorCode() : "") + rightPad + "┃");
                    } else if (h == height / 2 - 1 && loc != null ) { // Print "Entities" over the location name if this is the player's location // && loc.coord.equals(this.player.getCoord())
                        String name = loc.getEntities().length > 0 ? "E: " + loc.getEntities().length : "";
                        int nameLength = name.length();
                        int padding = (width - 2 - nameLength) / 2;
                        String leftPad = " ".repeat(padding);
                        String rightPad = " ".repeat(width - 2 - padding - nameLength);
                        System.out.print("┃" + leftPad + MessageHandler.Color.BLUE.getColorCode() + name + color.getColorCode() + rightPad + "┃"); // Use a different color for the player's name
                    } else if (h == height / 2 + 1 && loc != null && loc.coord.equals(this.player.getCoord())) { // Print "Player" under the location name if this is the player's location
                        String name = "Player";
                        int nameLength = name.length();
                        int padding = (width - 2 - nameLength) / 2;
                        String leftPad = " ".repeat(padding);
                        String rightPad = " ".repeat(width - 2 - padding - nameLength);
                        System.out.print("┃" + leftPad + playerColor.getColorCode() + name + color.getColorCode() + rightPad + "┃"); // Use a different color for the player's name
                    } else { // Empty space inside the box
                        System.out.print(color.getColorCode() + "┃" + " ".repeat(width - 2) + "┃");
                    }
                }
                System.out.println(MessageHandler.Color.RESET.getColorCode()); // Reset color and move to the next line
            }
        }
    }

    public static void main(String[] args) {
        // Create a new player
        Player player = new Player("Player", 100, 10, 5, 5, 1, 0);
        // Create a new map
        Map map = new Map(3, 3, player);
        map.addLocation(new SimpleLocation("Location 1", "First location", new Location.Coord(0, 0), map));
        map.addLocation(new EmptyLocation("Empty 2", "Second location", new Location.Coord(0, 1), map));
        map.addLocation(new SimpleLocation("Location 3", "Third location", new Location.Coord(0, 2), map));
        map.addLocation(new SimpleLocation("Location 4", "Fourth location", new Location.Coord(1, 0), map));
        map.addLocation(new SimpleLocation("Location 5", "Fifth location", new Location.Coord(1, 1), map));
        map.addLocation(new SimpleLocation("Location 6", "Sixth location", new Location.Coord(1, 2), map));
        map.addLocation(new EmptyLocation("Empty 7", "Seventh location", new Location.Coord(2, 0), map));
        map.addLocation(new SimpleLocation("Location 8", "Eighth location", new Location.Coord(2, 1), map));
        map.addLocation(new SimpleLocation("Location 9", "Ninth location", new Location.Coord(2, 2), map));

        map.printMapBox(MessageHandler.Color.CYAN, MessageHandler.Color.GREEN);

        for (int i = 0; i < 3; i++) {
            System.out.println();
        }

        // print accessible neighbors of the player's location
        System.out.println("Accessible neighbors of the player's location:");
        for (Location loc : map.getLocation(map.player.getCoord()).getAccessibleNeighbors() ) {
            System.out.println(loc.getName());
        }

    }

    public Location getLocation(Location.Coord coord) {
        return this.map[coord.x][coord.y];
    }
}
