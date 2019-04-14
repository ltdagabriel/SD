package tcp.exercicio1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class ReceiveThread extends Thread {
    private DataInputStream receive;
    private Socket ThreadSocket;

    ReceiveThread(Socket ThreadSocket) {
        this.ThreadSocket = ThreadSocket;

        try {
            receive = new DataInputStream(ThreadSocket.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        String buffer;
        try {
            do {
                buffer = receive.readUTF();
                System.out.println("MSG: "+ buffer);
            } while (!buffer.equals("SAIR"));
            receive.close();
            ThreadSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Finalizando thread receive!");
    } //run
}
