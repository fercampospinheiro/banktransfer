package br.com.spread.banktransfer.domain.bank.schedule.rate;

import br.com.spread.banktransfer.domain.bank.schedule.financial.ScheduledTransactions;
import java.math.BigDecimal;

/**
 * @author Fernando Pinheiro
 */
public class OperationTypeA implements  OperationOfTransaction{

    @Override
    public BigDecimal calculateRate(ScheduledTransactions transactions) {
        return transactions.getValue().multiply(new BigDecimal("0.03")).add(new BigDecimal("2.0"));
    }

}
