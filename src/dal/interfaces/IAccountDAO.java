package dal.interfaces;

import bll.be.Account;

import java.util.List;

public interface IAccountDAO {
    List<Account> getAllAccounts();
    Account getAccountByID(int id);
    Account getAccountByName(String name);
    Boolean createAccount(Account account);
    Boolean removeAccount(int id);
    Boolean updateAccount(Account account);
}
