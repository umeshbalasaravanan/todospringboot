
create table chitrabala.customer(cust_id bigint not null, 
	name varchar(30),
    address varchar(30),
    order_id bigint not null,
    primary key(cust_id),
    foreign key(order_id) references chitrabala.order(order_id));
    
insert into chitrabala.customer(cust_id, name, address, order_id) values(
	200, 'Susee', 'suppuraj nagar', 1);
    
insert into chitrabala.customer(cust_id, name, address, order_id) values(
	300, 'kcpmc', 'mundhal', 2);
    
select * from chitrabala.customer;
