package br.com.spread.banktransfer.domain.bank.schedule.rate;

import br.com.spread.banktransfer.domain.bank.schedule.financial.ScheduledTransactions;
import java.math.BigDecimal;
import org.joda.time.Days;

/**
 * @author Fernando Pinheiro
 */
public class OperationTypeB implements  OperationOfTransaction{

    @Override
    public BigDecimal calculateRate(ScheduledTransactions st) {
        
        Days days = Days.daysBetween(st.getDateOfRegistration(), st.getDateScheduled());
        
        if(days.isGreaterThan(Days.days(30))){
            return new BigDecimal("8.00");
        }else{
             return new BigDecimal("10.00");
        }
        
    }
 
}
