package UseCase;

/**
 * The DecryptionStrategy interface represents a contract for decryption strategies.
 * Classes implementing this interface will provide specific decryption algorithms
 * to decrypt messages based on the chosen strategy.
 */
public interface DecryptionStrategy {
    /**
     * Decrypts the given plaintext using the specified decryption key.
     *
     * @param plaintext The plaintext message to be decrypted.
     * @param key       The decryption key.
     * @return The decrypted message.
     */
    String decrypt(String plaintext, String key);
}
