package com.javiezcobar;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import java.io.IOException;
@SpringBootApplication
public class JavaFxApplicationSupport extends Application {

    public static ConfigurableApplicationContext applicationContext;
    public static Parent rootNode;
    public static Stage stage;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void init() throws Exception {
        SpringApplicationBuilder builder = new SpringApplicationBuilder(JavaFxApplicationSupport.class);
        builder.application().setWebApplicationType(WebApplicationType.NONE);
    }


    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(KillaApplication.class.getResource("/fxml/main.fxml"));
        Scene scene = new Scene(fxmlLoader.load(),600,400);
        primaryStage.setTitle("App for loan");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
