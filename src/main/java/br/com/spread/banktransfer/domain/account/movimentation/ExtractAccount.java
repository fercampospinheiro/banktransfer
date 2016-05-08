package br.com.spread.banktransfer.domain.account.movimentation;

import br.com.spread.banktransfer.domain.account.management.Account;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

/**
 * Extrato da conta bancária
 * @author Fernando Pinheiro
 */
@Entity
@Table(name="extract_account")
public class ExtractAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_extract_account")
    private Integer id;
    
    @Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    @Column(name="date_extract")
    private DateTime dateExtratct;
    
    @ManyToOne
    @JoinColumn(name = "id_account_movimentation")
    private Account accountOfMovimentation;
    
    @Enumerated(EnumType.STRING)
    @Column(name="type_account")
    private AccountMovimentationType type;
    
    private BigDecimal value;
    
    @Column(name = "number_account_destination")    
    private String numberAccountDestination;
    
    @Column(name="currency_balance")
    private BigDecimal currencyBalance;

    public ExtractAccount(Account accountMovimentation, AccountMovimentationType type, BigDecimal value, String numberAccountDestination, BigDecimal currencyBalance) {
        this.accountOfMovimentation = accountMovimentation;
        this.type = type;
        this.value = value;
        this.numberAccountDestination = numberAccountDestination;
        this.currencyBalance = currencyBalance;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
    
    
    
}
