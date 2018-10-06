package app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.sql.Connection;


public class Main extends Application  {



    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("app.fxml"));
        primaryStage.setScene(new Scene(root, 636, 431));
        primaryStage.show();
    }


    public static void main(String[] args) {
       Connection connection = ConnectionFactory.getConnection();
       launch(args);


    }

}
