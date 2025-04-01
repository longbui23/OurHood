package server;

import game.Question;
import java.io.*;
import java.net.*;

public class Request implements Runnable {
    private Socket socket;
    private DataOutputStream os;
    private BufferedReader br;
    private int id;

    public Request(Socket socket, int id) throws Exception {
        this.socket = socket;
        this.id = id;
        os = new DataOutputStream(socket.getOutputStream());
        br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    }

    public void run() {
        try {
            for (int i = 0; i <= Server.getQuestions().size(); i++) {
                if (id == 0) {
                    Server.sendQuestionToAllPlayers(i);
                }
                String answer = br.readLine();
                System.out.println("Player " + id + " answered: " + answer);
                Thread.sleep(5000);
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void sendQuestion(Question question) throws Exception {
        os.writeBytes(question.getQuestion() + "\n");
        for (String option : question.getOptions()) {
            os.writeBytes(option + "\n");
        }
    }

    public void sendGameOver() throws Exception {
        os.writeBytes("Game Over\n");
    }
}
