package diffie.hellman;

import Utilities.Person;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Scanner;

public class DiffieHellman {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SecureRandom rnd = new SecureRandom();

        System.out.println("+================================================+");
        System.out.println("|                Diffie-Hellman                  |");
        System.out.println("+================================================+");

        //Input the bits
        System.out.print("Input the bit size: ");
        int bitLength = sc.nextInt();

        //Random prime (main arguments)
        BigInteger p = BigInteger.probablePrime(bitLength, rnd);
        BigInteger g = BigInteger.probablePrime(bitLength, rnd);

        //Build people that know the main arguments
        Person Alice = new Person(p, g, bitLength);
        Person Bob = new Person(p, g, bitLength);

        //The people choose a number
        Alice.chooseNumber();
        Bob.chooseNumber();

        //The people calculate the number
        Alice.calculateValueToSend();
        Bob.calculateValueToSend();

        //The people receive the value sent
        Alice.receiveValueSended(Bob.getValueCalculate());
        Bob.receiveValueSended(Alice.getValueCalculate());

        //The peopple calculate the final key
        Alice.calculateFinalKey();
        Bob.calculateFinalKey();

        System.out.println("====================================================");
        System.out.println("The value of p selected:________________" + p);
        System.out.println("The value of g selected:________________" + g);
        System.out.println("The value of a selected by Alice:_______" + Alice.getNumberChoosen());
        System.out.println("The value of b selected by Bob:_________" + Bob.getNumberChoosen());
        System.out.println("The value of A sent to Bob by Alice:____" + Bob.getNumberReceived());
        System.out.println("The value of B sent to Alice by Bob:____" + Alice.getNumberReceived());
        System.out.println("The value of key shared between Alice and Bob: ");
        System.out.println("Alice:__" + Alice.getFinalKey());
        System.out.println("Bob:____" + Bob.getFinalKey());
        if (Alice.getFinalKey().equals(Bob.getFinalKey())) {
            System.out.println(">>>  SUCCESS ALICE AND BOB HAVE THE SAME KEY!  :D <<<"); 
       }else{
            System.err.println(">>>  ERROR ALICE AND BOB NOT HAVE THE SAME KEY!  :( <<<");
        }
        System.out.println("====================================================");
    }

}
