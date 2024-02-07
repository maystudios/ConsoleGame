package net.maystudios.InputHandler.StoryHandler;

import java.util.List;

public class StoryHandler {

    List<StoryElement> storyElements;

    public StoryHandler(List<StoryElement> storyElements) {
        this.storyElements = storyElements;
    }

    public void start() {
        StoryElement current = storyElements.get(0);
        while (current != null) {
            current = current.ask();
        }
    }

}
