
# **Storing and Using a Personal Access Token (PAT) for Git**

GitHub no longer supports password-based authentication for HTTPS. Instead, you can use a **Personal Access Token (PAT)** to authenticate securely.

---

## **Steps to Store and Use a PAT**

### **1. Generate a Personal Access Token (PAT)**
1. Go to [GitHub Developer Settings](https://github.com/settings/tokens).
2. Click **"Generate new token"** (classic).
3. Select the required scopes. For basic Git operations:
   - `repo` (for private repositories)
   - `workflow` (optional, for GitHub Actions)
4. Copy the generated token and save it in a secure location (you won’t see it again).

---

### **2. Store the PAT Using Git Credential Helper**
Git’s credential helper can securely store your token for future use.

#### **Steps to Enable Credential Storage:**
1. Open your terminal and run:
   ```bash
   git config --global credential.helper store
   ```

2. Authenticate with your PAT:
   - Use any Git command that requires authentication, such as:
     ```bash
     git clone https://github.com/<username>/<repository>.git
     ```
   - When prompted:
     - **Username**: Enter your GitHub username.
     - **Password**: Paste your **PAT**.

3. Git will now save the token in a local file, typically:
   - **Linux/Mac**: `~/.git-credentials`
   - **Windows**: `C:\Users\<YourUser>\.git-credentials`

---

### **3. Verify Stored Credentials**
You can check if your credentials were saved:
```bash
cat ~/.git-credentials
```

You should see something like:
```
https://<username>:<personal-access-token>@github.com
```

---

### **4. Secure the Stored Credentials**
Ensure the `.git-credentials` file is secure by setting appropriate permissions:
```bash
chmod 600 ~/.git-credentials
```

---

### **5. Using Your PAT in Git Commands**
Once stored, Git will automatically use the PAT for all HTTPS operations. For example:
```bash
git clone https://github.com/<username>/<repository>.git
git pull
git push
```

You won’t be prompted for the PAT again.

---

## **Important Notes**
- **Token Expiration**: If your PAT expires, regenerate a new one and repeat the steps above.
- **Security**: Avoid sharing or exposing your PAT in public repositories or logs.

For more details, check out the [GitHub documentation](https://docs.github.com/en/authentication).
