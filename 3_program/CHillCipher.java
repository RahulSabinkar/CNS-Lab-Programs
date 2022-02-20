
/* a) Hill Cipher */
import java.io.*;
import java.util.*;

public class CHillCipher {
    static float[][] decrypt = new float[3][1];
    static float[][] a = new float[3][3];
    static float[][] b = new float[3][3];
    static float[][] mes = new float[3][1];
    static float[][] res = new float[3][1];
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        // TO DO code application logic here
        getkeymes();
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 1; j++)
                for (int k = 0; k < 3; k++) {
                    res[i][j] = res[i][j] + a[i][k] * mes[k][j];
                }
        System.out.print("\nEncrypted string is : ");
        for (int i = 0; i < 3; i++) {
            System.out.print((char) (res[i][0] % 26 + 97));
            res[i][0] = res[i][0];
        }
        inverse();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 1; j++) {
                for (int k = 0; k < 3; k++) {
                    decrypt[i][j] = decrypt[i][j] + b[i][k] * res[k][j];
                }
            }
        }
        System.out.print("\nDecrypted string is : ");
        for (int i = 0; i < 3; i++) {
            System.out.print((char) (decrypt[i][0] % 26 + 97));
        }
        System.out.print("\n");
    }

    public static void getkeymes() throws IOException {
        System.out.println("Enter 3x3 matrix for key (It should be inversible): ");
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                a[i][j] = sc.nextFloat();
        System.out.print("\nEnter a 3 letter string: ");
        String msg = br.readLine();
        for (int i = 0; i < 3; i++)
            mes[i][0] = msg.charAt(i) - 97;
    }

    public static void inverse() {
        float p, q;
        float[][] c = a;
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++) {
                a[i][j] = sc.nextFloat();
                if (i == j)
                    b[i][j] = 1;
                else
                    b[i][j] = 0;
            }
        for (int k = 0; k < 3; k++) {
            for (int i = 0; i < 3; i++) {
                p = c[i][k];
                q = c[k][k];
                for (int j = 0; j < 3; j++) {
                    if (i != k) {
                        c[i][j] = c[i][j] * q - p * c[k][j];
                        b[i][j] = b[i][j] * q - p * b[k][j];
                    }
                }
            }
        }
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++) {
                b[i][j] = b[i][j] / c[i][i];
            }
        System.out.println("");
        System.out.println("\nInverse Matrix is : ");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++)
                System.out.print(b[i][j] + " ");
            System.out.print("\n");
        }
    }
}
/*
 * Output:
 * Enter a 3 letter string: hai
 * Encrypted string is :fdx
 * Inverse Matrix is :
 * 0.083333336 0.41666666 -0.33333334
 * -0.41666666 -0.083333336 0.6666667
 * 0.5833333 -0.083333336 -0.33333334
 * Decrypted string is :hai
 */