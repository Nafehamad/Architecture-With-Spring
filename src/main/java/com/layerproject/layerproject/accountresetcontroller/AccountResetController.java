package com.layerproject.layerproject.accountresetcontroller;


import com.layerproject.layerproject.accountservice.AccountService;
import com.layerproject.layerproject.accountservice.AccountServiceImplementation;
import com.layerproject.layerproject.entity.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Accounts")
public class AccountResetController {

    @Autowired
    AccountService accountService;

    @GetMapping
    public List<Account> findAll(){
        return accountService.findAll();
    }


    @PostMapping
    public void addAccount( Account theAccount) {
        theAccount.setBalance(10000);
        theAccount.setName("hammad");
        accountService.save(theAccount);

    }

    @GetMapping("/{theId}")
    public Account getAccount(@PathVariable("theId") int theId){
        return accountService.findById(theId);
    }

    @DeleteMapping("/{theId}")
    public void deleteAccount(@PathVariable("theId") int theId) {

        accountService.deleteById(theId);

    }

    

}
