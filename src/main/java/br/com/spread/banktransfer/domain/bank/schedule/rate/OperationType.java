package br.com.spread.banktransfer.domain.bank.schedule.rate;

/**
 * @author Fernando Pinheiro
 */
public enum OperationType {
    A(new OperationTypeA()),
    B(new OperationTypeB()),
    C(new OperationTypeC()),
    D(new OperationTypeD());
    
    private OperationOfTransaction operationOfTransaction;

    private OperationType(OperationOfTransaction operationOfTransaction) {
        this.operationOfTransaction = operationOfTransaction;
    }

    public OperationOfTransaction getOperationOfTransaction() {
        return operationOfTransaction;
    }
    
}
