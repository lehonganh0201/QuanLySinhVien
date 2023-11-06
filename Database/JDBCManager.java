package com.Database;

import com.mysql.cj.jdbc.Driver;

import java.sql.Connection;
import java.sql.DriverManager;

public class JDBCManager {
    public static Connection getConnection(){
        Connection connection=null;

        try {
            DriverManager.registerDriver(new Driver());

            String url="jdbc:mySQL://localhost:1433/quanlysinhvien";
            String username="root";
            String password="lehonganh0201";

            connection=DriverManager.getConnection(url,username,password);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return connection;
    }

    public static void closeConnection(Connection c){
        try {
            if (c!=null){
                c.close();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
