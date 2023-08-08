package Domain;

/**
 * Handling Encrypting the message
 */
public class VigenereEncryptorAlgorithm {
    private static final int ALPHABET_SIZE = 26;

    /**
     * Encrypts the plaintext using the Vigenere cipher with the given key.
     *
     * @param plaintext The plaintext message to be encrypted.
     * @param key       The encryption key.
     * @return The encrypted message.
     */
    public String encrypt(String plaintext, String key) {

        // Check if the encrypted text is empty, return an empty string
        if (plaintext == null || plaintext.isEmpty()){
            return "";
        }

        // Check the validity of the key
        if (key == null || key.isEmpty() || !containsOnlyLetters(key)) {
            throw new IllegalArgumentException("Invalid key. It must be a non-empty string containing only alphabetic characters.");
        }

        // Initialize StringBuilder to store the decrypted text
        StringBuilder encryptedText = new StringBuilder();

        // Convert the plaintext text and the key to uppercase for case-insensitive decryption
        plaintext = convertToUppercase(plaintext);
        key = convertToUppercase(key);

        // Use the vigenere cipher to encrypt
        for (int i = 0, j = 0; i < plaintext.length(); i++) {
            char currentChar = plaintext.charAt(i);

            if (Character.isLetter(currentChar)) {
                int shift = key.charAt(j % key.length()) - 'A';
                char encryptedChar = (char) ((currentChar - 'A' + shift) % ALPHABET_SIZE + 'A');
                encryptedText.append(encryptedChar);
                j++;
            } else {
                encryptedText.append(currentChar);
            }
        }

        return encryptedText.toString();
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
