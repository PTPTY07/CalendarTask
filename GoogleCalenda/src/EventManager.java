import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class EventManager 
{
    private ArrayList<EVT> EVTList;
    private String pathEVT = "evt.txt";
    private EVT temp_EVT = null;
    
    public EventManager() {
        EVTList = new ArrayList<>();
    }
    
    //getter / setter
    public ArrayList<EVT> getEVTList() {
        return EVTList;
    }

    public String getPathEVT()
    {
        return pathEVT;
    }
    
    public EVT getTemp_EVT()
    {
        return temp_EVT;
    }
    
    public void setTemp_EVT(EVT temp_EVT)
    {
        this.temp_EVT = temp_EVT;
    }
    
    //funzioni i/o file
    /*public void ReadFile() throws IOException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm"); // Data + Ora

        try (BufferedReader br = new BufferedReader(new FileReader(pathEVT))) {
            String line;
            EVTList.clear();

            while ((line = br.readLine()) != null) {
                String[] parts = line.split(";");
                if (parts.length != 4) continue;

                try {
                    Date data_EVT = sdf.parse(parts[0].trim() + " " + parts[1].trim()); // unisci data + ora
                    String dettagli = parts[2].trim();
                    String luogo = parts[3].trim();

                    EVT nuovo = new EVT(data_EVT, dettagli, luogo);
                    EVTList.add(nuovo);
                } catch (Exception e) {
                    System.err.println("Errore parsing data/ora: " + parts[0] + " " + parts[1]);
                }
            }
        }
    }*/

    public void SaveFile() throws IOException {
        SimpleDateFormat sdfData = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat sdfOra = new SimpleDateFormat("HH:mm");

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(pathEVT))) {
            for (EVT e : EVTList) {
                String data = sdfData.format(e.data_EVT);
                String ora = sdfOra.format(e.data_EVT);
                String dettagli = e.dettagli_EVT;
                String luogo = e.luogo_EVT;

                String line = data + ";" + ora + ";" + dettagli + ";" + luogo;
                bw.write(line);
                bw.newLine();
            }
        }
    }

    //funzioni utili
    public void insertSorted(EVT nuovoEvento) {
        if (EVTList.isEmpty()) {
            EVTList.add(nuovoEvento);
            return;
        }

        for (int i = 0; i < EVTList.size(); i++) {
            EVT e = EVTList.get(i);
            // Confronta le date: se il nuovo evento è prima, inseriscilo qui
            if (nuovoEvento.data_EVT.before(e.data_EVT)) {
                EVTList.add(i, nuovoEvento);
                return;
            }
        }

        // Se è dopo tutti gli altri, aggiungilo in fondo
        EVTList.add(nuovoEvento);
    }
    
    public void mostraEventiDelGiorno(Date dataSelezionata, JTable table_evt) {
        
        if (dataSelezionata == null) {
            JOptionPane.showMessageDialog(null, "Seleziona una data dal calendario.");
            return;
        }

        // Formatter solo per confrontare giorno/mese/anno (ignora ora)
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String giornoScelto = sdf.format(dataSelezionata);

        // Crea il modello per la JTable
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Ora");
        model.addColumn("Dettagli");
        model.addColumn("Luogo");

        // Aggiungi solo gli eventi della data selezionata
        SimpleDateFormat sdfOra = new SimpleDateFormat("HH:mm");
        for (EVT e : EVTList) {
            String giornoEvento = sdf.format(e.data_EVT);
            if (giornoEvento.equals(giornoScelto)) {
                String ora = sdfOra.format(e.data_EVT);
                model.addRow(new Object[]{ora, e.dettagli_EVT, e.luogo_EVT});
            }
        }

        // Aggiorna la tabella
        table_evt.setModel(model);
    }
}
