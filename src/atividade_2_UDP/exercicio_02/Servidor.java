package atividade_2_UDP.exercicio_02;

import java.io.FileWriter;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Servidor {
    public static void main(String[] args) {
        int port = 5555;
        String pasta= "C:\\Users\\gabri\\IdeaProjects\\SD\\src\\atividade_2_UDP\\out";
        String msg = "";

        DatagramSocket dgramSocket = null;
        FileWriter writer = null;
        try {
            dgramSocket = new DatagramSocket(port); // cria um socket datagrama em uma porta especifica
            byte[] buffer = new byte[1024]; // cria um buffer para receber requisições

            DatagramPacket dgramPacket = new DatagramPacket(buffer, buffer.length);

            dgramSocket.receive(dgramPacket); // aguarda a chegada de datagramas
            msg = (new String(dgramPacket.getData(), 0, dgramPacket.getLength()));
            writer = new FileWriter(String.format("%s/%s.txt", pasta, msg), true);
            msg = "";
            do {
                writer.write(msg);
                dgramPacket = new DatagramPacket(buffer, buffer.length);

                dgramSocket.receive(dgramPacket); // aguarda a chegada de datagramas

                msg = (new String(dgramPacket.getData(), 0, dgramPacket.getLength()));
            } while (!msg.equals("SAIR"));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            dgramSocket.close();
            try {
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
