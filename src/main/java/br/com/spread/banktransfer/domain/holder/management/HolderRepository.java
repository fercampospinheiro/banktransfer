package br.com.spread.banktransfer.domain.holder.management;

import br.com.spread.banktransfer.infrastructure.dao.AbstractDao;
import java.io.Serializable;
import org.springframework.stereotype.Repository;

/**
 * Repositório de titulares das contas bancárias
 * @author Fernando Pinheiro
 */
@Repository
public class HolderRepository extends AbstractDao<Holder, Serializable>{

    @Override
    public Class<Holder> getPojo() {
        return Holder.class;
    }
    
}
