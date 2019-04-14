package tcp.exercico2;


import tcp.exercicio1.ReceiveThread;
import tcp.exercicio1.SendThread;

import javax.swing.*;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

public class Cliente {
    public static void main(String[] args) throws ClassNotFoundException, UnsupportedLookAndFeelException, InstantiationException, IllegalAccessException {
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
//        socket do cliente
        Socket client;
        final MyChat[] chatGUI = {null};

//        prepara buffer de entrada
        try {
//            endereço do servido
            int serverPort = 6666;
            InetAddress serverAddress = InetAddress.getByName("127.0.0.1");
//            conexão com servidor
            client = new Socket(serverAddress, serverPort);
            // Iniciar janela
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    try {
                        chatGUI[0] = new MyChat(client);
                        chatGUI[0].setVisible(true);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }
            });

            DataInputStream receive = new DataInputStream(client.getInputStream());
            String buffer;
            do {
                buffer = receive.readUTF();
                chatGUI[0].setOutput(buffer);
            } while (!buffer.equals("SAIR"));

            client.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
