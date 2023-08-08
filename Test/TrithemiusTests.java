import Domain.TrithemiusEncryptionAlgo;
import Domain.TrithemiusDecryptionAlgo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import UseCase.TrithemiusEncryptor;
import org.junit.Test;

class TrithemiusTests {

    @Test
    void testEmptyStringEncryption() {
        String plaintext = "";
        String key = "KEY";

        TrithemiusEncryptionAlgo encryptor = new TrithemiusEncryptionAlgo();
        String encryptedText = encryptor.encrypt(plaintext, key);
        assertEquals("", encryptedText);
    }

    @Test
    void testEmptyStringDecryption() {
        String encryptedText = "";
        String key = "KEY";

        TrithemiusDecryptionAlgo decryptor = new TrithemiusDecryptionAlgo();
        String decryptedText = decryptor.decrypt(encryptedText, key);
        assertEquals("", decryptedText);
    }

    @Test
    void testNullStringEncryption() {
        String plaintext = null;
        String key = "KEY";

        TrithemiusEncryptionAlgo encryptor = new TrithemiusEncryptionAlgo();
        assertThrows(NullPointerException.class, () -> encryptor.encrypt(plaintext, key));
    }

    @Test
    void unsualCharacters() {
        String plaintext = "123##12";
        String key = "KEY";

        TrithemiusEncryptionAlgo encryptor = new TrithemiusEncryptionAlgo();
        TrithemiusDecryptionAlgo decryptorAlgorithm = new TrithemiusDecryptionAlgo();
        String encrypted = encryptor.encrypt(plaintext, key);
        assertEquals("123##12", encrypted);
        String decoded = decryptorAlgorithm.decrypt(encrypted, key);
        assertEquals("123##12", decoded);
    }
}