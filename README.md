# Maven Sample

1. Test project
   ```bash
   mvn clean test
   ```
2. Build project
    ```bash
    mvn clean package
    ```
3. Run project
    ```bash
    java -jar target/maven-sample-1.0-SNAPSHOT.jar
    ```
4. Verify project
   ```bash
   curl localhost:6666/greeting
   ```