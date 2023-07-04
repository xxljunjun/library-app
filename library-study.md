图书馆的增删改查
### 编写数据库book
```
create table t_book(
`id` int primary key auto_increment,
`name` varchar(100),
`price` decimal(11,2),
`author` varchar(100),
`sales` int,
`stock` int,
`img_path` varchar(200)
);
```
