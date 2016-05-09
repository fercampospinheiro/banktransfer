package br.com.spread.banktransfer.domain.bank.schedule.rate;

import br.com.spread.banktransfer.domain.bank.schedule.financial.ScheduledTransactions;
import java.math.BigDecimal;

/**
 * 
 * @author Fernando Pinheiro
 */
public interface Rate {
    BigDecimal caculate(ScheduledTransactions scheduledTransactions);
    void nextRate(Rate nextRate);
}
