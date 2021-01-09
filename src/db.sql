create DATABASE theatre ENCODING 'UTF-8';

create table play (
    title varchar(256) primary key,
    link varchar(256)
);

create table actors (
    actorID integer primary key,
    actor_Name varchar(256) not null,
    actor_Play varchar(256) references play(title)
);



insert into actor(actorID, actor_Name) values (1, "John");
insert into actor(actorID, actor_Name) values (2, "Gena");
