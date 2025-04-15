# Ourhood: Real-Time Streaming Quiz Game

## Introduction  
Introducing Ourhood — a dynamic, real-time multiplayer trivia game built with Java! Challenge your friends or get paired with random opponents in an exciting, high-speed quiz competition. Ourhood leverages Java’s Datagram and Socket classes to create a TCP-based communication framework, ensuring smooth, dependable connections between clients and the server throughout every match.

## Features

### Gaming:
- **Live Multiplayer Functionality**: Multiple users can play simultaneously in real-time.  
- **Multiple-Choice Questions**: Players respond to trivia questions with four selectable answer options
- **Built-in Timers**: Time constraints for various game phases — such as player response time, score updates, and game pacing
- **Host Modification**: The host can customize game by selecting quiz category, number of questions, and allotted time per question
- **Points Calculator**: The system awarded 1 point for every question that a player answers correctly and 0 for invalid answer or player choosing not to answer. After the end of the game, the system will anounced player who has the highest score as the winner

### Technical:

- **Client-Server Model**: Ourhood uses the Transmission Control Protocol (TCP) to ensure stable and consistent message exchange between the server and connected clients. TCP provides essential features like reliable transmission, ordered message delivery, flow control, and connection-oriented communication. These are implemented using Java’s `Socket` class.  
- **Multithreading Support**: Java's `Thread` class is used to manage concurrent gameplay across multiple users efficiently.  
- **Synchronized Methods**: Shared resources are protected using Java's `synchronized` keyword to maintain data integrity in a multithreaded environment.  
- **Server-Side Logic**: The server is responsible for sending welcome messages, distributing quiz questions, validating answers, tracking scores, and generating final results.  
- **Timeout Handling**: If a player fails to respond, the server clears the input buffer to prepare for the next question.  



## Installation  
To set up and run Ourhood on your local device, follow these steps:  
1. Clone the Ourhood project repository.
2. Compile all Java source files using your preferred compiler.
3. Start the server program on one machine.  
4. Launch the host program on a separate device to configure the game session.  
5. Open the client program on one or more machines to allow players to join the game.

## How to Play  
1. Start the Server by running `java network/Server`.

<img width="568" alt="Screenshot 2025-04-15 at 6 41 34 PM" src="https://github.com/user-attachments/assets/07e70b9b-fbe9-4bca-8aa5-97d22a9a2118" />

2. Run the Host setup with `java network/Host` to configure quiz settings.

<img width="568" alt="Screenshot 2025-04-15 at 6 42 02 PM" src="https://github.com/user-attachments/assets/64a22c2d-bce1-457a-919d-a341d8e429b4" />

3. After Host finished setting up the game, on the Server will display the setting that Host chose and wait for Players to join (You can press `Enter` to start early).

<img width="570" alt="Screenshot 2025-04-15 at 6 43 43 PM" src="https://github.com/user-attachments/assets/f73ea4c0-b9cf-43e6-9f9b-7d604ecb2772" />

4. Launch the Client application using `java network/Client` on separate terminals or devices.

<img width="570" alt="Screenshot 2025-04-15 at 6 44 36 PM" src="https://github.com/user-attachments/assets/113f000e-97b9-419f-a65b-4e8d63ea8168" />

<img width="570" alt="Screenshot 2025-04-15 at 6 44 57 PM" src="https://github.com/user-attachments/assets/f4d9508f-63bf-41ae-9a34-c8df0098f46d" />

5. Wait until all players have joined the lobby.
  
6. Once the game begins, answer the questions within the given time limit.

<img width="570" alt="Screenshot 2025-04-15 at 6 45 30 PM" src="https://github.com/user-attachments/assets/32824f6f-174f-4fb4-91d2-4c621008e93c" />

7. Points are awarded for correct answers.

<img width="570" alt="Screenshot 2025-04-15 at 6 47 22 PM" src="https://github.com/user-attachments/assets/d9d42a04-5f8b-469f-b591-2749f49ae4d4" />

8. The player with the highest score after all questions are answered wins the game!

<img width="570" alt="Screenshot 2025-04-15 at 6 47 43 PM" src="https://github.com/user-attachments/assets/d5108144-a26d-44f4-a55d-b561c1698e04" />

