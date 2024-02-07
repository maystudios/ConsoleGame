package net.maystudios.InputHandler.StoryHandler;

import net.maystudios.InputHandler.InputHandler;

import java.util.HashMap;
import java.util.function.Function;

public abstract class Action {

    // example of a simple action
    // ask a question, get an answer, and run the action
    // the action could be to print a message, or to change the story element
    // the action could be to attack, defend, run, etc.
    // the action could be to heal, attack, etc.

    InputHandler<String, Byte, Void> inputHandler;

    public Action(String question, HashMap<String, Byte> answers, Function<Byte, Void> action) {
        this.inputHandler = new InputHandler<>(question, answers, action);
    }

    public abstract void run();
}
