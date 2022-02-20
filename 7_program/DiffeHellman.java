
/*
 * Question 7:Implement the Diffie-Hellman Key Exchange algorithm.
 * AIM: Implement the Diffie-Hellman Key Exchange mechanism using HTML
 * and JavaScript. Consider the end user as one of the parties (Alice) and the
 * JavaScript application as other party (bob).
 * PROGRAM:
*/
import java.math.BigInteger;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.SecureRandom;
import javax.crypto.spec.DHParameterSpec;
import javax.crypto.spec.DHPublicKeySpec;

public class DiffeHellman {
    public final static int pValue = 47;
    public final static int gValue = 71;
    public final static int XaValue = 9;
    public final static int XbValue = 14;

    public static void main(String[] args) throws Exception {
        // TO DO code application logic here
        BigInteger p = new BigInteger(Integer.toString(pValue));
        BigInteger g = new BigInteger(Integer.toString(gValue));
        BigInteger Xa = new BigInteger(Integer.toString(XaValue));
        BigInteger Xb = new BigInteger(Integer.toString(XbValue));
        createKey();
        int bitLength = 512; // 512 bits
        SecureRandom rnd = new SecureRandom();
        p = BigInteger.probablePrime(bitLength, rnd);
        g = BigInteger.probablePrime(bitLength, rnd);
        createSpecificKey(p, g);
    }

    public static void createKey() throws Exception {
        KeyPairGenerator kpg = KeyPairGenerator.getInstance("DiffieHellman");
        kpg.initialize(512);
        KeyPair kp = kpg.generateKeyPair();
        KeyFactory kfactory = KeyFactory.getInstance("DiffieHellman");
        DHPublicKeySpec kspec = (DHPublicKeySpec) kfactory.getKeySpec(kp.getPublic(),
                DHPublicKeySpec.class);
        System.out.println("Public key is: " + kspec);
    }

    public static void createSpecificKey(BigInteger p, BigInteger g) throws Exception {
        KeyPairGenerator kpg = KeyPairGenerator.getInstance("DiffieHellman");
        DHParameterSpec param = new DHParameterSpec(p, g);
        kpg.initialize(param);
        KeyPair kp = kpg.generateKeyPair();
        KeyFactory kfactory = KeyFactory.getInstance("DiffieHellman");
        DHPublicKeySpec kspec = (DHPublicKeySpec) kfactory.getKeySpec(kp.getPublic(), DHPublicKeySpec.class);
        System.out.println("\nPublic key is : " + kspec);
    }
}
/*
 * OUTPUT:
 * Public key is: javax.crypto.spec.DHPublicKeySpec@5afd29
 * Public key is: javax.crypto.spec.DHPublicKeySpec@9971ad
 */