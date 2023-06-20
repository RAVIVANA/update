package com.nkxgen.spring.jdbc.Dao;
import com.nkxgen.spring.jdbc.model.*;


import java.util.List;

public interface AccountTypeInterface {
    List<accountTypes> getAllAccounts();

    List<accountTypes> getAllAccountDetails();

    accountTypes getSelectedAccountDetails(int accountType);

    void save(accountTypes accountTypes);
}
