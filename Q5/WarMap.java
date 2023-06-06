package Data_Structure_Assignment.Q5;

import java.util.*;

public class WarMap {

    Graph<Location, Integer> CaoCaomap = new Graph<>();
    Scanner user = new Scanner(System.in);
    Random RNG=new Random();
    String[] roadtype={"flat road","forest","swamp","plank road"};
    boolean verify;
    double foodharvested=0;

    //assigning camp name and index
    Location[] camp = {new Location(1, 0,0), new Location(3, 1,80), new Location(2, 2,90), new Location(6, 3,60), new Location(10, 4,60), new Location(4, 5,50), new Location(7, 6,80), new Location(5, 7,30), new Location(8, 8,30), new Location(9, 9,50)};

    //assigning path of each camp toward which camp
    Location[] path1 = {camp[4], camp[3], camp[1], camp[2]};
    int[] value1 = {18, 10, 20, 30};
    Location[] path3 = {camp[0], camp[5], camp[6]};
    int[] value3 = {28, 12, 18};
    Location[] path2 = {camp[0], camp[5]};
    int[] value2 = {10, 10};
    Location[] path6 = {camp[0], camp[8], camp[6], camp[7]};
    int[] value6 = {17, 23, 35, 20};
    Location[] path10 = {camp[0], camp[9], camp[8]};
    int[] value10 = {12, 18, 16};
    Location[] path4 = {camp[2], camp[1], camp[7]};
    int[] value4 = {12, 12, 10};
    Location[] path7 = {camp[3], camp[7], camp[8], camp[9]};
    int[] value7 = {17, 19, 10, 23};
    Location[] path5 = {camp[3], camp[5], camp[6]};
    int[] value5 = {10, 12, 17};
    Location[] path8 = {camp[9], camp[6], camp[3], camp[4]};
    int[] value8 = {7, 35, 12, 19};
    Location[] path9 = {camp[4], camp[6], camp[8]};
    int[] value9 = {7, 17, 18};

    //Assigning General for leading and fighting harvest
    General[] general={new General("Lu Su","S"),new General("Lu Meng","S"),new General("Zhu Ge Jin","S"),new General("Xiao Qiao","A"),new General("Da Qiao","A"),new General("Gan Ning","B"),new General("Xu Sheng","C"),new General("Tai Shi Chi","C"),new General("Gan Ning","C"),new General("Huang Gai","C")};

    General[] fighter={new General("Xu Sheng",90),new General("Lu Meng",70),new General("Xiao Qiao",42)};

    WarMap() {
        //declaring vertex
        for (Location camped : camp) {
            CaoCaomap.addvertex(camped);
        }
        //assigning edges & weight
        int i = 0;
        for (Location j : path1) {
            CaoCaomap.addedge(camp[0], j, value1[i]);
            camp[0].addTowardlocation(j);
            i++;
        }
        camp[0].setRoadtype(roadtype[1]);
        camp[0].setRoadtype(roadtype[0]);
        camp[0].setRoadtype(roadtype[0]);
        camp[0].setRoadtype(roadtype[0]);
        i = 0;
        for (Location j : path3) {
            CaoCaomap.addedge(camp[1], j, value3[i]);
            camp[1].addTowardlocation(j);
            i++;
        }
        camp[1].setRoadtype(roadtype[3]);
        camp[1].setRoadtype(roadtype[2]);
        camp[1].setRoadtype(roadtype[0]);
        i = 0;
        for (Location j : path2) {
            CaoCaomap.addedge(camp[2], j, value2[i]);
            camp[2].addTowardlocation(j);
            i++;
        }
        camp[2].setRoadtype(roadtype[2]);
        camp[2].setRoadtype(roadtype[0]);
        i = 0;
        for (Location j : path6) {
            CaoCaomap.addedge(camp[3], j, value6[i]);
            camp[3].addTowardlocation(j);
            i++;
        }
        camp[3].setRoadtype(roadtype[0]);
        camp[3].setRoadtype(roadtype[1]);
        camp[3].setRoadtype(roadtype[3]);
        camp[3].setRoadtype(roadtype[0]);
        i = 0;
        for (Location j : path10) {
            CaoCaomap.addedge(camp[4], j, value10[i]);
            camp[4].addTowardlocation(j);
            i++;
        }
        camp[4].setRoadtype(roadtype[1]);
        camp[4].setRoadtype(roadtype[0]);
        camp[4].setRoadtype(roadtype[0]);
        i = 0;
        for (Location j : path4) {
            CaoCaomap.addedge(camp[5], j, value4[i]);
            camp[5].addTowardlocation(j);
            i++;
        }
        camp[5].setRoadtype(roadtype[2]);
        camp[5].setRoadtype(roadtype[2]);
        camp[5].setRoadtype(roadtype[2]);
        i = 0;
        for (Location j : path7) {
            CaoCaomap.addedge(camp[6], j, value7[i]);
            camp[6].addTowardlocation(j);
            i++;
        }
        camp[6].setRoadtype(roadtype[0]);
        camp[6].setRoadtype(roadtype[0]);
        camp[6].setRoadtype(roadtype[1]);
        camp[6].setRoadtype(roadtype[1]);
        i = 0;
        for (Location j : path5) {
            CaoCaomap.addedge(camp[7], j, value5[i]);
            camp[7].addTowardlocation(j);
            i++;
        }
        camp[7].setRoadtype(roadtype[1]);
        camp[7].setRoadtype(roadtype[2]);
        camp[7].setRoadtype(roadtype[0]);
        i = 0;
        for (Location j : path8) {
            CaoCaomap.addedge(camp[8], j, value8[i]);
            camp[8].addTowardlocation(j);
            i++;
        }
        camp[8].setRoadtype(roadtype[1]);
        camp[8].setRoadtype(roadtype[3]);
        camp[8].setRoadtype(roadtype[0]);
        camp[8].setRoadtype(roadtype[2]);
        i = 0;
        for (Location j : path9) {
            CaoCaomap.addedge(camp[9], j, value9[i]);
            camp[9].addTowardlocation(j);
            i++;
        }
        camp[9].setRoadtype(roadtype[2]);
        camp[9].setRoadtype(roadtype[0]);
        camp[9].setRoadtype(roadtype[0]);
    }

