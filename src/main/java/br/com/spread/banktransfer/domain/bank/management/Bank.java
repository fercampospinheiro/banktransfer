package br.com.spread.banktransfer.domain.bank.management;

import br.com.spread.banktransfer.domain.account.management.Account;
import br.com.spread.banktransfer.domain.holder.management.Holder;
import br.com.spread.banktransfer.domain.bank.schedule.financial.ScheduledTransactions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.joda.time.DateTime;

/**
 * Classe que representa a instituiçao financeira
 * @author Fernando Pinheiro
 */
@Entity
@Table(name="bank")
public class Bank {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_bank")
    private Integer id; 
    private String name;
    @Column(length = 4)
    private Integer code;
    
    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "id_account_bank")
    private List<Account> accounts = new ArrayList<>();
    
    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_scheduled_transactions")
    private List<ScheduledTransactions> schedules = Lists.newArrayList();

    public Bank(String name, Integer code) {
        this.name = name;
        this.code = code;
    }
    
    public void addAccount(String number,Holder holder){
        Account account = new Account(number,holder);
        accounts.add(account);
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return this.name;
    }

    public Integer getCode() {
        return code;
    }
    
    /**
     * Obtem uma relaçao de contas somente para consulta
     * @return List<Account>
     */
    public List<Account> getAccounts() {
        return ImmutableList.copyOf(this.accounts);
    }
    
    public void scheduletTransfer(BigDecimal value,Account origin,Account destination, DateTime dateScheduled ){
        origin.withDraw(value);
        origin.deposit(value);
        schedules.add(new ScheduledTransactions(origin, destination, value, dateScheduled));
    }
    
}
