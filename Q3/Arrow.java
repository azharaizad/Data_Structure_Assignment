package Q3_DS_Assignment;
import java.util.Scanner;
public class Arrow {

    public static void BAselectionBar() {
        Strawman front = new Strawman();
        Strawman back = new Strawman();
        Strawman left = new Strawman();
        Strawman right = new Strawman();

        while (true) {
            Scanner in = new Scanner(System.in);
            System.out.println("----------------------------------------------");
            System.out.println("1 Standard Borrowing Arrow");
            System.out.println("2 Dynamic Borrowing Arrow");
            System.out.println("-1 Exit Page");
            System.out.print("Select a function : ");
            int opt = in.nextInt();
            //to make sure the process goes smooth as there will be some errors if we dont do so 
            in.nextLine();

            switch (opt) {
                case 1:
                    //Standard Borrowing Arrow
                    //Input the number of straw men in each direction
                    System.out.println("Enter the number of straw men for each side of the boat (Must be less than 100) :-");
                    System.out.print("Front : ");
                    int unit = in.nextInt();
                    in.nextLine();
                    Strawman temp = front;
                    front = inputUnit(front, "Front", unit);
                    if (front.equals(temp)) {
                        System.out.println("Number of straw men is out of bound");
                        System.out.println("Returning to Borrowing Arrow's Menu...");
                        break;
                    }
                    System.out.print("Back : ");
                    unit = in.nextInt();
                    in.nextLine();
                    temp = back;
                    back = inputUnit(back, "Back", unit);
                    if (back.equals(temp)) {
                        System.out.println("Number of straw men is out of bound");
                        System.out.println("Returning to Borrowing Arrow's Menu...");
                        break;
                    }
                    System.out.print("Left : ");
                    unit = in.nextInt();
                    in.nextLine();
                    temp = left;
                    left = inputUnit(left, "Left", unit);
                    if (left.equals(temp)) {
                        System.out.println("Number of straw men is out of bound");
                        System.out.println("Returning to Borrowing Arrow's Menu...");
                        break;
                    }
                    System.out.print("Right : ");
                    unit = in.nextInt();
                    in.nextLine();
                    temp = right;
                    right = inputUnit(right, "Right", unit);
                    if (right.equals(temp)) {
                        System.out.println("Number of straw men is out of bound");
                        System.out.println("Returning to Borrowing Arrow's Menu...");
                        break;
                    }
                    System.out.println("");
                    System.out.println("The number of arrows shot will gradually decrease in each waves");
                    System.out.print("Enter the number of waves of arrows shot : ");
                    int arrow[];
                    int waves = in.nextInt();
                    in.nextLine();
                    //Insert the number of arrows in each wave
                    if (waves > 0) {
                        arrow = new int[waves];
                        for (int i = 0; i < waves; i++) {
                            System.out.print("Enter the number of arrows shot [Wave " + (i + 1) + "] : ");
                            arrow[i] = in.nextInt();
                            in.nextLine();
                            if (i > 0) {
                                //if number of arrows exceed the previous one, reenter a new amount.
                                if (arrow[i] > arrow[i - 1]) {
                                    System.out.println("The number of arrows input is higher than previous wave");
                                    System.out.println("Please enter a new amount");
                                    i--;
                                }
                            }
                        }
                    } else {
                        System.out.println("Invalid input. Returning to Borrowing Arrow Menu...");
                        break;
                    }
                    System.out.println("\nCalculating maximum possible arrows that can be retrieved...");
                    int total = 0;
                    //New array to store arrows received in each waves
                    int arrows[] = new int[waves];
                    //calculate the maximum arrows received in each wave and prints the direction
                    System.out.print("Boat Direction : [");
                    for (int i = 0; i < waves; i++) {
                        //calculate the arrow received for each direction
                        calculateArrow(front, arrow[i]);
                        calculateArrow(back, arrow[i]);
                        calculateArrow(left, arrow[i]);
                        calculateArrow(right, arrow[i]);
                        //get the highest value
                        Strawman max = getMax(front, back, left, right);
                        System.out.print(max.getDirection());
                        //store the value in the array
                        arrows[i] = max.getArrowReceived();
                        total = total + arrows[i];
                        decreaseEfficiency(max, front, back, left, right);
                        if (i != waves - 1) {
                            System.out.print(", ");
                        } else {
                            System.out.println("]");
                        }
                    }
                    //print the arrows received in each wave
                    System.out.print("Arrows Received : [");
                    for (int i = 0; i < waves; i++) {
                        System.out.print(arrows[i]);
                        if (i != waves - 1) {
                            System.out.print(", ");
                        } else {
                            System.out.println("]");
                        }
                    }
                    System.out.println("Total Arrows : " + total + "\n");

                    //This is to allow the proceed next when they feel like it
                    System.out.println("Enter to go back to Borrowing Arrow Menu");
                    in.nextLine();
                    break;
                case 2:
                    //Dynamic Arrow Borrowing
                    //Input number of straw men in each side
                    System.out.println("Enter the number of straw men for each side of the boat (Must be less than 100) :-");
                    System.out.print("Front : ");
                    int unit2 = in.nextInt();
                    in.nextLine();
                    Strawman temp2 = front;
                    front = inputUnit(front, "Front", unit2);
                    if (front.equals(temp2)) {
                        System.out.println("Number of straw men is out of bound");
                        System.out.println("Returning to Borrowing Arrow's Menu...");
                        break;
                    }
                    System.out.print("Back : ");
                    unit2 = in.nextInt();
                    in.nextLine();
                    temp2 = back;
                    back = inputUnit(back, "Back", unit2);
                    if (back.equals(temp2)) {
                        System.out.println("Number of straw men is out of bound");
                        System.out.println("Returning to Borrowing Arrow's Menu...");
                        break;
                    }
                    System.out.print("Left : ");
                    unit2 = in.nextInt();
                    in.nextLine();
                    temp2 = left;
                    left = inputUnit(left, "Left", unit2);
                    if (left.equals(temp2)) {
                        System.out.println("Number of straw men is out of bound");
                        System.out.println("Returning to Borrowing Arrow's Menu...");
                        break;
                    }
                    System.out.print("Right : ");
                    unit2 = in.nextInt();
                    in.nextLine();
                    temp2 = right;
                    right = inputUnit(right, "Right", unit2);
                    if (right.equals(temp2)) {
                        System.out.println("Number of straw men is out of bound");
                        System.out.println("Returning to Borrowing Arrow's Menu...");
                        break;
                    }
                    System.out.println("");
                    System.out.print("Enter the number of waves of arrows shot : ");
                    int arrow2[];
                    int waves2 = in.nextInt();
                    in.nextLine();
                    //input the arrows shot for each wave
                    if (waves2 > 0) {
                        arrow2 = new int[waves2];
                        for (int i = 0; i < waves2; i++) {
                            System.out.print("Enter the number of arrows shot [Wave " + (i + 1) + "] : ");
                            arrow2[i] = in.nextInt();
                            in.nextLine();
                        }
                    } else {
                        System.out.println("Invalid input. Returning to Borrowing Arrow Menu...");
                        break;
                    }
                    System.out.println("\nCalculating maximum possible arrows that can be retrieved...");
                    int total2 = 0;
                    //new array to store the number of arrow received for each wave
                    int arrows2[] = new int[waves2];
                    //new array to store the original index of the sorted array
                    int originalOrder[] = originalOrder(arrow2);
                    //sort the arrow shot array in decreasing order
                    int selectedWaves[] = selectWave(arrow2);
                    //new array to store the direction and arrow received for each wave
                    Strawman max[] = new Strawman[waves2];
                    System.out.println("\"null\" direction represents that it is unnecessary to retrieve the arrows during that wave");
                    System.out.print("Boat Direction : [");
                    //calculate the max arrow received from the sorted array
                    for (int i = 0; i < 8; i++) {
                        //calculate the arrows received for each direction
                        calculateArrow(front, selectedWaves[i]);
                        calculateArrow(back, selectedWaves[i]);
                        calculateArrow(left, selectedWaves[i]);
                        calculateArrow(right, selectedWaves[i]);
                        //get the highest value and store it in the array
                        max[originalOrder[i]] = getMax(front, back, left, right);
                        //store the value in the arrow received array
                        arrows2[originalOrder[i]] = max[originalOrder[i]].getArrowReceived();
                        total2 = total2 + arrows2[originalOrder[i]];
                        //if the direction has been used previously in its original order, divide this wave's arrow received by two
                        //and multiply the previous arrow received by two
                        for (int j = 0; j < i; j++){
                            if(max[originalOrder[i]].getDirection().equals(max[originalOrder[j]].getDirection())){
                                if(originalOrder[i]<originalOrder[j]){
                                    if(arrows2[originalOrder[j]]%2==1){
                                        total2-=1;
                                    }
                                    //apply changes to the total arrow received
                                    total2 = total2 + arrows2[originalOrder[i]] - arrows2[originalOrder[j]]/2;
                                    arrows2[originalOrder[i]]*=2;
                                    arrows2[originalOrder[j]]/=2;
                                }
                            }
                        }
                        //decrease its efficiency by half the first time it has been used
                        //and zero if it has been used twice
                        decreaseDynamicEfficiency(max[originalOrder[i]], front, back, left, right);
                    }
                    //print the direction for each waves according to the original index
                    for (int i = 0; i < waves2; i++) {
                        //if the wave was not calculated in the selected wave, set the direction to null and arrow received to zero
                        //ps. the waves is not calculated because it will give out a lower total arrow received 
                        //due to the limited amount of straw men use
                        if (max[i] == null) {
                            max[i] = new Strawman();
                            arrows2[i] = 0;
                        }
                        System.out.print(max[i].getDirection());
                        if (i != waves2 - 1) {
                            System.out.print(", ");
                        } else {
                            System.out.println("]");
                        }
                    }
                    //print the arrow received for each wave according to the original index
                    System.out.print("Arrows Received : [");
                    for (int i = 0; i < waves2; i++) {
                        System.out.print(arrows2[i]);
                        if (i != waves2 - 1) {
                            System.out.print(", ");
                        } else {
                            System.out.println("]");
                        }
                    }
                    System.out.println("Total Arrows : " + total2 + "\n");

                    //This is to allow the proceed next when they feel like it
                    System.out.println("Enter to go back to Borrowing Arrow Menu");
                    in.nextLine();
                    break;
                case -1:
                    return;
                default:
                    System.out.println("Unrecognized function. Please key in again.");
            }
        }
    }
    
