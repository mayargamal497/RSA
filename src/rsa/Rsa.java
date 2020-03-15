
package rsa;

import java.util.Scanner;
import java.math.*;

public class Rsa {

    public static int p;
    public static int q;
    public static BigInteger e;
    public static int n;
    public static int X;
    public static int phi;
    public static BigInteger m;
    public static BigInteger M;
    public static int Mi;
    public static BigInteger power;
    public static int c;
    public static BigInteger C;
    public static int Ci;
    public static int D;
    public static BigInteger d;
    public static BigInteger N;
    public static int power2;
    public static int P;

    public static Scanner myObj = new Scanner(System.in);

    public static int calcN() {
        System.out.print("Enter the value of p: ");
        p = myObj.nextInt();
        System.out.print("Enter the value of q: ");
        q = myObj.nextInt();
        n = p * q;
        System.out.print("The value of n: " + n);
        System.out.print("\n");
        return n;
    }

    public static int calcPhi() {
        phi = (p - 1) * (q - 1);
        System.out.print("The the value of φ(n): " + phi);
        System.out.print("\n");
        return phi;
    }

    public static BigInteger calcD() {
        System.out.print("Enter the value of e: ");
        BigInteger PHI = BigInteger.valueOf(phi);/// PHI & e 'bigintegers'
        e = myObj.nextBigInteger();
        d = e.modInverse(PHI);
        System.out.print("The value of d is: " + d);
        return d;
    }

    public static BigInteger calcC() {
        System.out.print("\n");
        System.out.print("Enter the value of M: ");
        BigInteger N = BigInteger.valueOf(n);
        int E = e.intValue();
        m = myObj.nextBigInteger();
        power = m.pow(E);
        // c = power.intValue();
        //  Ci = c % n;
        C = power.mod(N);
        String str1 = m + "^" + E + " mod " + n + " = ";
        System.out.print("The the value of C: " + str1 + C);
        return C;
    }

    public static int calcM() {
        System.out.print("\n");
        String str2 = C + "^" + d + " mod " + n + " = ";
        Ci = C.intValue();
        int D = d.intValue();
        power2 = (int) Math.pow(Ci, D);
        Mi = power2 % n;
        System.err.print(power2);
        //power2 = C.pow(D);
        //System.out.println("C power d: " + power2);
        //M = power2.mod(N);
        System.out.println("The the value of M: " + str2 + Mi);
        return Mi;

    }

    public static void main(String[] args) {
        calcN();
        calcPhi();
        calcD();
        calcC();
        calcM();
    }

}
