package com.layerproject.layerproject.accountrepository;


import com.layerproject.layerproject.entity.Account;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Repository //access database
    public class AccountRepositoryImplementation implements AccountRepository{

        @Autowired
        private EntityManager entityManager;

        @Override
        public List<Account> findAll() {

            Session currentSession = entityManager.unwrap(Session.class);
            Query<Account> theQuery = currentSession.createQuery("from Account", Account.class);
            List<Account> accounts = theQuery.getResultList();
            return accounts;


        }

        @Override
        public Account findById(int theId) {
            Session currentSession = entityManager.unwrap(Session.class);
            Account theAccount = currentSession.get(Account.class, theId);
            return theAccount;
        }

        @Override
        public void save(Account theAccount) {
            Session currentSession = entityManager.unwrap(Session.class);
            currentSession.saveOrUpdate(theAccount);
        }

        @Override
        @Transactional
        public void deleteById(int theId) {
            Session currentSession = entityManager.unwrap(Session.class);
            Query theQuery = currentSession.createQuery("delete from Account where id=:accountId");
            theQuery.setParameter("accountId", theId);
            theQuery.executeUpdate();

        }


}
