package org.example;

public class ColumnsAlgorithm {

    public void outputMatrix(char[][] matrix, int rows, int columns){
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    private String readMatrix(char[][] matrix, String key) {
        StringBuilder keySb = new StringBuilder();
        StringBuilder newLineSb = new StringBuilder();
        keySb.append(key);
        char min = 'Я' + 1;
        int index = -1;
        int maxCounter = keySb.length();
        int counter = 0;
        for (int i = 0; i < maxCounter; i++) {

            min = 'а';
            for (counter = 0; counter < keySb.length(); counter++) {
                if (keySb.charAt(counter) < min) {
                    index = counter;
                    min = keySb.charAt(counter);
                }
            }
            keySb.setCharAt(index, ('б'));

            for (int j = 0; j < matrix.length; j++) {
                if (matrix[j][index] != ' ') {
                    newLineSb.append(matrix[j][index]);
                }
            }

        }

        return newLineSb.toString();
    }

    public String columnsEncryption(String input, String key) {
        Validation validation = new Validation();
        input = validation.validate(input);
        key = validation.validate(key);

        if (input == null || key == null) {
            return "Invalid input or key!";
        }

        int rows = 0;

        if (input.length() % key.length() == 0) {
            rows = input.length()/key.length();
        } else {
            rows = input.length()/key.length() + 1;
        }

        int columns = key.length();

        char[][] matrix = new char[rows][columns];
        int counter = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (counter >= input.length()){
                    matrix[i][j] = 'Ъ';
                    continue;
                }
                matrix[i][j] = input.charAt(counter);
                counter++;
            }
        }

        outputMatrix(matrix, rows, columns);
        String line = readMatrix(matrix, key);
        System.out.println(line);

        return readMatrix(matrix, key);
    }

    public String columnsDecryption(String input, String key) {
        Validation validation = new Validation();
        input = validation.validate(input);
        key = validation.validate(key);

        if (input == null || key == null) {
            return "Invalid input or key!";
        }

        int rows = 0;
        if (input.length() % key.length() != 0) {
            rows = input.length()/key.length() + 1;
        } else {
            rows = input.length()/key.length();
        }
        int columns = key.length();

        char[][] matrix = new char[rows][columns];

        StringBuilder keySb = new StringBuilder();
        StringBuilder inputSb = new StringBuilder();
        StringBuilder newLineSb = new StringBuilder();
        keySb.append(key);
        inputSb.append(input);

        if (input.length() < key.length()) {
            keySb.delete(input.length(), key.length());
        }

        for (int i = 0; i < inputSb.length() % keySb.length(); i++) {
            inputSb.append('Ъ');
        }

        char min = 'Я' + 1;
        int index = -1;
        int maxCounter = keySb.length();
        int counter = 0;
        int lastRowCounter = input.length() % key.length();

        for (int i = 0; i < maxCounter; i++) {
            min = 'а';

            for (counter = 0; counter < keySb.length(); counter++) {
                if (keySb.charAt(counter) < min) {
                    index = counter;
                    min = keySb.charAt(counter);
                }
            }

            keySb.setCharAt(index, ('б'));

            for (int j = 0; j < rows; j++) {
                matrix[j][index] = inputSb.charAt(i * rows + j);
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (matrix[i][j] != ' ') {
                    newLineSb.append(matrix[i][j]);
                }
            }
        }

        return newLineSb.toString();
    }

    // найти наименьший элемент ключа
    // запомнить индекс элемента, взять с шифротекста длина_столбца символов начиная с индекс*длина_стобца
    // записать их в столбец матрицы
    // повторить
    // прочитать матрицу построчно

}