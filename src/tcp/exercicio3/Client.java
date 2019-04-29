package tcp.exercicio3;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
//        socket do cliente
        Socket client;
//        prepara buffer de entrada
        try {
//            endereço do servido
            int serverPort = 6666;
            InetAddress serverAddress = InetAddress.getByName("127.0.0.1");
//            conexão com servidor
            client = new Socket(serverAddress, serverPort);

            SendThread send = new SendThread(client);
            ReceiveThread receive = new ReceiveThread(client);
            send.start();
            receive.start();

            send.join();
            receive.join();
            client.close();

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
