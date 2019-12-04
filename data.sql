use demo_db;
delete FROM demo_db.user_group_entity_user_list;
delete FROM demo_db.user_user_group_entity_set;
delete FROM demo_db.transaction_entity;
delete FROM demo_db.user_group_entity;
delete FROM demo_db.user;


insert into `user` (user_id, balance, password, user_name) values (1, 0.0, "123456", "Aditi"), (2, 0.0, "123456", "Sajid"), (3, 0.0, "123456", "Rabby"), (4, 0.0, "123456", "Tejaswini"), 
(5, 0.0, "123456", "Mike"), (6, 0.0, "123456", "Jordan"), (7, 0.0, "123456", "Tom"), (8, 0.0, "123456", "Chris"), (9, 0.0, "123456", "Rakeb"), (10, 0.0, "123456", "Mohi"), (11, 0.0, "123456", "Akshay"),
(12, 0.0, "123456", "Sakib");

insert into demo_db.user_group_entity (id, group_name) values (1, "UTN"), (2, "Ashford"), (3, "Walden_Court");

insert into `user_group_entity_user_list` (user_group_entity_id, user_list_user_id) values (1,1),(1,2),(1,3),(1,4), (2,5),(2,6),(2,7),(2,8),(3,9),(3,10),(3,11),(3,12);