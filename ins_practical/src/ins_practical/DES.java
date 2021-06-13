/*Write a program to encrypt and decrypt strings using DES Algorithm.*/

package ins_practical;
import java.util.Scanner;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

class DesEncrypter {
    Cipher ecipher;
    Cipher dcipher;
    DesEncrypter(SecretKey key) throws Exception
    {
        ecipher=Cipher.getInstance("DES");
        dcipher=Cipher.getInstance("DES");
        ecipher.init(Cipher.ENCRYPT_MODE,key);
        dcipher.init(Cipher.DECRYPT_MODE,key);
    }
    
    public String encrypt(String str) throws Exception
    {
        byte[] utf8=str.getBytes("UTF8");
        byte[] enc=ecipher.doFinal(utf8);
        return new sun.misc.BASE64Encoder().encode(enc);
    }
    
    public String decrypt(String str) throws Exception
    {
        byte[] dec=new sun.misc.BASE64Decoder().decodeBuffer(str);
        byte[] utf8=dcipher.doFinal(dec);
        return new String(utf8,"UTF8");
    }

}
public class DES {
    public static void main(String args[]) throws Exception
    {
        SecretKey key=KeyGenerator.getInstance("DES").generateKey();
        DesEncrypter encrypter=new DesEncrypter(key);
        System.out.println("Enter text : ");
        Scanner sc=new Scanner(System.in);
        String encrypted=encrypter.encrypt(sc.nextLine());
        System.out.println("Encrypted Text : "+encrypted);
        String decrypted=encrypter.decrypt(encrypted);
        System.out.println("Decrypted Text : "+decrypted);
    }
}
