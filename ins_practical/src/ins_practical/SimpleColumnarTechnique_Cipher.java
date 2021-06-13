/*Write a program to implement the following Substitution Cipher Technique : Simple Columnar technique.*/

package ins_practical;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SimpleColumnarTechnique_Cipher {
    public static void main(String args[]){
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
            System.out.println("Enter your plain text : ");
            String accept = br.readLine();
            System.out.println("Enter the no. of rows : ");
            int r = Integer.parseInt(br.readLine());
            System.out.println("Enter the no. of columns : ");
            int c = Integer.parseInt(br.readLine());
            int count =0;
            char cont[][]=new char[r][c];
            for(int i=0; i<r; i++){
                for(int j=0 ;j<c; j++){
                    if(count>=accept.length()){
                        cont[i][j]=' ';
                        count++;
                    }
                    else{
                        cont[i][j]=accept.charAt(count);
                        count++;
                    }
                }
            }
            System.out.println("\nEnter the order of columns you want to view them in :");
            int choice[]=new int[c];
            for(int k=0; k<c; k++){
                System.out.println("\nChoice "+k+" -> ");
                choice[k] = Integer.parseInt(br.readLine());
            }
            System.out.println("\nCipher text in Matrix is -> ");
            String cipher ="";
            for(int j=0; j<c; j++){
                int k = choice[j];
                for(int i=0; i<r; i++){
                    cipher += cont[i][k];
                }
            }
            cipher = cipher.trim();
            System.out.println(cipher);
        }
        catch(IOException | NumberFormatException e){
            System.out.println(e);
        }
    }
}
/*Choices must be smaller than the no. of rows and no. of columns individually.*/
