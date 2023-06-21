package com.nkxgen.spring.jdbc.Dao;

import java.util.List;

import com.nkxgen.spring.jdbc.model.InterestCal;

public interface AccountProcessingDAO {

	public List<InterestCal> getSavAcc(String acctype);

	public void executeProcedure(int accno);

}
