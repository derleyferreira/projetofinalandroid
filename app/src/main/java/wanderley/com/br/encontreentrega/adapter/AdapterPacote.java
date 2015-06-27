package wanderley.com.br.encontreentrega.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import wanderley.com.br.encontreentrega.R;
import wanderley.com.br.encontreentrega.to.TOAcoesPacote;
import wanderley.com.br.encontreentrega.to.TOPacote;

/**
 * Created by Wanderley on 15/06/2015.
 */
public class AdapterPacote extends BaseAdapter {

    private TOAcoesPacote acoesPacote;
    private Context context;

    public AdapterPacote(TOAcoesPacote acoesPacote, Context context) {
        this.acoesPacote = acoesPacote;
        this.context = context;
    }

    @Override
    public int getCount() {
        return acoesPacote.getLista().length;
    }

    @Override
    public Object getItem(int i) {
        return acoesPacote.getLista()[i];
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        TOPacote p = (TOPacote) getItem(i);

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View v = inflater.inflate(R.layout.detalhes,null);

        TextView tvData = (TextView) v.findViewById(R.id.tv_Detalhes_Data);
        tvData.setText(p.getData().toString());

        TextView tvAcao = (TextView) v.findViewById(R.id.tv_Detalhes_Acao);
        tvAcao.setText(p.getAcao().toString());

        TextView tvLocal = (TextView) v.findViewById(R.id.tv_Detalhes_Local);
        tvLocal.setText(p.getLocal().toString());

        TextView tvDetalhes = (TextView) v.findViewById(R.id.tv_Detalhes_Detalhe);
        tvDetalhes.setText(p.getDetalhes().toString());

        LinearLayout layout = (LinearLayout) v.findViewById(R.id.lay_Detalhes);


        if ( (i == 0) || ( (i % 2) == 0) ) {
            layout.setBackgroundColor(Color.parseColor("#FFFF80"));
        }
        else{
            layout.setBackgroundColor(Color.parseColor("#FFFF99"));
        }

        return v;

    }
}
