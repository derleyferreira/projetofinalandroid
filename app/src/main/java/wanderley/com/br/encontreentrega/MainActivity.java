package wanderley.com.br.encontreentrega;

import android.app.ProgressDialog;
import android.graphics.Color;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import wanderley.com.br.encontreentrega.adapter.AdapterNaoEncontrado;
import wanderley.com.br.encontreentrega.adapter.AdapterPacote;
import wanderley.com.br.encontreentrega.task.PacoteTask;
import wanderley.com.br.encontreentrega.to.TOAcoesPacote;
import wanderley.com.br.encontreentrega.to.TOPacote;


public class MainActivity extends ActionBarActivity implements View.OnClickListener {

    private EditText edtPesquisa;
    private Button btnPesquisa;
    private ListView lista;
    private LinearLayout lay_Main;

    private ProgressDialog pd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lay_Main = (LinearLayout) findViewById(R.id.lay_Main);

        lay_Main.setBackgroundColor(Color.parseColor("#FFFF66"));

        edtPesquisa = (EditText) findViewById(R.id.edt_Main_Pesquisa);
        btnPesquisa = (Button) findViewById(R.id.btn_Main_Pesquisa);
        btnPesquisa.setOnClickListener(this);

        lista = (ListView) findViewById(R.id.lv_Main_Lista);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        actionBar.setCustomView(R.layout.abs_layout);

    }

    private void pesquisaPacote()
    {
        pd = new ProgressDialog(this);
        pd.setMessage("Carregando...");
        pd.show();

        PacoteTask pt = new PacoteTask(){
            @Override
            protected void onPostExecute(TOAcoesPacote toAcoesPacote) {
                pd.hide();

                if (toAcoesPacote != null)
                {

                    AdapterPacote adapterPacote = new AdapterPacote(toAcoesPacote,MainActivity.this);
                    lista.setAdapter(adapterPacote);

                }
                else
                {
                    AdapterNaoEncontrado adapterNaoEncontrado = new AdapterNaoEncontrado(MainActivity.this);
                    lista.setAdapter(adapterNaoEncontrado);
                }

            }
        };
        pt.execute(edtPesquisa.getText().toString());

    }

    @Override
    public void onClick(View view) {

        if (edtPesquisa.getText().toString().equals(""))
        {
            lista.setAdapter(null);
            Toast.makeText(this,"Informe o número do pacote",Toast.LENGTH_LONG).show();
            return;
        }

        pesquisaPacote();



    }
}
