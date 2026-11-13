package com.example;

import java.util.List;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class MainController {

    @FXML
    private TextField editField;

    @FXML
    private ListView<String> todoList;

    @FXML 
    void initialize() {
        System.out.println("init.....");
        List<String> todos = Store.readFile();
        todoList.getItems().addAll(todos);
    }

    @FXML
    void onActionDeleteButton(ActionEvent event) {

    }

    @FXML
    void onClickAddButton(ActionEvent event) {

    }

    @FXML
    void onClickModifyButton(ActionEvent event) {

    }

}
