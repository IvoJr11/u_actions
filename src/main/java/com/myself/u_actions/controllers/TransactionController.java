package com.myself.u_actions.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

import com.myself.u_actions.dtos.CreateTransactionDTO;
import com.myself.u_actions.models.Transaction;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.myself.u_actions.services.TransactionServices.TransactionService;


@RestController
@RequestMapping("/api/transaction")
public class TransactionController {
  @Autowired
  TransactionService transactionService;

  @GetMapping("/all")
  public ResponseEntity<List<Transaction>> getAll() {
    return ResponseEntity.ok(transactionService.getAll());
  }

  @GetMapping("/{id}")
  public ResponseEntity<Object> getTransactionById(@PathVariable Long id) {
    if(id <= 0 | id == null) {
      return new ResponseEntity<>("ID cannot be 0 or negative", HttpStatus.BAD_REQUEST);
    }
    return new ResponseEntity<>(transactionService.getTransactionByID(id), HttpStatus.OK);
  }
  
  @PostMapping("/create")
  public ResponseEntity<Object> createTransaction(@RequestBody CreateTransactionDTO transactionDTO) {
    if(transactionDTO.getStockQuantity() <= 0) {
      return new ResponseEntity<>("Stock quantity cannot be 0 or negative", HttpStatus.BAD_REQUEST);
    }
    if(transactionDTO.getPrice() <= 0) {
      return new ResponseEntity<>("Price cannot be 0 or negative", HttpStatus.BAD_REQUEST);
    }
    if(transactionDTO.getOrder() == null) {
      return new ResponseEntity<>("Order cannot be empty", HttpStatus.BAD_REQUEST);
    }
    Transaction transaction = new Transaction(transactionDTO.getStockQuantity(), transactionDTO.getPrice(), transactionDTO.getOrder());
    transactionService.saveTransaction(transaction);
    return new ResponseEntity<>("Transaction has been created successfully", HttpStatus.CREATED);
  }

  @DeleteMapping("/delete/{id}")
  public ResponseEntity<Object> deleteTransaction(@PathVariable Long id) {
    if(id <= 0 | id == null) {
      return new ResponseEntity<>("ID cannot be 0 or negative", HttpStatus.BAD_REQUEST);
    }
    transactionService.deleteTransaction(id);
    return new ResponseEntity<>("Transaction deleted successfully", HttpStatus.OK);
  }
}
