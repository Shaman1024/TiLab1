package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Main extends JFrame {

    private JTextField keyTextField;
    private JTextArea inputTextArea;
    private JTextArea outputTextArea;
    private JButton encryptButton;
    private JButton decryptButton;
    private JButton loadInputButton;
    private JButton saveOutputButton;
    private JComboBox<String> cipherSelection;
    private JFileChooser fileChooser;

    private ColumnsAlgorithm columnarCipher = new ColumnsAlgorithm();
    private Vigenere vigenereCipher = new Vigenere();

    public Main() {
        setTitle("Cipher Tool");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700, 400);
        setLayout(new BorderLayout());

        JPanel cipherPanel = new JPanel(new FlowLayout());
        JLabel cipherLabel = new JLabel("Выберите шифр:");
        cipherSelection = new JComboBox<>(new String[]{"Столбцовый", "Виженер"});
        cipherPanel.add(cipherLabel);
        cipherPanel.add(cipherSelection);
        add(cipherPanel, BorderLayout.NORTH);

        JPanel keyPanel = new JPanel(new FlowLayout());
        JLabel keyLabel = new JLabel("Ключ:");
        keyTextField = new JTextField(20);
        keyPanel.add(keyLabel);
        keyPanel.add(keyTextField);
        add(keyPanel, BorderLayout.CENTER);


        JPanel inputPanel = new JPanel(new BorderLayout());
        JLabel inputLabel = new JLabel("Исходный текст:");
        inputTextArea = new JTextArea(15, 20);
        inputTextArea.setLineWrap(true);
        inputTextArea.setWrapStyleWord(true);
        JScrollPane inputScrollPane = new JScrollPane(inputTextArea);
        inputPanel.add(inputLabel, BorderLayout.NORTH);
        inputPanel.add(inputScrollPane, BorderLayout.CENTER);
        add(inputPanel, BorderLayout.WEST);

        JPanel outputPanel = new JPanel(new BorderLayout());
        JLabel outputLabel = new JLabel("Результат:");
        outputTextArea = new JTextArea(15, 20);
        outputTextArea.setLineWrap(true);
        outputTextArea.setWrapStyleWord(true);
        outputTextArea.setEditable(false);
        JScrollPane outputScrollPane = new JScrollPane(outputTextArea);
        outputPanel.add(outputLabel, BorderLayout.NORTH);
        outputPanel.add(outputScrollPane, BorderLayout.CENTER);
        add(outputPanel, BorderLayout.EAST);

        JPanel buttonPanel = new JPanel(new FlowLayout());
        encryptButton = new JButton("Шифровать");
        decryptButton = new JButton("Дешифровать");
        loadInputButton = new JButton("Загрузить из файла");
        saveOutputButton = new JButton("Сохранить в файл");

        buttonPanel.add(encryptButton);
        buttonPanel.add(decryptButton);
        buttonPanel.add(loadInputButton);
        buttonPanel.add(saveOutputButton);
        add(buttonPanel, BorderLayout.SOUTH);

        encryptButton.addActionListener(e -> {
            String key = keyTextField.getText();
            String inputText = inputTextArea.getText();
            String cipherType = (String) cipherSelection.getSelectedItem();
            String outputText = "";

            if ("Столбцовый".equals(cipherType)) {
                outputText = columnarCipher.columnsEncryption(inputText, key);
            } else if ("Виженер".equals(cipherType)) {
                outputText = vigenereCipher.vigenereCipherSelfKeyEncrypt(inputText, key);
            }

            outputTextArea.setText(outputText);
        });

        decryptButton.addActionListener(e -> {
            String key = keyTextField.getText();
            String inputText = inputTextArea.getText();
            String cipherType = (String) cipherSelection.getSelectedItem();
            String outputText = "";

            if ("Столбцовый".equals(cipherType)) {
                outputText = columnarCipher.columnsDecryption(inputText, key);
            } else if ("Виженер".equals(cipherType)) {
                outputText = vigenereCipher.vigenereCipherSelfKeyDecrypt(inputText, key);
            }

            outputTextArea.setText(outputText);
        });


        loadInputButton.addActionListener(e -> loadFile(inputTextArea));

        saveOutputButton.addActionListener(e -> saveFile(outputTextArea));

        fileChooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Текстовые файлы", "txt");
        fileChooser.setFileFilter(filter);
        fileChooser.setDialogTitle("Выберите файл");

        setVisible(true);
    }

    private void loadFile(JTextArea textArea) {
        int returnVal = fileChooser.showOpenDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                textArea.read(reader, null);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Ошибка чтения файла: " + ex.getMessage(), "Ошибка", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void saveFile(JTextArea textArea) {
        int returnVal = fileChooser.showSaveDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
                textArea.write(writer);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Ошибка записи в файл: " + ex.getMessage(), "Ошибка", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Main::new);
    }
}

