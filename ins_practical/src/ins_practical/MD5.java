/*Write a program to implement the MD5 algorithm. Compute the message digest.*/

package ins_practical;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class MD5 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a text : ");
        String i =sc.nextLine();
        System.out.println(md5(i));
        System.out.println("For null : " +md5(""));
        System.out.println("For simple text : "+md5("This is my test"));
        System.out.println("For simple numbers : "+md5("12345"));
    }
    
    public static String md5(String input){
        String Md5 = null;
        if(null == input){
            return null;
        }
        try{
            //Create MessageDigest object for MD5
            MessageDigest digest = MessageDigest.getInstance("MD5");

            //Update input string in message digest
            digest.update(input.getBytes(), 0, input.length());

            //Converts message digest value in base 16 (hex)
            Md5 = new BigInteger(1, digest.digest()).toString(16);          
        }
        catch(NoSuchAlgorithmException e){
            e.printStackTrace();
        }
        return Md5;   
    }
}
