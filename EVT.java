
import java.util.ArrayList;

public class EVT 
{
    public String dettagli_evt;
    public String luogo;
    public String ore;

    // 🔸 Costruttore
    public EVT(String dettagli_evt, String luogo, String ore) {
        this.dettagli_evt = dettagli_evt;
        this.luogo = luogo;
        this.ore = normalizzaOra(ore);
    }

    // 🔸 Rende l'ora sempre nel formato "HH:mm"
    private String normalizzaOra(String input) {
        if (!input.contains(":")) {
            input += ":00";
        }
        String[] parti = input.split(":");
        String hh = parti[0].length() == 1 ? "0" + parti[0] : parti[0];
        String mm = (parti.length > 1)
                ? (parti[1].length() == 1 ? "0" + parti[1] : parti[1])
                : "00";
        return hh + ":" + mm;
    }

    public String getOra() {
        return ore;
    }

    public String getOraFormattata() {
        return ore;
    }

    // 🔸 Ordinamento basato solo su stringhe
    public static void ordinaPerOra(ArrayList<EVT> arr) {
        arr.sort((a, b) -> a.getOra().compareTo(b.getOra()));
    }

    @Override
    public String toString() {
        return ore + " - " + dettagli_evt + " @ " + luogo;
    }
}