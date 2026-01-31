package com.expense.expensetracker.model;

import java.time.LocalDate;
import jakarta.persistence.*;

@Entity
@Table(name = "expense")
public class Expense {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String category;
    private Double amount;
    private LocalDate expenseDate;

    public Expense() {}

    public Long getId() { return id; }
    public String getTitle() { return title; }
    public String getCategory() { return category; }
    public Double getAmount() { return amount; }
    public LocalDate getExpenseDate() { return expenseDate; }

    public void setId(Long id) { this.id = id; }
    public void setTitle(String title) { this.title = title; }
    public void setCategory(String category) { this.category = category; }
    public void setAmount(Double amount) { this.amount = amount; }
    public void setExpenseDate(LocalDate expenseDate) { this.expenseDate = expenseDate; }
}

