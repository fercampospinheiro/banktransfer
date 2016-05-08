package br.com.spread.banktransfer.domain.account.management;

import br.com.spread.banktransfer.domain.account.movimentation.AccountMovimentationType;
import br.com.spread.banktransfer.domain.account.movimentation.ExtractAccount;
import br.com.spread.banktransfer.domain.holder.management.Holder;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import java.math.BigDecimal;
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
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Classe que representa uma conta bancária
 * @author Fernando Pinheiro
 */
@Entity
@Table(name="account_bank")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_account_bank")
    private Integer id;
    @Column(length = 7)
    private String number;
    private BigDecimal balance;
    @Column(name="limitValue")
    private BigDecimal limit;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_holder_account")
    private Holder holder;
    
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_extratc")
    private List<ExtractAccount> extracts = Lists.newArrayList();

    public Account() {
    }
    
    public Account(String number, Holder holder) {
        this.number = number;
        this.holder = holder;
    }
    
    public void deposit(BigDecimal value){
        this.balance.add(value);
        ExtractAccount extractAccount = new ExtractAccount(this, AccountMovimentationType.DEPOSIT, value, number, balance);
        extracts.add(extractAccount);
    } 
    public void withDraw(BigDecimal value) throws IllegalArgumentException{
        //possui saldo e valor dentro do limite, efetua saque e lança no extrato da conta
        if(balance.compareTo(value)>0 && value.compareTo(limit) < 0){
             balance.min(value);
             ExtractAccount extractAccount = new ExtractAccount(this, AccountMovimentationType.WITHDRAW, value, number, balance);
             extracts.add(extractAccount);
        }else{
            throw new IllegalArgumentException("saldo indisponivel");
        }
    }
    /**
     * Envia um valor por meio de transferência para outra conta
     * @param destination
     * @param value 
     */
    public void transferTo(Account destination,BigDecimal value){
        //possui saldo e valor dentro do limite, efetua transferência
        if(balance.compareTo(value)>0 && value.compareTo(limit) < 0){
            this.balance.min(value);
            ExtractAccount extractAccount = new ExtractAccount(this, AccountMovimentationType.TRANSFER, value, destination.getNumber(), balance);
            extracts.add(extractAccount);
            destination.receiverOf(this,value);

        }else{
            throw new IllegalArgumentException("saldo indisponivel");
        }
    } 
    /**
     * Recebe o valor de transferência
     * @param origin
     * @param value 
     */
    private void receiverOf(Account origin,BigDecimal value){
        //Só efetua tranfência para valores positivos
        if(value.compareTo(BigDecimal.ZERO) < 0){
            this.balance.add(value);
            ExtractAccount extractAccount = new ExtractAccount(this, AccountMovimentationType.TRANSFER, value, origin.number, balance);
            extracts.add(extractAccount);
        }else{
            throw new IllegalArgumentException("Não é posisvel trasnferir valore negativos");
        }
    } 
    
    
    public BigDecimal checkBalance(){
        return this.balance;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setNumber(String number) {
        this.number = number;
    }
    
    public Holder getHolder() {
        return holder;
    }

    public String getNumber() {
        return number;
    }

    public BigDecimal getLimit() {
        return limit;
    }

    @Override
    public String toString() {
        return "Account{" + "id=" + id + ", number=" + number + ", balance=" + balance + ", limit=" + limit + ", holder=" + holder + '}';
    }
    /**
     * Obtem os extrato  da conta para consulta
     * @return ImmutableList
     */
    public List<ExtractAccount> consultExtracts() {
        return ImmutableList.copyOf(extracts);
    }  
    
  
}
