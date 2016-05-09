package br.com.spread.banktransfer.domain.bank.transfer;

import br.com.spread.banktransfer.domain.account.management.AccountRespository;
import br.com.spread.banktransfer.domain.account.management.Account;
import br.com.spread.banktransfer.domain.bank.schedule.financial.ScheduledTransactions;
import br.com.spread.banktransfer.domain.bank.schedule.financial.ScheduledTransactionsRepository;
import br.com.spread.banktransfer.domain.bank.schedule.rate.CalculatorRate;
import java.math.BigDecimal;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Serviço de transferência bancaria
 * @author Fernando
 */
@Service
public class ServiceTransferBank {
    
    @Autowired
    private ScheduledTransactionsRepository transactionsRepository;
    @Autowired
    private AccountRespository accountRespository;
    @Autowired
    private CalculatorRate calculatorRate;
    
    private static Integer intervalExecuteInMinutes = 0;
    
    
    /**
     * Oserviço sera executado no intervalo informado em minutos
     * @param interval
     * @return ServiceTransferBank 
     */
    public ServiceTransferBank  intervalExecute(Integer interval){
        intervalExecuteInMinutes = interval;
        return this;
    }
    
    public void start(){
        List<ScheduledTransactions> allNotProccessing = transactionsRepository.allNotProccessing();
        executeTransfer(allNotProccessing);
        
    }
    
    @Transactional
    private void executeTransfer(List<ScheduledTransactions> allNotProccessing){
        for (ScheduledTransactions transaction : allNotProccessing) {
            //Obtem as contas origem e destino para excutar a transação
            Account origin = transaction.getOrigin();
            Account destination = transaction.getDestination();
            
            //Obtem os valores do agendamento da transação
            BigDecimal valueTransfer = transaction.getValue();
            BigDecimal valueRate  =  calculatorRate.calculateByTransaction(transaction);
            
            origin.transferTo(destination, valueTransfer,valueRate);
            transaction.setStatusProcessing(StatusProcessingTransfer.PROCESSED);
            
            accountRespository.update(origin);
            accountRespository.update(destination);
            transactionsRepository.update(transaction);
            
        }
    }
    
    public void stop(){
        intervalExecuteInMinutes = 0;
    }
    
    
}
