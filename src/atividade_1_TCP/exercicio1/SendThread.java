package atividade_1_TCP.exercicio1;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class SendThread extends Thread {
    private DataOutputStream send;
    private Socket ThreadSocket;

    SendThread(Socket ThreadSocket) {
        this.ThreadSocket = ThreadSocket;
        try {
            send = new DataOutputStream(ThreadSocket.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        String buffer;
        try {

            Scanner reader = new Scanner(System.in);
            do {
                System.out.print("MSG: ");
                buffer = reader.nextLine();

                send.writeUTF(buffer);
            } while (!buffer.equals("SAIR"));
            send.close();
            ThreadSocket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    } //run
}
