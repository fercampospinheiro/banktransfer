package br.com.spread.banktransfer.domain.bankmovimentation;

import br.com.spread.banktransfer.domain.account.management.Account;
import br.com.spread.banktransfer.domain.account.management.AccountRespository;
import br.com.spread.banktransfer.domain.holder.management.Holder;
import br.com.spread.banktransfer.infrastructure.conf.JPAConfiguration;
import org.joda.time.LocalDate;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.springframework.test.context.ContextConfiguration;

/**
 * Teste de integração da conta bancária
 * @author Fernando Pinheiro
 */
@RunWith(JUnit4.class)
@ContextConfiguration(classes={JPAConfiguration.class})
public class AccountRespositoryIT {

    private AccountRespository repo;
    
    public AccountRespositoryIT() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void contaSalvaDeve_SerIgualContaRecuperada() {
        
        Account conta = new Account("00000-0", new Holder("Fernando", LocalDate.now()));
        repo = new AccountRespository();
        repo.save(conta);
        
        Integer idGerado = conta.getId();
        Account contaRecuperada = repo.getById(idGerado);
        assertEquals(conta, contaRecuperada);
    }
    
}
