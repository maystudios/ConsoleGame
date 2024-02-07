package net.maystudios.InputHandler.StoryHandler;

import net.maystudios.InputHandler.InputHandler;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public abstract class StoryElement<T, R> {

    String question;
    Map<String, StoryElement> answers; // key is the answer, value is the next story element

    InputHandler<String, StoryElement, Void> inputHandlerForStoryElement;
    InputHandler<String, Byte, Void> inputHandlerForAction;

    public StoryElement(String question, HashMap<String, StoryElement> answers, Function<Byte, Void> action) {
        this.question = question;
        this.answers = answers;
        this.inputHandlerForStoryElement = new InputHandler<>(question, answers, (StoryElement input) -> {
            return null;
        });

        // create the input handler, with the question, answers, and action, which is the next story element, or the action to be performed
        this.inputHandlerForAction = new InputHandler<>(question, new HashMap<String, Byte>() {{
            for (String key : answers.keySet()) {
                put(key, (byte) 1);
            }
        }}, action);
    }

    // maybe use the InputHandler class to ask the question and get the answer
    public StoryElement ask() {
        // ask the question



        // get the answer
        // maybe a Input Action like Attack, Defend, Run
        action();
        // return the next story element
        return null;
    }

    public abstract void action();
}
