package com.geekbrains.server;

import java.sql.*;

public class AuthSQL implements AutoCloseable{

    private static AuthSQL instance;
    private static Connection connection;

    private static PreparedStatement findByLoginAndPassword;
    private static PreparedStatement changeNick;

    private AuthSQL(){}

    public static AuthSQL getInstance(){
        if(instance == null){
            LoadDriverAndOpenConnection();
            createPreparedStatements();

            instance = new AuthSQL();
        }
        return instance;
    }

    private static void LoadDriverAndOpenConnection(){
        try{
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:authorization.db");
        }catch (ClassNotFoundException | SQLException e){
            System.err.println("Ошибка открытия соединения с базой данных!");
            e.printStackTrace();
        }
    }

    private static void createPreparedStatements(){
        try{
            findByLoginAndPassword = connection.prepareStatement("SELECT * FROM log_in WHERE LOWER(login)=LOWER(?) AND password=?");
            changeNick = connection.prepareStatement("UPDATE log_in SET nickname=? WHERE nickname=?");
        } catch (SQLException ex){
            ex.printStackTrace();
        }
    }
    public String findByLoginAndPassword(String login, String password){
        ResultSet resultSet = null;
        Statement statement = null;

        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String checkSQL = "SELECT * FROM log_in";

        try {
            resultSet = statement.executeQuery(checkSQL);
        } catch (SQLException e) {
            e.printStackTrace();
        }


        try{
            resultSet.getString("nickname");
//            findByLoginAndPassword.setString(1, login);
//            findByLoginAndPassword.setString(2, password);
//
//            resultSet = findByLoginAndPassword.executeQuery();
//            if(resultSet.next()){
//                return resultSet.getString("nickname");
//            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            closeResultSet(resultSet);
        }
        return null;
    }
    private void closeResultSet(ResultSet resultSet){
        if(resultSet != null){
            try{
                resultSet.close();
            }catch (SQLException ex){
                ex.printStackTrace();
            }
        }
    }

    public int updateNickname(String oldNickname, String newNickname){
        try{
            changeNick.setString(1, newNickname);
            changeNick.setString(2, oldNickname);

            return changeNick.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public void close(){
        try{
            findByLoginAndPassword.close();
            changeNick.close();
            connection.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
