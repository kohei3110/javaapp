create user sample_user identified by WElcome##01
default tablespace users
temporary tablespace temp
quota unlimited on users;

grant connect, resource to sample_user;
