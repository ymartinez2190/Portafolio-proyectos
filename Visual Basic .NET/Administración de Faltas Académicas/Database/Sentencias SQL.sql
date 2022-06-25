CREATE DATABASE prj_final
USE prj_final
CREATE TABLE dt_asignatura(id_asignatura INT PRIMARY KEY IDENTITY(1,1) NOT NULL, dt_descripcion VARCHAR(50) NOT NULL);

CREATE TABLE dt_seccion(id_seccion INT PRIMARY KEY IDENTITY(1,1) NOT NULL, descripcion VARCHAR(10) NOT NULL);

CREATE TABLE dt_nivel(id_nivel INT PRIMARY KEY IDENTITY(1,1) NOT NULL, descripcion VARCHAR(20) NOT NULL, id_seccion INT NOT NULL,
FOREIGN KEY(id_seccion) REFERENCES dt_seccion (id_seccion));


CREATE TABLE dt_docentes(cedula VARCHAR(20) PRIMARY KEY NOT NULL, nombre VARCHAR(50) NOT NULL, apellido VARCHAR(50) NOT NULL, 
domicilio TEXT NOT NULL,f_nacimiento DATETIME NOT NULL,f_ingreso DATETIME NOT NULL, id_seccion INT NOT NULL, id_asignatura INT NOT NULL,
FOREIGN KEY(id_seccion) REFERENCES dt_seccion (id_seccion),FOREIGN KEY(id_asignatura) REFERENCES dt_asignatura(id_asignatura));

CREATE TABLE dt_login(id_login INT PRIMARY KEY IDENTITY (1,1) NOT NULL, cedula VARCHAR(20) NOT NULL, password VARBINARY(8000) NOT NULL, FOREIGN KEY(cedula) REFERENCES dt_docentes (cedula));

CREATE TABLE dt_acudientes(id_acudiente INT IDENTITY(1,1) NOT NULL, cedula VARCHAR(20) PRIMARY KEY NOT NULL, nombre VARCHAR(50) NOT NULL, apellido VARCHAR(50) NOT NULL, 
domicilio TEXT NOT NULL,profesion VARCHAR(20) NOT NULL,telefono INT NOT NULL);

CREATE TABLE dt_statusalu(id_status INT PRIMARY KEY IDENTITY(1,1) NOT NULL, descripcion VARCHAR(10) NOT NULL);

CREATE TABLE dt_alumnos(cedula VARCHAR(20) PRIMARY KEY NOT NULL, nombre VARCHAR(50) NOT NULL, apellido VARCHAR(50) NOT NULL, 
domicilio TEXT NOT NULL,f_nacimiento DATETIME NOT NULL,f_ingreso DATETIME NOT NULL, id_nivel INT NOT NULL, id_status INT NOT NULL,acu_cedula VARCHAR(20) NOT NULL, 
FOREIGN KEY(id_nivel) REFERENCES dt_nivel (id_nivel),FOREIGN KEY(acu_cedula) REFERENCES dt_acudientes(cedula),FOREIGN KEY(id_status) REFERENCES dt_statusalu(id_status));

CREATE TABLE dt_tipofalta(id_tipofalta INT PRIMARY KEY IDENTITY(1,1) NOT NULL, descripcion VARCHAR(50) NOT NULL);

CREATE TABLE dt_faltas(id_falta INT PRIMARY KEY IDENTITY(1,1) NOT NULL, descripcion VARCHAR(100) NOT NULL, id_tipofalta INT NOT NULL, FOREIGN KEY(id_tipofalta) REFERENCES dt_tipofalta(id_tipofalta));

CREATE TABLE dt_tiposancion(id_tiposancion INT PRIMARY KEY IDENTITY(1,1) NOT NULL, descripcion VARCHAR(50) NOT NULL);

CREATE TABLE dt_statussan(id_status INT PRIMARY KEY IDENTITY (1,1),descripcion VARCHAR(50) NOT NULL);

CREATE TABLE dt_sanciones(id_sancion INT PRIMARY KEY IDENTITY(1,1) NOT NULL, alu_cedula VARCHAR(20) NOT NULL, f_iniciosancion DATETIME NOT NULL, f_finalsancion DATETIME NOT NULL, doc_cedula VARCHAR(20) NOT NULL,
id_tipofalta INT NOT NULL, id_falta INT NOT NULL, id_tiposancion INT NOT NULL,id_status INT NOT NULL, FOREIGN KEY(alu_cedula) REFERENCES dt_alumnos (cedula),
FOREIGN KEY(doc_cedula) REFERENCES dt_docentes (cedula),FOREIGN KEY(id_falta) REFERENCES dt_faltas (id_falta),FOREIGN KEY(id_tipofalta) REFERENCES dt_tipofalta (id_tipofalta),
FOREIGN KEY(id_tiposancion) REFERENCES dt_tiposancion (id_tiposancion),FOREIGN KEY(id_status) REFERENCES dt_statussan (id_status));

