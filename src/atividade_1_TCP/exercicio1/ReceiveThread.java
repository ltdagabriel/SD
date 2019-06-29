package atividade_1_TCP.exercicio1;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

public class ReceiveThread extends Thread {
    private DataInputStream receive;
    private Socket ThreadSocket;

    public static void main(String[] args) throws IOException {
        int serverPort = 6666;
        InetAddress serverAddress = InetAddress.getByName("127.0.0.1");
        Socket client = new Socket(serverAddress, serverPort);


    }

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
