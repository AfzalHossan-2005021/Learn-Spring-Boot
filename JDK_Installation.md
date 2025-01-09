# Installing Java Development Kit (JDK)

This guide provides step-by-step instructions for installing the Java Development Kit (JDK) on Ubuntu 24.04 LTS.

## Prerequisites

- Administrative privileges on your system.
- Internet connection.

## Installation Instructions

1. **Check Your System Architecture**:
   ```bash
   uname -m
   ```

2. **Download JDK**:
   - Visit the [Oracle JDK Downloads page](https://www.oracle.com/bd/java/technologies/downloads/#java21).
   - Copy the download link for the `.deb` package that matches your system architecture.

3. **Download the JDK Package**:
   ```bash
   wget https://download.oracle.com/java/21/latest/jdk-21_linux-x64_bin.deb
   ```

4. **Install the Package**:
   ```bash
   sudo dpkg -i sudo dpkg -i jdk-21_linux-x64_bin.deb
   ```

5. **Verify Installation**:
   ```bash
   java -version
   ```
   - You should see the installed JDK version.

## Additional Resources

- [Official Oracle JDK Documentation](https://docs.oracle.com/en/java/)
- [OpenJDK Documentation](https://openjdk.org/)

Feel free to reach out if you encounter any issues during the installation process!
