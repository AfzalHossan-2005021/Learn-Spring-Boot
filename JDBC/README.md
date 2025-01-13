# Adding pgJDBC in IntelliJ IDEA

## Steps

1. **Open Your Project in IntelliJ IDEA**
   - Launch IntelliJ IDEA and open your project.

2. **Add the PostgreSQL JDBC Dependency**

   - Go to [Download | pgJDBC](https://jdbc.postgresql.org/download/).
   - Download the latest version.
   - From `File` menu of your project select `Project Structure...`.
   - From `Project Settings` select `Libraries`.
   - Click the `+`(New Project Library) button or press `alt` + `insert` and select  `Java`.
   - Then select the previously downloaded `.jar` file.

3. **Verify the Dependency**
   - Go to **File > Project Structure > Modules > Dependencies**.
   - Ensure that the PostgreSQL JDBC driver is listed under your dependencies.

4. **Connect to PostgreSQL**
   - Use the `DriverManager` class or your preferred database connection method in your code. Here's a sample project.
   - SQL commands are as follow:
   ```sql
   CREATE DATABASE my_database;
   ```
   ```sql
   CREATE TABLE my_table (
    id SERIAL PRIMARY KEY,
    name VARCHAR(128),
    type VARCHAR(32),
    place VARCHAR(256),
    warranty INT
   );
   ```
   ```sql
   INSERT INTO my_table (name, type, place, warranty) VALUES ('Anup', 'Laptop', 'Gopalging', 2030);
   ```
   ```sql
   INSERT INTO my_table (name, type, place, warranty) VALUES ('Afzal', 'Phone', 'Feni', 2028);
   ```
   ```sql
   INSERT INTO my_table (name, type, place, warranty) VALUES ('Asif', 'iPad', 'Dhaka', 2026);
   ```
   ```sql
    SELECT * FROM my_table;
    ```

5. **Run and Test**
   - Run your application to ensure the PostgreSQL JDBC driver is correctly configured and working.

---

## Resources
- [PostgreSQL JDBC Driver Documentation](https://jdbc.postgresql.org/)
