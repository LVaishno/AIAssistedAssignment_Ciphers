package Domain;

/**
 * The VigenereDecryptorAlgorithm class handles the decryption of messages using the Vigenere cipher.
 * It provides a method to decrypt an encrypted message with a given decryption key.
 */
public class VigenereDecryptorAlgorithm {
    private static final int ALPHABET_SIZE = 26;

    /**
     * Decrypts the encrypted text using the Vigenere cipher with the given key.
     *
     * @param encryptedText The encrypted message to be decrypted.
     * @param key           The decryption key.
     * @return The decrypted message.
     */
    public String decrypt(String encryptedText, String key) {
        // Check if the encrypted text is empty, return an empty string
        if(encryptedText == null || encryptedText.isEmpty()){
            return "";
        }

        // Check the validity of the key
        if (key == null || key.isEmpty() || !containsOnlyLetters(key)) {
            throw new IllegalArgumentException("Invalid key. It must be a non-empty string containing only alphabetic characters.");
        }

        // Initialize StringBuilder to store the decrypted text
        StringBuilder decryptedText = new StringBuilder();

        // Convert the encrypted text and the key to uppercase for case-insensitive decryption
        encryptedText = convertToUppercase(encryptedText);
        key = convertToUppercase(key);

        // Perform decryption using the Vigenere cipher
        for (int i = 0, j = 0; i < encryptedText.length(); i++) {
            char currentChar = encryptedText.charAt(i);

            if (Character.isLetter(currentChar)) {
                int shift = key.charAt(j % key.length()) - 'A';
                char decryptedChar = (char) ((currentChar - 'A' - shift + ALPHABET_SIZE) % ALPHABET_SIZE + 'A');
                decryptedText.append(decryptedChar);
                j++;
            } else {
                decryptedText.append(currentChar);
            }
        }

        return decryptedText.toString();
    }

    /**
     * Convert the message to Uppercase
     * @param text
     * @return String
     */
    private String convertToUppercase(String text) {
        return text.toUpperCase();
    }

    /**
     * Check that the text only contains letters
     * @param text
     * @return boolean
     */
    private boolean containsOnlyLetters(String text) {
        return text.matches("[a-zA-Z]+");
    }
}
