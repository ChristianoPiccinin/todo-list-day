package app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

class ConnectionFactory {

    private final static String dataBaseName = "todolistday";
    private final static String dataBaseUser = "root";
    private final static String dataBasePassword = "univille";

    static Connection getConnection(){
        try {

            return DriverManager
                    .getConnection(String.format("jdbc:mysql://localhost/%s?useTimezone=true&serverTimezone=UTC",dataBaseName),dataBaseUser,dataBasePassword);

        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

}