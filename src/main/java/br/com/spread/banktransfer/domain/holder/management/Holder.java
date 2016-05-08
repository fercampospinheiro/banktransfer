package br.com.spread.banktransfer.domain.holder.management;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.Type;
import org.joda.time.LocalDate;

/**
 * Classe que representa o titular da conta
 * @author Fernando Pinheiro
 */
@Entity
@Table(name="holder_account")
public class Holder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_holder_account")
    private Integer id;
    private String name;
    @Type(type="org.jadira.usertype.dateandtime.joda.PersistentLocalDate")
    private LocalDate birthDate;

    public Holder(String name, LocalDate birthDate) {
        this.name = name;
        this.birthDate = birthDate;
    }

    public String getName() {
        return name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }
    
}
