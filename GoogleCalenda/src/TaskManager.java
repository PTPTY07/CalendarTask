import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;

public class TaskManager {
    private ArrayList<TS> taskList;
    private final String pathTS = "tasks.txt";
    private TS temp_TS = null;

    //costruttore
    public TaskManager() {
        taskList = new ArrayList<>();
    }
    
    //getter / setter
    public ArrayList<TS> getTaskList() {
        return taskList;
    }

    public String getPathTS()
    {
        return pathTS;
    }
    
    public TS getTemp_TS()
    {
        return temp_TS;
    }
    
    public void setTemp_TS(TS temp_TS)
    {
        this.temp_TS = temp_TS;
    }
    
    //cerca l'indice dell'ultitima task non ancora completata
    private int lastUncompletedIndex() {
        int last = -1;
        for (int i = 0; i < taskList.size(); i++) {
            if (!taskList.get(i).complet) last = i;
        }
        return last;
    }
    
    public void addTask(TS t) {
        if (!t.complet) {
            int firstIndex = 0;
            while (firstIndex < taskList.size() && taskList.get(firstIndex).complet == false) {
                // trova la posizione giusta in base alla priorità 
                if (t.priorita < taskList.get(firstIndex).priorita) {
                    break;
                }
                firstIndex++;
            }
            taskList.add(firstIndex, t);
        } else {
            // task già completata → aggiungi in fondo
            taskList.add(t);
        }
    }


    public void removeTask(TS t) {
        taskList.remove(t);
    }

    public void markCompleted(TS t) {
        // se è già completata non fare nulla
        if (t.complet) return;

        // rimuovi dalla lista
        int currentIndex = taskList.indexOf(t);
        if (currentIndex == -1) return;

        taskList.remove(currentIndex);

        // imposta flag complet
        t.complet = true;

        // trova nuova posizione: dopo l'ultima non completata
        int insertPos = lastUncompletedIndex() + 1;
        taskList.add(insertPos, t);
    }
    
    
    public void ordinaTask() {
        ArrayList<TS> nonCompletate = new ArrayList<>();
        ArrayList<TS> completate = new ArrayList<>();

        for (TS t : taskList) {
            if (t.complet) completate.add(t);
            else nonCompletate.add(t);
        }

        // non completate → ordina per priorità
        nonCompletate.sort(Comparator.comparingInt(a -> a.priorita));

        // completate → **non ordinare**, rimangono nell’ordine di completamento
        // taskList finale: non completate + completate
        taskList.clear();
        taskList.addAll(nonCompletate);
        taskList.addAll(completate);
    }


    public void caricaDaFile(String filePath) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            taskList.clear();
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(";");
                if (parts.length != 3) continue;
                TS nuovo = new TS(parts[0].trim(), Integer.parseInt(parts[1].trim()));
                nuovo.complet = Boolean.parseBoolean(parts[2].trim());
                taskList.add(nuovo);
            }
            
            //-------------------Controllo forse non necessario-------------------------
            ordinaTask();
        }
    }

    public void salvaSuFile(String filePath) throws IOException {
        try (PrintWriter pw = new PrintWriter(new FileWriter(filePath))) {
            for (TS t : taskList) {
                pw.println(t.str + ";" + t.priorita + ";" + t.complet);
            }
        }
    }
    
    public TS getTSIndex(int index)
    {
        return taskList.get(index);
    }
}
