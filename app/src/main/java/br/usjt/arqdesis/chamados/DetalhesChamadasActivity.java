package br.usjt.arqdesis.chamados;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class DetalhesChamadasActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes_chamadas);
        TextView chamada = (TextView)findViewById(R.id.chamada_selecionada);
        Intent intent = getIntent();
        chamada.setText(intent.getStringExtra(ListaChamadas.CHAMADAS));
    }
}
