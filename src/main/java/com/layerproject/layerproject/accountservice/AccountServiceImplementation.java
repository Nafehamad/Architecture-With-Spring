package com.layerproject.layerproject.accountservice;

import com.layerproject.layerproject.accountrepository.AccountRepository;
import com.layerproject.layerproject.entity.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AccountServiceImplementation implements AccountService{
    @Autowired
    AccountRepository accountRepository;
    @Override
    public List<Account> findAll() {
        return accountRepository.findAll();
    }

    @Override
    public Account findById(int theId) {
        return accountRepository.findById(theId);
    }

    @Override
    public void save(Account theAccount) {
      accountRepository.save(theAccount);
    }

    @Override
    public void deleteById(int theId) {
       accountRepository.deleteById(theId);
    }

    @Override
    public Account withDrawMoney(int theId, int money) {
       Account account= accountRepository.findById(theId);
       account.setBalance(account.getBalance()-money);
       accountRepository.save(account);
        return account;
    }

    @Override
    public Account depositMoney(int theId, int money) {
        Account account= accountRepository.findById(theId);
        account.setBalance(account.getBalance()+money);
        accountRepository.save(account);
        return account;

    }
}
