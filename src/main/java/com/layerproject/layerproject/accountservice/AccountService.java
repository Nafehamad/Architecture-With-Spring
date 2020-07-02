package com.layerproject.layerproject.accountservice;

import com.layerproject.layerproject.entity.Account;

import java.util.List;

public interface AccountService {

    public List<Account> findAll();
    public Account findById(int theId);
    public void save(Account theAccount);
    public void deleteById(int theId);
    public Account withDrawMoney( int theId,int money);
    public Account depositMoney(int theId,int money);


}
