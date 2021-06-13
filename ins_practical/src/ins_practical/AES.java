/*Write a program to encrypt and decrypt strings using : AES algorithm.*/

package ins_practical;
import java.util.Scanner;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.xml.bind.DatatypeConverter;

public class AES {
    public static void main(String[] args) throws Exception{
        System.out.println("Enter text : ");
        Scanner sc = new Scanner(System.in);
        String plainText = sc.nextLine();
        SecretKey secKey = getSecretEncryptionKey();
        System.out.println("AES Key (Hex Form):"+bytesToHex(secKey.getEncoded()));
        String encryptedText = bytesToHex(encryptText(plainText, secKey));
        System.out.println("Encrypted Text (Hex Form):"+encryptedText);
        String decryptedText = decryptText(encryptedText, secKey);
        System.out.println("Decrypted Text:"+decryptedText);
    }
    
    public static SecretKey getSecretEncryptionKey() throws Exception{
        KeyGenerator generator = KeyGenerator.getInstance("AES");
        generator.init(128);
        SecretKey secKey = generator.generateKey();
        return secKey;
    }

    public static byte[] encryptText(String plainText,SecretKey secKey) throws Exception{
        Cipher aesCipher = Cipher.getInstance("AES");
        aesCipher.init(Cipher.ENCRYPT_MODE, secKey);
        byte[] byteCipherText = aesCipher.doFinal(plainText.getBytes());
        return byteCipherText;
    }

    public static String decryptText(String encrypted, SecretKey secKey) throws Exception {
        Cipher aesCipher = Cipher.getInstance("AES");
        aesCipher.init(Cipher.DECRYPT_MODE, secKey);
        byte[] bytePlainText = aesCipher.doFinal(hexToByte(encrypted));
        return new String(bytePlainText);
    }

    private static String bytesToHex(byte[] hash) {
        return DatatypeConverter.printHexBinary(hash);
    }

    private static byte[] hexToByte(String txt) {
        return DatatypeConverter.parseHexBinary(txt);
    }
}
