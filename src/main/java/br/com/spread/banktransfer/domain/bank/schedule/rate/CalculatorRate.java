package br.com.spread.banktransfer.domain.bank.schedule.rate;

import br.com.spread.banktransfer.domain.bank.schedule.financial.ScheduledTransactions;
import java.math.BigDecimal;
import org.springframework.stereotype.Component;

/**
 * Calculadora de taxas das transações
 * @author Fernando Pinheiro
 */
@Component
public class CalculatorRate {
        
    public BigDecimal calculateByTransaction(ScheduledTransactions st){
        OperationOfTransaction operationOfTransaction = st.getOperationType().getOperationOfTransaction();
        return operationOfTransaction.calculateRate(st);
    }
}
