package Data_Structure_Assignment.Q5;

public class General {
    private final String name;
    private String grade;
    private int power;

    General(String name,String grade){
        this.name=name;
        this.grade=grade;
    }

    General(String name,int power){
        this.name=name;
        this.power=power;
    }
    public String getname(){return name;}
    public String getgrade(){return grade;}
    public int getPower(){return power;}
    public double multiple(General general){
        if(general.grade.equals("S"))
            return 2;
        else if(general.grade.equals("S"))
            return 1.5;
        else if(general.grade.equals("S"))
            return 1.2;
        else
            return 1;
    }
}
