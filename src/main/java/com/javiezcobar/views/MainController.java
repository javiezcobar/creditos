package com.javiezcobar.views;


import com.javiezcobar.domain.Transaction;
import com.javiezcobar.repositories.AddressRepository;
import com.javiezcobar.repositories.LoanRepository;
import com.javiezcobar.repositories.TransactionRepository;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

@Component
public class MainController implements Initializable {
    @Autowired
    private TransactionRepository transactionRepository;
    @FXML
    private TableView<Transaction> tableTransaction;
    @FXML
    private TableColumn<Transaction, LocalDate> tableTransactionDate;
    @FXML
    private TableColumn<Transaction, String> tableTransactionDescription;
    @FXML
    private TableColumn<Transaction, Double> tableTransactionAmount;
    @FXML
    private TableColumn<Transaction, Boolean> tableTransactionType;
    private ObservableList<Transaction> observableList = FXCollections.observableArrayList();


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.println(transactionRepository.findAll().isEmpty());
    }



}
