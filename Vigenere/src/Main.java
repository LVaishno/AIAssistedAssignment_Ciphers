import Presenter.CipherPresenter;

import java.util.Objects;
import java.util.Scanner;

/**
 * The Main class is responsible for user input and output operations.
 * It interacts with the Presenter to perform
 * encryption and decryption of messages.
 */
public class Main {
    public static void main(String[] args) {
        //Initialize the Encrypted and Decrypted variables
        String encryptedText;
        String decryptedText;

        Scanner scanner = new Scanner(System.in);

        // Select whether to encode or decode the message
        System.out.println("Encode (E) or Decode (D): ");
        String action =  scanner.nextLine();

        System.out.print("Enter the text: ");
        String plaintext = scanner.nextLine();

        // User can select what algorithm to use
        System.out.println("Enter Algorithm type (Vigenere = V) (Trithemius = T): ");
        String algorithm = scanner.nextLine();

        // Let the user know what kind of input is expected
        if(Objects.equals(algorithm, "T")){
            System.out.print("Enter the key (must be a number): ");
        }
        else{
            System.out.print("Enter the key (must contain only alphabets): ");
        }
        String key = scanner.nextLine();

        CipherPresenter cipherPresenter = new CipherPresenter(algorithm, action);

        String displayMessage = cipherPresenter.displayMessage(plaintext, key);

        System.out.println("The message is: " + displayMessage);

        scanner.close();
    }
}