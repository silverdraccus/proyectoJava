create database if not exists citas_medicas;

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
m_cedula int primary key,
p_num_paciente int,
c_fecha date,
foreign key (m_cedula) references medico(m_cedula),
foreign key (p_num_paciente) references paciente(p_num_paciente)
);

create table usuarios(
usuario varchar(15),
contraseña varchar(40) -- firma sha1
);