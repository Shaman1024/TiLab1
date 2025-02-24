package org.example;


public class Vigenere {



    public void vigenereEncryption(String input, String key) {
        Validation validation = new Validation();
        StringBuilder inputSb = new StringBuilder();
        StringBuilder keySb = new StringBuilder();
        StringBuilder newLineSb = new StringBuilder();

        inputSb.append(validation.validate(input));
        keySb.append(validation.validate(key));

        int counter = 0;

        if (key.length() < input.length()) {
            while (keySb.length() != inputSb.length()) {
                keySb.append(inputSb.charAt(counter));
                counter++;
            }
        } else if (key.length() > input.length()) {
            keySb.delete(input.length(), key.length());
        }
        for (int i = 0; i < inputSb.length(); i++) {
            newLineSb.append((char) (inputSb.charAt(i) * 2 - keySb.charAt(i)));
        }
        System.out.println(newLineSb.toString());
    }

}
