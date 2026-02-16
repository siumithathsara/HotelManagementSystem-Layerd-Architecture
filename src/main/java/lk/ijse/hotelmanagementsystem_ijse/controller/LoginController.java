package lk.ijse.hotelmanagementsystem_ijse.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import lk.ijse.hotelmanagementsystem_ijse.dao.custom.impl.UserImpl;
import lk.ijse.hotelmanagementsystem_ijse.dto.Session;
import lk.ijse.hotelmanagementsystem_ijse.dto.UserDTO;


import java.io.IOException;
import java.sql.SQLException;

public class LoginController {

    @FXML
    private AnchorPane subContentField;

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    private final UserImpl userDao = new UserImpl();
    private final Session currentSession = new Session();

    @FXML
    private void login() throws IOException, SQLException, ClassNotFoundException {
        signIn();
    }

    private void signIn() throws IOException, SQLException, ClassNotFoundException {

        String username = usernameField.getText();
        String password = passwordField.getText();

        if (username.isEmpty() || password.isEmpty()) {
            showErrorMessage("Please enter username and password!");
            return;
        }

        UserDTO user = userDao.searchUser(username, password);

        if (user != null) {
            userDao.updateUserStatus(user.getUser_id(),"Active");
            currentSession.setCurrentUser(user);


            subContentField.getChildren().clear();
            AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("/view/UserView.fxml"));
            anchorPane.prefHeightProperty().bind(subContentField.heightProperty());
            anchorPane.prefWidthProperty().bind(subContentField.widthProperty());
            subContentField.getChildren().add(anchorPane);

        } else {
            showErrorMessage("Invalid username or password!");
        }
    }

    private void showErrorMessage(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Login Error");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}