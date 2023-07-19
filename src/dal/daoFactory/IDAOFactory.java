package dal.daoFactory;

import dal.AccountDAO;
import dal.DeviceDAO;
import dal.LogDAO;
import dal.ProjectDAO;

public interface IDAOFactory {
    AccountDAO getAccountDAO();
    ProjectDAO getProjectDAO();
    LogDAO getLogDAO();
    DeviceDAO getDeviceDAO();
}
