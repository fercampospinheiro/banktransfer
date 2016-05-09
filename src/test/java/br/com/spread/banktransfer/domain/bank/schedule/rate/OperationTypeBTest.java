package br.com.spread.banktransfer.domain.bank.schedule.rate;

import br.com.spread.banktransfer.domain.bank.schedule.financial.ScheduledTransactions;
import java.math.BigDecimal;
import org.joda.time.DateTime;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author fernando
 */
public class OperationTypeBTest {
    
    private OperationOfTransaction operacao ;
    private ScheduledTransactions agendamento;
    
    public OperationTypeBTest() {
    }
    
    @Before
    public void setUp() {
        operacao =  new OperationTypeB();
        agendamento = new ScheduledTransactions();
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void paraAte30DiasDoAgendamento_DeveGerar10DolaresDeTaxa() {
        
        DateTime dataDeTrintaDiasAtras = DateTime.now().minusDays(30);

        agendamento.setDateOfRegistration(dataDeTrintaDiasAtras);
        agendamento.setDateScheduled(DateTime.now());
        
        BigDecimal taxaCalculada = operacao.calculateRate(agendamento);
        
        assertEquals(taxaCalculada, new BigDecimal("10.00"));
    
    }
    
    @Test
    public void paraMais30DiasDoAgendamento_DeveGerar8DolaresDeTaxa() {
        
        DateTime maisdeTrintaDias = DateTime.now().minusDays(50);

        agendamento.setDateOfRegistration(maisdeTrintaDias);
        agendamento.setDateScheduled(DateTime.now());
        
        BigDecimal taxaCalculada = operacao.calculateRate(agendamento);
        
        assertEquals(taxaCalculada, new BigDecimal("8.00"));
    
    }

}
