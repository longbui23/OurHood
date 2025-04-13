package network;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class Host {

    public static void main(String argv[]) throws Exception {
        String answer;
        String msg;

        // Connect to the server
        Socket clientSocket = new Socket("127.0.0.1", 6789);

        BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));

        DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());

        BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));


        // Handle welcome message
        msg = inFromServer.readLine();
        System.out.println(msg);
        System.out.println();
        
        msg = inFromServer.readLine();
        System.out.println(msg);
        System.out.println();


        // Handle question message
        msg = inFromServer.readLine();
        String[] topics = msg.split(";");
        String question = topics[0];
        System.out.println();
        System.out.println(question);

        for (int i = 1; i <= 6; i++) {
            System.out.println(i + ": " + topics[i]);
        }

        System.out.print("Select a number corresponding with interested topics: ");

        String selectedTopics = inFromUser.readLine();

        outToServer.writeBytes(selectedTopics + "\n"); // Send topics to server

        System.out.println();
        

        // Handle number of question
        msg = inFromServer.readLine();
        System.out.print(msg + " ");
        String noQues = inFromUser.readLine();

        outToServer.writeBytes(noQues + "\n");

        System.out.println();


        // Handle question duration
        msg = inFromServer.readLine();
        System.out.print(msg + " ");
        String duration = inFromUser.readLine();

        outToServer.writeBytes(duration + "\n");

        System.out.println();

        System.out.println("You have finished setting up the game. Thank you!");

        inFromServer.close();
    }
}