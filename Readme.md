# Ourhood: Real-Time Streaming Quiz Game

## Introduction  
Welcome to Ourhood — an engaging, real-time multiplayer trivia game developed in Java! Compete against friends or be matched with random players in a fast-paced quiz showdown. Ourhood uses Java’s Datagram and Socket classes to build a TCP-based communication system between the client and server, enabling reliable and seamless interactions during gameplay.

## Features  
- **Client-Server Model**: Ourhood uses the Transmission Control Protocol (TCP) to ensure stable and consistent message exchange between the server and connected clients. TCP provides essential features like (1) reliable transmission, (2) ordered message delivery, (3) flow control, and (4) connection-oriented communication. These are implemented using Java’s `Socket` class.  
- **Live Multiplayer Functionality**: Multiple users can play simultaneously in real-time.  
- **Multiple-Choice Questions**: Players respond to trivia questions with four selectable answer options.  
- **Multithreading Support**: Java's `Thread` class is used to manage concurrent gameplay across multiple users efficiently.  
- **Built-in Timers**: Time constraints for various game phases — such as player response time, score updates, and game pacing — are managed using the `sleep` method in Java threads.  
- **Synchronized Methods**: Shared resources are protected using Java's `synchronized` keyword to maintain data integrity in a multithreaded environment.  
- **Structured Message Types**: Messages sent to clients are prefixed with characters for easy categorization (e.g., “q” for questions, “s” for scores, “w” for welcome messages, “r” for results).  
- **Server-Side Logic**: The server is responsible for sending welcome messages, distributing quiz questions, validating answers, tracking scores, and generating final results.  
- **Timeout Handling**: If a player fails to respond, the server clears the input buffer to prepare for the next question.  
- **Random Question Selection**: The server selects questions randomly for each session to keep games fresh.  
- **Host Capabilities**: The host can customize game parameters such as quiz category, number of questions, and allotted time per question.  
- **Quiz Generation Integration**: Though not yet fully integrated into the game, a feature is in development to use the ChatGPT API (OpenAI, n.d.) to automatically generate quiz content based on selected topics, question count, and difficulty level.

## Installation  
To set up and run Ourhood on your local device, follow these steps:  
1. Clone the Ourhood project repository.  
2. Compile all Java source files using your preferred compiler.  
3. Start the server program on one machine.  
4. Launch the host program on a separate device to configure the game session.  
5. Open the client program on one or more machines to allow players to join the game.

## How to Play  
1. Start the Server by running `java network/Server`.  
2. Run the Host setup with `java network/Host` to configure quiz settings.  
3. Launch the Client application using `java network/Client` on separate terminals or devices.  
4. Wait until all players have joined the lobby.  
5. Once the game begins, answer the questions within the given time limit.  
6. Points are awarded for correct answers.  
7. The player with the highest score after all questions are answered wins the game!
