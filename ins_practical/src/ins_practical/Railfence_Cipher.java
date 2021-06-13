/*Write a program to implement the following Substitution Cipher Technique : Rail Fence Cipher.*/
package ins_practical;
import java.util.Scanner;

public class Railfence_Cipher {
    public static void main(String args[]){
        String str;
        System.out.println("Enter text : ");
        Scanner sc = new Scanner(System.in);
        str = sc.nextLine();
        String s1 = "";
        String s2 = "";
        for(int i =0; i<str.length(); i++){
            if(i%2 == 0){
                s1 = s1 + str.charAt(i);
            }
            else{
                s2 = s2 + str.charAt(i);
            }
        }
        System.out.print("Encrypted text is : ");
        System.out.print(s1 + s2 + "\n");
    }
}
