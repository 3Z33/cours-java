package com.HTTPserver;

import java.io.*;
import java.net.*;

public class HttpServer {

    public static void main(String[] args) throws IOException {
        int port = 8080;

        ServerSocket serverSocket = new ServerSocket(port);
        System.out.println("Serveur lancé sur http://localhost:" + port);

        while (true) {
            Socket clientSocket = serverSocket.accept();
            System.out.println("Connexion acceptée : " + clientSocket.getInetAddress());

            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            String line;
            while (!(line = in.readLine()).isEmpty()) {
                System.out.println(line);
            }

            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            out.println("HTTP/1.1 200 OK");
            out.println("Content-Type: text/html; charset=utf-8");
            out.println();
            out.println("<html><body><h1>test</h1></body></html>");

            clientSocket.close();
        }
    }
}
