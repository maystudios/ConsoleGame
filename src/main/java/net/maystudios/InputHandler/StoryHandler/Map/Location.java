package net.maystudios.InputHandler.StoryHandler.Map;

import net.maystudios.Game.Entity.Entity;

public abstract class Location {



        public static class Coord {
            public int x;
            public int y;

            public Coord(int x, int y) {
                this.x = x;
                this.y = y;
            }

        public boolean equals(Coord other) {
            return this.x == other.x && this.y == other.y;
        }

        public Coord add(Coord other) {
            return new Coord(this.x + other.x, this.y + other.y);
        }

        public Coord subtract(Coord other) {
            return new Coord(this.x - other.x, this.y - other.y);
        }

        public Coord multiply(int scalar) {
            return new Coord(this.x * scalar, this.y * scalar);
        }

        public Coord divide(int scalar) {
            return new Coord(this.x / scalar, this.y / scalar);
        }

        public int distance(Coord other) {
            return Math.abs(this.x - other.x) + Math.abs(this.y - other.y);
        }

        public Coord copy() {
            return new Coord(this.x, this.y);
        }

        public String toString() {
            return "(" + this.x + ", " + this.y + ")";
        }


    }

    String name;
    String description;
    // on grid map, nabors are the 4 directions
    Coord coord;

    public Coord getCoord() {
        return coord;
    }
    boolean isRevealed;

    // reference to the map
    Map map;

    Entity[] entities = new Entity[0];

    public Location(String name, String description, Coord coord, Map map) {
        this.name = name;
        this.description = description;
        this.coord = coord;
        this.isRevealed = false;
        this.map = map;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getX() {
        return coord.x;
    }

    public int getY() {
        return coord.y;
    }

    public boolean isRevealed() {
        return isRevealed;
    }

    public void setRevealed(boolean isRevealed) {
        this.isRevealed = isRevealed;
    }

    public Entity[] getEntities() {
        return entities;
    }

    public void addEntity(Entity entity) {
        Entity[] newEntities = new Entity[entities.length + 1];
        for (int i = 0; i < entities.length; i++) {
            newEntities[i] = entities[i];
        }
        newEntities[entities.length] = entity;
        entities = newEntities;
    }

    public Location[] getNeighbors() {
        Location[] neighbors = new Location[4];
        // check if the neighbor is within the map
        neighbors[0] = (coord.x > 0) ? map.map[coord.x - 1][coord.y] : null;
        neighbors[1] = (coord.x < map.map.length - 1) ? map.map[coord.x + 1][coord.y] : null;
        neighbors[2] = (coord.y > 0) ? map.map[coord.x][coord.y - 1] : null;
        neighbors[3] = (coord.y < map.map[0].length - 1) ? map.map[coord.x][coord.y + 1] : null;

        return neighbors;
    }

    public Location[] getAccessibleNeighbors() {
        Location[] neighbors = getNeighbors();
        int count = 0;
        for (Location neighbor : neighbors) {
            if (neighbor != null && neighbor.isAccessible()) {
                count++;
            }
        }
        Location[] accessibleNeighbors = new Location[count];
        count = 0;
        for (Location neighbor : neighbors) {
            if (neighbor != null && neighbor.isAccessible()) {
                accessibleNeighbors[count] = neighbor;
                count++;
            }
        }
        return accessibleNeighbors;
    }

    public abstract void enter();
    public abstract void leave();

    public abstract boolean isAccessible();
}
