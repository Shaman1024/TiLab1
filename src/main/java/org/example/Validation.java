package org.example;

import static org.example.Vigenere.RUSSIAN_ALPHABET;

public class Validation {
    public Validation() {
    }

    public String validate(String input) {
        StringBuilder sb = new StringBuilder();

        char plainChar = input.charAt(i);

        if (RUSSIAN_ALPHABET.indexOf(plainChar) == -1) {
            // Символ не из русского алфавита, оставляем как есть
            ciphertext.append(plainChar);
            continue;
        }
        // не забыть изменить валидацию при отсутствии валидных элементов
        return sb.toString().toUpperCase();
    }
}