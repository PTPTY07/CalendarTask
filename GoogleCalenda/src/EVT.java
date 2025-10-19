import java.util.Date;
public class EVT 
{
    public String dettagli_EVT;
    public String luogo_EVT;
    public Date data_EVT;

    // 🔸 Costruttore
    public EVT(String dettagli_EVT, String luogo, Date data_EVT) {
        this.dettagli_EVT = dettagli_EVT;
        this.luogo_EVT = luogo;
        this.data_EVT = data_EVT;
    }
    
    public EVT() {
        this.dettagli_EVT = "";
        this.luogo_EVT = "";
        this.data_EVT = null;
    }

}
