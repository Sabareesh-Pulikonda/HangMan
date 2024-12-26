## Hangman Game
This repository contains two implementations of the Hangman game:

Hangman.java: A Java-based graphical Hangman game using Swing.
Hangman.py: A Python-based graphical Hangman game using Tkinter.


# Features
### Hangman.java
A graphical interface using the Swing library.
Customizable word and attempts limit.
Real-time feedback on guesses.
Displays a hangman image that updates with incorrect guesses (image paths need to be updated to your local setup).
Win and loss conditions with alert messages.

### Hangman.py
A graphical interface using the Tkinter library.
Allows the player to input a custom word for the game.
Tracks correct and incorrect guesses dynamically.
Displays win/loss messages based on the game outcome.

# Requirements

### Java Version
JDK 8 or above.

### Python Version
Python 3.6 or above.
Tkinter library (pre-installed with Python).

# Setup Instructions
---> Java
Compile the Java file:

javac Hangman.java

Run the program:

java Hangman

---> Python
Run the Python script:

python Hangman.py

# Customization
Java
Update the word to guess by modifying the word variable in the Hangman class.
Update the image paths in the updateHangmanImage method for custom hangman images.

Python
The game prompts the user to input a word during startup.

# Contribution
Feel free to submit issues or pull requests to enhance the game or fix bugs.