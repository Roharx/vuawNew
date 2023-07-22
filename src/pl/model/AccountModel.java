package pl.model;

import bll.be.Account;
import bll.manager.AccountManager;

import java.util.List;

public class AccountModel {
    //TODO methods: logged in user, etc.
    private Account loggedInAccount = null;
    private AccountManager accountManager = new AccountManager();
    private static AccountModel instance;

    private static AccountModel getInstance(){
        if(instance == null){
            instance = new AccountModel();
        }
        return instance;
    }

    public List<Account> getAllAccounts(){
        return accountManager.getAllAccounts();
    }
    public Account getAccountByID(int id){
        return accountManager.getAccountByID(id);
    }
    public Account getAccountByName(String name){
        return accountManager.getAccountByName(name);
    }
    public Boolean createAccount(Account account){
        return accountManager.createAccount(account);
    }
    public Boolean removeAccount(int id){
        return accountManager.removeAccount(id);
    }
    public Boolean updateAccount(Account account){
        return accountManager.updateAccount(account);
    }
    public Boolean login(String username, String password){
        return null;
    }
}
