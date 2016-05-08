package br.com.spread.banktransfer.domain.account.management;

import br.com.spread.banktransfer.domain.account.management.Account;
import br.com.spread.banktransfer.infrastructure.dao.AbstractDao;
import java.io.Serializable;
import org.springframework.stereotype.Repository;

/**
 * Repositório de contas bancárias
 * @author Fernando Pinheiro
 */
@Repository
public class AccountRespository extends AbstractDao<Account, Serializable>{

    @Override
    public Class<Account> getPojo() {
        return Account.class;
    }

    
     
}
