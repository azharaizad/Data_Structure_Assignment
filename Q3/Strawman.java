package Q3_DS_Assignment;

public class Strawman {
    private String direction;
    private int unit;
    private int arrowReceived;
    private int used;
    
    public Strawman(String direction, int unit){
        this.direction = direction;
        this.unit = unit;
        this.used = 0;
    }
    
    public Strawman(){
        
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public void setUnit(int unit) {
        this.unit = unit;
    }
    
    public void setArrowReceived(int arrowReceived){
        this.arrowReceived = arrowReceived;
    }

    public void setUsed(int used) {
        this.used = used;
    }
    
    public String getDirection(){
        return direction;
    }
    
    public int getUnit(){
        return unit;
    }
    
    public int getArrowReceived(){
        return arrowReceived;
    }

    public int getUsed() {
        return used;
    }

    public static void main(String[] args) {
        // TODO code application logic here
        Arrow.BAselectionBar();
    }

}
        
