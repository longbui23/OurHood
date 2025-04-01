package game;

import java.util.ArrayList;

public class Game {
    private ArrayList<Question> questions;
    private int currentQuestion;

    public Game(ArrayList<Question> questions) {
        this.questions = questions;
        this.currentQuestion = 0;
    }

    public ArrayList<Question> getQuestions() {
        return questions;
    }

    public int getCurrentQuestion() {
        return currentQuestion;
    }

    public void updateCurrentQuestion() {
        currentQuestion++;
    }

    public boolean isEnd() {
        return currentQuestion >= questions.size();
    }
}
