package tcp.exercicio1;

import java.io.IOException;
import java.net.Socket;

class ClientThread extends Thread {

    private Socket client;

    ClientThread(Socket clientSocket) {
        this.client = clientSocket;
    }

    @Override
    public void run() {
        try {
            SendThread send = new SendThread(client);
            ReceiveThread receive = new ReceiveThread(client);
            send.start();
            receive.start();

            send.join();
            receive.join();
            client.close();
        } catch (InterruptedException | IOException e) {
            e.printStackTrace();
        }
    } //run
} //class