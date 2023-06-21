package com.nkxgen.spring.jdbc.Dao;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.StoredProcedureQuery;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.nkxgen.spring.jdbc.model.InterestCal;

// ...

@Repository
@Transactional
public class AccountProcessingDAOimp implements AccountProcessingDAO {

	@PersistenceContext
	public EntityManager em;

	// ...
	@Transactional
	public List<InterestCal> getSavAcc(String acctype) {
		List<InterestCal> intCal = new ArrayList<>();

		if ("Fixed Deposit".equals(acctype)) {
			LocalDate currentDate = LocalDate.now();
			LocalDate fourMonthsAgo = currentDate.minus(4, ChronoUnit.MONTHS);

			String jpql = "SELECT i FROM InterestCal i WHERE i.acctype = :acctype AND i.date <= :date";
			TypedQuery<InterestCal> query = em.createQuery(jpql, InterestCal.class);
			query.setParameter("acctype", acctype);
			query.setParameter("date", java.sql.Date.valueOf(fourMonthsAgo));

			intCal = query.getResultList();
		} else if ("Savings Account".equals(acctype)) {
			// LocalDate currentDate = LocalDate.now();
			// LocalDate SixMonths = currentDate.minus(6, ChronoUnit.MONTHS);
			//
			String jpql = "SELECT i FROM InterestCal i WHERE i.tr_type = :acctype";
			TypedQuery<InterestCal> query = em.createQuery(jpql, InterestCal.class);
			query.setParameter("acctype", acctype);

			intCal = query.getResultList();
			System.out.println(intCal);
			for (InterestCal i : intCal) {
				System.out.println("inside");
				int acc = i.getAccno();
				String sql = "CALL smi(:acc)";
				Query query1 = em.createNativeQuery(sql);
				query1.setParameter("acc", acc);

				query1.executeUpdate();

				// System.out.println(acc);
				// StoredProcedureQuery query1 = em.createStoredProcedureQuery("smi");
				// query1.registerStoredProcedureParameter(1, Integer.class, ParameterMode.IN);
				// query1.setParameter(1, acc);
				//
				// query1.execute();
			}

		} else if ("Recurrent Deposit".equals(acctype)) {
			LocalDate currentDate = LocalDate.now();
			LocalDate fourMonthsAgo = currentDate.minus(4, ChronoUnit.MONTHS);

			String jpql = "SELECT i FROM InterestCal i WHERE i.acctype = :acctype AND i.date <= :date";
			TypedQuery<InterestCal> query = em.createQuery(jpql, InterestCal.class);
			query.setParameter("acctype", acctype);
			query.setParameter("date", java.sql.Date.valueOf(fourMonthsAgo));

			intCal = query.getResultList();
		}

		return intCal;
	}

	@Override
	@Transactional
	public void executeProcedure(int acc) {
		System.out.println("procedure");
		System.out.println(acc);

		StoredProcedureQuery query = em.createStoredProcedureQuery("smi");
		query.registerStoredProcedureParameter(1, Integer.class, ParameterMode.IN);
		query.setParameter(1, acc);

		query.execute();

	}

}
