package atividade_2_UDP.exercicio_02;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class Cliente {
    public static void main(String[] args) {
        try {
            DatagramSocket dgramSocket = new DatagramSocket(); //cria um socket datagrama

            String dstIP = "127.0.0.1"; //JOptionPane.showInputDialog("IP Destino?");

            /* armazena o IP do destino */
            InetAddress serverAddr = InetAddress.getByName(dstIP);
            int serverPort = 5555;
            String arquivo = "env.txt";
            File file = new File(String.format("C:\\Users\\gabri\\IdeaProjects\\SD\\src\\atividade_2_UDP\\exercicio_02\\in\\%s", arquivo));

            DatagramPacket requestName = new DatagramPacket(arquivo.getBytes(), "SAIR".getBytes().length, serverAddr, serverPort);
            dgramSocket.send(requestName);


            InputStream is = new FileInputStream(file);
            int length = (int) file.length();
            int take = 1024;                      //size of chunk
            byte[] bytes = new byte[take];
            int offset = 0;
            int bytes_lidos;

            while (offset < length) {

                bytes_lidos = is.read(bytes, 0, take);


                /* cria um pacote datagrama */
                DatagramPacket request = new DatagramPacket(bytes, bytes.length, serverAddr, serverPort);

                /* envia o pacote */
                dgramSocket.send(request);

                /* cria um buffer vazio para receber datagramas */
                byte[] buffer = new byte[1000];
                DatagramPacket reply = new DatagramPacket(buffer, buffer.length);

                /* aguarda datagramas */
                offset += bytes_lidos;
            }
            /* libera o socket */

            DatagramPacket requestQuit = new DatagramPacket("SAIR".getBytes(), "SAIR".getBytes().length, serverAddr, serverPort);
            dgramSocket.send(requestQuit);
            dgramSocket.close();
            is.close();
        } catch (SocketException e) {
            System.out.println("Socket: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("IO: " + e.getMessage());
        }
    }
}
