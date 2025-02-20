package org.example;

public class Validation {
    public Validation() {
    }

    public String validate(String input) {
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i < input.length(); i++) {
            if ((input.charAt(i) >= 'А' && input.charAt(i) <= 'Я') || (input.charAt(i) >= 'а' && input.charAt(i) <= 'я')) {
                sb.append(input.charAt(i));
            }
        }
        return sb.toString().toUpperCase();
    }
}
