/*Write a program to implement the Diffie-Hellman key agreement algorithm to generate symmetric keys.*/

package ins_practical;
import java.io.DataInputStream;
import java.io.IOException;

public class DiffieHellman {
    public static void main(String[] args) throws IOException{
        DataInputStream d = new DataInputStream(System.in);
        System.out.println("Enter the secret key for the Alice : ");
        int x = Integer.parseInt(d.readLine());
        System.out.println("Enter the secret key for the Bob : ");
        int y = Integer.parseInt(d.readLine());
        
        System.out.print("Enter the first prime number(g) : ");
        int g = Integer.parseInt(d.readLine());
        System.out.print("Enter the second prime number(n) : ");
        int n = Integer.parseInt(d.readLine());
        
        int A = (int) ((Math.pow(g,x)%n));
        System.out.println("A calculated by Alice : "+A);
        int B = (int) ((Math.pow(g,y)%n));
        System.out.println("B calculated by Bob : "+B);
        
        int k1 = (int) ((Math.pow(B,x)%n));
        System.out.println("k1 calculated by Alice : "+k1);
        int k2 = (int) ((Math.pow(A,y)%n));
        System.out.println("k2 calculated by Bob : "+k2);
        
        if(k1==k2){
            System.out.println("Shared secret key is : "+k1+"\n");
        }
    }
}
