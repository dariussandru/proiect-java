package com.example.mergiterog.Controller;

import com.example.mergiterog.domain.User;
import com.example.mergiterog.service.ServiceUser;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class CreateAccountController {

    @FXML private TextField firstNameCreateAccount;
    @FXML private TextField lastNameCreateAccount;
    @FXML private TextField mailCreateAccount;
    @FXML private PasswordField passwordCreateAccount;
    @FXML private PasswordField confirmPasswordCreateAccount;
    @FXML private Label lableMassageCreateAccount;
    @FXML private Button closeButton ;
    @FXML private Button CancelButtonCreateAccount;

    @FXML
    protected void createAccount() {
            Integer ID     = ServiceUser.getInstance().getId() + 1;
            String nume    = firstNameCreateAccount.getText();
            String prenume = lastNameCreateAccount.getText();
            String email   = mailCreateAccount.getText();
            String parola  = passwordCreateAccount.getText();

            if (firstNameCreateAccount.getText().isBlank())
            {
                lableMassageCreateAccount.setText("Enter the first name!");
            }
            else if (lastNameCreateAccount.getText().isBlank())
            {
                lableMassageCreateAccount.setText("Enter the last name!");
            }
            else if (mailCreateAccount.getText().isBlank())
            {
                lableMassageCreateAccount.setText("Enter the mail!");
            }
            else if (passwordCreateAccount.getText().isBlank())
            {
                lableMassageCreateAccount.setText("Enter the password!");
            }
            else {
                if (Objects.equals(passwordCreateAccount.getText(), confirmPasswordCreateAccount.getText())) {
                    ServiceUser.getInstance().addElem(new User(ID, nume, prenume, email, parola));
                    lableMassageCreateAccount.setText("Account created succesfully!");
                } else {
                    lableMassageCreateAccount.setText("Password do not match. Try again!");
                }
            }

    }


    public void closeButtonAction(ActionEvent event)
    {
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
    }
    public void cancelButtonAction(ActionEvent event)
    {
        Stage stage = (Stage) CancelButtonCreateAccount.getScene().getWindow();
        stage.close();
    }
}
