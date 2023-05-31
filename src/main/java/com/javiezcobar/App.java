package com.javiezcobar;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class App extends Application {
    public static ConfigurableApplicationContext appContext;


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        appContext = SpringApplication.run(App.class);
        FXMLLoader loader = new FXMLLoader(App.class.getResource("/fxml/main.fxml"));
        loader.setControllerFactory(appContext::getBean);
        Scene scene = new Scene(loader.load());
        stage.setScene(scene);
        stage.show();
    }
}
