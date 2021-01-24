package com.geekbrains.client;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception{
//        /*начало моего кода*/Class.forName("org.sqLite.JDBC");
//        Connection connection = DriverManager.getConnection("jdbc:sqlite:autorization.db");
//        Statement statement = connection.createStatement();
////        statement.executeUpdate("SELECT * FROM log_in");
////        statement.executeQuery("SELECT * FROM log_in");
//        ResultSet resultSet = statement.executeQuery("SELECT * FROM log_in");
//       while(resultSet.next()){
//           System.out.println(resultSet.getString("name") + " " + resultSet.getInt("score"));
//       }
//       connection.setAutoCommit(false);// отмена автосохранения
//        for (int i = 0; i < 10000; i++) {
//            String str= String.format("INSERT INTO log_in(name, score) VALUES(\"%s\", %d)", "BOB_" + i, i * 10);
//            statement.executeUpdate(str);
//        }
//        connection.commit(); // сохранение типа
        /*конец моего кода*/
        Parent root = FXMLLoader.load(getClass().getResource("/main.fxml"));
        primaryStage.setTitle("BrainsChat Client");
        primaryStage.setScene(new Scene(root, 400, 400));
        primaryStage.show();
//        connetion.close();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
