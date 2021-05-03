create table article
(
  id serial,
  name character varying(20) not null,
  short_description character varying(30) not null,
  description character varying(50) not null,
  create_dt date not null,
  modify_dt date not null
);