    //method to input direction and number of straw men
    public static Strawman inputUnit(Strawman straw, String direction, int unit) {
        if (unit >= 0 && unit < 100) {
            straw = new Strawman(direction, unit);
        }
        return straw;
    }
    
    //method to return the highest arrow received in the wave
    public static Strawman getMax(Strawman front, Strawman back, Strawman left, Strawman right) {
        if (front.getArrowReceived() > back.getArrowReceived()) {
            if (front.getArrowReceived() > left.getArrowReceived()) {
                if (front.getArrowReceived() > right.getArrowReceived()) {
                    return front;
                } else {
                    return right;
                }
            } else {
                if (left.getArrowReceived() > right.getArrowReceived()) {
                    return left;
                } else {
                    return right;
                }
            }
        } else {
            if (back.getArrowReceived() > left.getArrowReceived()) {
                if (back.getArrowReceived() > right.getArrowReceived()) {
                    return back;
                } else {
                    return right;
                }
            } else {
                if (left.getArrowReceived() > right.getArrowReceived()) {
                    return left;
                } else {
                    return right;
                }
            }

        }
    }
    
    //method to decrease the efficiency after the straw men is used
    public static void decreaseEfficiency(Strawman max, Strawman front, Strawman back, Strawman left, Strawman right) {
        if (max.equals(front)) {
            decreaseEfficiency(front);
        } else if (max.equals(back)) {
            decreaseEfficiency(back);
        } else if (max.equals(left)) {
            decreaseEfficiency(left);
        } else {
            decreaseEfficiency(right);
        }
    }
    
