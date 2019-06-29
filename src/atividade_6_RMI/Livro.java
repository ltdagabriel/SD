package atividade_6_RMI;

/**
 * Faça uma implementação usando Java RMI ou Python (Pyro4) para um serviço remoto de gerenciamento de músicas/livros
 * que possibilita adicionar, remover e consultar músicas/livros.
 *
 * @author Gabriel Choptian
 */
public class Livro {

    private String name;
    private String autor;
    private String publisher;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

}
