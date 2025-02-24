package org.example;

public class Main {
    public static void main(String[] args) {
        ColumnsAlgorithm columnsAlgorithm = new ColumnsAlgorithm();
        String key = "АБАААААд";
        String input = "АБВГД ЕЁЖЗИ ЙКЛМН ОПРСТ УФХЦЧ ШЩ";
        String encryption = columnsAlgorithm.columnsEncryption(input, key);
        System.out.println(columnsAlgorithm.columnsDecryption(encryption , key));

    }
}