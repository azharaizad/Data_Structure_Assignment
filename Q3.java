public class Q3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
         Boats boats = new Boats(1000, 750, 400, 320);
        
        // Attack from different directions
        int arrowCount = 50;
        int arrowsCollectedFront = boats.Attack("Front", arrowCount);
        int arrowsCollectedLeft = boats.Attack("Left", arrowCount);
        int arrowsCollectedRight = boats.Attack("Right", arrowCount);
        int arrowsCollectedBack = boats.Attack("Back", arrowCount);
        
        // Display the arrows collected from each direction
        System.out.println("\nArrows Collected:");
        System.out.println("Front: " + arrowsCollectedFront);
        System.out.println("Left: " + arrowsCollectedLeft);
        System.out.println("Right: " + arrowsCollectedRight);
        System.out.println("Back: " + arrowsCollectedBack);
    }
    
}
