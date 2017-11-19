package br.usjt.arqdesis.chamados;

import android.app.Activity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.AdapterView;

import java.util.ArrayList;

public class ListaChamadas extends Activity
{
    public static final String CHAMADAS = "br.usjt.arqdesis.chamadas.chamadas";
    ArrayList<String> lista;
    Activity atividade;
    int position;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_chamadas);
        atividade = this;
        Intent intent = getIntent();
        String chave = intent.getStringExtra(BotaoListar.CHAVE);
        lista = buscaChamadas(chave);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, lista);
        ListView listView = (ListView) findViewById(R.id.listview);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l)
            {
                //Manda para a tela de detalhe
                Intent intent = new Intent(atividade, DetalhesChamadasActivity.class);
                intent.putExtra(CHAMADAS, lista.get(position));

                startActivity(intent);
            }
        });
    }

    public ArrayList<String> buscaChamadas(String chave)
    {
        ArrayList<String> lista = geraListaChamadas();
        if(chave == null || chave.length() == 0)
            return lista;
        else
        {
            ArrayList<String> subLista = new ArrayList<>();
            for(String chamada:lista)
            {
                if(chamada.toUpperCase().contains(chave.toUpperCase()))
                {
                    subLista.add(chamada);
                }
            }
            return lista;
        }
    }

    public ArrayList geraListaChamadas()
    {
        ArrayList<String> lista = new ArrayList<>();

        lista.add("12345 - Aberto - 17/11/17 - No prazo!" + "\nComputador não funciona.");
        lista.add("12346 - Aberto - 18/11/17 - Atrasado!" + "\nComputador não funciona.");
        lista.add("12347 - Fechado - 18/11/17 - Atrasado!" + "\n Computador não funciona.");
        lista.add("12348 - Aberto - 18/11/17 - Atrasado!" + "\nComputador não funciona.");
        lista.add("12349 - Parado - 18/11/17 - No prazo!" + "\nComputador não funciona.");
        lista.add("12350 - Aberto - 19/11/17 - Atrasado!" + "\nComputador não funciona.");
        lista.add("12351 - Aberto - 19/11/17 - No prazo!" + "\nComputador não funciona.");

        return lista;
    }

}
