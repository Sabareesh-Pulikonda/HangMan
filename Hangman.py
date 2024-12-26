import tkinter as tk
from tkinter import messagebox

class HangmanGame:
    def __init__(self, master):
        self.master = master
        self.master.title("Hangman Game")
        
        self.word = input("Enter a word: ").lower()
        self.attempts = 15
        self.wrong = 0
        self.check = ["_"] * len(self.word)

        self.word_label = tk.Label(master, text=" ".join(self.check), font=("Helvetica", 18))
        self.word_label.pack(pady=10)

        self.attempts_label = tk.Label(master, text=f"Remaining Attempts: {self.attempts - self.wrong}", font=("Helvetica", 14))
        self.attempts_label.pack(pady=5)

        self.guess_entry = tk.Entry(master, font=("Helvetica", 14))
        self.guess_entry.pack(pady=5)

        self.submit_button = tk.Button(master, text="Submit", command=self.process_guess, font=("Helvetica", 14))
        self.submit_button.pack(pady=5)

    def process_guess(self):
        guess = self.guess_entry.get().lower()
        self.guess_entry.delete(0, tk.END)

        if len(guess) != 1:
            messagebox.showwarning("Invalid Input", "Please enter a single letter.")
            return

        if guess in self.word:
            for i, letter in enumerate(self.word):
                if letter == guess:
                    self.check[i] = guess
        else:
            self.wrong += 1

        self.word_label.config(text=" ".join(self.check))
        self.attempts_label.config(text=f"Remaining Attempts: {self.attempts - self.wrong}")

        if "".join(self.check) == self.word:
            messagebox.showinfo("Congratulations", "You Won the Game!")
            self.master.quit()
        elif self.wrong >= self.attempts:
            messagebox.showerror("Game Over", f"You Lost! The word was: {self.word}")
            self.master.quit()

if __name__ == "__main__":
    root = tk.Tk()
    game = HangmanGame(root)
    root.mainloop()
