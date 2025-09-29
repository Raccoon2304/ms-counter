Подключение liquibase plugin
В модуле db создаем новый pom.xml по шаблону (замени паттерн {имя ms} на имя проекта)

pom db модуля
```
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <parent>
        <artifactId>ms-counter</artifactId>
        <groupId>com.lanit.edp</groupId>
        <version>0.0.1-SNAPSHOT</version>
    </parent>
    <modelVersion>4.0.0</modelVersion>

    <artifactId>ms-counter-db</artifactId>

    <properties>
        <maven.compiler.source>17</maven.compiler.source>
        <maven.compiler.target>17</maven.compiler.target>
    </properties>

    <dependencies>
        <dependency>
            <groupId>org.postgresql</groupId>
            <artifactId>postgresql</artifactId>
            <scope>provided</scope>
        </dependency>
    </dependencies>

    <build>
        <resources>
            <resource>
                <directory>../ms-counter-db</directory>
                <includes>
                    <include>db.changelog-*.xml</include>
                </includes>
            </resource>
        </resources>
        <plugins>
            <plugin>
                <groupId>org.liquibase</groupId>
                <artifactId>liquibase-maven-plugin</artifactId>
                <version>3.5.5</version>
                <configuration>
                    <propertyFileWillOverride>true</propertyFileWillOverride>
                    <propertyFile>../liquibase.properties</propertyFile>
                </configuration>
            </plugin>
        </plugins>
    </build>

</project>
```
На случай пустого db.changelog-master.xml, создай его по шаблону с подключением changelogs:
```
<databaseChangeLog xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xmlns="http://www.liquibase.org/xml/ns/dbchangelog"
    xsi:schemaLocation="http://www.liquibase.org/xml/ns/dbchangelog
                        http://www.liquibase.org/xml/ns/dbchangelog/dbchangelog-3.4.xsd">

    <include file="db.changelog-init.xml"/>

</databaseChangeLog>

```

Существует несколько вариантов выполнения скриптов:

С помощью команды с подстановкой параметра
```
mvn liquibase:update -Dliquibase.url="jdbc:postgresql://localhost:5432/counter" -Dliquibase.changeLogFile="C:\Users\abelousov.LANIT\IdeaProjects\ms-counter\ms-counter-db\db.changelog-master.xml" -Dliquibase.username=postgres -Dliquibase.password=postgres -Dliquibase.driver="org.postgresql.Driver" -Pliquibase

```
или

а же команда, но через интерфейс IDEA
