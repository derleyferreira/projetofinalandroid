package wanderley.com.br.encontreentrega.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import wanderley.com.br.encontreentrega.R;

/**
 * Created by Wanderley on 19/06/2015.
 */
public class AdapterNaoEncontrado extends BaseAdapter {

    private Context context;

    public AdapterNaoEncontrado(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return 1;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View v = inflater.inflate(R.layout.activity_nao_encontrado, null);

        TextView tvNaoEncontrado = (TextView) v.findViewById(R.id.tv_Naoencontrado);
        tvNaoEncontrado.setText(R.string.nao_encontrado);

        return v;
    }
}
