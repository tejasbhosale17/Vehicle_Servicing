DROP DATABASE IF EXISTS vehicles_db;

CREATE DATABASE vehicles_db;

USE vehicles_db;

CREATE TABLE customer(
 customer_id INT PRIMARY KEY AUTO_INCREMENT,
 name VARCHAR(30),
 mobile VARCHAR(12),
 email VARCHAR(100),
 address VARCHAR(100)
);

insert into customer values(1,'David','9895607810','david@gmail.com','Pune');

insert into customer values(2,'Raj','9994717174','raj@gmail.com','Mumbai');

insert into customer values(3,'Sanket','7891007810','sanket@gmail.com','Satara');

insert into customer values(4,'Laxman','8845607890','laxman@gmail.com','Kolhapur');

insert into customer values(5,'Dhruva','9595857565','dhruva@gmail.com','Sambhaji Nagar');

insert into customer values(6,'Rani','78654507898','rani@gmail.com','Jalgoen');

insert into customer values(7,'James','9970139252','james@gmail.com','Nashik');

insert into customer values(8,'Lalita','9325280026','lalita@gmail.com','Chalisgoen');

insert into customer values(9,'Pooja','8759068778','pooja@gmail.com','Nagpur');

insert into customer values(10,'Nilesh','9876543210','nilesh@gmail.com','Kolhapur');

CREATE TABLE vehicle(
    vehicle_id INT PRIMARY KEY AUTO_INCREMENT,
    company VARCHAR(30),
    model VARCHAR(30)
);

insert into vehicle values(1,'Honda','cb-unicorn');

insert into vehicle values(2,'Hero','splender');

insert into vehicle values(3,'Honda','activa');

insert into vehicle values(4,'Honda','shine125');

insert into vehicle values(5,'Yamaha','FZ160');

insert into vehicle values(6,'Hero','karizma');

insert into vehicle values(7,'Honda','Hornet');

insert into vehicle values(8,'TVS','jupiter');

insert into vehicle values(9,'TVS','apache160');

insert into vehicle values(10,'Bajaj','pulsar');

CREATE TABLE customer_vehicles(
    vehicle_number VARCHAR(10) PRIMARY KEY,
    customer_id INT,
    vehicle_id INT,
    foreign key (customer_id) REFERENCES customer(customer_id) ON DELETE CASCADE ON UPDATE CASCADE,
    foreign key (vehicle_id) REFERENCES vehicle(vehicle_id) ON DELETE CASCADE ON UPDATE CASCADE
);

insert into customer_vehicles values('MH12HK4481',8,9);

insert into customer_vehicles values('MH09KV1234',10,4);

insert into customer_vehicles values('MH09OP5678',10,6);

insert into customer_vehicles values('MH15AB8814',7,1);

insert into customer_vehicles values('MH20',5,8);

insert into customer_vehicles values('MH11PD5161',3,2);

insert into customer_vehicles values('MH01TY8814',2,7);

insert into customer_vehicles values('MH01RM4141',2,10);

insert into customer_vehicles values('MH19PH6543',6,2);

insert into customer_vehicles values('MH31DS7890',9,8);

insert into customer_vehicles values('MH12SJ4161',1,7);

insert into customer_vehicles values('MH09OT0808',4,3);

insert into customer_vehicles values('MH11AD7878',3,5);


CREATE TABLE parts(
	part_id INT PRIMARY KEY AUTO_INCREMENT,
	name VARCHAR(50),
	description VARCHAR(100),
	price DECIMAL(10,2)
);

insert into parts values(1,'clutch','The clutch is a part of the transmission system next to the crankshaft',1000);

insert into parts values(2,'battery','The car battery is also an essential component of car as it provides the electricity to car',4600);

insert into parts values(3,'alternator','It provides energy the electrical components such as power steering systems,power windows',3000);

insert into parts values(4,'radiator','important part of the car engine’s cooling system,helps to drain out the excess heat from the engine',4000);

insert into parts values(5,'propeller shaft','The power is transferred to the wheels using the propeller shaft. It is also called a driveshaft.',5000);

insert into parts values(6,'axles','It is nothing but shafts,used to mount the wheels,two types namely, Front Axle and Rear Axle',8000);

insert into parts values(7,'timing belt','keep the engine intake and exhaust valves open and close simultaneously in time with the pistons',8000);


CREATE TABLE service_requests(
	service_request_id INT PRIMARY KEY AUTO_INCREMENT,
	vehicle_number VARCHAR(10),
	request_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	bill_amount DECIMAL(10,2),
	foreign key (vehicle_number) REFERENCES customer_vehicles(vehicle_number) ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE payments(
	payment_id INT PRIMARY KEY AUTO_INCREMENT,
	service_request_id INT,
	tx_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	paid_amount DECIMAL(8,2),
	foreign key (service_request_id) REFERENCES 
	service_requests(service_request_id) ON UPDATE CASCADE ON DELETE CASCADE 
);

CREATE TABLE services(
	service_id INT PRIMARY KEY AUTO_INCREMENT,
	type ENUM ('oil','maintainance'),
	oil_cost DECIMAL(6,2),
	labour_charges DECIMAL(6,2),
	total_cost DECIMAL(7,2),
	remark VARCHAR(100),
	service_request_id INT,
	foreign key (service_request_id) REFERENCES
	service_requests(service_request_id) ON UPDATE CASCADE ON DELETE CASCADE 
);



CREATE TABLE service_parts(
	service_id INT,
	part_id INT,
	quantity INT,
	foreign key (service_id) REFERENCES services(service_id) ON UPDATE CASCADE ON DELETE CASCADE,
	foreign key (part_id) REFERENCES parts(part_id) ON UPDATE CASCADE ON DELETE CASCADE	
);

ALTER TABLE customer RENAME COLUMN name TO customer_name;

ALTER TABLE vehicle RENAME COLUMN name TO vehicle_name;

ALTER TABLE parts RENAME COLUMN name TO part_name;
