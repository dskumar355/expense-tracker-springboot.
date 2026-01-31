package com.expense.expensetracker.service;

import com.expense.expensetracker.model.Expense;
import com.expense.expensetracker.repository.ExpenseRepository;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class ExpenseService {

    private final ExpenseRepository repo;

    public ExpenseService(ExpenseRepository repo) {
        this.repo = repo;
    }

    public Expense save(Expense e) {
        return repo.save(e);
    }

    public List<Expense> getAll() {
        return repo.findAll();
    }

    public Expense update(Long id, Expense e) {
        Expense existing = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Expense not found"));

        existing.setTitle(e.getTitle());
        existing.setCategory(e.getCategory());
        existing.setAmount(e.getAmount());
        existing.setExpenseDate(e.getExpenseDate());

        return repo.save(existing);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }

    public List<Object[]> categorySummary() {
        return repo.categorySummary();
    }

    public List<Object[]> monthlySummary() {
        return repo.monthlySummary();
    }
}
