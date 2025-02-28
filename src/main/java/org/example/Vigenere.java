package org.example;

public class Vigenere {

    public static final String RUSSIAN_ALPHABET = "АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ";
    private static final int ALPHABET_SIZE = RUSSIAN_ALPHABET.length();

    public String vigenereCipherSelfKeyEncrypt(String input, String key) {

        Validation validation = new Validation();
        input = validation.validate(input);
        key = validation.validate(key);

        if (input == null || key == null) {
            return "Invalid input or key!";
        }

        StringBuilder ciphertext = new StringBuilder();
        StringBuilder extendedKey = new StringBuilder(key);
        StringBuilder inputSb = new StringBuilder(input);

        for (int i = 0; i < input.length(); i++) {
            char plainChar = input.charAt(i);

            char keyChar;

            if (i < extendedKey.length()) {
                keyChar = extendedKey.charAt(i);
            } else {
                keyChar = inputSb.charAt(i - key.length());
            }

            int plainIndex = RUSSIAN_ALPHABET.indexOf(plainChar);
            int keyIndex = RUSSIAN_ALPHABET.indexOf(keyChar);

            int encryptedIndex = (plainIndex + keyIndex) % ALPHABET_SIZE;
            char encryptedChar = RUSSIAN_ALPHABET.charAt(encryptedIndex);
            ciphertext.append(encryptedChar);

            if (i >= extendedKey.length()) {
                extendedKey.append(inputSb.charAt(i - key.length()));

            }
        }
        return ciphertext.toString();
    }

    public String vigenereCipherSelfKeyDecrypt(String input, String key) {
        Validation validation = new Validation();
        input = validation.validate(input);
        key = validation.validate(key);

        if (input == null || key == null) {
            return "Invalid input or key!";
        }

        StringBuilder plaintext = new StringBuilder();
        StringBuilder extendedKey = new StringBuilder(key);
        StringBuilder inputSb = new StringBuilder(input);

        for (int i = 0; i < input.length(); i++) {
            char cipherChar = input.charAt(i);

            char keyChar;

            if (i < extendedKey.length()) {
                keyChar = extendedKey.charAt(i);
            } else {
                keyChar = plaintext.charAt(i - key.length());
            }

            int cipherIndex = RUSSIAN_ALPHABET.indexOf(cipherChar);
            int keyIndex = RUSSIAN_ALPHABET.indexOf(keyChar);

            if (cipherIndex == -1 || keyIndex == -1) {
                continue;
            }

            int decryptedIndex = (cipherIndex - keyIndex + ALPHABET_SIZE) % ALPHABET_SIZE;
            char decryptedChar = RUSSIAN_ALPHABET.charAt(decryptedIndex);
            plaintext.append(decryptedChar);

            if (i >= extendedKey.length()) {
                extendedKey.append(inputSb.charAt(i - key.length()));

            }
        }
        return plaintext.toString();
    }

}