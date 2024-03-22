package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClientService {
    private PreparedStatement createSt;
    private PreparedStatement selectMaxIdSt;
    private PreparedStatement readSt;
    private PreparedStatement updateSt;
    private PreparedStatement deleteByIdSt;
    private PreparedStatement getAllSt;
    private final Connection connection;
    public ClientService(Connection connection) throws SQLException {
        this.connection = connection;
        createSt = connection.prepareStatement(
                "INSERT INTO client(name) VALUES (?)"
        );
        readSt = connection.prepareStatement(
                "SELECT name FROM client WHERE ID = ?"
        );
        updateSt = connection.prepareStatement(
                "UPDATE client SET name = ? WHERE ID = ?"
        );
        deleteByIdSt = connection.prepareStatement(
                "DELETE FROM client  WHERE ID = ?"
        );
        getAllSt = connection.prepareStatement(
                "SELECT id, name FROM client"
        );
    }
    public long create(String name) throws SQLException {
        try {
            if((name.length() < 3) || (name.length() > 1000)) {
                throw new SQLException("The length of the NAME field cannot be less than 3!!!");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return -1;
        }
        long id = -1;
        createSt.setString(1, name);
        createSt.executeUpdate();
        selectMaxIdSt = connection.prepareStatement("SELECT max(id) AS maxId FROM client");
        try(ResultSet rs = selectMaxIdSt.executeQuery()){
            rs.next();
            id = rs.getLong("maxId");
        }
        return id;
    }
    public String getById(long id) throws SQLException {
        String name = null;
        readSt.setLong(1, id);
        try(ResultSet rs = readSt.executeQuery()){
            rs.next();
            name = rs.getString("name");
        }
        return name;
    }
    public void setName(long id, String name) throws SQLException {
        try {
            if((name.length() < 3) || (name.length() > 1000)) {
                throw new SQLException("The length of the NAME field cannot be less than 3!!!");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return;
        }
        updateSt.setString(1, name);
        updateSt.setLong(2, id);
        updateSt.executeUpdate();
    }
    public void deleteById(long id) throws SQLException {
        deleteByIdSt.setLong(1, id);
        deleteByIdSt.executeUpdate();
    }
    public List<Client> listAll() throws SQLException{
        List<Client> clientList = new ArrayList<>();
        try(ResultSet rs = getAllSt.executeQuery()) {
            while (rs.next()) {
                clientList.add(new Client(rs.getLong("id"), rs.getString("name")));
            }
        }
        return clientList;
    }

}