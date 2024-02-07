package net.maystudios.InputHandler.Message.MessageHandler;

public class MessageHandler {

    public enum Color {
        RED("\033[31m"),
        GREEN("\033[32m"),
        YELLOW("\033[33m"),
        BLUE("\033[34m"),
        PURPLE("\033[35m"),
        CYAN("\033[36m"),
        WHITE("\033[37m"),
        RESET("\033[0m");

        private final String colorCode;

        Color(String colorCode) {
            this.colorCode = colorCode;
        }

        public String getColorCode() {
            return colorCode;
        }
    }

    public static void printMessageBox(String message, Color color) {
        System.out.println(color.getColorCode() + "┎ " + "─".repeat(message.length()) + " ┒");
        System.out.println(color.getColorCode() + "┃ " + message + " ┃");
        System.out.println(color.getColorCode() + "┖ " + "─".repeat(message.length()) + " ┚" + Color.RESET.getColorCode());
    }
}
