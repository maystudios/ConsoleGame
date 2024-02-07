package net.maystudios;

import net.maystudios.Game.Entity.Entitiys.Boss;
import net.maystudios.Game.Entity.Entitiys.Player;
import net.maystudios.Game.Entity.Entity;
import net.maystudios.InputHandler.InputHandler;
import net.maystudios.InputHandler.Message.MessageHandler.MessageHandler;
import net.maystudios.InputHandler.StoryHandler.Map.Location;
import net.maystudios.InputHandler.StoryHandler.Map.Locations.EmptyLocation;
import net.maystudios.InputHandler.StoryHandler.Map.Locations.SimpleLocation;
import net.maystudios.InputHandler.StoryHandler.Map.Map;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {

        /*
        Entity boss = new Boss("mini Boss", 100, 10, 5, 5, 1, 0);
        Entity player = new Player("Player", 100, 10, 5, 5, 1, 0);



        InputHandler<String, Byte, Void> inputHandler = new InputHandler<>("Next Action: ", new HashMap<String, Byte>() {{
            put("attack", (byte) 1);
            put("heal", (byte) 2);
        }}, (Byte input) -> {
            switch (input) {
                case 1:
                    loadingAnimation(2);
                    player.attack(boss);
                    break;
                case 2:
                    player.heal(10);
                    loadingAnimation(2);
                    MessageHandler.printMessageBox("Player healed -> " + player, MessageHandler.Color.GREEN);
                    break;
                default:
                    System.out.println("Invalid action");
            }
            return null;
        });


        while(!boss.isDead()) {
            inputHandler.askAndHandle();
            loadingAnimation(4);
            boss.attack(player);
            MessageHandler.printMessageBox("Boss attacked -> " + player, MessageHandler.Color.RED);
        }
        */

        // Create a new player
        Player player = new Player("Player", 100, 10, 5, 5, 1, 0);
        // Create a new boss
        Entity boss = new Boss("mini Boss", 100, 10, 5, 5, 1, 0, new Location.Coord(1, 2));

        Map map = new Map(6, 6, player);
        // create random map

        for (int x = 0; x < map.getX(); x++) {
            for (int y = 0; y < map.getY(); y++) {
                System.out.println("x: " + x + " y: " + y);
                if (Math.random() > 0.25) {
                    map.addLocation(new SimpleLocation("Wald " + (map.getX() * x + y), "Wald", new Location.Coord(x, y), map));
                    if (Math.random() > 0.75) {
                        System.out.println("Boss added");
                        map.getLocation(new Location.Coord(x, y)).addEntity(boss);
                    }
                } else {
                    map.addLocation(new EmptyLocation("Fells " + (map.getX() * x + y), "Fells", new Location.Coord(x, y), map));
                }
            }
        }


        // load first enter
        player.move(map.getLocation(player.getCoord()));

        map.printMapBox(MessageHandler.Color.WHITE, MessageHandler.Color.GREEN);

        while(!boss.isDead()) {
            // Create a new input handler for the player's actions (Accessible neighbors of the player's location)
            // The neighbors can be getted by there names in map, getLocationByName(String name)

            InputHandler<String, String, Void> inputHandler = new InputHandler<>("Next Action: ", new HashMap<String, String>() {{
                for (Location loc : map.getLocation(player.getCoord()).getAccessibleNeighbors()) {
                    put(loc.getName(), loc.getName());
                }
            }}, (String input) -> {
                // Move the player to the selected location
                player.move(map.getLocationByName(input));
                map.printMapBox(MessageHandler.Color.WHITE, MessageHandler.Color.GREEN);
                return null;
            });

            inputHandler.askAndHandle();
        }

        }



    private static void loadingAnimation(double secondsToWait) {
        // loading animation, with 3 dots, which appear like ... -> . -> .. -> ... and repeat every 250ms
        // it deletes the previous line and prints the new one
        String[] dots = {"", ".", "..", "..."};
        for (int i = 0; i < (secondsToWait * 1000) / 250; i++) {
            try {
                Thread.sleep(250);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.print("\r" + dots[i % 4]);
        }
        // delete the last line
        System.out.print("\r");
    }

}