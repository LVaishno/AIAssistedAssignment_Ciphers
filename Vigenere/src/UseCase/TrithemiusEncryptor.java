package UseCase;

import Domain.TrithemiusDecryptionAlgo;
import Domain.TrithemiusEncryptionAlgo;
import UseCase.EncryptionStrategy;

/**
 * The TrithemiusEncryptor class represents an encryption strategy using the Trithemius cipher.
 * It implements the EncryptionStrategy interface, providing a specific encryption algorithm.
 */
public class TrithemiusEncryptor implements EncryptionStrategy {
    private TrithemiusEncryptionAlgo trithemiusEncryptionAlgo;
    public TrithemiusEncryptor(){
        this.trithemiusEncryptionAlgo = new TrithemiusEncryptionAlgo();
    }

    /**
     * Encrypt the provided plain text message using the trithemius cipher
     * @param plaintext - The plaintext message
     * @param key - Encryption key
     * @return String
     */
    @Override
    public String encrypt(String plaintext, String key) {
        return trithemiusEncryptionAlgo.encrypt(plaintext, key);
    }
}