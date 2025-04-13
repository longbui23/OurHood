package network;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class Client {

    public static void main(String argv[]) throws Exception {

        String answer;
        String msg;
        int questionDuration = 0;

        // Connect to the server
        Socket clientSocket = new Socket("127.0.0.1", 6789);

        BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));

        DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());

        BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        int questionNo = 1;
        int numQuestions;

        // Get question duration and number of question for players
        msg = inFromServer.readLine(); 
        questionDuration = Integer.parseInt(msg);

        msg = inFromServer.readLine(); 
        numQuestions = Integer.parseInt(msg);

        // Handle welcome message
        msg = inFromServer.readLine(); 
        System.out.println(msg);
        msg = inFromServer.readLine(); 
        System.out.println(msg);
        
        
        System.out.println("For each question you will have " + questionDuration / 1000 + " seconds to answer the question.\n");
        
        System.out.println("You will have " + numQuestions + " to answer.\n");

        System.out.println("3\n");
        System.out.println("2\n");
        System.out.println("1\n");
        System.out.println("Start!\n");

        
        // Handle question message
        for (int i = 0; i < numQuestions; i++) {
            msg = inFromServer.readLine(); 
            String[] questionAndOptions = msg.split(",");
            String question = questionAndOptions[0];

            System.out.println();
            System.out.println("Question " + questionNo + ": " + question);

            for (int j = 1; j <= 4; j++) {
                System.out.println(questionAndOptions[j]);
            }

            System.out.println("You have " + questionDuration / 1000 + " seconds to answer.");
            System.out.print("Please select your answer (1 to 4): ");
            questionNo += 1;

            answer = "-1";

            long startTime = System.currentTimeMillis();

            // Clear input buffer
            while (inFromUser.ready()) {
                inFromUser.readLine();
            }

            // allow players to answer in ... seconds
            while (System.currentTimeMillis() - startTime < questionDuration) {
                if (inFromUser.ready()) {
                    answer = inFromUser.readLine();
                    System.out.println("You entered: " + answer);
                    break;
                }
            }

            if (answer == "-1") {
                System.out.println();
                System.out.println("You ran out of time!");
            }

            if (answer.length() != 0) {
                outToServer.writeBytes(answer + "\n"); // Send answer to server
            }
        

            // Handle score message
            msg = inFromServer.readLine(); 
            String[] result = msg.split(",");
            System.out.println(result[0]);
            System.out.println(result[1]);
        }
        

        // Handle game result message
        msg = inFromServer.readLine(); 
        String[] result = msg.split(";");
        System.out.println();
        System.out.println("Game Over! Here are the final results:");
        System.out.println("---------------------------------");

        for (String score : result) {
            System.out.println(score);
        }

        System.out.println("---------------------------------");

        inFromUser.close();            
    }
}