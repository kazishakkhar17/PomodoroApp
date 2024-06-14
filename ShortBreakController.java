package application;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.util.Duration;

public class ShortBreakController {
    private PomodoroApp app;

    public void setApp(PomodoroApp app) {
        this.app = app;
    }

    @FXML
    private Label timerLabel;

    private int minutes = 5;
    private int seconds = 0;
    private Timeline timeline;

    public void initialize() {
        updateTimerLabel();
    }

    private void updateTimerLabel() {
        timerLabel.setText(String.format("%02d:%02d", minutes, seconds));
    }

    private void startTimer() {
        timeline = new Timeline(new KeyFrame(Duration.seconds(1), event -> {
            if (minutes == 0 && seconds == 0) {
                timeline.stop();
                System.out.println("Short Break Timer Complete!");
                // Automatically switch to Long break scene
                switchToLongBreakScene(new ActionEvent());
            } else {
                if (seconds == 0) {
                    minutes--;
                    seconds = 59;
                } else {
                    seconds--;
                }
                updateTimerLabel();
            }
        }));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }

    private void pauseTimer() {
        if (timeline != null) {
            timeline.pause();
        }
    }

    private void resetTimer() {
        if (timeline != null) {
            timeline.stop();
        }
        minutes = 5;
        seconds = 0;
        updateTimerLabel();
    }

    @FXML
    private void startButtonClicked(ActionEvent event) {
        startTimer();
    }

    @FXML
    private void pauseButtonClicked(ActionEvent event) {
        pauseTimer();
    }

    @FXML
    private void resetButtonClicked(ActionEvent event) {
        resetTimer();
    }

    @FXML
    private void switchToPomodoroScene(ActionEvent event) {   //connected with button clicking
        try {
            app.showPomodoroScene();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void switchToLongBreakScene(ActionEvent event) {  //connected with button clicking
        try {
            app.showLongBreakScene();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
