# Expenses tracker

## Technologies

- ### [Mongock](https://mongock.io/)

- ### [Spring Boot](https://spring.io/projects/spring-boot)

- ### [Spring Data MongoDB](https://spring.io/projects/spring-data-mongodb)

## Endpoints

- ### GET /api/expense

**Endpoint description:**

|               Response type | Controller method |    Description    | OK code |
|----------------------------:|:-----------------:|:-----------------:|:-------:|
| [Expense](#project-types)[] | getAllExpenses()  | Get all expenses  |   200   |

**Response example:**
```json
[
    {
        "id": "64bbe71c5686733de69370b9",
        "name": "Netflix",
        "category": "ENTERTAINMENT",
        "amount": 20
    },
    {
        "id": "64bbf18334eac8418631fc11",
        "name": "Movie Tickets",
        "category": "ENTERTAINMENT",
        "amount": 50
    },
    {
        "id": "64bbf18334eac8418631fc12",
        "name": "Dinner",
        "category": "RESTAURANT",
        "amount": 10
    },
    {
        "id": "64bbf18334eac8418631fc13",
        "name": "Netflix",
        "category": "ENTERTAINMENT",
        "amount": 30
    },
    {
        "id": "64bbf18334eac8418631fc14",
        "name": "Gym",
        "category": "MISC",
        "amount": 70
    },
    {
        "id": "64bbf18334eac8418631fc15",
        "name": "Internet",
        "category": "UTILITIES",
        "amount": 5
    }
]
```
<br/>

- ### POST /api/expense

**Endpoint description:**

| Controller method |        Request body        | Response body |   Description   | OK code |
|:-----------------:|:--------------------------:|:-------------:|:---------------:|:-------:|
|   addExpense()    | [Expense](#project-types)  |     Empty     | Add new expense |   201   |
<br/>

- ### PUT /api/expense

**Endpoint description:**

| Controller method |        Request body        | Response body |           Description            | OK code  | 
|:-----------------:|:--------------------------:|:-------------:|:--------------------------------:|:--------:|
|  updateExpense()  | [Expense](#project-types)  |     Empty     | Update expense by id in req body |   200    |
<br/>

- ### GET /api/expense/{name}

**Path variables:**

|       Name | Required |      Type       |     Description     | 
|-----------:|:--------:|:---------------:|:-------------------:|
|     `name` | required |     string      |   Name of expense   | 

**Endpoint description:**

| Controller method  |       Response body       |    Description    | OK code  |
|:------------------:|:-------------------------:|:-----------------:|:--------:|
| getExpenseByName() | [Expense](#project-types) | Get expense by id |   200    |

**Response example:**
<br/><br/>
***GET /api/expense/Internet***

```json
{
        "id": "64bbf18334eac8418631fc15",
        "name": "Internet",
        "category": "UTILITIES",
        "amount": 5
}
```
<br/>

- ### DELETE /api/expense/{id}

**Path variables:**

| Name | Required |      Type       |  Description  |
|-----:|:--------:|:---------------:|:-------------:|
| `id` | required |     string      | Id of expense |

**Endpoint description:**

| Controller method | Response body |    Description    | OK code  | 
|:-----------------:|:-------------:|:-----------------:|:--------:|
|  deleteExpense()  |     Empty     | Get expense by id |   204    |

# Project types

- ## Expense: 

|       Name |     Required     |      Type       |     Description     |
|-----------:|:----------------:|:---------------:|:-------------------:|
|       `id` | only in response |     string      |    Id of expense    |
|     `name` |     required     |     string      |   Name of expense   |
| `category` |     required     | ExpenseCategory | Category of expense |
|   `amount` |     required     |   BigDecimal    |   Expense amount    |

- ## Enum ExpenseCategory:

|      Field      | 
|:---------------:|
| `ENTERTAINMENT` | 
|   `GROCERIES`   | 
|  `RESTAURANT`   | 
|   `UTILITIES`   | 
|     `MISC`      | 
