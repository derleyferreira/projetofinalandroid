package wanderley.com.br.encontreentrega.to;

/**
 * Created by Wanderley on 14/06/2015.
 */
public class TOPacote extends TOBase {

    private String data;
    private String local;
    private String acao;
    private String detalhes;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getAcao() {
        return acao;
    }

    public void setAcao(String acao) {
        this.acao = acao;
    }

    public String getDetalhes() {
        return detalhes;
    }

    public void setDetalhes(String detalhes) {
        this.detalhes = detalhes;
    }
}
