# Тестовое задание от М.Тех

## Задание
Написать REST API сервис по сбору авто.
### Что сделано
Написан сервис по сбору авто, в котором есть:
- валидация данных
- обработка исключений и работа со статус кодами
- подключенный и настроенный Swagger
- созданная коллекция Postman со всеми запросами
- docker-compose для базы данных и запуска приложения

### Что использовал
1. Java 17
2. Liquibase для вставки данных и создания таблиц
3. Hibernate для взаимодействия с базой данных
4. База данных PostgreSQL

## Инструкция по развертыванию проекта
1. Склонировать репозиторий
2. Перейте в папку с проектом и выполнить следующее:
 ```
mvn clean install -Dmaven.test.skip
```
 ```
docker-compose build
```
```
docker-compose up
```
4. Импортировать коллекцию Postman (Опционально)
5. Сервис доступен по адресу http://localhost:8080

## Эндпоинты
На данный момент реализовано 12 эндпоинтов для добавления, получения и удаления.

### Запросы для Car
GET запрос
```
/catalog/cars/{id}
```
```
/catalog/cars/all
```
POST запрос
```
/catalog/cars
```
DELETE запрос
```
/catalog/cars/{id}
```
### Запросы для CarBody
GET запрос
```
/catalog/bodies/{id}
```
```
/catalog/bodies/all
```
POST запрос
```
/catalog/bodies
```
DELETE запрос
```
/catalog/bodies/{id}
```
### Запросы для CarWheel
GET запрос
```
/catalog/tyres/{id}
```
```
/catalog/tyres/all
```
POST запрос
```
/catalog/tyres
```
DELETE запрос
```
/catalog/tyres/{id}
```
