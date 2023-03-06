package com.example.mergiterog.Controller;

import com.example.mergiterog.HelloApplication;
import com.example.mergiterog.domain.CurrentUser;
import com.example.mergiterog.domain.User;
import com.example.mergiterog.service.ServiceUser;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.util.Objects;

public class LoginAccountController {

    ServiceUser serviceUser = ServiceUser.getInstance();

    private String userMail;
    private String userPassword;

    @FXML private Button loginButton, closeButton;
    @FXML private Button createAccount;
    @FXML private TextField userMailTextField;
    @FXML private PasswordField passwordPasswordField;
    @FXML private Label loginMassageLabel;

    public void login() throws IOException {

        userMail = userMailTextField.getText();
        userPassword = passwordPasswordField.getText();

        for (User user : serviceUser.getAll())
        {

            if (userMailTextField.getText().isBlank() || passwordPasswordField.getText().isBlank())
            {
                loginMassageLabel.setText("Plese enter username and password. ");
            }
            else
            { if (Objects.equals(user.getEmail(), userMail) && Objects.equals(user.getParola(), userPassword))
                {
                CurrentUser.getInstance().setUser(user);
                loginMassageLabel.setText("Succes!");
                FXMLLoader fxmlLoader1 = new FXMLLoader(HelloApplication.class.getResource("userAccountInterface.fxml"));
                Scene scene1 = new Scene(fxmlLoader1.load());
                Stage stage = new Stage();
                stage.setScene(scene1);
                UserAccountController userAccount = fxmlLoader1.getController();
                userAccount.setService(serviceUser);
                stage.show();
                break;
                }
                else
                    loginMassageLabel.setText("This account doesn't exist! Create one!" );
            }

        }

    }



    public void onClickCreateAccount(){
        try{
            FXMLLoader fxmlLoader1 = new FXMLLoader(HelloApplication.class.getResource("createAccount.fxml"));
            Scene scene1 = new Scene(fxmlLoader1.load());
            Stage stage = new Stage();
            stage.initStyle(StageStyle.UNDECORATED);
            stage.setScene(scene1);
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public void closeButtonAction(ActionEvent event)
    {
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
    }




}
