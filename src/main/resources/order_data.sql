create table chitrabala.order(order_id bigint not null, order_date date, delivery_date date, garland_type varchar(30),
	no_of_pcs int, no_of_gms int, finalized_price bigint, advance_amount bigint, 
    remaining_amount bigint, isCompleted boolean,
    primary key(order_id)); 
    
insert into chitrabala.orderinfo(orderinfo_id, order_date, delivery_date, garland_type,
	no_of_pcs, no_of_gms, finalized_price, advance_amount, 
    remaining_amount, is_completed) values(1, CURRENT_DATE, CURRENT_DATE, 'Vetiver garland',
3, 400, 3000, 1000, 2000, false);

insert into chitrabala.orderinfo(orderinfo_id, order_date, delivery_date, garland_type,
	no_of_pcs, no_of_gms, finalized_price, advance_amount, 
    remaining_amount, is_completed) values(2, CURRENT_DATE, CURRENT_DATE, 'Ayyappan garland',
3, 200, 4500, 1000, 3500, false);

select * from chitrabala.orderinfo;
