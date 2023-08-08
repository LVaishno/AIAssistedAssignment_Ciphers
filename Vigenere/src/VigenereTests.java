import Domain.VigenereEncryptorAlgorithm;
import Domain.VigenereDecryptorAlgorithm;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import org.junit.Test;

class VigenereTests {

    @Test
    void testEmptyStringEncryption() {
        String plaintext = "";
        String key = "KEY";

        VigenereEncryptorAlgorithm encryptor = new VigenereEncryptorAlgorithm();
        String encryptedText = encryptor.encrypt(plaintext, key);
        assertEquals("", encryptedText);
    }

    @Test
    void testEmptyStringDecryption() {
        String encryptedText = "";
        String key = "KEY";

        VigenereDecryptorAlgorithm decryptor = new VigenereDecryptorAlgorithm();
        String decryptedText = decryptor.decrypt(encryptedText, key);
        assertEquals("", decryptedText);
    }

    @Test
    void testNullStringEncryption() {
        String plaintext = null;
        String key = "KEY";

        VigenereEncryptorAlgorithm encryptor = new VigenereEncryptorAlgorithm();
        assertThrows(NullPointerException.class, () -> encryptor.encrypt(plaintext, key));
    }

    @Test
    void unsualCharacters() {
        String plaintext = "123##12";
        String key = "KEY";

        VigenereEncryptorAlgorithm encryptor = new VigenereEncryptorAlgorithm();
        VigenereDecryptorAlgorithm decryptorAlgorithm = new VigenereDecryptorAlgorithm();
        String encrypted = encryptor.encrypt(plaintext, key);
        assertEquals("123##12", encrypted);
        String decoded = decryptorAlgorithm.decrypt(encrypted, key);
        assertEquals("123##12", decoded);
    }
}
