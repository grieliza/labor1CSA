package com.company;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {

    public static void main(String[] args) throws IOException {
        // write your code here

        ServerSocket server = new ServerSocket(1234);
        while (true) {
            Socket client = server.accept();
            if (client != null) {
                DataInputStream in = new DataInputStream(client.getInputStream());
                DataOutputStream out = new DataOutputStream(client.getOutputStream());

                String message = in.readUTF();

                out.writeUTF(message);

                in.close();
                out.close();

                client.close();


            }
        }

    }
}