    //continuation of the previous method
    public static void decreaseEfficiency(Strawman direction) {
        int current;
        int used;
        current = direction.getUnit();
        used = direction.getUsed();
        switch (used) {
            //if the straw men has not been used before, decrease the efficiency to 80% for next use
            case 0 -> {
                direction.setUsed(1);
                direction.setUnit(current * 4 / 5);
            }
            //if the straw men has been used once, decrease the efficiency to 40% for the final use
            case 1 -> {
                direction.setUsed(2);
                direction.setUnit(current / 2);
            }
            //if it has been used twice before, drop the efficiency to zero so that it can no longer be used
            case 2 -> {
                direction.setUsed(3);
                direction.setUnit(0);
            }
            default -> {
            }
        }
    }
    
    //method to decrease the efficiency of straw men after being used, but for the dynamic arrow borrowing option
    public static void decreaseDynamicEfficiency(Strawman max, Strawman front, Strawman back, Strawman left, Strawman right) {
        if (max.equals(front)) {
            decreaseDynamicEfficiency(front);
        } else if (max.equals(back)) {
            decreaseDynamicEfficiency(back);
        } else if (max.equals(left)) {
            decreaseDynamicEfficiency(left);
        } else {
            decreaseDynamicEfficiency(right);
        }
    }
    
