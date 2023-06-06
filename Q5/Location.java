package Data_Structure_Assignment.Q5;

import java.util.ArrayList;

public class Location implements Comparable<Location> {

    private boolean visited;
    private final int locationname;
    private double food;
    private int index;
    private final int enemy;
    private ArrayList<String> roadtype=new ArrayList<>();
    private final ArrayList<Location> towardlocation=new ArrayList<>();


    public Location(int locationname,int index,int enemy){
        this.locationname=locationname;
        this.index=index;
        this.enemy=enemy;
        visited=false;
        food=100;
    }

    public void setVisited(boolean visited){this.visited=visited;}

    public boolean isVisited() {return visited;}

    public int getLocationname() {return locationname;}

    public void setFood(double amount){this.food=amount;}

    public double getFood(){return food;}

    public int getIndex(){return index;}

    public void addTowardlocation(Location location){towardlocation.add(location);}

    public int getIndextowardlocation(Location location){return towardlocation.indexOf(location);}

    public ArrayList<Location> getlocation(){

        return towardlocation;}
    public void setRoadtype(String roadtype){this.roadtype.add(0,roadtype);}

    public String getRoadType(int index){ return roadtype.get(index);}

    public int getEnemy(){return enemy;}

    public void printroad(){
        System.out.println("camp"+this.locationname);
        for(String i: roadtype){
            System.out.print(i + " ");
        }
        System.out.println();
    }

    @Override
    public int compareTo(Location others) {
        if(this.locationname>others.locationname){
            return 1;
        }
        if(this.locationname<others.locationname){
            return -1;
        }
        return 0;
    }
}
