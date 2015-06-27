package wanderley.com.br.encontreentrega.task;

import android.os.AsyncTask;

import com.google.gson.Gson;

import org.json.JSONArray;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import wanderley.com.br.encontreentrega.adapter.AdapterPacote;
import wanderley.com.br.encontreentrega.fw.Constant;
import wanderley.com.br.encontreentrega.fw.Util;
import wanderley.com.br.encontreentrega.to.TOAcoesPacote;
import wanderley.com.br.encontreentrega.to.TOPacote;


/**
 * Created by Wanderley on 15/06/2015.
 */
public class PacoteTask extends AsyncTask<String,Void, TOAcoesPacote> {
    @Override
    protected TOAcoesPacote doInBackground(String... strings) {
        TOAcoesPacote p = new TOAcoesPacote();

        TOPacote[] pacote = null;

        try {

            URL url = new URL(Constant.API.URL + strings[0]);
            HttpURLConnection http = (HttpURLConnection) url.openConnection();
            http.setRequestMethod("GET");
            http.setRequestProperty("Content-Type", "text/plain; charset=utf-8");

            InputStream i = new BufferedInputStream(http.getInputStream());
            String result = Util.readString(i);


            Gson gson = new Gson();

            TOPacote[] pct = gson.fromJson(result,TOPacote[].class);

            p.setLista(pct);

        } catch (Exception e) {
            p = null;
        }

        return p;

    }
}
