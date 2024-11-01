## Running the Application
### 1. Run MongoDB locally

To run the application locally, ensure that MongoDB is running on port `27017`. You can start MongoDB using one of the following methods:

#### CLI
If you have MongoDB installed locally, you can start it by running:
```bash
mongod --dbpath /path/to/your/db/folder
```

#### Docker
If you prefer using Docker, you can start a MongoDB container with the following command:
```bash
docker run -d -p 27017:27017 --name mongodb mongo:latest
```

#### MongoDB Compass
If you prefer using a GUI, ensure that your local instance is running on `localhost:27017`. You can connect to the local database by entering `mongodb://localhost:27017` in the connection string field.

### 2. Activate Profiles

To switch from development to production environment, you can activate the appropriate profile by setting the `spring.profiles.active` property when running the application.
- **Development (default)**:
```bash
./gradlew bootRun
```
- **Production**:
```bash
./gradlew bootRun --args='--spring.profiles.active=prod'
```
This will load the corresponding `application.properties` or `application-prod.properties` file based on the active profile.

## Accessing the Documentation
Once the application is running, you can access the **Swagger UI** to explore and test the API endpoints. Open your web browser and navigate to:

```text
http://localhost:8080/swagger-ui.html
```
This will load the Swagger UI, where you can view and interact with all available API endpoints.

If you need to access the raw OpenAPI documentation in JSON format, you can visit:
```text
http://localhost:8080/v3/api-docs
```
This will provide a machine-readable version of the OpenAPI specification for your API.