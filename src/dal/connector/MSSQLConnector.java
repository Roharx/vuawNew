package dal.connector;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import com.microsoft.sqlserver.jdbc.SQLServerException;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.util.Properties;

public class MSSQLConnector {
    private static final String file = "resources/mssql.properties";
    private SQLServerDataSource dataSource = null;

    public MSSQLConnector() throws IOException {
        Properties properties = loadConfigFile();
        this.dataSource = new SQLServerDataSource();
        this.dataSource.setDatabaseName(properties.getProperty("db.name"));
        this.dataSource.setUser(properties.getProperty("db.username"));
        this.dataSource.setPassword(properties.getProperty("db.password"));
        this.dataSource.setServerName(properties.getProperty("db.server"));
        this.dataSource.setPortNumber(Integer.parseInt(properties.getProperty("db.port")));
        this.dataSource.setTrustServerCertificate(true);
    }

    public Connection createConnection() throws SQLServerException {
        return dataSource.getConnection();
    }

    private Properties loadConfigFile() throws IOException {
        FileInputStream fs = new FileInputStream(file);
        Properties properties = new Properties();
        properties.load(fs);
        return properties;
    }

}
