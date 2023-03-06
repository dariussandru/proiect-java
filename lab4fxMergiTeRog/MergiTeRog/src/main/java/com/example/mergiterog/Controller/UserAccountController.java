package com.example.mergiterog.Controller;

import com.example.mergiterog.domain.CurrentUser;
import com.example.mergiterog.domain.Friendship;
import com.example.mergiterog.domain.User;
import com.example.mergiterog.service.ServiceFriendship;
import com.example.mergiterog.service.ServiceUser;
import com.example.mergiterog.Controller.LoginAccountController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.time.Instant;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;


public class UserAccountController implements Initializable {

    ServiceUser serviceUser = ServiceUser.getInstance();
    ServiceFriendship serviceFriendship = ServiceFriendship.getInstance();

    private ObservableList<User> model = FXCollections.observableArrayList();


    @FXML Label nameUserAccount;
    @FXML Label messageLable;
    @FXML TextField textFieldUser1;
    @FXML TextField textFieldUser2;
    @FXML TableView<User> tabelViewAllUsers ;
    @FXML TableColumn<User, Integer> tableColumnC1 ;
    @FXML TableColumn<User, String> tableColumnC2 ;
    @FXML TableColumn<User, String> tableColumnC3 ;
    @FXML TableColumn<User, String> tableColumnC4 ;


    public void setService(ServiceUser service){
        this.serviceUser = service;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        nameUserAccount.setText(CurrentUser.getInstance().getUser().getNume()+" "+CurrentUser.getInstance().getUser().getPrenume());

        for (User user : serviceUser.getAll()) {
            tableColumnC2.setCellValueFactory(new PropertyValueFactory<User, String>("nume"));
            tableColumnC3.setCellValueFactory(new PropertyValueFactory<User, String>("prenume"));
            tableColumnC4.setCellValueFactory(new PropertyValueFactory<User, String>("email"));


        }
    }

   @FXML
   public void setFriendButton()
   {
       int user1 = Integer.parseInt(textFieldUser1.getText());
       int user2 = Integer.parseInt(textFieldUser2.getText());
       int id = serviceFriendship.getId()+1;
       messageLable.setText("merge");
       Friendship friendship = new Friendship(id,user1,user2,"acceptat","12");
       ServiceFriendship.getInstance().addElem(friendship);

   }



}
