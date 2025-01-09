
# PostgreSQL CRUD Operations Guide

This guide provides common Create, Read, Update, and Delete (CRUD) operations in PostgreSQL.

## Table of Contents

1. [Create Operations](#create-operations)
2. [Read Operations](#read-operations)
3. [Update Operations](#update-operations)
4. [Delete Operations](#delete-operations)

---

## Create Operations

### 1.1 Create a New Database
To create a new database:

```sql
CREATE DATABASE my_database;
```

### 1.2 Create a New Table
To create a new table:

```sql
CREATE TABLE my_table (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100),
    age INT
);
```

To check whether the table is created:
```bash
\dt
```

You will see a list of all tables.

### 1.3 Insert Data into a Table
To insert data into a table:

```sql
INSERT INTO my_table (name, age) VALUES ('John Doe', 25);
```

---

## Read Operations

### 2.1 Select All Data from a Table
To select all records from a table:

```sql
SELECT * FROM my_table;
```

### 2.2 Select Specific Columns from a Table
To select specific columns from a table:

```sql
SELECT name, age FROM my_table;
```

### 2.3 Select Data with Conditions
To select data with a condition:

```sql
SELECT * FROM my_table WHERE age > 20;
```

### 2.4 Select Data with Sorting
To select data with sorting:

```sql
SELECT * FROM my_table ORDER BY age DESC;
```

---

## Update Operations

### 3.1 Update a Single Record
To update a single record:

```sql
UPDATE my_table SET age = 30 WHERE name = 'John Doe';
```

### 3.2 Update Multiple Records
To update multiple records:

```sql
UPDATE my_table SET age = age + 1 WHERE age < 30;
```

---

## Delete Operations

### 4.1 Delete a Single Record
To delete a single record:

```sql
DELETE FROM my_table WHERE name = 'John Doe';
```

### 4.2 Delete All Records
To delete all records from a table (but not the table itself):

```sql
DELETE FROM my_table;
```

### 4.3 Drop a Table
To delete the table entirely:

```sql
DROP TABLE my_table;
```

---

For more information on PostgreSQL operations, consult the [PostgreSQL Documentation](https://www.postgresql.org/docs/).