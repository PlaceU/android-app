package amsi.dei.estg.ipleiria.placeu.vistas;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import amsi.dei.estg.ipleiria.placeu.R;
import amsi.dei.estg.ipleiria.placeu.adaptadores.ListaOrganizacoesAdaptador;
import amsi.dei.estg.ipleiria.placeu.modelo.SingletonOrganizacoes;

public class OrganizacoesFragment extends Fragment {

    private ListView lvorganizacoes;
    private ListaOrganizacoesAdaptador adaptador;

    public OrganizacoesFragment(){

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        setHasOptionsMenu(true);

        View view = inflater.inflate(R.layout.fragment_lista_organizacoes, container, false);

        this.lvorganizacoes = view.findViewById(R.id.lvOrganizacoes);

        this.adaptador = new ListaOrganizacoesAdaptador(getContext(), SingletonOrganizacoes.getInstance().getListaOrganizacoes());

        this.lvorganizacoes.setAdapter(adaptador);

        this.lvorganizacoes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                mostraDetalheOrganizacao(position);
            }
        });

        return view;
    }

    private void mostraDetalheOrganizacao(int position){
        Intent intentDetalhe = new Intent (getContext(), DetalhesOrganizacao.class);
        intentDetalhe.putExtra("indice", position);
    }

}
