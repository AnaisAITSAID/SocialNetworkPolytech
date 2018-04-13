CREATE TABLE STORY(
  ID INT IDENTITY,
  CONTENT VARCHAR (144)
);

create table users(
	username varchar_ignorecase(250) not null primary key,
	password varchar_ignorecase(250) not null,
	enabled boolean not null
);

create table authorities (
	username varchar_ignorecase(250) not null,
	authority varchar_ignorecase(250) not null,
	constraint fk_authorities_users foreign key(username) references users(username)
);
create unique index ix_auth_username on authorities (username,authority);

INSERT INTO users values('zeros','$2a$10$q5YnsG4NOzqw61Z04ikNGuWSdEwurX4mf76yNcCjozOF9AI2QzjHu',true);
insert into authorities values ('zeros','ADMIN');