    public void findingpath(int location) {
//        CaoCaomap.printgraph();
//        for (Location i : camp) {
//            i.printroad();
//        }
        do {//looping to make sure that user enter correct location
            if (location > 10 || location < 0) {
                System.out.println("The camp not exist");
                verify = true;
            } else {
                verify = false;
                continue;
            }
            System.out.print("The enemy base location : ");
            location = user.nextInt();
        } while (verify);
        int j = 0;
        while (location != camp[j].getLocationname()) {
            j++;
        }//getting the Cao Cao camp
        System.out.println("\nBest path :");
        int i = 0;
        while (!camp[i].equals(camp[5])) {//move until level 2 only cause it covered all vertex
            if (location == 1) {//The camp is at your place
                System.out.println("don't need to move ,you are already at enemy base");
                break;
            }
            if (CaoCaomap.hasedge(camp[i], camp[j])) {
                if (camp[i].compareTo(camp[0]) == 0) {//The location is at level 2
                    System.out.println(camp[i].getLocationname() + " " + location);
                    System.out.println("The type of path :");
                    System.out.println(camp[0].getRoadType(camp[0].getIndextowardlocation(camp[j])));
                    System.out.println("The path distance is "+CaoCaomap.weightedge(camp[0],camp[i])+"km\n");
                    break;
                }
                //the location is at level 3
                System.out.println(camp[0].getLocationname() + " " + camp[i].getLocationname() + " " + location);
                System.out.println("The type of path :");
                System.out.println(camp[0].getRoadType(camp[0].getIndextowardlocation(camp[i])));
                System.out.println(camp[i].getRoadType(camp[i].getIndextowardlocation(camp[j])));
                System.out.println("The path distance is "+CaoCaomap.weightedge(camp[0],camp[i])+"km and "+CaoCaomap.weightedge(camp[i],camp[j])+"km\n");
            }
            i++;
        }

    }
    public void Scout(int location,int general){
        do {//looping to make sure that user enter correct location
            if (general > 3 || general < 0) {
                System.out.println("That no general");
                verify = true;
            } else {
                verify = false;
                continue;
            }
            System.out.print("Choose the General's role to scout path 1(1,2,3) :");
            general = user.nextInt();
        } while (verify);
        int j = 0;
        while (location != camp[j].getLocationname()) {
            j++;
        }//getting the Cao Cao camp
        int i = 0,count=1;;
        float speedCalvary=2,speedArcher=1,speedInfantry=1;
        float speedCalvary2=2,speedArcher2=1,speedInfantry2=1;
        while (!camp[i].equals(camp[5])) {//move until level 2 only cause it covered all vertex
            if (location == 1) {//The camp is at your place
                System.out.println("Get ready to ambushed Cao Cao Camp!!!!!");
                break;
            }
            if (CaoCaomap.hasedge(camp[i], camp[j])) {
                if (camp[i].compareTo(camp[0]) == 0) {//The location is at level 2
                    int distance = CaoCaomap.weightedge(camp[0],camp[j]);
                    //identify the camps path road type
                    if(camp[0].getRoadType(camp[0].getIndextowardlocation(camp[j])).equals(roadtype[0])){
                        speedCalvary*=3;
                        speedArcher*=2;
                        speedInfantry*=2;
                    }
                    else if(camp[0].getRoadType(camp[0].getIndextowardlocation(camp[j])).equals(roadtype[1])){
                        speedCalvary*=0.8;
                        speedArcher*=1;
                        speedInfantry*=2.5;
                    }
                    else if(camp[0].getRoadType(camp[0].getIndextowardlocation(camp[j])).equals(roadtype[2])){
                        speedCalvary*=0.3;
                        speedArcher*=2.5;
                        speedInfantry*=1;
                    }
                    else if(camp[0].getRoadType(camp[0].getIndextowardlocation(camp[j])).equals(roadtype[3])){
                        speedCalvary*=0.5;
                        speedArcher*=0.5;
                        speedInfantry*=0.5;
                    }
                    float timeCalvary=(float)distance/speedCalvary;
                    float timeArcher=(float)distance/speedArcher;
                    float timeInfantry=(float)distance/speedInfantry;
                    float[] timecompare={timeCalvary,timeArcher,timeInfantry};
                    //sort in ascending order
                    Arrays.sort(timecompare);
                    if(general==1 && timecompare[0]==timeCalvary){
                        System.out.println("You are Right, Calvary is the fastest for this path");
                    }else if(general==2 && timecompare[0]==timeArcher){
                        System.out.println("You are Right, Archer is the fastest for this path");
                    }else if(general==3 && timecompare[0]==timeInfantry){
                        System.out.println("You are Right, Infantry is the fastest for this path");
                    }else{
                        System.out.println("Sorry but you are wrong,This is the time consumed by each general.");
                    }
                    System.out.printf("The time for Calvary is %.2f hours\n",timeCalvary);
                    System.out.printf("The time for Archer is %.2f hours\n",timeArcher);
                    System.out.printf("The time for Infantry is %.2f hours\n",timeInfantry);
                    break;
                }
                if(count==2){//for the second best path if any
                    System.out.print("Choose the General's role to scout path "+count+"(1,2,3) :");
                    general = user.nextInt();
                    do {//looping to make sure that user enter correct location
                        if (general > 3 || general < 0) {
                            System.out.println("That no general");
                            verify = true;
                        } else {
                            verify = false;
                            continue;
                        }
                        System.out.print("Choose the General's role to scout path "+count+"(1,2,3) :");
                        general = user.nextInt();
                    } while (verify);
                }
                //the location is at level 3
                int distance = CaoCaomap.weightedge(camp[0],camp[i])+CaoCaomap.weightedge(camp[i],camp[j]);
                //Speed for the first path //identify the camps path road type
                if(camp[0].getRoadType(camp[0].getIndextowardlocation(camp[i])).equals(roadtype[0])){
                    speedCalvary*=3;
                    speedArcher*=2;
                    speedInfantry*=2;
                }
                else if(camp[0].getRoadType(camp[0].getIndextowardlocation(camp[i])).equals(roadtype[1])){
                    speedCalvary*=0.8;
                    speedArcher*=1;
                    speedInfantry*=2.5;
                }
                else if(camp[0].getRoadType(camp[0].getIndextowardlocation(camp[i])).equals(roadtype[2])){
                    speedCalvary*=0.3;
                    speedArcher*=2.5;
                    speedInfantry*=1;
                }
                else if(camp[0].getRoadType(camp[0].getIndextowardlocation(camp[i])).equals(roadtype[3])){
                    speedCalvary*=0.5;
                    speedArcher*=0.5;
                    speedInfantry*=0.5;
                }
                //speed for the second path //identify the camps path road type
                if(camp[i].getRoadType(camp[i].getIndextowardlocation(camp[j])).equals(roadtype[0])){
                    speedCalvary2*=3;
                    speedArcher2*=2;
                    speedInfantry2*=2;
                }
                else if(camp[i].getRoadType(camp[i].getIndextowardlocation(camp[j])).equals(roadtype[1])){
                    speedCalvary2*=0.8;
                    speedArcher2*=1;
                    speedInfantry2*=2.5;
                }
                else if(camp[i].getRoadType(camp[i].getIndextowardlocation(camp[j])).equals(roadtype[2])){
                    speedCalvary2*=0.3;
                    speedArcher2*=2.5;
                    speedInfantry2*=1;
                }
                else if(camp[i].getRoadType(camp[i].getIndextowardlocation(camp[j])).equals(roadtype[3])){
                    speedCalvary2*=0.5;
                    speedArcher2*=0.5;
                    speedInfantry2*=0.5;
                }
                float timeCalvary=(float)distance/(speedCalvary+speedCalvary2);
                float timeArcher=(float)distance/(speedArcher+speedArcher2);
                float timeInfantry=(float)distance/(speedInfantry+speedInfantry2);
                //sort in ascending order
                float[] timecompare={timeCalvary,timeArcher,timeInfantry};
                Arrays.sort(timecompare);
                if(general==1 && timecompare[0]==timeCalvary){
                    System.out.println("You are Right, Calvary is the fastest for this path "+count);
                }else if(general==2 && timecompare[0]==timeArcher){
                    System.out.println("You are Right, Archer is the fastest for this path"+count);
                }else if(general==3 && timecompare[0]==timeInfantry){
                    System.out.println("You are Right, Infantry is the fastest for this path "+count);
                }else{
                    System.out.println("Sorry but you are wrong,This is the time consumed by each general.");
                }
                System.out.printf("The time for Calvary is %.2f hours\n",timeCalvary);
                System.out.printf("The time for Archer is %.2f hours\n",timeArcher);
                System.out.printf("The time for Infantry is %.2f hours\n",timeInfantry);
                count++;
            }
            i++;
        }

    }
    public void foodharvest(int location,int Leader,int Fighter) {
        //initialize the leader to list to be chose
        LinkedList<General> fighter=new LinkedList<>(Arrays.asList(this.fighter));
        ArrayList<General> leader = new ArrayList<>(Arrays.asList(this.general));
        //chose th leader
        General choosenfight=fighter.get(Fighter-1);
        General choosenone= leader.get(Leader-1);
        //assigning the leader power of multiplication
        if(choosenone.getgrade().equals("S")){
            for(Location i:camp){
                i.setFood(i.getFood()*choosenone.multiple(choosenone));
            }
        }else if(choosenone.getgrade().equals("A")){
            for(Location i:camp){
                i.setFood(i.getFood()*choosenone.multiple(choosenone));
            }
        }else if(choosenone.getgrade().equals("B")){
            for(Location i:camp){
                i.setFood(i.getFood()*choosenone.multiple(choosenone));
            }
        }
        do {//looping to make sure that user enter correct location
            if (location > 10 || location < 0) {
                System.out.println("The camp not exist");
                verify = true;
            } else {
                verify = false;
                continue;
            }
            System.out.print("Enter location without food: ");
            location = user.nextInt();
        } while (verify);
        int j = 0;
        while (location!=camp[j].getLocationname()) {
            j++;
        }//getting cao cao camp
        List<Location> Thepath = findPath(camp[j],choosenfight);
        // Example output
        System.out.println("Path:");
        for (Location node : Thepath) {
            System.out.print(node.getLocationname() + " ");
        }
        System.out.println("\nfood harvested :"+foodharvested);
        System.out.println("The food harvest lead by "+choosenone.getname()+" and have "+choosenone.getgrade()+" in politic.");
        System.out.println("Multiply the harvest by "+choosenone.multiple(choosenone));
    }

