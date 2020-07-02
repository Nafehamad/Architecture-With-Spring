package com.layerproject.layerproject;

import com.layerproject.layerproject.accountservice.AccountService;
import com.layerproject.layerproject.entity.Account;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
class LayerprojectApplicationTests {


    @Autowired
    private AccountService accountService;

    @Test
    @Transactional
    @Rollback(false)
    void addAccount() {
        Account account=new Account();
        account.setName("jhjhja");
        account.setBalance(2000);
        accountService.save(account);
    }
    @Test
    @Transactional
    @Rollback(false)
    void testWithdraw(){
      accountService.withDrawMoney(6,2500);

    }

}
