package br.com.spread.banktransfer.domain.bank.management;


import br.com.spread.banktransfer.infrastructure.dao.AbstractDao;
import java.io.Serializable;
import org.springframework.stereotype.Repository;

/**
 * Repositório de bancos
 * @author Fernando
 */
@Repository
public class BankRepository extends AbstractDao<Bank, Serializable> {

    @Override
    public Class<Bank> getPojo() {
        return Bank.class;
    }
    
}
