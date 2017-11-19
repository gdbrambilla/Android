package br.usjt.arqdesis.chamados;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class BotaoListar extends Activity
{
    private EditText chamada;
    public static final String CHAVE = "br.usjt.arqdesis.chamadas.chave";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_botao_listar);
    }

    public void startActivity2(View view)
    {
        Intent intent = new Intent(this, ListaChamadas.class);
        startActivity(intent);
    }
}
