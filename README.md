# About me:
Hey, I am Agnieszka. I have always been drawn to technical skills and that is why I graduated in Physics. I am looking for a career for me where I belong and I could be happy. Coding seems perfect to me, because I really like to think and solve problems, and that's what coding is about.
Completing this task was a real fun for me, but at the same time, it made me realize I still have a lot to learn. I would like to develop my programming skills and I am convinced that getting into the Academy would give me this opportunity.

# memory-game
Java Academy Task - Memory Game

## How to build

Memory Game is a maven project. To build execute command:

mvn clean package

## How to run

To run the game execute command with prepared (in build step) jar:

java -cp memory-1.0-SNAPSHOT.jar org.java.academy.Main

Of course, you can use also your IDE to run the game :)

## Game features

1. Simple memory game with randomly selected words from Words.txt file
2. Game supports two difficulty levels: easy with 4 words pair and 10 chances to guest and hard with 8 words pair and 15 chances
3. Player score is displayed after the game and contains number guess tries and time of playing in seconds
4. Game also contains a high score feature with list of 10 best scores per difficulty level
5. After the finished game player can restart the game or exit from the application
6. Input from the player is validated against the rules
7. Game welcomes the player with ASCII art :)

