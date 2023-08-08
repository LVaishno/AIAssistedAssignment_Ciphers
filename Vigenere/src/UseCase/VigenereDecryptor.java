package UseCase;

import Domain.VigenereDecryptorAlgorithm;
import UseCase.DecryptionStrategy;


/**
 * The VigenereDecryptor class represents a decryption strategy using the Vigenere cipher.
 * It implements the DecryptionStrategy interface, providing a specific decryption algorithm.
 */
public class VigenereDecryptor implements DecryptionStrategy {
    private VigenereDecryptorAlgorithm vigenereDecryptorAlgorithm;
    public VigenereDecryptor(){
        this.vigenereDecryptorAlgorithm = new VigenereDecryptorAlgorithm();
    }

    /**
     * Decrypt the provided plain text message using the vigenere cipher
     * @param encryptedText - The plaintext message
     * @param key - Encryption key
     * @return String
     */
    @Override
    public String decrypt(String encryptedText, String key) {
        return vigenereDecryptorAlgorithm.decrypt(encryptedText, key);
    }
}