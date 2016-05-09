package br.com.spread.banktransfer.domain.bank.schedule.rate;

import br.com.spread.banktransfer.domain.bank.schedule.financial.ScheduledTransactions;
import java.math.BigDecimal;

/**
 * @author Fernando Pinheiro
 */
public class OperationTypeD implements OperationOfTransaction{

    @Override
    public BigDecimal calculateRate(ScheduledTransactions st) {
        BigDecimal twentyFiveThousand =  new BigDecimal("25000");
        BigDecimal oneHundredAndTwentyThousand =  new BigDecimal("120000");
        
        if(st.getValue().compareTo(twentyFiveThousand) < 0 || st.getValue().compareTo(twentyFiveThousand)  == 0 ){
            //Até 25.000
            return new OperationTypeA().calculateRate(st);
        }else if(st.getValue().compareTo(twentyFiveThousand) > 0 
                &&  (st.getValue().compareTo(oneHundredAndTwentyThousand) < 0 ||st.getValue().compareTo(oneHundredAndTwentyThousand) == 0) ){
            //entre 25.001 até 120.000
             return new OperationTypeB().calculateRate(st);
        }else{
            // acima de 120.000
            return new OperationTypeD().calculateRate(st);
        }
    }


}
