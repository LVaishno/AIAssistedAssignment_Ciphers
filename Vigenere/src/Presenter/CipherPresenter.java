package Presenter;

import UseCase.DecryptionStrategy;
import UseCase.EncryptionStrategy;

import java.util.Objects;

/**
 * The CipherPresenter is responsible for formatting and presenting the
 * encrypted and decrypted messages to the user interface. It interacts with
 * the UseCase layer to perform encryption and decryption operations.
 */
public class CipherPresenter {
    private EncryptionStrategy encryptor;
    private DecryptionStrategy decryptor;
    private CipherFactory cipherFactory;

    private String action;

    /**
     * Initializes the CipherPresenter with a new CipherUsecase instance.
     */
    public CipherPresenter(String algorithm, String action) {
        this.action = action;
        this.cipherFactory = new CipherFactory();
        this.encryptor = cipherFactory.createEncryptionStrategy(algorithm);
        this.decryptor = cipherFactory.createDecryptionStrategy(algorithm);
    }

    /**
     * Display the message depending on whether encryption or decryption was selected
     * @param message Message to be ecrypted or decrypted
     * @param key Key used for encryption
     * @return The message to be displayed
     */
    public String displayMessage(String message, String key){
        if(Objects.equals(action, "E")){
            return presentEncryptedMessage(message, key);
        }
        else {
            return presentDecryptedMessage(message, key);
        }
    }

    /**
     * Encrypts the plaintext message using the selected cipher with the given key,
     * and presents the encrypted message to the user interface.
     *
     * @param plaintext The plaintext message to be encrypted.
     * @param key       The encryption key.
     */
    private String presentEncryptedMessage(String plaintext, String key) {
        String encryptedText = encryptor.encrypt(plaintext, key);
        return encryptedText;
    }

    /**
     * Decrypts the encrypted message using the selected cipher with the given key,
     * and presents the decrypted message to the user interface.
     *
     * @param encryptedText The encrypted message to be decrypted.
     * @param key           The decryption key.
     */
    private String presentDecryptedMessage(String encryptedText, String key) {
        String decryptedText = decryptor.decrypt(encryptedText, key);
        return decryptedText;
    }
}
