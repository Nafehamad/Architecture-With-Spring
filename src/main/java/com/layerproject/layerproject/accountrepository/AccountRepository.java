package com.layerproject.layerproject.accountrepository;

import com.layerproject.layerproject.entity.Account;

import java.util.List;

public interface AccountRepository {

    public List<Account> findAll();
    public Account findById(int theId);
    public void save(Account theEmployee);
    public void deleteById(int theId);
}
