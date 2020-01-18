package amsi.dei.estg.ipleiria.placeu.adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import amsi.dei.estg.ipleiria.placeu.R;
import amsi.dei.estg.ipleiria.placeu.modelo.Organizacao;

public class ListaOrganizacoesAdaptador extends BaseAdapter {

    private ArrayList<Organizacao> listaorganizacoes;
    private Context contexto;
    private LayoutInflater inflater;

    public ListaOrganizacoesAdaptador(Context context, ArrayList<Organizacao> lista){
        this.contexto = context;
        this.listaorganizacoes = lista;
    }

    @Override
    public int getCount(){
        return this.listaorganizacoes.size();
    }

    @Override
    public Object getItem(int position){
        return this.listaorganizacoes.get(position);
    }

    @Override
    public long getItemId(int position){
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        if(inflater == null)
            inflater = (LayoutInflater) this.contexto.getSystemService(this.contexto.LAYOUT_INFLATER_SERVICE);

        if(convertView == null)
            convertView = inflater.inflate(R.layout.item_lista_organizacoes, null);

        ViewHolderLista holder = (ViewHolderLista) convertView.getTag();
        if(holder == null){
            holder = new ViewHolderLista(convertView);
            convertView.setTag(holder);
        }

        holder.update(listaorganizacoes.get(position));

        return convertView;
    }

    private class ViewHolderLista{
        private TextView tvnome;

        public ViewHolderLista(View view){
            this.tvnome = view.findViewById(R.id.tvNome);
        }

        public void update (Organizacao org){
            this.tvnome.setText(org.getNome());
        }
    }

}
