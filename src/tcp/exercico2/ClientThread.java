package tcp.exercico2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.List;

class ClientThread extends Thread {

    private Socket client;
    private List<Socket> usuarios;
    ClientThread(Socket clientSocket, List<Socket> clientes) {
        this.client = clientSocket;
        usuarios = clientes;
    }

    @Override
    public void run() {
        try {
            DataInputStream receive = new DataInputStream(client.getInputStream());


            String buffer;
            do {
                buffer = receive.readUTF();
                for(Socket user: usuarios){
                    if( user != client){
                        DataOutputStream send = new DataOutputStream(user.getOutputStream());
                        send.writeUTF(buffer);
                    }
                }
            } while (!buffer.equals("SAIR"));

            client.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    } //run
} //class