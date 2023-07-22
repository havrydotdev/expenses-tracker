# Spring boot CRUD application

## Technologies

- ### [Mongock](https://mongock.io/)

- ### [Spring Boot](https://spring.io/projects/spring-boot)

- ### [Spring Data MongoDB](https://spring.io/projects/spring-data-mongodb)

## Endpoints

- ### GET /api/expense

**Route description:**

| Response type | Controller method |
|--------------:|:-----------------:|
| List<Expense> | getAllExpenses()  |

**Response example:**
```json
[
    {
        "id": "64bbe71c5686733de69370b9",
        "expenseName": "Netflix",
        "expenseCategory": "ENTERTAINMENT",
        "amount": 20
    },
    {
        "id": "64bbf18334eac8418631fc11",
        "expenseName": "Movie Tickets",
        "expenseCategory": "ENTERTAINMENT",
        "amount": 50
    },
    {
        "id": "64bbf18334eac8418631fc12",
        "expenseName": "Dinner",
        "expenseCategory": "RESTAURANT",
        "amount": 10
    },
    {
        "id": "64bbf18334eac8418631fc13",
        "expenseName": "Netflix",
        "expenseCategory": "ENTERTAINMENT",
        "amount": 30
    },
    {
        "id": "64bbf18334eac8418631fc14",
        "expenseName": "Gym",
        "expenseCategory": "MISC",
        "amount": 70
    },
    {
        "id": "64bbf18334eac8418631fc15",
        "expenseName": "Internet",
        "expenseCategory": "UTILITIES",
        "amount": 5
    }
]
```

- ### POST /api/expense

| Response type | Controller method | 
|--------------:|:-----------------:|
|       -       |   addExpense()    | 