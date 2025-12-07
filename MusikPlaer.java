import javafx.application.Application;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import java.io.File;

public class MusikPlaer extends Application {
    @Override
    public void start(Stage primaryStage) {
        // Load the media file (supports MP3, etc.)
        File audioFile = new File("music.mp3");
        Media media = new Media(audioFile.toURI().toString());
        MediaPlayer player = new MediaPlayer(media);
        
        // Play the music
        player.play();
        
        // Optional: Set volume (0.0 to 1.0)
        player.setVolume(0.5);
        
        // Keep the app running
        primaryStage.setTitle("Music Player");
        primaryStage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}