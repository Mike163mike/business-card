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
       ('ООО "Оренбург-Терминал"',
        '2016-09-01',
        '2019-08-01',
        '3 года 11 месяцев',
        'Оренбург',
        'Директор',
        'Перевозки, логистика, склад, ВЭД. Нефтепродукты. Заключение договоров и контроль доставки  топлива заказчику.' ||
        'Контроль документооборота организации.'),
       ('ООО "Регион-СМ"',
        '2015-08-01',
        '2016-10-01',
        '1 год 2 месяцев',
        'Самара',
        'Директор',
        'Перевозки, логистика, склад. Нефтепродукты. Заключение договоров и контроль доставки  топлива заказчику.' ||
        'Контроль документооборота организации.'''),
       ('ООО "Первый Кредитный Кооператив"',
        '2011-08-01',
        '2015-08-01',
        '4 год',
        'Самара',
        'Заместитель директора',
        'Оформление кредитов под залог жилой недвижимости и автомобилей (из собственных средств компании и денег ' ||
        'инвесторов). Проведение сделок в Рег. палате. Работа с просроченной задолженностью. Представительство ' ||
        'интересов компании в судах.'),
       ('ООО "Мир Оценки"',
        '2009-01-01',
        '2011-08-01',
        '2 года 7 месяцев',
        'Самара',
        'Коммерческий директор',
        'Заключение договоров на оценку с юридическими и физическими лицами. Консультирование клиентов. Аккредитация' ||
        'компании в банках.'),
       ('ООО "БрокСтар"',
        '2007-03-01',
        '2009-01-01',
        '2 года 10 месяцев',
        'Самара',
        'Консультант',
        'Консультирование юридических и физических лиц по вопросам получения банковского кредита (подбор кредитной ' ||
        'организации, проверка кредитной истории, первичная проверка пакета документов). Ипотеки, залоговые кредиты, ' ||
        'потребительские кредиты.'),
       ('ООО "Гранит"',
        '2004-05-01',
        '2007-02-01',
        '2 года 9 месяцев',
        'Самара',
        'Руководитель направления - демонтаж трубопровода.',
        'Набор и техническое оснащение бригады, осуществляющей демонтаж нефтяной трубы. Аренда спецтехники. Подготовка
        разрешительной документации, контакты с контролирующими и курирующими организациями. Непосредственное
        руководство процессом демонтажа "в поле".'),
       ('Собственная транспортная фирма.',
        '1999-01-01',
        '2004-05-01',
        '5 лет 4 месяца',
        'Самара',
        'Владелец. Директор.',
        'Поиск инвесторов. Покупка автотранспорта (бензовозов). Набор персонала. Общее руководство деятельностью ' ||
        'организации.'),
       ('ООО Сафран',
        '1993-01-01',
        '1999-01-01',
        '6 лет',
        'Самара',
        'Младший партнёр',
        'Начинал в качестве младшего партнёра, курировавшего одно из направлений. Затем создал дочернюю фирму, которую ' ||
        'сам и возглавил, нашёл инвесторов. Фирма занималась оптовой продажей бытовой химии производства Польши. Мои ' ||
        'обязанности: выбор ассортимента, покупка, растаможка и доставка товара в Самару, складирование, поиск оптовых ' ||
        'покупателей, контроль своевременной оплаты. Фирма успешно работала до кризиса 1998 г.'),
       ('Волго-Камский коммерческий банк',
        '1991-01-01',
        '1993-01-01',
        '2 года',
        'Самара',
        'Сотрудник отдела безопасности.',
        'Охрана сейфовых ячеек.');

insert into employees_place_of_work (employee_id, place_of_work_id)
values (1, 1),
       (1, 2),
       (1, 3),
       (1, 4),
       (1, 5),
       (1, 6),
       (1, 7),
       (1, 8),
       (1, 9),
       (1, 10);