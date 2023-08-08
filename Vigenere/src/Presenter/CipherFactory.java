package Presenter;

import UseCase.*;

/**
 * The CipherFactory class is a factory for creating encryption and decryption strategies
 * based on the specified algorithm.
 */
public class CipherFactory {
    /**
     * Creates an encryption strategy based on the specified algorithm.
     *
     * @param algorithm The encryption algorithm code. Supported codes:
     *                  "V" - Vigenere Cipher
     *                  "T" - Trithemius Cipher
     * @return An instance of the EncryptionStrategy corresponding to the specified algorithm.
     * @throws IllegalArgumentException If the specified algorithm code is not supported.
     */
    public EncryptionStrategy createEncryptionStrategy(String algorithm) {
        switch (algorithm) {
            case "V":
                return new VigenereEncryptor();
            case "T":
                return new TrithemiusEncryptor();
            default:
                throw new IllegalArgumentException("Unsupported encryption algorithm: " + algorithm);
        }
    }

    /**
     * Creates a decryption strategy based on the specified algorithm.
     *
     * @param algorithm The decryption algorithm code. Supported codes:
     *                  "V" - Vigenere Cipher
     *                  "T" - Trithemius Cipher
     * @return An instance of the DecryptionStrategy corresponding to the specified algorithm.
     * @throws IllegalArgumentException If the specified algorithm code is not supported.
     */
    public DecryptionStrategy createDecryptionStrategy(String algorithm) {
        switch (algorithm) {
            case "V":
                return new VigenereDecryptor();
            case "T":
                return new TrithemiusDecryptor();
            default:
                throw new IllegalArgumentException("Unsupported decryption algorithm: " + algorithm);
        }
    }
}
