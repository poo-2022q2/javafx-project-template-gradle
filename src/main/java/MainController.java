import javafx.animation.AnimationTimer;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class MainController {

    @FXML
    private Button startStopButton;

    @FXML
    private Label timeLabel;

    private boolean isRunning;
    private long lastTick;
    private long currentTime;
    private final PomodoroTimer timer;

    public MainController() {
        timer = new PomodoroTimer();
    }

    private void reset() {
        isRunning = false;
        lastTick = 0;
        currentTime = 25 * 60 * 1000;
        updateUi();
    }

    @FXML
    public void initialize() {
        startStopButton.setOnMouseClicked((event) -> {
            if (isRunning) {
                stopTimer();
                startStopButton.setText("START");
            } else {
                startTimer();
                startStopButton.setText("CANCEL");
            }
        });
        reset();
    }

    private void startTimer() {
        isRunning = true;
        lastTick = System.currentTimeMillis();
        timer.start();
    }

    private void stopTimer() {
        reset();
        timer.stop();
    }

    private void updateUi() {
        timeLabel.setText(String.format("%02d:%02d", currentTime / 1000 / 60, currentTime / 1000 % 60));
    }

    private class PomodoroTimer extends AnimationTimer {

        @Override
        public void handle(long now) {
            if (isRunning) {
                var delta = System.currentTimeMillis() - lastTick;

                if (delta >= 1000) {
                    lastTick = System.currentTimeMillis();
                    currentTime -= 1000;
                    updateUi();
                }
            }
        }
    }

}
