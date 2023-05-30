create table member (
	member_id INT PRIMARY KEY,
	first_name VARCHAR(15) NOT NULL,
	last_name VARCHAR(15) NOT NULL,
	email VARCHAR(25) NOT NULL,
        password VARCHAR(15) NOT NULL,
	book_issue_date DATE,
	book_id INT,
	FOREIGN KEY (book_id) REFERENCES book (id)
);
insert into member (member_id, first_name, last_name, email, password, book_issue_date, book_id) values (1, 'Daisi', 'Sammut', 'dsammut0@so-net.ne.jp', 'yq54L6aee', null, null);
insert into member (member_id, first_name, last_name, email, password, book_issue_date, book_id) values (2, 'Euphemia', 'Wickrath', 'ewickrath1@bing.com', '1cPZ50EHC2J', null, null);
insert into member (member_id, first_name, last_name, email, password, book_issue_date, book_id) values (3, 'Ruthi', 'Olivetti', 'rolivetti2@spiegel.de', 'kVH2efw', null, null);
insert into member (member_id, first_name, last_name, email, password, book_issue_date, book_id) values (4, 'Feodora', 'Smaling', 'fsmaling3@ca.gov', '4XiORqc3i', null, null);
insert into member (member_id, first_name, last_name, email, password, book_issue_date, book_id) values (5, 'Erin', 'Lepope', 'elepope4@comcast.net', '0DaVWfxL1', null, null);
insert into member (member_id, first_name, last_name, email, password, book_issue_date, book_id) values (6, 'Freddie', 'Packington', 'fpackington5@blogspot.com', 'JUBGMWOO183V', null, null);
insert into member (member_id, first_name, last_name, email, password, book_issue_date, book_id) values (7, 'Madelena', 'Montfort', 'mmontfort6@forbes.com', 'RznQ7wBnPxM8', null, null);
insert into member (member_id, first_name, last_name, email, password, book_issue_date, book_id) values (8, 'Leontyne', 'Silverlock', 'lsilverlock7@fc2.com', 'G7LN9Ap', null, null);
insert into member (member_id, first_name, last_name, email, password, book_issue_date, book_id) values (9, 'Ilysa', 'Poleykett', 'ipoleykett8@spiegel.de', 'mSrAF7vOA', '07-APR-23', null);
insert into member (member_id, first_name, last_name, email, password, book_issue_date, book_id) values (10, 'Dodie', 'Dederick', 'ddederick9@about.com', 'tgwg9pWdWow', '04-MAY-23', null);
