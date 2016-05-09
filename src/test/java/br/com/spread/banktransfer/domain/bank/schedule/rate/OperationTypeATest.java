package br.com.spread.banktransfer.domain.bank.schedule.rate;

import br.com.spread.banktransfer.domain.bank.schedule.financial.ScheduledTransactions;
import java.math.BigDecimal;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Fernando Pinheiro
 */
public class OperationTypeATest {

    @Test
    public void valorDaTaxa_deveRetornarValorMaisPercentual() {
        
        ScheduledTransactions st = new ScheduledTransactions();
        st.setValue(new BigDecimal("1000"));
        
        OperationOfTransaction  operation =  new OperationTypeA();
        BigDecimal taxaCalculada = operation.calculateRate(st);
        
        // ($1000  X 3%) + $2
        assertEquals(taxaCalculada, new BigDecimal("32.00"));
    }
    
}
