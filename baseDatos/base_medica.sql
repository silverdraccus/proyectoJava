create database if not exists citas_medicas;
use citas_medicas;

create table usuario(
id_us integer(10) primary key,
nombre char(255) unique,
password char(255)
);

create table administrador(
rfc char(255) primary key,
nombre varchar(255),
id_us integer(10),
constraint usuario_administrador_fk
foreign key (id_us) references usuario(id_us)
);

create table paciente(
noCuenta integer(10) primary key,
nombre varchar(255),
carrera varchar(255),
fechaNacimiento date,
semestreVigente integer(10),
dirCalle varchar(255),
dirNumero integer(10),
dirColonia integer(10),
telefono varchar(255),
correoE varchar(255),
id_us integer(10),
foreign key (id_us) references usuario(id_us)
);

create table consultorio(consultorio int(10) primary key);
create table turno(turno varchar(255) primary key);
create table especialidad(especialidad varchar(255) primary key);

create table doctor(
rfc varchar(25) primary key,
nombre varchar(255),
especialidad varchar(255),
turno varchar(255),
consultorio integer(10),
id_us integer(10),
foreign key (especialidad) references especialidad(especialidad),
foreign key (turno) references turno(turno),
foreign key (consultorio)references consultorio(consultorio),
foreign key (id_us) references usuario(id_us)
);

create table estatus(
id_est integer(10) primary key,
descripcion char(255)
);

create table cita(
id_cit integer(10) primary key,
fecha date,
hora time,
id_est integer(10) ,
rfc varchar(255), 
noCuenta integer(10),
foreign key (id_est) references estatus(id_est),
foreign key (rfc) references doctor(rfc),
foreign key (noCuenta) references paciente(noCuenta)

);

insert into estatus values (1,'activa'),(2,'terminada'),(3,'cancelada');
insert into turno values ('matutino'),('vespertino');


