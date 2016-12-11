package br.java.android.Telas;
import android.app.Activity;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.TextView;

import com.thayna.telas.R;

import org.w3c.dom.Text;


public class DetalheActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detalhe_layout);

        Tarefa tarefa = (Tarefa) getIntent().getSerializableExtra("tarefa");

        ((TextView)findViewById(R.id.tarefaTextView))
                .setText(tarefa.getTarefa());
        ((TextView)findViewById(R.id.descricaoTextView))
                .setText(tarefa.getDescricao());
        ((CheckBox)findViewById(R.id.concluidoCheckBox))
                .setChecked(tarefa.isConcluida());
    }
}
