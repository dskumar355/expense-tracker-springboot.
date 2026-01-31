package com.expense.expensetracker.repository;

import com.expense.expensetracker.model.Expense;
import org.springframework.data.jpa.repository.*;
import java.util.*;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {

    @Query("SELECT e.category, SUM(e.amount) FROM Expense e GROUP BY e.category")
    List<Object[]> categorySummary();

    @Query("""
        SELECT MONTH(e.expenseDate), SUM(e.amount)
        FROM Expense e
        GROUP BY MONTH(e.expenseDate)
    """)
    List<Object[]> monthlySummary();
}
