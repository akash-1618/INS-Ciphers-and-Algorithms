/*Write a program to implement the following Substitution Cipher Technique : Caesar Cipher.*/

package ins_practical;

import java.util.Scanner;
public class Caesar_Cipher {
    public static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
    
    public static String encrypt(String plainText, int shiftKey){
        plainText = plainText.toLowerCase();
        String cipherText = "";
        
        for(int i = 0; i < plainText.length(); i++){
            int charPosition = ALPHABET.indexOf(plainText.charAt(i));
            int keyVal = (shiftKey + charPosition)%26;
            char replaceVal = ALPHABET.charAt(keyVal);
            cipherText += replaceVal;
        }      
        return cipherText;
    }
    
        public static String decrypt(String cipherText, int shiftKey){
        cipherText = cipherText.toLowerCase();
        String plainText = "";
        
        for(int i = 0; i < cipherText.length(); i++){
            int charPosition = ALPHABET.indexOf(cipherText.charAt(i));
            int keyVal = (charPosition - shiftKey) % 26;
            if(keyVal < 0){
                keyVal = ALPHABET.length() + keyVal;
            }
            char replaceVal = ALPHABET.charAt(keyVal);
            plainText += replaceVal;
        }      
        return plainText;
    }
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the String for encryption : ");
        String message = new String();
        message = sc.next();
        String enMsg = encrypt(message, 3);
        System.out.println("Encrypted text : " + enMsg);
        System.out.println("Decrypted text : " + decrypt(enMsg, 3));
    }
}
