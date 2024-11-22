package com.openclassroom.tchat;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class ChatClient {
    private static final String SERVER_ADDRESS = "127.0.0.1";
    private static final int SERVER_PORT = 12345;

    public static void main(String[] args) {
        try (Socket socket = new Socket(SERVER_ADDRESS, SERVER_PORT);
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

            System.out.println("Connecté au serveur de chat.");
            Scanner scanner = new Scanner(System.in);

            // Thread pour écouter les messages entrants
            new Thread(() -> {
                try {
                    String message;
                    while ((message = in.readLine()) != null) {
                        System.out.println("Message reçu : " + message);
                    }
                } catch (IOException e) {
                    System.out.println("Déconnecté du serveur.");
                }
            }).start();

            // Lecture des entrées utilisateur
            while (true) {
                System.out.print("Vous : ");
                String userMessage = scanner.nextLine();
                out.println(userMessage);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
