package atividade_1_TCP.exercicio2;


import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Server {
    public static void main(String[] args) {
        try {
            int serverPort = 6666; // porta do servidor

            /* cria um socket e mapeia a porta para aguardar conexão */
            ServerSocket listenSocket = new ServerSocket(serverPort);
            List<Socket> clientes = new ArrayList<>();
            while (true) {
                System.out.println("Servidor aguardando conexão ...");

                /* aguarda conexoes */
                Socket clientSocket = listenSocket.accept();

                System.out.println("Cliente conectado ... Criando thread ...");

                /* cria um thread para atender a conexão */
                ClientThread c = new ClientThread(clientSocket,clientes);
                clientes.add(clientSocket);
                /* inicializa a thread */
                c.start();
            } //while

        } catch (IOException e) {
            System.out.println("Listen socket:" + e.getMessage());
        } //catch
    }
}
