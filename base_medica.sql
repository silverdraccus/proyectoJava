create database if not exists citas_medicas;
use citas_medicas;
create table medico(
m_cedula varchar(30) primary key,
m_nombre varchar(255),
m_consultorio int
);

create table paciente(
p_num_paciente int primary key,
p_nombre varchar(255),
p_fecha_nac date,
p_email varchar(255),
p_direccion varchar(255),
p_telefono varchar(30)
);

create table cita(
m_cedula varchar(30) primary key,
p_num_paciente int,
c_fecha date,
foreign key (m_cedula) references medico(m_cedula),
foreign key (p_num_paciente) references paciente(p_num_paciente)
);

use citas_medicas;
drop table usuarios;
create table usuario(
usuario varchar(15) primary key,
contraseña varchar(40) -- firma sha1

);

insert into usuario values ('medico1',sha1('medico1')),('medico2',sha1('medico2'));

select * from usuario;