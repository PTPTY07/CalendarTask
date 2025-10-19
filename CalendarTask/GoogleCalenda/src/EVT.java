import java.util.Date;
public class EVT {
    public Date data_EVT;
    public String dettagli_EVT;
    public String luogo_EVT;

    public EVT(Date data_EVT, String dettagli_EVT, String luogo_EVT) {
        this.data_EVT = data_EVT;
        this.dettagli_EVT = dettagli_EVT;
        this.luogo_EVT = luogo_EVT;
    }

    public EVT() {
        this.dettagli_EVT = "";
        this.luogo_EVT = "";
        this.data_EVT = null;
    }

}
