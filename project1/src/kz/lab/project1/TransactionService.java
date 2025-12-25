package kz.lab.project1;

public class TransactionService implements TransactionInterface {
    @Override
    public String startTransaction(String cardNumber, long amount) {
        return ApiService.getInstance().start(cardNumber, amount);
    }

    @Override
    public String completeTransaction(String transactionId, boolean success) {
        return ApiService.getInstance().completeMode1(transactionId, success);
    }
}
