# unir-devops-fintech-back

### MySQL Docker volume
```bash
docker volume create mysql-data
```

### Fintech Docker Network
```bash
docker network create fintech
```

### MySQL Docker Command
```bash
docker run --name mysql-db \
  --network fintech \
  -e MYSQL_ROOT_PASSWORD=root \
  -e MYSQL_DATABASE=fintech \
  -e MYSQL_USER=devuser \
  -e MYSQL_PASSWORD=devpass \
  -v mysql-data:/var/lib/mysql \
  -p 3306:3306 \
  -d mysql:latest
```

### Fintech API Docker Command
```bash
docker run --name fintech-api  \
  --network fintech \
  -e MYSQL_DB_URL=jdbc:mysql://mysql-db:3306/fintech \
  -e MYSQL_DB_USER=devuser \
  -e MYSQL_DB_PASS=devpass \
  -p 8080:8080 \
  -d fintech-api:latest
```
