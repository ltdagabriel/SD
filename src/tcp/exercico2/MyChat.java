package tcp.exercico2;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class MyChat extends JFrame {
    private JTextArea GUI_Output;
    private JTextField GUI_Input;
    private JButton GUI_Send;
    private JPanel root;

    private DataOutputStream send;

    private String getInput() {
        String in = GUI_Input.getText();
        GUI_Input.setText("");
        return in + '\n';
    }

    void setOutput(String out){
        GUI_Output.setText(out+"\n");
    }
    private void sendMSG(String msg) throws IOException {
        send.writeUTF(msg);
    }

    MyChat(Socket client) throws IOException {
        // Input e output
        send = new DataOutputStream(client.getOutputStream());

        // Criação de GUI
        add(root);
        setTitle("Exercicio 2");
        setSize(400, 500);
        GUI_Output.setEditable(false);
        GUI_Output.setAutoscrolls(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        GUI_Send.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String msg = getInput();
                try {
                    sendMSG(msg);
                    setOutput("Me: "+msg);
                } catch (IOException ex) {
                    setOutput("[não enviada] Me: "+msg);
                }
            }
        });
        GUI_Input.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String msg = getInput();
                try {
                    sendMSG(msg);
                    setOutput("Me: "+msg);
                } catch (IOException ex) {
                    setOutput("[não enviada] Me: "+msg);
                }
            }
        });
    }
}
