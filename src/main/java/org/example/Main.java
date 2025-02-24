package org.example;

public class Main {
    public static void main(String[] args) {
        ColumnsAlgorithm columnsAlgorithm = new ColumnsAlgorithm();
        Vigenere vigenere = new Vigenere();
        String key = "АААБВГЁде";
        String input = "АБВГДЕЁЖЗИ ЙКЛМН3254tОПРСТ УФХЦЧ ШЩ";
        System.out.println(key);
        String encryption = columnsAlgorithm.columnsEncryption(input, key);
        System.out.println(columnsAlgorithm.columnsDecryption(encryption , key) + "\n");
        vigenere.vigenereEncryption(input, key);


    }
}