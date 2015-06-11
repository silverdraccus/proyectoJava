create database if not exists citas_medicas;
use citas_medicas;

create table Usuario(
id_us integer(10) primary key,
nombre char(255),
password char(255)
);

create table Administrador(
rfc char(255) primary key,
nombre varchar(255),
id_us integer(10),
constraint usuario_administrador_fk
foreign key (id_us) references Usuario(id_us)
);

create table Paciente(
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
foreign key (id_us) references Usuario(id_us)
);

create table Consultorio(consultorio int(10) primary key);
create table Turno(turno varchar(255) primary key);
create table Especialidad(especialidad varchar(255) primary key);

create table Doctor(
rfc varchar(25) primary key,
nombre varchar(255),
especialidad varchar(255),
turno varchar(255),
consultorio integer(10),
id_us integer(10),
foreign key (especialidad) references Especialidad(especialidad),
foreign key (turno) references Turno(turno),
foreign key (consultorio)references Consultorio(consultorio),
foreign key (id_us) references Usuario(id_us)
);

create table Estatus(
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
foreign key (id_est) references Estatus(id_est),
foreign key (rfc) references Doctor(rfc),
foreign key (noCuenta) references Paciente(noCuenta)

);

insert into Estatus values (1,'activa'),(2,'terminada'),(3,'cancelada');


