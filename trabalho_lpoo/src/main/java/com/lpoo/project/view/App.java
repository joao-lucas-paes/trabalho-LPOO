package com.lpoo.project.view;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class App extends Application {

    static public void startApp() {
        launch();
    }

    @Override
    public void start(Stage arg0) throws Exception {
        System.out.println("started");
        Scene scene = new Scene(new StackPane(), 800, 800);

        arg0.setTitle("Jogos da Copa do Mundo");

        arg0.setScene(scene);
        arg0.show();
    }
    
}
