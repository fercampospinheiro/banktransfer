package br.com.spread.banktransfer.domain.bank.schedule.financial;

import br.com.spread.banktransfer.domain.account.transfer.StatusProcessingTransfer;
import br.com.spread.banktransfer.infrastructure.dao.AbstractDao;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;

/**
 * Repositório de movimentacoes agendadas
 * @author Fernando Pinheiro
 */
@Repository
public class ScheduledTransactionsRepository extends AbstractDao<ScheduledTransactions, Serializable>{

    @Override
    public Class<ScheduledTransactions> getPojo() {
        return ScheduledTransactions.class;
    }
    /**
     * Obtem as movimentações agendadas ainda não processadas
     * @return List<ScheduledTransactions>
     */
    public List<ScheduledTransactions> allNotProccessing(){
        String hql = "select sc from ScheduledTransactions as sc where sc.statusProcessing = :status "; 
        Query query = super.getEntityManager().createQuery(hql);
        query.setParameter("statusProcessing", StatusProcessingTransfer.WAINTING);
        return query.getResultList();
    }

}
