# Batch-Boilerplate

배치서버의 보일러 플레이트를 작성

```shell
java -Dspring.profiles.active=test -jar /home/ubuntu/batch/batch.jar
```

## Reference

### Batch

- [jojoldu/spring-batch-in-action](https://github.com/jojoldu/spring-batch-in-action)
- [schema-drop-mariadb.sql](https://github.com/spring-projects/spring-batch/blob/main/spring-batch-core/src/main/resources/org/springframework/batch/core/schema-drop-mariadb.sql)
- [schema-mariadb.sql](https://github.com/spring-projects/spring-batch/blob/main/spring-batch-core/src/main/resources/org/springframework/batch/core/schema-mariadb.sql)

### Quartz

- [Spring Batch 관리 도구](https://jojoldu.tistory.com/489)
- [tables_mysql.sql](https://github.com/quartz-scheduler/quartz/blob/main/quartz/src/main/resources/org/quartz/impl/jdbcjobstore/tables_mysql.sql)

### Jenkins

- [Spring Batch를 Jenkins 를 이용해 간단하게 사용해보자](https://hooneats.tistory.com/33)

```shell
# 젠킨스 실행
docker-compose up -d 

# 젠킨스 초기 비밀번호 확인
docker logs -f jenkins

# Jenkins 를 위한 메모리 설정
sudo vim /etc/default/jenkins
# JAVA_ARGS="-Djava.awt.headless=true -Xmx4096m -XX:MaxPermSize=2048m"
```
