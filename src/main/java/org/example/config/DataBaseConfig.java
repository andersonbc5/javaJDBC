package org.example.config;

import org.example.exception.BdExceptions;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConfig {

    private static final String url = "jdbc:postgresql://localhost:5432/estoque";
    private static final String user = "postgres";
    private static final String password = "12345678";

    private Connection connection;


    public Connection getConnection(){
        try {
            connection = DriverManager.getConnection(url,user,password);
            System.out.println("✅ Conectado com sucesso!");
        }catch (SQLException e){
            throw new BdExceptions("❌ Erro ao conectar!");
        }
        return connection;
    }


}
