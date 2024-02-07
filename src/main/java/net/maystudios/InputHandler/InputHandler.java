package net.maystudios.InputHandler;

import net.maystudios.InputHandler.StoryHandler.StoryElement;

import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class InputHandler<K, T, R> {

    private String question;
    private HashMap<K, T> map;
    private Function<T, R> handler;
    private Scanner scanner;

    public InputHandler(String question, HashMap<K, T> map, Function<T, R> handler) {
        this.scanner = new Scanner(System.in);
        this.question = question;
        this.map = map;
        this.handler = handler;
        System.out.println("InputHandler class loaded");
    }

    public R askAndHandle() {
        T input = ask();
        return handler.apply(input);
    }

    private T ask() {
        System.out.println(this.question);
        String type = "";
        for (Map.Entry<K, T> entry : this.map.entrySet()) {
            type += entry.getKey() + " ";
        }
        System.out.println("Type: " + type);
        String input = this.getInput();

        // verify input, if not in map, ask again
        while (!this.map.containsKey(input)) {
            System.out.println("Invalid input, please try again");
            input = this.getInput();
        }

        System.out.println("You have selected: " + input);
        return this.map.get(input);
    }

    public void addCommand(K key, T value) {
        this.map.put(key, value);
    }

    private String getInput() {
        return this.scanner.nextLine();
    }

    public void close() {
        this.scanner.close();
    }
}