import kz.lab.project1.TransactionInterface;
import kz.lab.project1.TransactionService;

void main() {
    IO.println("Project1...");

    // Код по умолчанию работает в режиме MODE1
    TransactionInterface transactionInterface = new TransactionService();

    String cardNumber = "4111111111111111";
    long amount = 100;
    String transactionId = transactionInterface.startTransaction(cardNumber, amount);

    IO.println(String.format("TransactionId: %s", transactionId));

    boolean success = true;
    String result = transactionInterface.completeTransaction(transactionId, success);
    IO.println(String.format("Result: %s", result));
}
