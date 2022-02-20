
/*
 * Question 5: Write a C/JAVA program to implement the Blowfish algorithm logic.
 * AIM: Write a C/JAVA program to implement the BlowFish algorithm logic.
 * Program:
*/
import java.io.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.security.Key;
import javax.crypto.Cipher;
import javax.crypto.CipherOutputStream;
import javax.crypto.KeyGenerator;
import sun.misc.BASE64Encoder;

public class BlowFish {
    public static void main(String[] args) throws Exception {
        // TO DO code application logic here
        KeyGenerator keyGenerator = KeyGenerator.getInstance("Blowfish");
        keyGenerator.init(128);
        Key secretKey = keyGenerator.generateKey();
        Cipher cipherOut = Cipher.getInstance("Blowfish/CFB/NoPadding");
        cipherOut.init(Cipher.ENCRYPT_MODE, secretKey);
        BASE64Encoder encoder = new BASE64Encoder();
        byte iv[] = cipherOut.getIV();
        if (iv != null) {
            System.out.println("Initialization Vector of the Cipher: " +
                    encoder.encode(iv));
        }
        FileInputStream fin = new FileInputStream("inputFile.txt");
        FileOutputStream fout = new FileOutputStream("outputFile.txt");
        CipherOutputStream cout = new CipherOutputStream(fout, cipherOut);
        int input = 0;
        while ((input = fin.read()) != -1) {
            cout.write(input);
        }
        fin.close();
        cout.close();
    }
}
/*
 * OUTPUT:
 * Initialization Vector of the Cipher: dI1MXzW97oQ=
 * Contents of inputFile.txt: Hello World
 * Contents of outputFile.txt: ùJÖ˜ NåI“
 */