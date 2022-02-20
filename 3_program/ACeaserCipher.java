
/*
 * Question 3: Write a Java program to perform encryption and decryption using the following
 * algorithms a. Ceaser cipher b. Substitution cipher c. Hill Cipher
 * 
 * AIM: Write a Java program to perform encryption and decryption using the
 * following algorithms:
 * a) Ceaser Cipher
 * b) Substitution Cipher
 * c) Hill Cipher
 * 
 * PROGRAM:
 * a) Ceaser Cipher
*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class ACeaserCipher {
    static Scanner sc = new Scanner(System.in);
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        // TO DO code application logic here
        System.out.print("Enter any String: ");
        String str = br.readLine();
        System.out.print("\nEnter the Key: ");
        int key = sc.nextInt();
        String encrypted = encrypt(str, key);
        System.out.println("\nEncrypted String is: " + encrypted);
        String decrypted = decrypt(encrypted, key);
        System.out.println("\nDecrypted String is: "
                + decrypted);
        System.out.println("\n");
    }

    public static String encrypt(String str, int key) {
        String encrypted = "";
        for (int i = 0; i < str.length(); i++) {
            int c = str.charAt(i);
            if (Character.isUpperCase(c)) {
                c = c + (key % 26);
                if (c > 'Z')
                    c = c - 26;
            } else if (Character.isLowerCase(c)) {
                c = c + (key % 26);
                if (c > 'z')
                    c = c - 26;
            }
            encrypted += (char) c;
        }
        return encrypted;
    }

    public static String decrypt(String str, int key) {
        String decrypted = "";
        for (int i = 0; i < str.length(); i++) {
            int c = str.charAt(i);
            if (Character.isUpperCase(c)) {
                c = c - (key % 26);
                if (c < 'A')
                    c = c + 26;
            } else if (Character.isLowerCase(c)) {
                c = c - (key % 26);
                if (c < 'a')
                    c = c + 26;
            }
            decrypted += (char) c;
        }
        return decrypted;
    }
}
/*
 * Output:
 * Enter any String: Hello World
 * Enter the Key: 5
 * Encrypted String is: Mjqqt Btwqi
 * Decrypted String is: Hello World
 */