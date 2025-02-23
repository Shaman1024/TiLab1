package org.example;

public class ColumnsAlgorithm {


    private char[][] sortMatrix(char[][] matrix, int rows, int columns) {
        char temp = ' ';
        for (int i = 0; i < columns; i++) {
            for (int j  = 0; i < columns - i - 1; i++) {
                if (matrix[0][j] > matrix[0][j + 1]) {
                    for (int k = 0; k < rows; k++) {
                        temp = matrix[k][j];
                        matrix[k][j] = matrix[k + 1][j];
                        matrix[k + 1][j] = temp;
                    }
                }
            }
        }

        return matrix;
    }

    public String columnsAlgorithm(String input, String key) {
        Validation validation = new Validation();
        input = validation.validate(input);
        key = validation.validate(key);
        int rows = input.length()/key.length() + 1;
        int columns = key.length();

        char[][] matrix = new char[rows][columns];
        int counter = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (counter >= input.length() - 1){
                    matrix[i][j] = ' ';
                    continue;
                }
                matrix[i][j] = input.charAt(counter);
                counter++;
            }
        }

        matrix = sortMatrix(matrix, rows, columns);

        StringBuilder sb = new StringBuilder();
        counter = 0;

        for (int i = 0; i < columns; i++) {
            for (int j = 0; j < rows; j++) {
                if (matrix[j][i] == ' '){
                    continue;
                }
                sb.append(matrix[j][i]);
                counter++;
                if (counter == 5) {
                    sb.append(' ');
                    counter = 0;
                }
            }
        }
        System.out.println(sb.toString());

        return sb.toString();
    }

}
