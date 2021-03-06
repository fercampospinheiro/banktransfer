package br.com.spread.banktransfer.domain.bank.schedule.financial;

import br.com.spread.banktransfer.domain.bank.transfer.StatusProcessingTransfer;
import br.com.spread.banktransfer.domain.account.management.Account;
import br.com.spread.banktransfer.domain.bank.schedule.rate.OperationOfTransaction;
import br.com.spread.banktransfer.domain.bank.schedule.rate.OperationType;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

/**
 * Classe que representa os agendamentos de movimentaçoes
 * @author Fernando Pinheiro
 */
@Entity
@Table(name="scheduled_transactions")
public class ScheduledTransactions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_scheduled_transactions")
    private Integer id;
    
    @Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    @Column(name="date_resgistration")
    private DateTime dateOfRegistration;
    
    @OneToOne
    @JoinColumn(name="id_account_origin")
    private Account origin;
    
    @OneToOne
    @JoinColumn(name="id_account_destination")  
    private Account destination;
    private BigDecimal value;
    
    @Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    @Column(name="date_scheduled ")
    private DateTime dateScheduled ;
    
    @Enumerated(EnumType.STRING)
    private StatusProcessingTransfer statusProcessing;
    
    @Enumerated(EnumType.STRING)
    @Column(name="operation_type")
    private OperationType operationType;

    public ScheduledTransactions() {
    }
    
    public ScheduledTransactions(Account origin, Account destination, BigDecimal value, DateTime dateScheduled) {
        this.origin = origin;
        this.destination = destination;
        this.value = value;
        this.dateScheduled = dateScheduled;
        statusProcessing = StatusProcessingTransfer.WAINTING;
    }

    public Integer getId() {
        return id;
    }

    public Account getOrigin() {
        return origin;
    }

    public Account getDestination() {
        return destination;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public void setDateScheduled(DateTime dateScheduled) {
        this.dateScheduled = dateScheduled;
    }
    
    public DateTime getDateScheduled() {
        return dateScheduled;
    }  

    public void setStatusProcessing(StatusProcessingTransfer statusProcessing) {
        this.statusProcessing = statusProcessing;
    }

    public DateTime getDateOfRegistration() {
        return dateOfRegistration;
    }

    public void setDateOfRegistration(DateTime dateOfRegistration) {
        this.dateOfRegistration = dateOfRegistration;
    }

    public OperationType getOperationType() {
        return operationType;
    }

    public void setOperationType(OperationType operationType) {
        this.operationType = operationType;
    }
    
    
    
}
