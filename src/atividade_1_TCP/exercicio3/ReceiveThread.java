package atividade_1_TCP.exercicio3;

import java.io.*;
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
                String[] arg = buffer.split("[ \n]");
                System.out.println("---- Resposta ----");

                if ("DOWN".equals(arg[0])) {// receive file
                    System.out.printf("Download FILE:%s", arg[1]);

                    try {
                        DataOutputStream out = new DataOutputStream(new FileOutputStream(arg[1]));
                        int bf;
                        while ((bf = receive.read()) != -1) {
                            out.write(bf);
                            out.flush();
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    System.out.printf("Download FILE:%s[ok]%n", arg[2]);
                }
                if ("FILES".equals(arg[0])) {
                    int n = Integer.valueOf(arg[1]);
                    for (int i = 0; i < n; i++) {
                        System.out.printf("%d: %s", i, receive.readUTF());
                    }
                } else {
                    System.out.println(buffer);
                }


            } while (!buffer.equals("SAIR"));
            receive.close();
            ThreadSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Finalizando thread receive!");
    } //run
}
