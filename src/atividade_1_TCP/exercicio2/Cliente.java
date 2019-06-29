package atividade_1_TCP.exercicio2;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

public class Cliente extends JFrame {
    private JTextArea GUI_Output;
    private JTextField GUI_Input;
    private JPanel root;

    private DataOutputStream send;

    public static void main(String[] args){
        int serverPort = 6666;
        InetAddress serverAddress = null;
        try {
            serverAddress = InetAddress.getByName("127.0.0.1");
            Socket client = new Socket(serverAddress, serverPort);
            Cliente chat = new Cliente(client);
            chat.setVisible(true);

            String buffer;
            do {
                DataInputStream receive = new DataInputStream(client.getInputStream());
                buffer = receive.readUTF();
                chat.GUI_Output.append(buffer);
            } while (!buffer.equals("SAIR"));


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String getInput() {
        String in = GUI_Input.getText();
        GUI_Input.setText("");
        return in + '\n';
    }


    private Cliente(Socket client) throws IOException {
        // Input e output
        send = new DataOutputStream(client.getOutputStream());

        // Criação de GUI
        add(root);
        setTitle("Exercicio 2");
        setSize(400, 500);
        GUI_Output.setEditable(false);
        GUI_Output.setAutoscrolls(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        GUI_Input.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String msg = getInput();
                try {
                    send.writeUTF(msg);
                    GUI_Output.append("Eu: " + msg);
                } catch (IOException ex) {
                    GUI_Output.append("[não enviada] Eu: " + msg);
                }
            }
        });
    }
}
