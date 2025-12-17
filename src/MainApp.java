import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;

public class MainApp extends Application {

    private int seconds = 0;

    @Override
    public void start(Stage stage) {
        Label timerLabel = new Label("Time: 0 seconds");
        timerLabel.setStyle("-fx-font-size: 24px;");

        // Timeline for updating the timer
        Timeline timeline = new Timeline(
            new KeyFrame(Duration.seconds(1), e -> {
                seconds++;
                timerLabel.setText("Time: " + seconds + " seconds");
            })
        );
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();

        VBox root = new VBox(20, timerLabel);
        root.setStyle("-fx-padding: 20; -fx-alignment: center;");

        Scene scene = new Scene(root, 400, 200);
        stage.setScene(scene);
        stage.setTitle("Digital Timer");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
