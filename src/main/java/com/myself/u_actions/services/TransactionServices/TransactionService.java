package com.myself.u_actions.services.TransactionServices;

import java.util.List;

import com.myself.u_actions.models.Transaction;

public interface TransactionService {
  List<Transaction> getAll();
  Transaction getTransactionByID(Long id);
  void saveTransaction(Transaction transaction);
  void deleteTransaction(Long id);
}
