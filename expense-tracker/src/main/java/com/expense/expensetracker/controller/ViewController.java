package com.expense.expensetracker.controller;

import com.expense.expensetracker.model.Expense;
import com.expense.expensetracker.service.ExpenseService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ViewController {

    private final ExpenseService service;

    public ViewController(ExpenseService service) {
        this.service = service;
    }

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("expenses", service.getAll());
        model.addAttribute("expense", new Expense());
        return "expenses";
    }

    @PostMapping("/add")
    public String addExpense(Expense expense) {
        service.save(expense);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deleteExpense(@PathVariable Long id) {
        service.delete(id);
        return "redirect:/";
    }
}
