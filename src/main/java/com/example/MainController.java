package com.example;

import java.util.List;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class MainController {

    @FXML
    private TextField editField;

    @FXML
    private ListView<String> todoList;

    @FXML
    private Label statusLabel;

    @FXML 
    void initialize() {
        System.out.println("init.....");
        List<String> todos = Store.readFile();
        todoList.getItems().addAll(todos);
    }

    @FXML
    void onClickDeleteButton(ActionEvent event) {
        int index = todoList.getSelectionModel().getSelectedIndex();
        todoList.getItems().remove(index);
        List<String> todos = todoList.getItems();
        Store.writeAllToFile(todos);
        statusLabel.setText("Törlés sikeres!");  
    }

    @FXML
    void onClickAddButton(ActionEvent event) {
        String newTodo = editField.getText();
        if (!newTodo.isEmpty()) {
        todoList.getItems().add(newTodo);
        Store.appendTodoToFile(newTodo);
        editField.setText("");
        statusLabel.setText("");
        }else {
            statusLabel.setText("Üres a szerkesztő mező!");
        }
    }

    @FXML
    void onClickModifyButton(ActionEvent event) {
        
    }

}
