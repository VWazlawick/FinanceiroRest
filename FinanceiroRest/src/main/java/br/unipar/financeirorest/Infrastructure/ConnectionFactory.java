
package br.unipar.financeirorest.Infrastructure;

import java.sql.Connection;
import java.sql.SQLException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;


public class ConnectionFactory {
 
    private static final String RESOURCE_NAME = "postgresResource";
    
    private DataSource getDataSource() throws NamingException{
        Context c = new InitialContext();
        
        return (DataSource) c.lookup(RESOURCE_NAME);
    }
    
    public Connection getConnection() throws NamingException, SQLException{
        return getDataSource().getConnection();
    }
}
