# unir-devops-fintech-back

### MySQL Docker Command
```bash
docker run --name mysql-db -e MYSQL_ROOT_PASSWORD=root -e MYSQL_DATABASE=fintech -e MYSQL_USER=devuser -e MYSQL_PASSWORD=devpass -v mysql-data:/var/lib/mysql -p 3
306:3306 -d mysql:latest
```
