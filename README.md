# sampleapp

## Description
This is a sample application in "(article title)".

The purpose of this application is above.

 - To Do : write contents.
 
## Environments
 - Oracle Database 19c (19.3.0) Enterprise Edition
 - Oracle JDK 8

## Setup Oracle Database
### Clone Official Repository
`$ git clone https://github.com/oracle/docker-images.git`

### Download Oracle Database Software
<a href="https://www.oracle.com/database/technologies/oracle-database-software-downloads.html">19.3 - Enterprise Edition (also includes Standard Edition 2)</a><br>
`$ cd docker-images/OracleDatabase/SingleInstance/dockerfiles`<br>
`$ cp ~/Downloads/LINUX.X64_193000_db_home.zip .`

### Build Database
`$ cd ..`<br>
`$ ./buildDockerImage.sh -v 19.3.0 -e`

The resulting images will be an image with the Oracle binaries installed. On first startup of the container a new database will be created, the following lines highlight when the database is ready to be used:
```
#########################
DATABASE IS READY TO USE!
#########################
```

```
$ docker ps
CONTAINER ID        IMAGE                       COMMAND                  CREATED             STATUS                    PORTS                                            NAMES
e85249e82ae4        oracle/database:19.3.0-ee   "/bin/sh -c 'exec $O…"   27 minutes ago      Up 27 minutes (healthy)   0.0.0.0:1521->1521/tcp, 0.0.0.0:5500->5500/tcp   oracle
```
