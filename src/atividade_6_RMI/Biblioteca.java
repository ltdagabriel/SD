package atividade_6_RMI;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

/**
 * Faça uma implementação usando Java RMI ou Python (Pyro4) para um serviço remoto de gerenciamento de músicas/livros
 * que possibilita adicionar, remover e consultar músicas/livros.
 *
 * @author Gabriel Choptian
 */
public class Biblioteca extends UnicastRemoteObject implements LivroRemote {

    private ArrayList<Livro> biblioteca = new ArrayList<>();

    public Biblioteca() throws RemoteException {
        super();
        System.out.println("Objeto remoto instanciado");
    }

    @Override
    public String adicionar(String nome, String autor, String publisher) throws RemoteException {
        Livro livro = new Livro();
        livro.setName(nome);
        livro.setAutor(autor);
        livro.setPublisher(publisher);

        this.biblioteca.add(livro);

        String result = "Livro Adicionado: " + nome;
        System.out.println(result);
        return result;
    }

    @Override
    public String remover(String nome) throws RemoteException {

        for (Livro livro : this.biblioteca) {
            if (livro.getName().equals(nome)) {
                this.biblioteca.remove(livro);
                System.out.println(String.format("Livro Removido: %s", nome));
                return String.format("Livro %s foi Removido", nome);
            }
        }

        return String.format("Livro %s não encontrado", nome);
    }

    @Override
    public String listar() throws RemoteException {
        StringBuilder result = new StringBuilder();
        for (Livro livro : this.biblioteca) {

            result.append(String.format("Nome: %s\nAutor: %s\nPublisher: %s\n", livro.getName(), livro.getAutor(), livro.getPublisher()));
        }
        System.out.println(result);
        return result.toString();
    }
}
