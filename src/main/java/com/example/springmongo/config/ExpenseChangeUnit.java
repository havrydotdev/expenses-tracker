package com.example.springmongo.config;

import com.example.springmongo.model.Expense;
import com.example.springmongo.model.ExpenseCategory;
import io.mongock.api.annotations.*;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static com.example.springmongo.model.ExpenseCategory.*;

@ChangeUnit(id="expenseChangeUnit", order="1", author="github.com/gavrylenkoIvan")
public class ExpenseChangeUnit {
    private final MongoTemplate template;

    private List<Expense> expenseList;

    public ExpenseChangeUnit(MongoTemplate template) {
        this.template = template;
        this.expenseList = new ArrayList<>() {{
            add(createNewExpense("Movie Tickets", ENTERTAINMENT, BigDecimal.valueOf(50)));
            add(createNewExpense("Dinner", RESTAURANT, BigDecimal.valueOf(10)));
            add(createNewExpense("Netflix", ENTERTAINMENT, BigDecimal.valueOf(30)));
            add(createNewExpense("Gym", MISC, BigDecimal.valueOf(70)));
            add(createNewExpense("Internet", UTILITIES, BigDecimal.valueOf(5)));
        }};
    }

    @RollbackBeforeExecution
    public void before() {
        template.remove(new Expense());
    }

    @Execution
    public void migrationMethod() {
        expenseList
                .forEach(template::insert);
    }

    @RollbackExecution
    public void rollback() {
        template.remove(new Expense());
    }

    private Expense createNewExpense(String expenseName, ExpenseCategory expenseCategory, BigDecimal amount) {
        Expense expense = new Expense();
        expense.setExpenseCategory(expenseCategory);
        expense.setExpenseName(expenseName);
        expense.setAmount(amount);
        return expense;
    }
}
