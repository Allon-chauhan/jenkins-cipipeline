# 🚀 Creating a CI Pipeline with Jenkinsfile

## 🛠️ Technologies Used:
1. **Jenkins** 🏗️
2. **Docker** 🐳
3. **DockerHub Repository** 📦
4. **Linux** 🐧
5. **Git** 🔗
6. **Java** ☕
7. **Maven** 🔧
8. **Groovy** 🎭

---

## ✅ Prerequisites:
1. Download Java Maven source code from [here](https://github.com/Allon-chauhan/artifact-manager-nexus.git).

---

## ⚙️ Setting Up and Configuring Jenkins on Local Computer
1. **Run Jenkins as a Docker container:**
   ```bash
   docker run -d -p 8080:8080 -p 50000:50000 \
   -v jenkins_home:/var/jenkins_home \
   -v /var/run/docker.sock:/var/run/docker.sock \
   jenkins/jenkins:lts
   ```
2. **Log in as root inside the container:**
   ```bash
   docker exec -u 0 -it [container ID] bash
   ```
3. **Change permissions for the Docker socket:**
   ```bash
   chmod 666 /var/run/docker.sock
   ```
4. **Retrieve the temporary Jenkins admin password:**
   ```bash
   cat /var/jenkins_home/secrets/initialAdminPassword
   ```
5. **Access Jenkins via browser:**
   ```
   http://localhost:8080/
   ```
6. **Create an Admin user and set up Jenkins.**

---

## 🔨 Installing Build Tools in Jenkins - Maven
1. Go to **Manage Jenkins** → **Global Tool Configuration**.
2. Under **Maven**, select **Install Automatically from Apache**.
3. Name it **maven-3.9.9** for reference.

---

## 🔐 Creating Jenkins Credentials for Git Repository
1. Navigate to **Manage Jenkins** → **Credentials**.
2. **Create a system global credential**:
   - **Kind:** Username and Password
   - **Provide GitHub/GitLab username and password**
   - **Set an ID for reference**
3. **Create another credential for DockerHub credentials** following the same process.

---

## 📜 Creating a Jenkins Pipeline for Java Maven Project with Jenkinsfile
1. From **New Item**, select **Pipeline**.
2. Click **Configure**.
3. Under **Pipeline**:
   - Set **Definition** to **Pipeline script from SCM**.
   - Set **SCM** to **Git**.
   - Provide **Git repository URL** and credentials from the created global credentials.
   - Set **Branch Specifier** to `master`.
   - Set **Script Path** to `Jenkinsfile` (as it will define the pipeline stages).

---

## 📝 Defining Jenkinsfile and Groovy File
- **`Jenkinsfile`** will contain the pipeline stages.
- **`script.groovy`** will define helper functions and scripts used in the pipeline.

🚀 **Jenkins CI Pipeline is now ready!** 🎉
