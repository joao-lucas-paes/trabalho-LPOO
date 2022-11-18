package com.lpoo.project.view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

import com.lpoo.project.model.Grupo;
import com.lpoo.project.model.Time;

public class App extends Application {

    private static Scene scene;

    static public ArrayList<Time> UnsignedTeam = new ArrayList<Time>();
    static public ArrayList<Grupo> listGroup = new ArrayList<Grupo>();
    static public int tempI, tempJ; // metodo de comunicao global, visto que ao abrir um DialogBox eu nao tenho um meio de comunicacao preparada pela lib previamente

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("primary"), 640, 480);
        stage.setScene(scene);
        stage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    public static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        
        return fxmlLoader.load();
    }

    public static Parent loadFXML(String fxml, Object o) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        
        fxmlLoader.setController(fxmlLoader);

        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }

}