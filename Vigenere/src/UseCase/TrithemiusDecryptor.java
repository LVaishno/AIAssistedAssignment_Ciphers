package UseCase;

import Domain.TrithemiusDecryptionAlgo;
import UseCase.DecryptionStrategy;

/**
 * The TrithemiusDecryptor class represents a decryption strategy using the Trithemius cipher.
 * It implements the DecryptionStrategy interface, providing a specific decryption algorithm.
 */
public class TrithemiusDecryptor implements DecryptionStrategy {
    private TrithemiusDecryptionAlgo trithemiusDecryptionAlgo;

    /**
     * Constructs a TrithemiusDecryptor instance and initializes the TrithemiusDecryptionAlgo.
     */
    public TrithemiusDecryptor(){
        this.trithemiusDecryptionAlgo = new TrithemiusDecryptionAlgo();
    }

    /**
     * Decrypt the provided plain text message using the Trithemius cipher
     * @param encryptedText - The plaintext message
     * @param key - Encryption key
     * @return String
     */
    @Override
    public String decrypt(String encryptedText, String key) {
        return trithemiusDecryptionAlgo.decrypt(encryptedText, key);
    }
}