package org.example;

public class Main {
    public static void main(String[] args) {
        ColumnsAlgorithm columnsAlgorithm = new ColumnsAlgorithm();
        Vigenere vigenere = new Vigenere();
        String key = "АААБВГЁде";
        String input = "АБВГДЕЁЖЗИЙ dgdfКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ";
        System.out.println(key);
        String encryption = columnsAlgorithm.columnsEncryption(input, key);
        System.out.println(columnsAlgorithm.columnsDecryption(encryption , key) + "\n");

        System.out.println("Исходный текст: " + input);
        System.out.println("Ключ: " + key);

        String ciphertext = vigenere.vigenereCipherSelfKeyEncrypt(input, key);
        System.out.println("Зашифрованный текст: " + ciphertext);

        String decryptedText = vigenere.vigenereCipherSelfKeyDecrypt(ciphertext, key);
        System.out.println("Расшифрованный текст: " + decryptedText);

    }
}