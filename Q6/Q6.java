package Q6;

import java.util.Scanner;
import java.util.ArrayList;
public class Q6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //Ask user to enter text
        boolean flag = true;
        while (flag){
            System.out.print("Enter type of Encryption: 1.Shift messages 2.Base number 3.Break: ");
            int input = sc.nextInt();
            if(input==1) {
                Shift_message();
                System.out.println();
            }
            else if(input==2) {
                Basenumber();
                System.out.println();
            }
            else
                flag = false;
        }



    }
    public static void Shift_message() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Text: ");
        String Text = sc.nextLine();
        System.out.print("Shift: ");
        int Shift = sc.nextInt();

        String encrypted;
        ArrayList<String> List = new ArrayList<>();
        String Alphabet = "abcdefghijklmnopqrstuvwxyz";
        String[] Alpha = Alphabet.split("");
        String[] Letter = Text.split("");
        //Shift alphabet and space '$'
        for (int i = 0; i < Letter.length; i++) {
            for (int j = 0; j < Alpha.length; j++) {
                if (Letter[i].equalsIgnoreCase(Alpha[j])) {
                    int num = j - Shift;
                    if (num < 0) {
                        num = 26 + num;
                    }
                    encrypted = Alpha[num];
                    List.add(encrypted);
                }
                if (Letter[i].equals("$")) {
                    List.add(" ");
                    break;
                } else if (Letter[i].equals("^")) {
                    List.add("^");
                    break;
                } else if (Letter[i].equals(",")|Letter[i].equals(".")|Letter[i].equals("(")|Letter[i].equals(")")) {
                    List.add(Letter[i]);
                    break;
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

        ArrayList<String> Word = new ArrayList<>();
        for (int i = 0; i < List.size(); i++) {
            Word.clear();
            if(List.get(i).equals("(")){
                for (int j = i+1;; j++) {
                    Word.add(List.get(j));
                    if(List.get(j).equals(")")) {
                        for (int k = Word.size()-1; k >= 0; k--) {
                            List.set(i++, Word.get(k));
                        }
                        break;
                    }
                }
            }
        }
        for (int i = 0; i < List.size(); i++) {

        }

        //Print out
        for (int i = 0; i < List.size(); i++) {
            if (List.get(i).equals(")")) {
                List.remove(i);
            }
            System.out.print(List.get(i));
        }
    }
    public static void Basenumber(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Message (SEPARATED BY COMMA Eg. 1,10,12): ");
        String message = sc.nextLine();
        System.out.print("Base number: ");
        int Base = sc.nextInt();
        String[]Text = message.split(",");

        int[]num = new int[Text.length];
        for (int i = 0; i < Text.length; i++) {
            num[i] = Integer.parseInt(Text[i],Base);
        }
        String Alphabet = "abcdefghijklmnopqrstuvwxyz";
        String[] Alpha = Alphabet.split("");
        String[] Output = new String[num.length];
        for (int i = 0; i < num.length; i++) {
            System.out.print(Alpha[num[i]]);
        }

    }
}

