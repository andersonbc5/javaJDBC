package org.example.application;

import org.example.config.DataBaseConfig;
import org.example.exception.BdExceptions;
import org.example.model.dao.ClienteDao;
import org.example.model.dao.DaoFactory;

import java.sql.Connection;
import java.sql.SQLException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        DataBaseConfig dataBaseConfig = new DataBaseConfig();

        try (Connection connection = dataBaseConfig.getConnection()) {

            ClienteDao clienteDao = DaoFactory.createClienteDao(connection);

            System.out.println(clienteDao.findById(10));


        } catch (Exception e) {

            e.printStackTrace();
        }
    }
}