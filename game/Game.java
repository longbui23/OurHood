package game;

import java.util.ArrayList;

/**
 * Represents a game consisting of a series of questions.
 */
public class Game {
    private ArrayList<Question> questions; // List of questions in the game
    private Integer curQuestionIdx; // Index of the current question
    private int curAnswer; // Index of the current correct answer
    private int noPlayer; // Number of players participating in the game
    private int duration; // The duration set up for each question

    /**
     * Constructs a new Game object with the given list of questions.
     *
     * @param questions The list of questions for the game.
     */
    public Game(ArrayList<Question> questions, int duration) {
        this.questions = questions;
        this.curQuestionIdx = 0; // Start with the first question
        this.curAnswer = this.questions.get(0).getAnswer(); // Set the current correct answer
        this.noPlayer = 0; // Initialize number of players
        this.duration = duration;
    }

    /**
     * Returns the list of questions in the game.
     *
     * @return The list of questions.
     */
    public ArrayList<Question> getQuestions() {
        return this.questions;
    }

    /**
     * Returns the number of questions in the game.
     *
     * @return The number of questions.
     */
    public int getNumberOfQuestions() {
        return this.questions.size();
    }

    /**
     * Returns the index of the current question.
     *
     * @return The index of the current question.
     */
    public Integer getCurrentQuestion() {
        return this.curQuestionIdx;
    }

    /**
     * Returns the index of the correct answer for the current question.
     *
     * @return The index of the correct answer.
     */
    public int getCurAnswer() {
        return this.curAnswer;
    }

    /**
     * Sets the index of the correct answer for the current question.
     *
     * @param newAns The index of the new correct answer.
     */
    public void setCurAnswer(int newAns) {
        this.curAnswer = newAns;
    }

    /**
     * Returns the text of the correct answer for the current question.
     *
     * @return The text of the correct answer.
     */
    public String getCurAnsText() {
        return this.questions.get(this.curQuestionIdx).getAnswerText();
    }

    /**
     * Updates the index of the current question to the next question in the game.
     * Also updates the index of the correct answer for the new current question.
     */
    public void updateCurrentQuestion() {
        this.curQuestionIdx += 1;
        Question curQ = this.questions.get(this.curQuestionIdx);
        setCurAnswer(curQ.getAnswer());
    }

    /**
     * Returns the number of players participating in the game.
     *
     * @return The number of players.
     */
    public int getNoPlayers() {
        return this.noPlayer;
    }

    /**
     * Increments the number of players participating in the game.
     */
    public void updateNoPlayers() {
        this.noPlayer += 1;
    }

    /**
     * Returns the duration allowed for each question.
     *
     * @return The duration.
     */
    public int getDur() {
        return this.duration;
    }
}