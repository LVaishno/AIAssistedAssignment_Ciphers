package UseCase;

/**
 * The EncryptionStrategy interface represents a contract for encryption strategies.
 * Classes implementing this interface will provide specific encryption algorithms
 * to encrypt messages based on the chosen strategy.
 */
public interface EncryptionStrategy {
    /**
     * Encrypts the given plaintext using the specified encryption key.
     *
     * @param plaintext The plaintext message to be encrypted.
     * @param key       The encryption key.
     * @return The encrypted message.
     */
    String encrypt(String plaintext, String key);
}
