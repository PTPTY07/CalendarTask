public class TS 
{
    public String str;
    public int priorita;
    public boolean complet;
    public TS(String str, int priorita)
    {
        this.str = str;
        this.priorita = priorita;
        complet = false;
    }
    
    public TS()
    {
        str = null;
        priorita = 0;
        complet = false;
    }
    
    public void setPriorita(int priorita)
    {
        this.priorita = priorita;
    }
    
    public void setTS(String str)
    {
        this.str = str;
    }
    
    public void setComplet(boolean b)
    {
        complet = b;
    }
}
