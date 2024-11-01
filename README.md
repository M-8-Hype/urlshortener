## 1. Run MongoDB locally

To run the application locally, ensure that MongoDB is running on port `27017`. You can start MongoDB using one of the following methods:

### 1. CLI
If you have MongoDB installed locally, you can start it by running:
```bash
mongod --dbpath /path/to/your/db/folder
```

### 2. Docker
If you prefer using Docker, you can start a MongoDB container with the following command:
```bash
docker run -d -p 27017:27017 --name mongodb mongo:latest
```

### 3. MongoDB Compass
If you prefer using a GUI, ensure that your local instance is running on `localhost:27017`. You can connect to the local database by entering `mongodb://localhost:27017` in the connection string field.

## 2. Activate Profiles

To switch between development and production environments, you can activate the appropriate profile by setting the `spring.profiles.active` property when running the application.
- **Development**:
```bash
./gradlew bootRun --args='--spring.profiles.active=dev'
```
- **Production**:
```bash
./gradlew bootRun --args='--spring.profiles.active=prod'
```
This will load the corresponding application-dev.properties or application-prod.properties file based on the active profile.