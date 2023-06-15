package com.nkxgen.spring.jdbc.model;

import com.nkxgen.spring.jdbc.model.LoanApplication;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class LoanApplicationDaos {
    @PersistenceContext
    private EntityManager entityManager;

    public List<LoanApplication> getLoanApplicationsByStatus(String status) {
        String jpql = "SELECT la FROM LoanApplication la WHERE la.status = :status";
        TypedQuery<LoanApplication> query = entityManager.createQuery(jpql, LoanApplication.class);
        query.setParameter("status", status);
        return query.getResultList();
    }
}
