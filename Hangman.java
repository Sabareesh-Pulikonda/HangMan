// package Sara;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class Hangman {

    private static final int MAX_ATTEMPTS = 13;
    private String word = "programming";
    private char[] guessedWord;
    private int wrongAttempts = 0;

    private JFrame frame;
    private JLabel wordLabel;
    private JLabel attemptsLabel;
    private JTextField inputField;
    private JLabel hangmanImage;

    public Hangman() {
        guessedWord = new char[word.length()];
        Arrays.fill(guessedWord, '_');
        
        frame = new JFrame("Hangman Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setLayout(new BorderLayout());

        wordLabel = new JLabel(new String(guessedWord), SwingConstants.CENTER);
        wordLabel.setFont(new Font("SansSerif", Font.BOLD, 24));

        attemptsLabel = new JLabel("Remaining Attempts: " + (MAX_ATTEMPTS - wrongAttempts), SwingConstants.CENTER);
        attemptsLabel.setFont(new Font("SansSerif", Font.PLAIN, 18));

        inputField = new JTextField();
        inputField.setHorizontalAlignment(JTextField.CENTER);
        inputField.setFont(new Font("SansSerif", Font.PLAIN, 18));

        hangmanImage = new JLabel();
        hangmanImage.setHorizontalAlignment(SwingConstants.CENTER);
        updateHangmanImage();

        inputField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = inputField.getText().toLowerCase();
                if (input.length() == 1) {
                    processGuess(input.charAt(0));
                }
                inputField.setText("");
            }
        });

        frame.add(wordLabel, BorderLayout.NORTH);
        frame.add(attemptsLabel, BorderLayout.CENTER);
        frame.add(inputField, BorderLayout.SOUTH);
        frame.add(hangmanImage, BorderLayout.EAST);

        frame.setVisible(true);
    }

    private void processGuess(char guess) {
        boolean correctGuess = false;
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == guess && guessedWord[i] == '_') {
                guessedWord[i] = guess;
                correctGuess = true;
            }
        }

        if (!correctGuess) {
            wrongAttempts++;
        }

        updateHangmanImage();
        wordLabel.setText(new String(guessedWord));
        attemptsLabel.setText("Remaining Attempts: " + (MAX_ATTEMPTS - wrongAttempts));

        if (String.valueOf(guessedWord).equals(word)) {
            JOptionPane.showMessageDialog(frame, "Congratulations! You've won the game!", "Game Over", JOptionPane.INFORMATION_MESSAGE);
            frame.dispose();
        } else if (wrongAttempts >= MAX_ATTEMPTS) {
            JOptionPane.showMessageDialog(frame, "Game Over! The word was: " + word, "Game Over", JOptionPane.ERROR_MESSAGE);
            frame.dispose();
        }
    }

    private void updateHangmanImage() {
        String imagePath = "C:\\Users\\pulik\\OneDrive\\Pictures\\profile" + wrongAttempts + ".jpg";
        ImageIcon icon = new ImageIcon(imagePath);
        hangmanImage.setIcon(icon);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Hangman());
    }
}
