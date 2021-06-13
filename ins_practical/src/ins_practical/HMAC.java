/*Write a program to calculate HMAC-SHA1 Signature.*/

package ins_practical;
import java.io.DataInputStream;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SignatureException;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;

public class HMAC {
    public static byte[] calculateRFC2104HMAC(String data, String key) throws NoSuchAlgorithmException, InvalidKeyException{
        SecretKeySpec signingKey = new SecretKeySpec(key.getBytes(), "HmacSHA1");
        Mac mac = Mac.getInstance("HmacSHA1");
        mac.init(signingKey);
        byte[] hex = mac.doFinal(data.getBytes());
        return hex;
    }
    
    public static void main(String[] args) throws IOException, SignatureException, NoSuchAlgorithmException, InvalidKeyException { 
        System.out.print("Enter plain text: ");
        DataInputStream ds=new DataInputStream(System.in); 
        String plain=ds.readLine(); 
        System.out.print("Enter key text: "); 
        String key=ds.readLine(); 
        byte[] hmac = calculateRFC2104HMAC(plain, key);
        System.out.println("HMAC - SHA1 : " + DatatypeConverter.printHexBinary(hmac));
    }
}
