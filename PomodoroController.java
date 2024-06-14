package application;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.util.Duration;

public class PomodoroController {
	 private PomodoroApp app;

	    public void setApp(PomodoroApp app) {
	        this.app = app;
	    }
	    
	    //// Event handler for switching to the Short Break scene
	    @FXML
	    private void switchToShortBreakScene(ActionEvent event) {
	        try {
	            app.showShortBreakScene();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }

	 // Event handler for switching to the Long Break scene
	    @FXML
	    private void switchToLongBreakScene(ActionEvent event) {
	        try {
	            app.showLongBreakScene();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }

	    
    @FXML                                 // Label for displaying the timer
    private Label timerLabel;

    private int minutes = 30;
 
    private int seconds = 0;
    private Timeline timeline;

    public void initialize() {
        updateTimerLabel();
    }

    private void updateTimerLabel() {
        timerLabel.setText(String.format("%02d:%02d", minutes, seconds));
    }                                    //// Format the time as string

    private void startTimer() {
        timeline = new Timeline(new KeyFrame(Duration.seconds(1), event -> {
            if (minutes == 0 && seconds == 0) {
                timeline.stop();
                // Handle timer completion
                System.out.println("Pomodoro Timer Complete!");
                // Automatically switch to Short Break scene
                switchToShortBreakScene(new ActionEvent()); // Added for automatic scene switch
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
        minutes = 25;
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

	
}
