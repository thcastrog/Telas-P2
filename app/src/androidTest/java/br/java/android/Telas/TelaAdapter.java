package br.java.android.Telas;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.content.Context;
import android.widget.CheckBox;
import android.widget.LinearLayout;

import com.thayna.telas.R;

import java.util.List;

public class TelaAdapter extends BaseAdapter {

    private List<Telas> tela;
    private Context contexto;
    private InstanciaVisao instanciaVisao;

    public TelaAdapter(Context contextoParam, List<Telas> arrayTelas){
        contexto = contextoParam;
        tela = arrayTelas;
    }

    @Override
    public int getCount() {
        return tela.size();
    }

    @Override
    public Object getItem(int i) {
        return tela.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup){

        if(view == null) {
            LayoutInflater inflador = (LayoutInflater)
            contexto.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflador.inflate(R.layout.celular_tarefa, null);
            instanciaVisao = new InstanciaVisao();
            instanciaVisao.setTarefaCheckBox((CheckBox)
                    view.findViewById(R.id.telaCheckBox));
            instanciaVisao.setCelularLayout((LinearLayout)
                    view.findViewById(R.id.celularTarefaLayout));
            view.setTag(instanciaVisao);
        }else{
            instanciaVisao = (InstanciaVisao) view.getTag();

        }
        return view;
    }

    public InstanciaVisao getInstanciaVisao() {
        instanciaVisao.getTarefaCheckBox().setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(contexto,DetalheActivity.class);
                boolean t = false;
                intent.putExtra("tarefa",t);
                contexto.startActivity(intent);

            }
        });
        return instanciaVisao;
    }
}

