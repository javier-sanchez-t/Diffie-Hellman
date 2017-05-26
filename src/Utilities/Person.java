package Utilities;

import java.math.BigInteger;
import java.security.SecureRandom;

public class Person {

    private BigInteger p;
    private BigInteger g;
    private int bitLength;
    private BigInteger numberChoosen;
    private BigInteger valueCalculate;
    private BigInteger numberReceived;
    private BigInteger finalKey;

    public Person() {
    }

    public Person(BigInteger p, BigInteger g, int bitLength) {
        this.p = p;
        this.g = g;
        this.bitLength = bitLength;
    }

    public void chooseNumber() {
        SecureRandom rnd = new SecureRandom();
        do {
            numberChoosen = new BigInteger(getBitLength(), rnd);
        } while (numberChoosen.compareTo(p) >= 0);
    }

    public void calculateValueToSend() {
        valueCalculate = g.modPow(numberChoosen, p);
    }

    public void receiveValueSended(BigInteger numberSended) {
        numberReceived = numberSended;
    }

    public void calculateFinalKey() {
        finalKey = numberReceived.modPow(numberChoosen, p);
    }

    public BigInteger getP() {
        return p;
    }

    public void setP(BigInteger p) {
        this.p = p;
    }

    public BigInteger getG() {
        return g;
    }

    public void setG(BigInteger g) {
        this.g = g;
    }

    public BigInteger getNumberChoosen() {
        return numberChoosen;
    }

    public void setNumberChoosen(BigInteger numberChoosen) {
        this.numberChoosen = numberChoosen;
    }

    /**
     * @return the bitLength
     */
    public int getBitLength() {
        return bitLength;
    }

    /**
     * @param bitLength the bitLength to set
     */
    public void setBitLength(int bitLength) {
        this.bitLength = bitLength;
    }

    /**
     * @return the valueCalculate
     */
    public BigInteger getValueCalculate() {
        return valueCalculate;
    }

    /**
     * @param valueCalculate the valueCalculate to set
     */
    public void setValueCalculate(BigInteger valueCalculate) {
        this.valueCalculate = valueCalculate;
    }

    /**
     * @return the numberReceived
     */
    public BigInteger getNumberReceived() {
        return numberReceived;
    }

    /**
     * @param numberReceived the numberReceived to set
     */
    public void setNumberReceived(BigInteger numberReceived) {
        this.numberReceived = numberReceived;
    }

    /**
     * @return the finalKey
     */
    public BigInteger getFinalKey() {
        return finalKey;
    }

    /**
     * @param finalKey the finalKey to set
     */
    public void setFinalKey(BigInteger finalKey) {
        this.finalKey = finalKey;
    }

}
