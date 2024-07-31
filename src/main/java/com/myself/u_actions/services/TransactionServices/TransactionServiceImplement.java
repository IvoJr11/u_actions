package com.myself.u_actions.services.TransactionServices;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myself.u_actions.models.Transaction;
import com.myself.u_actions.repositories.TransactionRepository;

@Service
public class TransactionServiceImplement implements TransactionService {

  @Autowired
  TransactionRepository transactionRepository;

  @Override
  public List<Transaction> getAll() {
    return transactionRepository.findAll();
  }

  @Override
  public Transaction getTransactionByID(Long id) {
    return transactionRepository.findById(id).get();
  }

  @Override
  public void saveTransaction(Transaction transaction) {
    transactionRepository.save(transaction);
  }

  @Override
  public void deleteTransaction(Long id) {
    transactionRepository.deleteById(id);
  }

}
