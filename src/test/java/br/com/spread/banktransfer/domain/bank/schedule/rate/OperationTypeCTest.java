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
public class OperationTypeCTest {
    
    private OperationOfTransaction operacao ;
    private ScheduledTransactions agendamento;
    
    @Before
    public void setUp() {
        operacao =  new OperationTypeC();
        agendamento = new ScheduledTransactions();
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void para_5_DiasDoAgendamento_DeveGerarTaxaSobre_8_3() {
        
        DateTime dataAgendamento = DateTime.now();
        DateTime data5diasAntesDoAgedamento = DateTime.now().minusDays(5);

        agendamento.setDateOfRegistration(data5diasAntesDoAgedamento);
        agendamento.setDateScheduled(dataAgendamento);
        agendamento.setValue(new BigDecimal("1000"));
        
        BigDecimal taxaCalculada = operacao.calculateRate(agendamento);
        // 1000 X 0,083 = 83,000
        BigDecimal valorDaTaxaDe_8_3 = new BigDecimal("83.000");
        
        assertEquals(taxaCalculada, valorDaTaxaDe_8_3);
    
    }
    
    @Test
    public void para10DiasDoAgendamento_DeveGerarTaxaSobre_7_4() {
        
        DateTime dataAgendamento = DateTime.now();
        DateTime data10diasAntesDoAgedamento = DateTime.now().minusDays(10);

        agendamento.setDateOfRegistration(data10diasAntesDoAgedamento);
        agendamento.setDateScheduled(dataAgendamento);
        agendamento.setValue(new BigDecimal("1000"));
        
        BigDecimal taxaCalculada = operacao.calculateRate(agendamento);
        // 1000 X 0,074 = 74,000 
        BigDecimal valorDaTaxaDe_7_4 = new BigDecimal("74.000");
        
        assertEquals(taxaCalculada, valorDaTaxaDe_7_4);
    
    }
    
    @Test
    public void para15DiasDoAgendamento_DeveGerarTaxaSobre_6_7() {
        
        DateTime dataAgendamento = DateTime.now();
        DateTime data15diasAntesDoAgedamento = DateTime.now().minusDays(15);

        agendamento.setDateOfRegistration(data15diasAntesDoAgedamento);
        agendamento.setDateScheduled(dataAgendamento);
        agendamento.setValue(new BigDecimal("1000"));
        
        BigDecimal taxaCalculada = operacao.calculateRate(agendamento);
        // 1000 X 0,067 = 67,000 
        BigDecimal valorDaTaxaDe_6_7 = new BigDecimal("67.000");
        
        assertEquals(taxaCalculada, valorDaTaxaDe_6_7);
    
    }
    
    @Test
    public void para20DiasDoAgendamento_DeveGerarTaxaSobre_5_4() {
        
        DateTime dataAgendamento = DateTime.now();
        DateTime data20diasAntesDoAgedamento = DateTime.now().minusDays(20);

        agendamento.setDateOfRegistration(data20diasAntesDoAgedamento);
        agendamento.setDateScheduled(dataAgendamento);
        agendamento.setValue(new BigDecimal("1000"));
        
        BigDecimal taxaCalculada = operacao.calculateRate(agendamento);
        // 1000 X 0,054 = 54,000
        BigDecimal valorDaTaxaDe_5_4 = new BigDecimal("54.000");
        
        assertEquals(taxaCalculada, valorDaTaxaDe_5_4);
    
    }
    
    @Test
    public void para25DiasDoAgendamento_DeveGerarTaxaSobre_4_3() {
        
        DateTime dataAgendamento = DateTime.now();
        DateTime data25diasAntesDoAgedamento = DateTime.now().minusDays(25);

        agendamento.setDateOfRegistration(data25diasAntesDoAgedamento);
        agendamento.setDateScheduled(dataAgendamento);
        agendamento.setValue(new BigDecimal("1000"));
        
        BigDecimal taxaCalculada = operacao.calculateRate(agendamento);
        // 1000 X 0,053 = 53,000
        BigDecimal valorDaTaxaDe_4_3 = new BigDecimal("43.000");
        
        assertEquals(taxaCalculada, valorDaTaxaDe_4_3);
    
    }
    @Test
    public void para30DiasDoAgendamento_DeveGerarTaxaSobre_2_1() {
        
        DateTime dataAgendamento = DateTime.now();
        DateTime data30diasAntesDoAgedamento = DateTime.now().minusDays(30);

        agendamento.setDateOfRegistration(data30diasAntesDoAgedamento);
        agendamento.setDateScheduled(dataAgendamento);
        agendamento.setValue(new BigDecimal("1000"));
        
        BigDecimal taxaCalculada = operacao.calculateRate(agendamento);
        // 1000 X 0,021 = 
        BigDecimal valorDaTaxaDe_2_1 = new BigDecimal("21.000");
        
        assertEquals(taxaCalculada, valorDaTaxaDe_2_1);
    
    }
    @Test
    public void paraMais30DiasDoAgendamento_DeveGerarTaxaSobre_1_2() {
        
        DateTime dataAgendamento = DateTime.now();
        DateTime mais30diasAntesDoAgedamento = DateTime.now().minusDays(50);

        agendamento.setDateOfRegistration(mais30diasAntesDoAgedamento);
        agendamento.setDateScheduled(dataAgendamento);
        agendamento.setValue(new BigDecimal("1000"));
        
        BigDecimal taxaCalculada = operacao.calculateRate(agendamento);
        
        BigDecimal valorDaTaxaDe_1_2 = new BigDecimal("12.000");
        
        assertEquals(taxaCalculada, valorDaTaxaDe_1_2);
    
    }

}
