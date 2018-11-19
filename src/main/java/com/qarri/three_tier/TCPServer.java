package com.qarri.three_tier;

import java.net.*;

public class TCPServer {

    public static void main(String argv[]) throws Exception {
    	int counter = 1;

        @SuppressWarnings("resource")
        ServerSocket welcomeSocket = new ServerSocket(6789);

        while(true) {
        	
            Socket connectionSocket = welcomeSocket.accept();
            Serverthreads connection = new Serverthreads(connectionSocket);
            connection.start();
            System.out.println("Client number: "+counter+" connected successfully.");
            counter++;
        }
    }
}
