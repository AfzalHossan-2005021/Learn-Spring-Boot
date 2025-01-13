
# PostgreSQL Installation Guide for Linux

This guide provides instructions for installing PostgreSQL on a Linux system.

## Table of Contents

1. [Prerequisites](#prerequisites)
2. [Installation](#installation)
3. [Post-installation Setup](#post-installation-setup)
4. [Troubleshooting](#troubleshooting)

---

## Prerequisites

- Linux distribution - Ubuntu.
- Sudo privileges.

---

## Installation

### Step 1: Update Package Lists
Run the following command to update your system's package lists:

```bash
sudo apt-get update
```

### Step 2: Install PostgreSQL
Install PostgreSQL and its contrib package (provides additional features):

```bash
sudo apt-get install postgresql postgresql-contrib
```

### Step 3: Start PostgreSQL Service
After installation, PostgreSQL should start automatically. To verify or start the service manually, use:

```bash
sudo systemctl start postgresql
```

To enable PostgreSQL to start on boot:

```bash
sudo systemctl enable postgresql
```

### Step 4: Verify Installation
Check the status of PostgreSQL to confirm it is running:

```bash
sudo systemctl status postgresql
```

You should see output indicating that the service is active and running.

---

## Post-installation Setup

### Step 1: Access PostgreSQL
To access the PostgreSQL command line as the default `postgres` user, run:

```bash
sudo -u postgres psql
```

To set password for `postgres` user:
```bash
\password postgres
```

### Step 2: Create a New Database (Optional)
To create a new database, use the following SQL command inside `psql`:

```sql
CREATE DATABASE my_database;
```

Check the whether the databse is created:

```bash
\l+
```

You should see a table containing all databases. Press q to exit the list.

To connect to the database:
```bash
\c my_database
```
Now you can you do all available operations on the database.

To disconnect databse:
```bash
\q
```

To drop database:
```sql
DROP DATABASE IF EXISTS my_database;
```

### Step 3: Create a New User (Optional)
To create a new user, run:

```sql
CREATE USER my_user WITH PASSWORD 'my_password';
```

To check whether the user is created or not:
```bash
\du+
```

To drop user:
```sql
DROP USER IF EXISTS my_user;
```

### Step 4: Grant Privileges (Optional)
Grant the necessary privileges to the new user:

```sql
GRANT ALL PRIVILEGES ON DATABASE my_database TO my_user;
```

### Step 4: Install pgAdmin (Optional)
Run following commands one by one:
```bash
curl -fsS https://www.pgadmin.org/static/packages_pgadmin_org.pub | sudo gpg --dearmor -o /usr/share/keyrings/packages-pgadmin-org.gpg
```
```bash
sudo sh -c 'echo "deb [signed-by=/usr/share/keyrings/packages-pgadmin-org.gpg] https://ftp.postgresql.org/pub/pgadmin/pgadmin4/apt/$(lsb_release -cs) pgadmin4 main" > /etc/apt/sources.list.d/pgadmin4.list && apt update'
```
```bash
sudo apt install pgadmin4
```
```bash
sudo /usr/pgadmin4/bin/setup-web.sh
```
The commands are available [here](https://www.pgadmin.org/download/pgadmin-4-apt/).  

Adding a New Server in pgAdmin -

1. **Open pgAdmin Application**
   - Launch the pgAdmin application on your system.

2. **Add a New Server**
   - Go to the **`Object`** menu in the top navigation bar.
   - Expand **`Register`** and select **`Server...`**.

3. **Configure the New Server**
   - In the **`General`** tab:
     - Provide a name for your server in the **`Name`** field (e.g., "Local PostgreSQL").
   - In the **`Connection`** tab:
     - Set the **`Host name/address`** field to **`localhost`**.
     - Enter the password for the `postgres` user in the **`Password`** field. If password is not configured, follow [step 1](#step-1-access-postgresql).

4. **Save the Configuration**
   - Click **`Save`** to add the server.

Once configured, the newly added server will appear in the left-hand browser panel of pgAdmin. Expand it to view and manage your databases!


---

## Troubleshooting

### Error: PostgreSQL service not starting
If PostgreSQL does not start, check the logs to identify the issue:

```bash
sudo journalctl -u postgresql
```

### Error: Could not connect to server
Ensure the PostgreSQL service is running:

```bash
sudo systemctl status postgresql
```

---

For more information, consult the [PostgreSQL Documentation](https://www.postgresql.org/docs/).