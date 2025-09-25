package org.example.model.dao.impl;

import org.example.exception.BdExceptions;
import org.example.model.dao.ClienteDao;
import org.example.model.entities.Cliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClienteDaoJDBC implements ClienteDao {

    private Connection connection;

    public ClienteDaoJDBC(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void insert(Cliente cliente) {
        String sql = "INSERT INTO cliente (nome, cpf, email, sexo, dt_nascimento) VALUES (?,?,?,?,?)";

        try (PreparedStatement stmt = connection.prepareStatement(sql)){
            stmt.setString(1,cliente.getNome());
            stmt.setString(2,cliente.getCpf());
            stmt.setString(3,cliente.getEmail());
            stmt.setString(4,cliente.getSexo());
            stmt.setDate(5,cliente.getDt_nascimento());
            stmt.executeUpdate();
        }catch (SQLException e){
            throw new BdExceptions("❌ erro ao inserir!" + e.getMessage());
        }
    }

    @Override
    public void update(Cliente cliente) {
        String sql = "UPDATE cliente SET nome = ?, cpf = ?, email = ?, sexo = ?, dt_nascimento = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)){
            stmt.setString(1,cliente.getNome());
            stmt.setString(2,cliente.getCpf());
            stmt.setString(3,cliente.getEmail());
            stmt.setString(4,cliente.getSexo());
            stmt.setDate(5,cliente.getDt_nascimento());
            stmt.setInt(6,cliente.getId());
            stmt.executeUpdate();
        }catch (SQLException e){
            throw new BdExceptions("❌ erro ao atualizar!" + e.getMessage());
        }
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM cliente WHERE id = ?";
        try(PreparedStatement stmt = connection.prepareStatement(sql)){
            stmt.setInt(1,id);
            stmt.executeUpdate();
        }catch (SQLException e){
            throw new BdExceptions("❌ erro ao deletar!" + e.getMessage());
        }
    }

    @Override
    public Cliente findById(int id) {
        String sql = "SELECT * FROM cliente WHERE id = ?";
        try(PreparedStatement stmt = connection.prepareStatement(sql)){
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()){
                Cliente cliente = new Cliente();
                cliente.setId(rs.getInt("id"));
                cliente.setNome(rs.getString("nome"));
                cliente.setCpf(rs.getString("cpf"));
                cliente.setEmail(rs.getString("email"));
                cliente.setSexo(String.valueOf(rs.getString("sexo").charAt(0)));
                cliente.setDt_nascimento(rs.getDate("dt_nascimento"));

                return cliente;

            }


        }catch (SQLException e){
            throw new BdExceptions("❌ erro ao listar por id!" + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Cliente> findAll() {
        String sql = "SELECT * FROM cliente";
        List<Cliente> clientes = new ArrayList<>();
        try (PreparedStatement stmt = connection.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()){
            while (rs.next()){
                Cliente cliente = new Cliente();
                cliente.setId(rs.getInt("id"));
                cliente.setNome(rs.getString("nome"));
                cliente.setCpf(rs.getString("cpf"));
                cliente.setEmail(rs.getString("email"));
                cliente.setSexo(String.valueOf(rs.getString("sexo").charAt(0)));
                cliente.setDt_nascimento(rs.getDate("dt_nascimento"));

                clientes.add(cliente);

            }
        }catch (SQLException e){
            throw new BdExceptions("❌ erro ao listar!" + e.getMessage());
        }
        return clientes;
    }
}
