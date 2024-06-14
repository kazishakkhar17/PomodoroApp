package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class PomodoroApp extends Application {

    private Stage primaryStage;

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.primaryStage = primaryStage;
        showPomodoroScene();         //// Call method to show Pomodoro scene when the application starts
                                        //at the very begining, pomodoro scene will be shown
    }

    public void showPomodoroScene() throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Pomodoro.fxml"));
        Parent root = loader.load();
        PomodoroController controller = loader.getController();
        controller.setApp(this);     //allows the controllers to interact with the main application class
        primaryStage.setScene(new Scene(root, 800, 600));
        primaryStage.setTitle("Pomodoro Timer");
        primaryStage.show();
    }

    public void showShortBreakScene() throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ShortBreak.fxml"));
        Parent root = loader.load();
        ShortBreakController controller = loader.getController();
        controller.setApp(this);
        primaryStage.setScene(new Scene(root, 800, 600));
        primaryStage.setTitle("Short Break Timer");
        primaryStage.show();
    }

    public void showLongBreakScene() throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("LongBreak.fxml"));
        Parent root = loader.load();
        LongBreakController controller = loader.getController();
        controller.setApp(this);
        primaryStage.setScene(new Scene(root, 800, 600));
        primaryStage.setTitle("Long Break Timer");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
