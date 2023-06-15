package com.nkxgen.spring.jdbc.model;

import com.nkxgen.spring.jdbc.model.LoanAccount;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class LoanAccountDao {

    @PersistenceContext
    private EntityManager entityManager;

    public List<LoanAccount> getLoanAccountsByLoanType(String loanType) {
        String queryStr = "SELECT la FROM LoanAccount la WHERE la.loanType = :loanType";
        TypedQuery<LoanAccount> query = entityManager.createQuery(queryStr, LoanAccount.class);
        query.setParameter("loanType", loanType);
        return query.getResultList();
    }
}
