
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

### Step 3: Create a New User (Optional)
To create a new user, run:

```sql
CREATE USER my_user WITH PASSWORD 'my_password';
```

### Step 4: Grant Privileges (Optional)
Grant the necessary privileges to the new user:

```sql
GRANT ALL PRIVILEGES ON DATABASE my_database TO my_user;
```

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