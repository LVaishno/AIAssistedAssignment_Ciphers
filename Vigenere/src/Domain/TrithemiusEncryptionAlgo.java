// TrithemiusEncryptor.java
package Domain;

/**
 * The TrithemiusEncryptionAlgo class provides an implementation of the Trithemius encryption algorithm.
 * The Trithemius cipher is a simple polyalphabetic substitution cipher that shifts each character in the
 * plaintext forward by a certain key value to generate the encrypted text. This class allows encrypting
 * a message using the Trithemius encryption algorithm.
 */
public class TrithemiusEncryptionAlgo {
    // Implementation of Trithemius encryption algorithm
    private static final int ALPHABET_SIZE = 26;

    /**
     * Encrypt the message using the Trithemius Algorithm
     * @param plaintext - The message to be encrypted
     * @param key - Key used for encryption
     * @return String
     */
    public String encrypt(String plaintext, String key) {
        StringBuilder ciphertext = new StringBuilder();

        // Parse the key as an integer
        int usableKey = Integer.parseInt(key);

        for (char c : plaintext.toCharArray()) {
            if (Character.isLetter(c)) {
                // Encrypt individual character
                char encryptedChar = encryptChar(c, usableKey);
                ciphertext.append(encryptedChar);
            } else {
                // Non-alphabetic characters remain unchanged
                ciphertext.append(c);
            }
        }

        return ciphertext.toString();
    }

    private static char encryptChar(char c, int key) {
        if (Character.isUpperCase(c)) {
            // Encrypt uppercase character
            return (char) ((c - 'A' + key) % ALPHABET_SIZE + 'A');
        } else if (Character.isLowerCase(c)) {
            // Encrypt lowercase character
            return (char) ((c - 'a' + key) % ALPHABET_SIZE + 'a');
        } else {
            return c; // Non-alphabetic characters remain unchanged
        }
    }
}
