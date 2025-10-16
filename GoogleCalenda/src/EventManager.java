import java.util.ArrayList;

public class EventManager 
{
    private ArrayList<EVT> evtList;
    private String pathEVT = "evt.txt";
    private EVT temp_EVT = null;
    
    public EventManager() {
        evtList = new ArrayList<>();
    }
    
    //getter / setter
    public ArrayList<EVT> getTaskList() {
        return evtList;
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
    
    public void addEVT(EVT t) {
        
    }
}
