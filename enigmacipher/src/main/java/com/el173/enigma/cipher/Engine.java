package com.el173.enigma.cipher;

public class Engine {

    private Motor motor;

    public Engine() {
        setMotor(new Motor());
    }

    /**
     *
     * @return Cipher engine motor
     */
    public Motor getMotor() {
        return motor;
    }


    /**
     *
     * @param plainText plain text
     * @return encrypted text
     */
    public String cifrar(String plainText) {
        return plainText != null && !plainText.isEmpty() ? getMotor().cifrar(plainText) : "";
    }

    /**
     *
     * @param encryptedText encrypted text
     * @return decrypted text
     */
    public String descifrar(String encryptedText) {
        return encryptedText != null && !encryptedText.isEmpty() ? getMotor().descifrar(encryptedText) : "";
    }

    private void setMotor(Motor motor) {
        this.motor = motor;
    }
}
