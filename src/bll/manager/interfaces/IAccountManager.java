package bll.manager.interfaces;

import bll.be.Account;

import java.util.List;

public interface IAccountManager {
    List<Account> getAllAccounts();
    Account getAccountByID(int id);
    Account getAccountByName(String name);
    Boolean createAccount(Account account);
    Boolean removeAccount(int id);
    Boolean updateAccount(Account account);
}
