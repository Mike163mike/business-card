## Web application "Business Card"

Spring-приложение "Визитка". Хранит информацию о владельце в виде текста      
и изображений (фотографий). Позволяет неавторизованным пользователям       
заходить в браузере на страницу приложения без права редактирования      
(read - only). Открытый endpoint на локальной машине на порту 8080  <u>/home</u>.     

У авторизованного пользователя (в нашем случае - владельца страницы)    
есть возможность редактировать текст, вставлять изображения. Закрытый    
endpoint на локальной машине на порту 8080 <u>/admin</u>.

Авторизация пользователя реализована с помощью Spring security (basic auth -   
пароль - логин, форма для login и logout - дефолтные). Данные     
авторизованного пользователя (имя и пароль) храняться в базе данных    
Postgres. Сама база данных развёртывается в контейнере Docker автоматически,     
в момент старта приложения (при первом старте образ для контейнера стягивается   
с dockerhub'а, затем переиспользуется локальный). После остановки приложения    
контейнер останавливается. При перезапуске приложения - запускается.   

Данные ползователя записываются в базу данных при помощи двух миграций    
flyway. Затем только валидируются. Пароль хранится в зашифрованной форме.   
Данные для ввода в форму для login: name: <u>Mike</u>  password: <u>password</u>       
 


### Использованные в проекте нструменты и технологии:

● Java 17\
● Git\
● Maven\
● PostgreSQL\
● Hibernate\
● Flyway
● Spring Boot\
● Spring Web\
● Spring JPA\
● Spring MVC\
● Spring Security\
● Docker\
● Lombok

###  ТЗ:

> Создать Spring-приложение Визитка, которое хранит информацию о вас.    
> Данные будут храниться в текстовом файле. Приложение должно позволять     
> добавлять, редактировать и удалять места работы, навыки и ссылки на страницы.    
> Также должна быть возможность добавлять фото.  Требуется создать возможность      
> авторизации в закрытую часть приложения для редактирования информации.    
> Корневая страница должна выводить для чтения, без возможности редактирования.    
> Портфолио должно содержать следующую информацию:     
> Статическая информация: ФИО, возраст, город проживания, телефон, фото.     
> Динамическая информация: ссылки на github, социальные сети, предыдущие места работы     
> с информацией о компании, должности, реализуемых проекта и должностных обязанностях.    
> Заполнение страницы возможно тестовыми данными.