package Util;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by chairyfish on 2017/6/26.
 */
public class JDBCUtil {

    private static Connection conn;
    private static ComboPooledDataSource ds = new ComboPooledDataSource();


    public static Connection getConnection() {
        try {
            ds.setDriverClass("com.mysql.jdbc.Driver");
            ds.setJdbcUrl("jdbc:mysql://112.74.173.33:3306/GISProject?useSSL=false&useUnicode=true&characterEncoding=UTF8&useServerPrepStmts=true&prepStmtCacheSqlLimit=256&cachePrepStmts=true&prepStmtCacheSize=256&rewriteBatchedStatements=true");
            ds.setUser("REMOTEUSER");
            ds.setPassword("961219");
            conn = ds.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        }
        return conn;
    }



}
