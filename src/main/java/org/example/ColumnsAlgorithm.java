package org.example;

public class ColumnsAlgorithm {
    String input;
    String key;

    public ColumnsAlgorithm(String input, String key) {
        this.input = input;
        this.key = key;
    }

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String columnsAlgorithm(String input, String key) {
        Validation validation = new Validation();
        input = validation.validate(input);
        key = validation.validate(key);

        char[][] matrix = new char[input.length()/key.length() + 1][key.length()];

        return null;
    }

}
