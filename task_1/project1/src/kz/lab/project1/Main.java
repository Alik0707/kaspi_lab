import kz.lab.project1.TransactionInterface;
import kz.lab.project1.TransactionMode;
import kz.lab.project1.TransactionService;

void main() {
    IO.println("Project1...");


    String cardNumber = "4111111111111111";
    long amount = 100;
    boolean success = true;


    // mode 1
    TransactionInterface mode1 = new TransactionService(TransactionMode.MODE1);
    
    String transactionId_mode1 = mode1.startTransaction(cardNumber, amount);
    IO.println("MODE1 TransactionId: " + transactionId_mode1);
    IO.println("MODE1 Result: " + mode1.completeTransaction(transactionId_mode1, success));

    // mode 2

    TransactionInterface mode2 = new TransactionService(TransactionMode.MODE2);
    String transactionId_mode2 = mode2.startTransaction(cardNumber, amount);
    IO.println("MODE2 TransactionId: " + transactionId_mode2);
    IO.println("MODE2 Result: " + mode2.completeTransaction(transactionId_mode2, success));
}
