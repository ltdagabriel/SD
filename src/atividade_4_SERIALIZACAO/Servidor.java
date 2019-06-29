package atividade_4_SERIALIZACAO;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
    public static void main(String[] args) {
        try {
            System.out.println("Inicializando Servidor ...");
            ServerSocket serverSocket = new ServerSocket(6666);
            System.out.println("Servidor aguardando conexões ...");

            Socket clientSocket = serverSocket.accept();

            System.out.println("Criando objetos de leitura/escrita ...");
            ObjectInputStream objectInputStream = new ObjectInputStream(clientSocket.getInputStream());

            System.out.println("Receber objeto 1 ...");
            Livro p1 = (Livro) objectInputStream.readObject();
            print(p1);

            System.out.println("\nReceber objeto 2 ...");
            Livro p2 = (Livro) objectInputStream.readObject();
            print(p2);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
    static private void print(Livro livro) {
        System.out.print(String.format("Nome: %s\nAutor: %s\nPublisher: %s\n", livro.getName(), livro.getAutor(), livro.getPublisher()));
    }
}
