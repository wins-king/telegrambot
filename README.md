REST application
For run application you have to go to file TelegramBotApplication.java and run main method

see all application properties in file application.properties

using remotemysql.com 

telegramBot link: https://t.me/KotikovEvgenTelegramBot
@KotikovEvgenTelegramBot - *after launching the app, go to the bot and evaluate the work
telegramBot token=1337804692:AAGLyrUobRx7T1sqwiOqeFEdm8W61bqK2rI

inside path /src/main/java/com/kotikov/telegrambot/rest/* you see REST Controllers which manage (CRUD) application  


Access CityService using next REST requests:

POST: http://localhost:8066/api/v1/city/ Request body {
    "name": "Paris",
    "setDescriptions": [
        {
            "description": "Delicious croissants"
        },
        {
            "description": "Romantic city"
        },
        {
            "description": "The Eiffel tower is located here"
        }
    ]
} - CREATE new City

GET:http://localhost:8066/api/v1/city/ - get all Cities

GET:http://localhost:8066/api/v1/city/1 - get City with id=1

DELETE: http://localhost:8066/api/v1/city/1 - delete City with id=1

PUT:http://localhost:8066/api/v1/city/ - Request body {
    "name": "Paris",
    "setDescriptions": [
        {
            "description": "Delicious croissants"
        }
    ]
} - UPDATE new City
