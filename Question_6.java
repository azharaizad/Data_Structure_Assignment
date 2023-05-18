import java.util.Scanner;
import java.util.ArrayList;
public class Question_6 {
    public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    System.out.print("Text: ");
    String Text = sc.nextLine();

    System.out.print("Shift: ");
    int Shift = sc.nextInt();

    Decryption(Text, Shift);
}
public static void Decryption(String Text, int Shift) {
        String decrypted;
        ArrayList<String> List = new ArrayList<>();
        String Alphabet = "abcdefghijklmnopqrstuvwxyz";
        String[] Alpha = Alphabet.split("");
        String[] Letter = Text.split("");
        //Shift alphabet and space '$'
        for (int i = 0; i < Letter.length; i++) {
        for (int j = 0; j < Alpha.length; j++) {
        if (Letter[i].equalsIgnoreCase(Alpha[j])) {
        int num = j-Shift;
        if(num<0){
        num =26+num;
        }
        decrypted = Alpha[num];
        List.add(Alpha[num]);
        }
        else  {
        if (Letter[i].equals("$")) {
        List.add(" ");
        break;
        } else if (Letter[i].equals("^")) {
        List.add("^");
        break;
        }
        else{
        List.add(Letter[i]);
        break;
        }
        }

        }
        }
        //Capitalized '^'
        for (int i = 0; i < List.size() - 1; i++) {
        if (List.get(i).equals("^")) {
        String nextElement = List.get(i+1);
        String updatedElement = nextElement.toUpperCase();
        List.set(i+1, updatedElement);
        List.remove(i);
        }
        }

        //Print out
        for (int i = 0; i < List.size(); i++)
        System.out.print(List.get(i));
        }
        }
