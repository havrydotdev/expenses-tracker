package com.example.springmongo;
import static com.example.springmongo.model.ExpenseCategory.*;
import static com.example.springmongo.model.ExpenseCategory.UTILITIES;
import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.example.springmongo.controller.ExpenseController;
import com.example.springmongo.model.Expense;
import com.example.springmongo.model.ExpenseCategory;
import com.example.springmongo.service.ExpenseService;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.util.ArrayList;

@WebMvcTest(ExpenseController.class)
@TestPropertySource(locations="classpath:test.properties")
public class WebMockTest {
    private static String getAllExpensesExpectedResult = "[{\"id\":null,\"name\":\"Movie Tickets\",\"category\":\"ENTERTAINMENT\",\"amount\":50},{\"id\":null,\"name\":\"Dinner\",\"category\":\"RESTAURANT\",\"amount\":10},{\"id\":null,\"name\":\"Netflix\",\"category\":\"ENTERTAINMENT\",\"amount\":30},{\"id\":null,\"name\":\"Gym\",\"category\":\"MISC\",\"amount\":70},{\"id\":null,\"name\":\"Internet\",\"category\":\"UTILITIES\",\"amount\":5}]";

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ExpenseService service;

    @Test
    public void getAllExpensesOKTest() throws Exception {
        when(service.getAllExpenses()).thenReturn(new ArrayList<>() {{
            add(createNewExpense("Movie Tickets", ENTERTAINMENT, BigDecimal.valueOf(50)));
            add(createNewExpense("Dinner", RESTAURANT, BigDecimal.valueOf(10)));
            add(createNewExpense("Netflix", ENTERTAINMENT, BigDecimal.valueOf(30)));
            add(createNewExpense("Gym", MISC, BigDecimal.valueOf(70)));
            add(createNewExpense("Internet", UTILITIES, BigDecimal.valueOf(5)));
        }});

        this.mockMvc.perform(get("/api/expense")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString(getAllExpensesExpectedResult)));
    }

    private Expense createNewExpense(String expenseName, ExpenseCategory expenseCategory, BigDecimal amount) {
        Expense expense = new Expense();
        expense.setCategory(expenseCategory);
        expense.setName(expenseName);
        expense.setAmount(amount);
        return expense;
    }
}
