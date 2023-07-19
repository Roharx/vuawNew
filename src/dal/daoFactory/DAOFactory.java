package dal.daoFactory;

import dal.AccountDAO;
import dal.DeviceDAO;
import dal.LogDAO;
import dal.ProjectDAO;

public class DAOFactory implements IDAOFactory {
    @Override
    public AccountDAO getAccountDAO(){
        return new AccountDAO();
    }

    @Override
    public ProjectDAO getProjectDAO(){
        return new ProjectDAO();
    }

    @Override
    public LogDAO getLogDAO(){
        return new LogDAO();
    }

    @Override
    public DeviceDAO getDeviceDAO(){
        return new DeviceDAO();
    }
}
