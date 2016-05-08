package br.com.spread.banktransfer.presentation.account;

import br.com.spread.banktransfer.domain.bank.management.Bank;
import br.com.spread.banktransfer.domain.bank.management.BankRepository;
import br.com.spread.banktransfer.domain.account.management.FormAccount;
import br.com.spread.banktransfer.domain.holder.management.Holder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.joda.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Responsável pelo iterações do cadastro de contas
 * @author Fernando Pinheiro
 */
@Controller
@RequestMapping("account")      
public class RegisterAccountController {

    @Autowired
    private BankRepository bankRepository;
    
    @RequestMapping(method = RequestMethod.GET)
    public String loadRegister(Model model,FormAccount form){
        model.addAttribute(form);
        return "/account/registerAccount";
    }
    
    @RequestMapping(value="/save", method = RequestMethod.POST)
    public String register(Model model,FormAccount form) throws ParseException{
        
        Bank bank = new Bank("Banco do Brasil", form.getCodeBank());
        Date bithDate = new SimpleDateFormat("yyyy-MM-dd").parse(form.getBirthDateCliente());
        
        bank.addAccount(form.getNumberAccount(),new Holder(form.getNameCliente(),LocalDate.fromDateFields(bithDate) ) );
        
        bankRepository.save(bank);
        
        model.addAttribute(form);
        return "/registerAccount/registerAccount";
    }
    
    
    
}
