# ProductsFromTheManufacturer

This is my training project. At the moment I'm studying servlets and my knowledge of hibernate is still too bad.

My task is:

Необходимо создать веб-приложение, которое позволяет:

1) Выполнять регистрацию пользователей
2) Выполнять авторизацию пользователей
3) Выполнять CRUD операции над следующими объектами:

=====================================

Product: 

Long id; 
String name; 

BigDecimal price; 

Manufacturer manufacturer; 

=====================================


Manufacturer 

Long id; 

String name; 

Set products;

=====================================

В базе данных хранятся данные о производителях (Manufacturer) и товарах (Product). 


Каждый товар имеет одного производителя, и каждый производитель имеет набор товаров.

Страницы:

Manufacturers (список производителей + возможность создавать новых, редактировать и удалять созданных производителей)
Products (список товаров + возможность создавать новых, редактировать и удалять созданные товары) 

Технологии: Java, MySQL, Hibernate, Servlets, JSP, Maven, Tomcat, Git
