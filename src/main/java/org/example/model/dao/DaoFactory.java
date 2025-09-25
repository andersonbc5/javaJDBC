package org.example.model.dao;

import org.example.model.dao.impl.ClienteDaoJDBC;

import java.sql.Connection;

public class DaoFactory {

    public static ClienteDao createClienteDao(Connection connection){
        return new ClienteDaoJDBC(connection);
    }
}
