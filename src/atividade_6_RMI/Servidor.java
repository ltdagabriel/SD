package atividade_6_RMI;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;

/**
 * Faça uma implementação usando Java RMI ou Python (Pyro4) para um serviço remoto de gerenciamento de músicas/livros
 * que possibilita adicionar, remover e consultar músicas/livros.
 *
 * @author Gabriel Choptian
 */
public class Servidor {
    public static void main(String[] args) {
        try {
            java.rmi.registry.LocateRegistry.createRegistry(1099);
            System.out.println("RMI Registry Pronto!");
        } catch (RemoteException e) {
            e.printStackTrace();
        }

        try {
            Biblioteca biblioteca = new Biblioteca();

            Naming.rebind("Biblioteca", biblioteca);
            System.out.println("Servidor pronto ...");
        } catch (RemoteException | MalformedURLException e) {
            e.printStackTrace();
        }

    }
}
