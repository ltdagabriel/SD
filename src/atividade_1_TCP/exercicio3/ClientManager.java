package atividade_1_TCP.exercicio3;

import java.io.*;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

class ClientManager extends Thread {

    private Socket client;

    ClientManager(Socket clientSocket) {
        this.client = clientSocket;
    }

    @Override
    public void run() {
        try {
            DataInputStream receive = new DataInputStream(client.getInputStream());
            DataOutputStream send = new DataOutputStream(client.getOutputStream());

            // Diretorio
            String dirName = "/home/ltdagabriel/IdeaProjects/SD/src/atividade_1_TCP/exercicio3/compartilhado";
            File fileName = new File(dirName);
            File[] files = fileName.listFiles();

            String buffer;
            do {
                buffer = receive.readUTF();
                String[] arg = buffer.split("[ \n]");
                switch (arg[0]) {
                    case "TIME": {
                        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
                        buffer = formatter.format(new Date());

                        send.writeUTF(buffer + "\n");
                        break;
                    }
                    case "DATE": {
                        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                        buffer = formatter.format(new Date());
                        send.writeUTF(buffer + "\n");
                        break;
                    }
                    case "FILES": {
                        send.writeUTF(String.format("FILES %d\n", files.length));
                        for (File f : files) {
                            send.writeUTF(f.getName() + "\n");
                        }
                        break;
                    }
                    case "DOWN": {
                        String FILE_TO_SEND = dirName + "/" + arg[1];

                        BufferedInputStream in = new BufferedInputStream(new FileInputStream(FILE_TO_SEND));

                        send.writeUTF(String.format("DOWN %s", arg[1]));
                        int bf;
                        while ((bf = in.read()) != -1){
                            send.write(bf);
                            send.flush();
                        }
                    }
                    default: {
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