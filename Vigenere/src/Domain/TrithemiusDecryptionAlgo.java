// TrithemiusDecryptor.java
package Domain;

/**
 * The TrithemiusDecryptionAlgo class provides an implementation of the Trithemius decryption algorithm.
 * The Trithemius cipher is a simple polyalphabetic substitution cipher that shifts each character in the
 * plaintext backward by a certain key value to generate the encrypted text. This class allows decrypting
 * the encrypted text back to the original plaintext using the same key.
 */
public class TrithemiusDecryptionAlgo{
    // Implementation of Trithemius decryption algorithm
    private static final int ALPHABET_SIZE = 26;

    /**
     * Decrypt the encoded message
     * @param encryptedText - The encrypted text
     * @param key - Key used for encryption
     * @return
     */
    public String decrypt(String encryptedText, String key) {
        StringBuilder plaintext = new StringBuilder();

        // Parse the key as an integer
        int usableKey = Integer.parseInt(key);

        for (char c : encryptedText.toCharArray()) {
            if (Character.isLetter(c)) {
                // Decrypt individual character
                char decryptedChar = decryptChar(c, usableKey);
                plaintext.append(decryptedChar);
            } else {
                // Non-alphabetic characters remain unchanged
                plaintext.append(c);
            }
        }

        return plaintext.toString();
    }

    private static char decryptChar(char c, int key) {
        if (Character.isUpperCase(c)) {
            // Decrypt uppercase character
            return (char) ((c - 'A' - key + ALPHABET_SIZE) % ALPHABET_SIZE + 'A');
        } else if (Character.isLowerCase(c)) {
            // Decrypt lowercase character
            return (char) ((c - 'a' - key + ALPHABET_SIZE) % ALPHABET_SIZE + 'a');
        } else {
            return c; // Non-alphabetic characters remain unchanged
        }
    }
}