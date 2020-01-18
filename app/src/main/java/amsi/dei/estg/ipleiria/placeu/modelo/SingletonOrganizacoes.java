package amsi.dei.estg.ipleiria.placeu.modelo;

import java.util.ArrayList;

public class SingletonOrganizacoes {

    private static SingletonOrganizacoes INSTANCIA = null;

    private ArrayList<Organizacao> listaorganizacoes;

    public static synchronized SingletonOrganizacoes getInstance()
    {
        if(INSTANCIA == null){
            INSTANCIA = new SingletonOrganizacoes();
        }

        return INSTANCIA;
    }

    private SingletonOrganizacoes(){
        this.listaorganizacoes = new ArrayList<Organizacao>();
        gerarFakeData();
    }

    private void gerarFakeData(){

        this.listaorganizacoes.add(new Organizacao(1,"Nelsan LDA"));
        this.listaorganizacoes.add(new Organizacao(2,"Amigos do Nelsan"));
    }

    public ArrayList<Organizacao> getListaOrganizacoes(){
        return this.listaorganizacoes;
    }

    public Organizacao getOrganizacao(int indice){
        if(indice >= 0 && indice < this.listaorganizacoes.size()){
            return this.listaorganizacoes.get(indice);
        }
        return null;
    }
}
