package server;

import java.io.*;
import java.net.*;

class Client {
    public static void main(String argv[]) throws Exception {
        BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
        Socket clientSocket = new Socket("127.0.0.1", 6789);
        DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
        BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        while (true) {
            String question = inFromServer.readLine();
            if (question == null || question.isEmpty()) {
                System.out.println("Game Over.");
                break;
            }

            System.out.println("\n" + question);
            for (int i = 0; i < 4; i++) {
                System.out.println((i + 1) + ". " + inFromServer.readLine());
            }

            System.out.print("Your answer (1-4): ");
            String answer = inFromUser.readLine();
            outToServer.writeBytes(answer + "\n");
        }

        clientSocket.close();
    }
}