    //continuation of the previous method
    public static void decreaseDynamicEfficiency(Strawman direction) {
        int current;
        int used;
        current = direction.getUnit();
        used = direction.getUsed();
        switch (used) {
            //if the straw men has never been used, decrease the efficiecny to half
            case 0 -> {
                direction.setUsed(1);
                direction.setUnit(current / 2);
            }
            //if it has been used once before drop the efficiency to zero
            case 1 -> {
                direction.setUsed(2);
                direction.setUnit(0);
            }
            default -> {
            }
        }
    }
    
    //method to calculate the number of arrow received for the direction
    public static void calculateArrow(Strawman direction, int shots) {
        double unit = direction.getUnit();
        double arrow = shots * (unit / 100);
        //set the arrow received for the direction
        direction.setArrowReceived((int) arrow);
    }
    
    //method to select 8 waves that would maximize the number of arrows received
    public static int[] selectWave(int[] arrows) {
        int arrow[] = arrows;
        int waves[];
        int temp;
        if (arrow.length > 8) {
            waves = new int[8];
        } else {
            waves = new int[arrow.length];
        }
        for (int i = 0; i < arrow.length; i++) {
            for (int j = i + 1; j < arrow.length; j++) {
                if (arrow[i] < arrow[j]) {
                    temp = arrow[i];
                    arrow[i] = arrow[j];
                    arrow[j] = temp;
                }
            }
        }
        System.arraycopy(arrows, 0, waves, 0, waves.length);
        return waves;
    }
    
    //method to store the original index of the sorted array in another array
    public static int[] originalOrder(int[] arrows) {
        int[] arrow = arrows;
        int temp;
        int tempIndex;
        int index[] = new int[arrow.length];
        for (int i = 0; i < arrow.length; i++) {
            index[i] = i;
        }
        for (int i = 0; i < arrow.length; i++) {
            for (int j = i + 1; j < arrow.length; j++) {
                if (arrow[i] < arrow[j]) {
                    temp = arrow[i];
                    arrow[i] = arrow[j];
                    arrow[j] = temp;
                    tempIndex = index[i];
                    index[i] = index[j];
                    index[j] = tempIndex;
                }
            }
        }
        return index;
    }
}
       
            
