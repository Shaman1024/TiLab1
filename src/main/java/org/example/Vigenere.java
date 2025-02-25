package org.example;


public class Vigenere {

    public static final String RUSSIAN_ALPHABET = "АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ";
    private static final int ALPHABET_SIZE = RUSSIAN_ALPHABET.length();

    public String vigenereCipherSelfKeyEncrypt(String input, String key) {
        Validation validation = new Validation();
        key = validation.validate(key);
        input = validation.validate(input);

        StringBuilder ciphertext = new StringBuilder();
        StringBuilder extendedKey = new StringBuilder(key);

        for (int i = 0; i < input.length(); i++) {
            char plainChar = input.charAt(i);

            char keyChar;
            if (i < extendedKey.length()) {
                keyChar = extendedKey.charAt(i);
            } else {
                keyChar = ciphertext.charAt(i - extendedKey.length()); // Используем уже зашифрованный символ
            }


            int plainIndex = RUSSIAN_ALPHABET.indexOf(plainChar);
            int keyIndex = RUSSIAN_ALPHABET.indexOf(keyChar);

            if (plainIndex == -1 || keyIndex == -1) {
                // Обработка Ё, если вдруг alphabet не содержит
                if (plainChar == 'Ё') plainIndex = RUSSIAN_ALPHABET.indexOf('Ё');
                if (keyChar == 'Ё') keyIndex = RUSSIAN_ALPHABET.indexOf('Ё');
                if (plainIndex == -1 || keyIndex == -1) {
                    ciphertext.append(plainChar); // Если все равно не нашли, оставляем как есть
                    continue;
                }
            }


            int encryptedIndex = (plainIndex + keyIndex) % ALPHABET_SIZE;
            char encryptedChar = RUSSIAN_ALPHABET.charAt(encryptedIndex);
            ciphertext.append(encryptedChar);

            if (i >= extendedKey.length()) {
                extendedKey.append(encryptedChar); // Добавляем зашифрованный символ к ключу для следующих итераций
            }
        }
        return ciphertext.toString();
    }

    public String vigenereCipherSelfKeyDecrypt(String ciphertext, String key) {
        StringBuilder plaintext = new StringBuilder();
        StringBuilder extendedKey = new StringBuilder(key);

        for (int i = 0; i < ciphertext.length(); i++) {
            char cipherChar = ciphertext.charAt(i);

            if (RUSSIAN_ALPHABET.indexOf(cipherChar) == -1) {
                // Символ не из русского алфавита, оставляем как есть
                plaintext.append(cipherChar);
                continue;
            }

            char keyChar;
            if (i < extendedKey.length()) {
                keyChar = extendedKey.charAt(i);
            } else {
                keyChar = plaintext.charAt(i - extendedKey.length()); // Используем уже расшифрованный символ
            }

            int cipherIndex = RUSSIAN_ALPHABET.indexOf(cipherChar);
            int keyIndex = RUSSIAN_ALPHABET.indexOf(keyChar);

            if (cipherIndex == -1 || keyIndex == -1) {
                // Обработка Ё, если вдруг alphabet не содержит
                if (cipherChar == 'Ё') cipherIndex = RUSSIAN_ALPHABET.indexOf('Ё');
                if (keyChar == 'Ё') keyIndex = RUSSIAN_ALPHABET.indexOf('Ё');
                if (cipherIndex == -1 || keyIndex == -1) {
                    plaintext.append(cipherChar); // Если все равно не нашли, оставляем как есть
                    continue;
                }
            }

            int decryptedIndex = (cipherIndex - keyIndex + ALPHABET_SIZE) % ALPHABET_SIZE;
            char decryptedChar = RUSSIAN_ALPHABET.charAt(decryptedIndex);
            plaintext.append(decryptedChar);

            if (i >= extendedKey.length()) {
                extendedKey.append(decryptedChar); // Добавляем расшифрованный символ к ключу для следующих итераций
            }
        }
        return plaintext.toString();
    }

}