    public List<Location> findPath(Location noFoodNode,General chosenfight) {
        //set the no food node to be true and the food is 0
        camp[noFoodNode.getIndex()].setVisited(true);
        camp[noFoodNode.getIndex()].setFood(0);
        //set the node 1 food become 0
        camp[0].setFood(0);
        if(noFoodNode.getLocationname()==4||noFoodNode.getLocationname()==6||noFoodNode.getLocationname()==7||noFoodNode.getLocationname()==8||noFoodNode.getLocationname()==66||noFoodNode.getLocationname()==1){
            System.out.println("The camp must be passed through in order to harvest all food\n");
            camp[noFoodNode.getIndex()].setVisited(false);
        }
        //create the list for uncollectable food camps and path of all camps
        List<Location> path = new ArrayList<>();
        List<Location> Uncollectable = new ArrayList<>();
        // Start the search from Camp 1
        DepthFS(camp[0], path,Uncollectable,chosenfight);
        // Add Camp 1 to complete the cycle
        path.add(camp[0]);
        //print the camps that cannot be collected
        System.out.print("The food is uncollectable at camp :");
        for (Location node : Uncollectable) {
            System.out.print(node.getLocationname() + " ");
        }
        System.out.println("\n"+chosenfight.getname()+"'s strength is "+chosenfight.getPower());
        return path;
    }

