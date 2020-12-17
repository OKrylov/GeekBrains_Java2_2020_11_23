package lesson4.homework;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;

import java.util.ArrayList;

public class ViewController {

    @FXML
    public ListView<String> usersList;

    @FXML
    private Button sendButton;
    @FXML
    private TextArea chatHistory;
    @FXML
    private TextField textField;

    @FXML
    public void initialize() {
        usersList.setItems(FXCollections.observableArrayList(Main.USERS_TEST_DATA));
        usersList.getSelectionModel().selectedItemProperty().addListener((observableValue, selectionMode, t1) -> {
            System.out.println(t1);
        });

        usersList.setOnMouseClicked(click -> {

            if (click.getClickCount() == 2) {
                //Use ListView's getSelected Item
                String selectedItem = usersList.getSelectionModel().getSelectedItem();
                usersList.getItems().remove(selectedItem);
                //use this to do whatever you want to. Open Link etc.
            }
        });

//        sendButton.setOnAction(event -> sendMessage());
//        textField.setOnAction(event -> sendMessage());
    }

    @FXML
    private void sendMessage() {
        String message = textField.getText();
        chatHistory.appendText(message);
        chatHistory.appendText(System.lineSeparator());

        usersList.getItems().add(message);
        textField.clear();


    }

}