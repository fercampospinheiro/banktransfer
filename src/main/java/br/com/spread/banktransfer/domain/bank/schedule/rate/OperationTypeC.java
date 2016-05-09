package br.com.spread.banktransfer.domain.bank.schedule.rate;

import br.com.spread.banktransfer.domain.bank.schedule.financial.ScheduledTransactions;
import java.math.BigDecimal;
import org.joda.time.Days;

/**
 * @author Fernando Pinheiro
 */
public class OperationTypeC implements  OperationOfTransaction{

    @Override
    public BigDecimal calculateRate(ScheduledTransactions st) {
        
        Days days = Days.daysBetween(st.getDateOfRegistration(), st.getDateScheduled());
        Days thirty = Days.days(30);
        Days twentyFive = Days.days(25);
        Days twenty = Days.days(20);
        Days fifteen = Days.days(15);
        Days ten = Days.days(10);
        Days five = Days.FIVE;
        Days zero = Days.ZERO;
        

        if(days.isGreaterThan(thirty)){
            // maior que 30
            return st.getValue().multiply(new BigDecimal("0.012"));
        }else if(days.isGreaterThan(twentyFive) && (days.isLessThan(thirty) || days.equals(thirty) ) ){
            // ate 30
            return st.getValue().multiply(new BigDecimal("0.021"));
        }else if( days.isGreaterThan(twenty) && (days.isLessThan(twentyFive) ||days.equals(twentyFive)) ){
            //ate 25
            return st.getValue().multiply(new BigDecimal("0.043"));
        }else if(days.isGreaterThan(fifteen) && (days.isLessThan(twenty) ||days.equals(twenty)) ){
            //ate 20
            return st.getValue().multiply(new BigDecimal("0.054"));
        }else if(days.isGreaterThan(ten) && (days.isLessThan(fifteen) ||days.equals(fifteen)) ){
            //ate 15
            return st.getValue().multiply(new BigDecimal("0.067"));
        }else if(days.isGreaterThan(five) && (days.isLessThan(ten) ||days.equals(ten)) ){
            //ate 10
            return st.getValue().multiply(new BigDecimal("0.074"));
        }else if(days.isGreaterThan(zero) && (days.isLessThan(five) || days.equals(five)) ){
            //ate 5
            return st.getValue().multiply(new BigDecimal("0.083"));
        }else{
            return BigDecimal.ZERO;
        }
        
        
    }


}
