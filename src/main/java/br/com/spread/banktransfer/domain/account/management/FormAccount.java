package br.com.spread.banktransfer.domain.account.management;

/**
 * Formulário de conta nova
 *
 * @author Fernando Pinheiro
 */
public class FormAccount {

    private String numberAccount;
    private Integer codeBank;
    private String nameCliente;
    private String birthDateCliente;

    public String getNumberAccount() {
        return numberAccount;
    }

    public void setNumberAccount(String numberAccount) {
        this.numberAccount = numberAccount;
    }

    public Integer getCodeBank() {
        return codeBank;
    }

    public void setCodeBank(Integer codeBank) {
        this.codeBank = codeBank;
    }

    public String getNameCliente() {
        return nameCliente;
    }

    public void setNameCliente(String nameCliente) {
        this.nameCliente = nameCliente;
    }

    public String getBirthDateCliente() {
        return birthDateCliente;
    }

    public void setBirthDateCliente(String birthDateCliente) {
        this.birthDateCliente = birthDateCliente;
    }

}
