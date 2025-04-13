package game;

import java.util.ArrayList;

/**
 * Represents a question with multiple-choice options and the correct answer.
 */
public class Question {
    private String question; // The question text
    private String[] options; // The multiple-choice options
    private int answer; // The index of the correct answer
    private String topic; // The question topic

    /**
     * Constructs a new Question object with the given question text, options, and
     * correct answer index.
     *
     * @param question The text of the question.
     * @param options  The array of multiple-choice options.
     * @param answer   The index of the correct answer.
     * @param topic    The topic of the question.
     */
    public Question(String question, String[] options, int answer, String topic) {
        this.question = question;
        this.options = options;
        this.answer = answer;
        this.topic = topic;
    }

    /**
     * Returns the text of the question.
     *
     * @return The question text.
     */
    public String getQuestion() {
        return this.question;
    }

    /**
     * Sets the text of the question.
     *
     * @param newQues The new question text.
     */
    public void setQuestion(String newQues) {
        this.question = newQues;
    }

    /**
     * Returns the array of multiple-choice options.
     *
     * @return The array of options.
     */
    public String[] getAllOpt() {
        return this.options;
    }

    /**
     * Returns the index of the correct answer.
     *
     * @return The index of the correct answer.
     */
    public int getAnswer() {
        return this.answer;
    }

    /**
     * Sets the index of the correct answer.
     *
     * @param newAns The new index of the correct answer.
     */
    public void setAnswer(int newAns) {
        this.answer = newAns;
    }

    /**
     * Returns the text of the correct answer.
     *
     * @return The text of the correct answer.
     */
    public String getAnswerText() {
        return options[answer];
    }

    /**
     * @return The question topic.
     */
    public String getTopic() {
        return this.topic;
    }
}