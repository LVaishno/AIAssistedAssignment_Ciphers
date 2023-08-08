package UseCase;

import Domain.VigenereEncryptorAlgorithm;
import UseCase.EncryptionStrategy;

/**
 * The VigenereEncryptor class represents an encryption strategy using the Vigenere cipher.
 * It implements the EncryptionStrategy interface, providing a specific encryption algorithm.
 */
public class VigenereEncryptor implements EncryptionStrategy {
    private VigenereEncryptorAlgorithm vigenereEncryptorAlgorithm;
    public VigenereEncryptor(){
        this.vigenereEncryptorAlgorithm = new VigenereEncryptorAlgorithm();
    }

    /**
     * Encrypt the provided plain text message using the vigenere cipher
     * @param plaintext - The plaintext message
     * @param key - Encryption key
     * @return String
     */
    @Override
    public String encrypt(String plaintext, String key) {
        return vigenereEncryptorAlgorithm.encrypt(plaintext, key);
    }
}