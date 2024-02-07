# Console Game

This is a text-based adventure game developed in Java. The game features a player character who can move around a map, interact with entities, and engage in combat with bosses.

## Table of Contents

- [Getting Started](#getting-started)
- [Prerequisites](#prerequisites)
- [Installing](#installing)
- [Project Structure](#project-structure)
- [How it Works](#how-it-works)
- [Running the tests](#running-the-tests)
- [Running the game](#running-the-game)
- [Built With](#built-with)
- [Contributing](#contributing)
- [Versioning](#versioning)
- [Authors](#authors)
- [License](#license)
- [Acknowledgments](#acknowledgments)

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.

### Prerequisites

- Java Development Kit (JDK) 8 or higher
- Gradle build tool

### Installing

1. Clone the repository to your local machine using the following command:

```bash
git clone https://github.com/maystudios/ConsoleGame.git
```

2. Navigate to the project directory:

```bash
cd ConsoleGame
```

3. Build the project using Gradle:

```bash
gradle build
```

Sure, I can provide a more detailed explanation of the project structure and how the game works.

## Project Structure

The project is structured into several packages, each with a specific purpose:

- `src/main/java/net/maystudios`: This is the main package for the game. It contains the main game logic and classes. The classes in this package are responsible for the overall operation of the game, including the game loop and the initialization of game entities.

- `src/main/java/net/maystudios/InputHandler`: This package contains classes for handling user input. The `InputHandler` class is a crucial part of the game, as it is responsible for interpreting the player's commands and translating them into actions in the game. It takes a question, a map of possible answers, and a function to handle the user's answer. The `InputHandler` asks the question, gets the user's input, and applies the function to the input.

- `src/main/java/net/maystudios/Game`: This package contains classes related to the game entities and mechanics. This includes classes for the player character, enemies, items, and game mechanics like combat and interaction. Each class has specific methods and attributes that define its behavior in the game.

- `src/main/java/net/maystudios/InputHandler/StoryHandler`: This package contains classes for handling the game story and map. The `StoryHandler` class is responsible for managing the game's narrative elements, including the progression of the story and the player's choices. The game map is represented by a 2D array of `Location` objects. Each `Location` can contain entities and has a name. The player can move to different locations on the map.

## How it Works

The game starts by creating a player and a boss. The player character is an instance of the `Player` class, which has attributes like health, inventory, and current location. The boss is an instance of the `Boss` class, which is a subclass of the `Enemy` class. The boss has unique attributes and methods that make it more challenging than regular enemies.

The player can move around a map, interact with entities, and engage in combat with the boss. The map is a 2D array of `Location` objects, and the player can move to different locations by entering commands that are interpreted by the `InputHandler`. Entities in the game, such as items and enemies, are represented by classes in the `Game` package. The player can interact with these entities through commands, which can result in various outcomes like picking up items or initiating combat.

The game continues until the boss is defeated. The combat system is turn-based, with the player and the boss taking turns to attack each other. The player's actions during combat are determined by their commands, and the outcome of the combat is determined by the attributes of the player and the boss, as well as the player's strategy.

The game uses an `InputHandler` to handle user input. The `InputHandler` takes a question, a map of possible answers, and a function to handle the user's answer. The `InputHandler` asks the question, gets the user's input, and applies the function to the input. This allows for a flexible and interactive gameplay experience, as the player's commands can have a wide range of effects on the game.

## Running the tests

To run the automated tests for this system, use the following command:

```bash
gradle test
```

## Running the game

To start the game, use the following command:

```bash
gradle run
```

## Built With

- [Java](https://www.java.com/) - The programming language used
- [Gradle](https://gradle.org/) - Dependency Management

## Contributing

Please read `CONTRIBUTING.md` for details on our code of conduct, and the process for submitting pull requests to us.

## Versioning

We use [SemVer](http://semver.org/) for versioning. For the versions available, see the [tags on this repository](https://github.com/maystudios/ConsoleGame/tags).

## Authors

- **maystudios** - *Initial work* - [maystudios](https://github.com/maystudios)

See also the list of [contributors](https://github.com/maystudios/ConsoleGame/contributors) who participated in this project.

## License

This project is licensed under the MIT License - see the `LICENSE.md` file for details

## Acknowledgments

- Hat tip to anyone whose code was used
- Inspiration
- etc.
```