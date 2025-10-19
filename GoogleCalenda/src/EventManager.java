import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class EventManager 
{
    private ArrayList<EVT> EVTList;
    private String pathEVT = "evt.txt";
    private EVT temp_EVT = null;
    
    public EventManager() {
        EVTList = new ArrayList<>();
    }
    
    //getter / setter
    public ArrayList<EVT> getTaskList() {
        return EVTList;
    }

    public String getPathTS()
    {
        return pathEVT;
    }
    
    public EVT getTemp_TS()
    {
        return temp_EVT;
    }
    
    public void setTemp_TS(EVT temp_EVT)
    {
        this.temp_EVT = temp_EVT;
    }
    
    //funzioni i/o file
    public void ReadFile() throws IOException
    {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        try (BufferedReader br = new BufferedReader(new FileReader(pathEVT))) {
            String line;
            EVTList.clear();
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(";");
                if (parts.length != 4) continue;
                
                try{
                    Date data_EVT = sdf.parse(parts[0].trim());
                    EVT nuovo = new EVT(data_EVT,parts[1].trim(),parts[2].trim());
                    EVTList.add(nuovo);
                } catch (Exception e){
                    System.err.println("Errore parsing data: " + parts[0]);
                }
                
            }
            
        }
    }
    
    public void SaveFile() throws IOException
    {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(pathEVT)))
        {
            for (EVT e : EVTList)
            {
                String line = sdf.format(e.data_EVT) + ";" + e.dettagli_EVT+ ";" + e.luogo_EVT;
                bw.write(line);
                bw.newLine();
            }
        }
    }
}
