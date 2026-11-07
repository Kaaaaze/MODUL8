package embg;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.net.URL;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

/**
 *
 * @author lenovo
 */
public class MainApp extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        URL fxmlLocation = getClass().getResource("/embg/view/siswa-alergi-mobile.fxml");
        if (fxmlLocation == null) {
            throw new IllegalStateException("File FXML tidak ditemukan di /embg/view/siswa-alergi-mobile.fxml");
        }
        
        Parent root = FXMLLoader.load(fxmlLocation);
        
        // Resolusi layar mobile (lebar 390, tinggi 844)
        Scene scene = new Scene(root, 390, 844);
        
        primaryStage.setTitle("e-MBG - Data Siswa Alergi");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}