package server;

import java.io.*;
import java.net.*;
import java.util.*;
import game.Game; 
import game.Question;

public final class Server {
    private static List<Question> questions = new ArrayList<>();
    private static List<Request> playerConnections = new ArrayList<>();
    
    public static void main(String[] args) throws Exception {
        int port = 6789;
        ServerSocket socket = new ServerSocket(port);

        // Load questions from file
        loadQuestions("server/questions.txt");

        int id = 0;
        while (true) {
            Socket connection = socket.accept();
            Request request = new Request(connection, id);
            playerConnections.add(request);

            Thread thread = new Thread(request);
            thread.start();
            id++;
        }
    }

    private static void loadQuestions(String fileName) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        String line;
        while ((line = br.readLine()) != null) {
            String questionText = line;
            List<String> options = new ArrayList<>();
            for (int i = 0; i < 4; i++) {
                options.add(br.readLine());
            }
            int correctAnswer = Integer.parseInt(br.readLine().trim());
            questions.add(new Question(questionText, options, correctAnswer));
            br.readLine();
        }
        br.close();
    }

    public static synchronized void sendQuestionToAllPlayers(int questionIndex) {
        if (questionIndex >= questions.size()) {
            System.out.println("Game Over.");

            for (Request player : playerConnections) {
                try {
                    player.sendGameOver();
                } catch (Exception e) {
                    System.out.println("Error sending question: " + e.getMessage());
                }
            }

            return;
        }

        Question question = questions.get(questionIndex);
        for (Request player : playerConnections) {
            try {
                player.sendQuestion(question);
            } catch (Exception e) {
                System.out.println("Error sending question: " + e.getMessage());
            }
        }
    }

    public static List<Question> getQuestions() {
        return questions;
    }
}
