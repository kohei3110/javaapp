create table member(
   id number generated always as identity,
   name varchar2(400),
   salary number,
   created_date date,
   type_id number
);

create table m_type(
   id number generated always as identity,
   name varchar2(40)
);