    public boolean DepthFS(Location current,List<Location> path,List<Location> Uncollectable,General chosenfight){
        //set the visit camp into true and add it into path,adding the food harvested
        current.setVisited(true);
        path.add(camp[current.getIndex()]);
        foodharvested+=camp[current.getIndex()].getFood();

        // Check if all camps have been visited
        boolean allVisited = true;
        for (int i = 0; i < CaoCaomap.size; i++) {
            if (!camp[i].isVisited()) {
                allVisited = false;
                break;
            }
        }

        // If all camps have been visited, return true to complete the cycle
        if (allVisited) {
            return true;
        }

        for (Location neighbor : camp[current.getIndex()].getlocation()) {
            if (!neighbor.isVisited()) {
                if(neighbor.getEnemy()>chosenfight.getPower()&&!Uncollectable.contains(neighbor)){
                    Uncollectable.add(neighbor);
                    foodharvested-=camp[current.getIndex()].getFood();
                }
                if (DepthFS(neighbor, path,Uncollectable,chosenfight)) {
                    return true;
                }
            }
        }
        // Backtrack if no path is found and minus the food harvested
        current.setVisited(false);
        path.remove(path.size() - 1);
        foodharvested-=camp[current.getIndex()].getFood();
        return false;
    }

    public static void main(String[] args) {
        WarMap locate = new WarMap();
        Scanner user=new Scanner(System.in);

        //QUESTION 5
        System.out.println("Our base camp located at node 1");
        System.out.print("The enemy base location : ");
        int location = user.nextInt();
        locate.findingpath(location);

        //EXTRA FEATURES
        System.out.println("\nWe will send Scout First\nChoose the fastest :");
        System.out.println("1: Calvary - speed : 2 km/h\n" +
                "- Flat road - x 3\n" +
                "- Forest - x 0.8\n" +
                "- Swamp - x 0.3\n" +
                "- Plank road - x 0.5\n" +
                "2: ArcherCavalry  - speed: 1 km/h\n" +
                "- Flat road - x 2\n" +
                "- Forest - x 1\n" +
                "- Swamp - x 2.5\n" +
                "- Plank road - x 0.5\n" +
                "3: Infantry- speed:1 km/h\n" +
                "- Flat road - x 2\n" +
                "- Forest - x 2.5\n" +
                "- Swamp - x 1\n" +
                "- Plank road - x 0.5\n");
        System.out.print("Choose the General's role to scout  path 1(1,2,3) :");
        int General=user.nextInt();
        locate.Scout(location,General);

        //EXTRA FEATURES
        System.out.println("\nWe need to do some food harvesting");
        System.out.println("We need political general to lead");
        System.out.println("1) Lu Su (General)\n"+
                        "2)Lu Meng (General)\n"+
                        "3)Zhu Ge Jin (General)\n"+
                        "4)Xiao Qiao (General)\n"+
                        "5)Da Qiao (General)\n"+
                        "6)Gan Ning (General)\n"+
                        "7)Xu Sheng (General)\n"+
                        "8)Tai Shi Chi (General)\n"+
                        "9)Gan Ning (General)\n"+
                        "10)Huang Gai (General)");
        System.out.print("Choose your General to be the harvest leader: ");
        General=user.nextInt();

        System.out.println("\nOh No!!we found that the camp have enemy guarding the food!");
        System.out.println("1)Xu Sheng\n2)Lu Meng\n3)Xiao Qiao");
        System.out.print("Choose strongest general to fight the enemy :");
        int Fighter=user.nextInt();

        //QUESTION 6
        System.out.print("Enter location without food: ");
        location = user.nextInt();
        locate.foodharvest(location,General,Fighter);
    }
}