package atividade_4_SERIALIZACAO;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Cliente {

    public static void main(String[] args) {


        try {
            System.out.println("Conectando ao servidor ...\n");
            Socket s = new Socket("localhost", 6666);

            ObjectOutputStream objectOutputStream = new ObjectOutputStream(s.getOutputStream());

            System.out.println("Enviando objeto 1 ...\n");
            objectOutputStream.writeObject(adicionar("Livro 1", "joao", "tu"));
            System.out.println("Enviando objeto 1 ...\n");
            objectOutputStream.writeObject(adicionar("Livro 2", "pedro", "eu"));
            objectOutputStream.flush();


            System.out.println("Finalizado.");

        } //catch
        catch (IOException e) {
            e.printStackTrace();
        }
    } //main

    private static Livro adicionar(String nome, String autor, String publisher) {
        Livro livro = new Livro();
        livro.setName(nome);
        livro.setAutor(autor);
        livro.setPublisher(publisher);

        return livro;
    }


}
