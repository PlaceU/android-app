package amsi.dei.estg.ipleiria.placeu.modelo;

import java.sql.Timestamp;
import java.util.Date;

public class Organizacao {
    private long id;
    private String nome;
    //private Timestamp data;
    //private Date data;

    public Organizacao(long id, String nome){
        this.setNome(nome);
        this.id = id;
    }

    public long getId() { return id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
}
