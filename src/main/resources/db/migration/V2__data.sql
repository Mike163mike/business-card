insert into security_users(username, password)
values ('Mike',
        '$2a$12$8v7vCL9vQjo.IhTQTEcfZurlQh1ivTJucDtjrPFoJ3xUT/FiNGe22');

insert into roles (name)
values ('ROLE_ADMIN'),
       ('ROLE_USER');

insert into security_users_roles (security_user_id, roles_id)
values (1, 1),
       (1, 2);

insert into employees (name, middle_name, last_name, birthday, gender, phone, email, city,
                       specialization, education, languages, skills, auto, additional_information, hobby)
values ('Михаил',
        'Викторович',
        'Кобзарёв',
        '1969-07-12',
        'мужской',
        '+7(927)656-29-86',
        'mick_mick_mick@icloud.com',
        'Самара',
        'Java-разработчик (backend)',
        'Высшее, Самарский государственный аэрокосмический университет им. академика С.П. Королева ' ||
        '(национальный исследовательский университет), 5 факультет, начало учёбы: 1991, Самара. Специальность:' ||
        ' Конструирование и производство радиоаппаратуры',
        'Русский — родной, английский — B1 — Средний',
        'Java Core, Intellij IDEA, SQL, ООП, HTML, Spring Framework, Apache Maven, PostgreSQL, Java SE, XML, JUnit,' ||
        'REST, Английский язык, Пользователь ПК, Грамотная речь',
        'Есть автомобиль, права категории B. Стаж вождения - более 30 лет',
        'С 2019 года самостоятельно изучаю ЯП Java, SQL, технологии Spring Framework, HTML, JSON, Log4j, jUnit, ' ||
        'СУБД PostgreSQL, инструменты Intellej IDEA, Git, Docker, микросервисную архитектуру, паттерны проектирования ' ||
        'web приложений REST, MVC. В 2021 году прошёл платный обучающий курс по направлению Java на сайте JavaRush. ' ||
        'До этого там же прошёл курсы: основы БД, основы операционных систем, компьютерные сети, таблицы Excel. ' ||
        'Частично (по причине закрытия проекта) пройдена стажировка в SimbirSoft по направлению Java backend разработка ' ||
        '(проект task-board в моём githab''e: https://github.com/Mike163mike. Там же выполненные тестовые задания ' ||
        'и учебные проекты). Продолжаю учиться и выполнять небольшие тренировочные проекты. В последние годы я работал ' ||
        'в сфере малого бизнеса: оптовая торговля продуктами, бытовой химией, перевозка нефтепродуктов, АЗС. В данной ' ||
        'специальности опыта нет.',
        'Спорт, книги, java');

insert into places_of_work (name, start, finish, duration, city, position, description)
values ('АЗС ИП Вишняков',
        '2019-08-01',
        '2022-05-01',
        '2 года 9 месяцев',
        'Нефтегорск, Самарская область',
        'Управляющий АЗС',
        'Заключение договоров с поставщиками. Контроль сдача отчётности и оплаты налогов. Контроль продаж. Ценовая ' ||
        'политика. Работа с персоналом.'),
       ('factory',
        '2002-03-01',
        '2019-08-01',
        '2 года 9 месяцев',
        'Samara',
        'director',
        'blah-blah-blah'),
       ('factory1',
        '2000-01-01',
        '2002-03-01',
        '2 года 6 месяцев',
        'Moscow',
        'director',
        'blah-blah-blah1');

insert into employees_place_of_work (employee_id, place_of_work_id)
values (1, 1),
       (1, 2),
       (1, 3);