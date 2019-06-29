package atividade_6_RMI;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * Faça uma implementação usando Java RMI ou Python (Pyro4) para um serviço remoto de gerenciamento de músicas/livros
 * que possibilita adicionar, remover e consultar músicas/livros.
 *
 * @author Gabriel Choptian
 */
public class Cliente {
    public static void main(String[] args) {
        /* obtem a referencia para o objeto remoto */
        Registry registry = null;
        try {
            registry = LocateRegistry.getRegistry("localhost");


            LivroRemote c = (LivroRemote) registry.lookup("Biblioteca");

            System.out.println("Adicionar :");
            System.out.println(c.adicionar("Livro 1", "joao ninguem", "nao sei"));
            System.out.println(c.adicionar("Livro 2", "joao ninguem", "nao sei"));
            System.out.println(c.adicionar("Distributed Systems: Concepts and Design",
                    " George Coulouris (Author), Jean Dollimore (Author), Tim Kindberg  (Author), Gordon Blair (Author)",
                    "May 7, 2011"));
            System.out.println(c.adicionar("Livro 3", "joao ninguem", "nao sei"));
            System.out.println(c.adicionar("Livro 4", "joao ninguem", "nao sei"));
            System.out.println(c.adicionar("Livro 5", "joao ninguem", "nao sei"));

            System.out.println("Listar :");
            System.out.println(c.listar());

            System.out.println();
            System.out.println("Remover :");
            System.out.println(c.remover("Vivendo e Aprendendo"));



            System.out.println();
            System.out.println("Remover Inexistente:");
            System.out.println(c.remover("Distributed Systems: Concepts and Design"));

            System.out.println();
            System.out.println("Listar após a remoção :");
            System.out.println(c.listar());
        } catch (RemoteException | NotBoundException e) {
            e.printStackTrace();
        }
    }
}
