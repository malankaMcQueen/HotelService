# HotelsInfo - Приложение для работы с информацией об отелях

Это приложение предназначено для работы с данными об отелях. Оно использует Spring Boot для backend-а и другие технологии для обеспечения функциональности.

## Технологии

- **Java 21** — основная версия языка программирования.
- **Spring Boot** — основной фреймворк для разработки приложения.
- **H2 Database** — для работы с базой данных.
- **Liquibase** — для управления миграциями базы данных.
- **Maven** — для управления зависимостями.

---

## Установка

1. **Клонируйте репозиторий:**

    ```bash
    git clone https://github.com/malankaMcQueen/HotelService.git
    cd HotelService
    ```

2. **Установите зависимости:**

   Убедитесь, что у вас установлены все зависимости для работы с Java 21.

    - Установите [Java 21](https://adoptopenjdk.net/)
    - Установите [Maven](https://maven.apache.org/install.html)

## Запуск приложения

### 1. **Запуск с помощью Maven**

Для запуска приложения используйте команду Maven:

```bash
mvn spring-boot:run
```

## Документация API с использованием Swagger

Для удобного взаимодействия с API приложения, вы можете воспользоваться интерфейсом Swagger UI.

### Открытие документации Swagger UI

После запуска приложения, откройте браузер и перейдите по следующему URL, чтобы открыть Swagger UI:

http://localhost:8092/swagger-ui/index.html


Это откроет веб-интерфейс, в котором вы сможете увидеть все доступные эндпоинты API, а также протестировать их непосредственно через интерфейс.