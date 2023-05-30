package com.example.librarydbnew;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import java.sql.SQLException;

public class BookApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException, SQLException {
        final Repository repository = new Repository();
        FXMLLoader fxmlLoader = new FXMLLoader(BookApplication.class.getResource("LoginCheck.fxml"));
        Scene login_check = new Scene(fxmlLoader.load(), 800, 600);
        final LoginCheckController controller = fxmlLoader.getController();
        controller.setRepository(repository);
        stage.setTitle("Hello!");
        stage.setScene(login_check);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}