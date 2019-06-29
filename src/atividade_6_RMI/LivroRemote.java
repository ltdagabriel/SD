package atividade_6_RMI;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Faça uma implementação usando Java RMI ou Python (Pyro4) para um serviço remoto de gerenciamento de músicas/livros
 * que possibilita adicionar, remover e consultar músicas/livros.
 *
 * @author Gabriel Choptian
 */
public interface LivroRemote extends Remote {

    public String adicionar(String nome, String autor, String publisher) throws RemoteException;

    public String remover(String name) throws RemoteException;

    public String listar() throws RemoteException;
}

