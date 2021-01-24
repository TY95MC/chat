package com.geekbrains.server;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SimpleAuthService implements AuthService {

    private final AuthSQL authSQL =  AuthSQL.getInstance();

    @Override
    public String getNicknameByLoginAndPassword(String login, String password){
        return authSQL.findByLoginAndPassword(login, password);
    }

    @Override
    public boolean updateNickname(String oldNickname, String newNickname){
        int result = authSQL.updateNickname(oldNickname, newNickname);

        return result !=0;
    }
//    private String login;
//    private String password;
//
//    private class UserData {
//        private String login;
//        private String password;
//        private String nickname;
//
//        public UserData(String login, String password, String nickname) {
//            this.login = login;
//            this.password = password;
//            this.nickname = nickname;
//        }
//    }
//
//    private List<UserData> users;
////    Connection connection = DriverManager.getConnection("jdbc:sqlite:authorization.db");
////    ResultSet resultSet;
//    public SimpleAuthService(){
//        this.users = new ArrayList<>();
//        for (int i = 1; i <= 10; i++) {
//            users.add(new UserData("login" + i, "pass" + i, "nick" + i));
//        }
////        Class.forName("org.sqLite.JDBC");
//////        Statement statement = connection.createStatement();
////        connection.setAutoCommit(false);
////        PreparedStatement prprdstmnt = connection.prepareStatement("INSERT INTO log_in(nickname, password) VALUES(?, ?");
////        prprdstmnt.setString(1, "Alex"); //вставил логин и пароль в базу данных. у вас был цикл, который их придумал, у меня же пусто.
////        prprdstmnt.setString(2, "102030");
////        prprdstmnt.executeUpdate();
////        resultSet = prprdstmnt.executeQuery("SELECT * FROM log_in");
////        System.out.println(resultSet);
////
////
////        prprdstmnt.close();
////        resultSet.close();
////        connection.close();
//    }
//
//    @Override
//    public String getNicknameByLoginAndPassword(String login, String password) {
//        this.login = login;
//        this.password = password;
////        try{Class.forName("org.sqLite.JDBC");}catch(Exception e){e.printStackTrace();}
////        try {
////            if (login.equals(resultSet.getString(2))/*если логин совпадает с 2 колонкой из таблицы*/ && password.equals(resultSet.getString(3/*если совпадает с колонкой пароля из таблицы*/))) {
////                return resultSet.getString(2);
////            }
////        }catch(Exception e){
////            e.printStackTrace();
////        }
//
//        for (UserData o : users) {
//            if (o.login.equals(login) && o.password.equals(password)) {
//                return o.nickname;
//            }
//        }
//        return null;
//    }
}
//но все равно не работает чат у меня выдает много ошибок, свзанных с классами нетворк и контроллер, хотя без моей базы данных все работает