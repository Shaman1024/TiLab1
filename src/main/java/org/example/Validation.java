package org.example;

public class Validation {
    public Validation() {}

    public static final String RUSSIAN_ALPHABET = "АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ";

    public String validate(String input) {
        StringBuilder sb = new StringBuilder();
        input = input.toUpperCase();
        for (int i = 0; i < input.length(); i++) {
            if (RUSSIAN_ALPHABET.indexOf(input.charAt(i)) != -1) {
                sb.append(input.charAt(i));
            }
        }

        if (sb.toString().length() == 0) {
            return null;
        }

        //не забыть добавить обработку полностью невалидного ключа

        return sb.toString().toUpperCase();
    }
}