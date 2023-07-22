package bll.manager;

import bll.be.Account;
import bll.manager.interfaces.IAccountManager;
import dal.AccountDAO;
import dal.interfaces.IAccountDAO;
import org.mindrot.jbcrypt.BCrypt;

import java.util.List;

public class AccountManager implements IAccountManager {
    //more complex methods later
    private IAccountDAO accountDAO;

    public AccountManager(){
        accountDAO = new AccountDAO();
    }
    @Override
    public List<Account> getAllAccounts() {
        return accountDAO.getAllAccounts();
    }

    @Override
    public Account getAccountByID(int id) {
        return accountDAO.getAccountByID(id);
    }

    @Override
    public Account getAccountByName(String name) {
        return accountDAO.getAccountByName(name);
    }

    @Override
    public Boolean createAccount(Account account) {
        account.setPassword(hashPassword(account.getPassword()));
        return accountDAO.createAccount(account);
    }

    @Override
    public Boolean removeAccount(int id) {
        return accountDAO.removeAccount(id);
    }

    @Override
    public Boolean updateAccount(Account account) {
        account.setPassword(hashPassword(account.getPassword()));
        return accountDAO.updateAccount(account);
    }

    @Override
    public Boolean login(String username, String password) {
        return null;
    }

    private String hashPassword(String password){ //TODO can develop own hash & salt instead of library later
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }
}
