--Proyecto Base de datos, Clinica DB : Daniel Correa , Alvaro Martinez , Brayan Rodriguez, Camilo Narvaez
DROP TABLE IF EXISTS Causas_Registro;
DROP TABLE IF EXISTS RegistroHC;
DROP TABLE IF EXISTS Pacientes_Campana;
DROP TABLE IF EXISTS Campana;
DROP TABLE IF EXISTS Formula;
DROP TABLE IF EXISTS Camas_Paciente;
DROP TABLE IF EXISTS HistoriaClinica;
DROP TABLE IF EXISTS Causa;
DROP TABLE IF EXISTS Medicamentos;
DROP TABLE IF EXISTS Cita;
DROP TABLE IF EXISTS Medico;
DROP TABLE IF EXISTS Habilidades_Enfermera;
DROP TABLE IF EXISTS Enfermera;
DROP TABLE IF EXISTS Empleado;
DROP TABLE IF EXISTS Paciente;
DROP TABLE IF EXISTS Persona;
DROP TABLE IF EXISTS Cama;
DROP TABLE IF EXISTS Area;
--Creación de tabla area (ejem: psicologia, pediatria, etc) 
CREATE TABLE Area(
	codigoArea INT PRIMARY KEY NOT NULL,
	nombre VARCHAR(30) NOT NULL,
	descripcion TEXT NOT NULL,
	estado BOOLEAN NOT NULL
);


--Creación de la tabla cama (ejem: cama1, cama2, etc). Está relacionada con Area
CREATE TABLE Cama(
	numeroCama VARCHAR(20) PRIMARY KEY NOT NULL,
	estado BOOLEAN NOT NULL,
	descripcion TEXT NOT NULL,
	codigoArea INT NOT NULL,
	activa BOOLEAN NOT NULL,
	CONSTRAINT fk_codigoArea FOREIGN KEY(codigoArea) REFERENCES Area(codigoArea) ON UPDATE CASCADE ON DELETE NO ACTION 
); 

--Creacion de la tabla persona (ejem: juan, pedro, etc)
CREATE TABLE Persona(
	identificacion VARCHAR(35) NOT NULL PRIMARY KEY,
	nombres VARCHAR(40) NOT NULL,
	apellidos VARCHAR(40) NOT NULL,
	telefono VARCHAR(30) NOT NULL,
	direccion VARCHAR(40) NOT NULL
);

--Creacion de la tabla paciente. Está relacionada con persona
CREATE TABLE Paciente(
	identificacion VARCHAR(35) NOT NULL PRIMARY KEY,
	numeroSegSocial VARCHAR(40) NOT NULL,
	actEcon VARCHAR(30) NOT NULL,
	fechaNac DATE NOT NULL,
	estado BOOLEAN NOT NULL,
	CONSTRAINT fk_identificacion FOREIGN KEY(identificacion) REFERENCES Persona(identificacion) ON UPDATE CASCADE ON DELETE NO ACTION 
);

--Creacion de la tabla empleado. Está relacionada con persona, con ella misma (como jefe) y con area (a la que pertenece)
CREATE TABLE Empleado(
	identificacion VARCHAR(35) NOT NULL PRIMARY KEY,
	salario INT NOT NULL,
	email VARCHAR(40) NOT NULL UNIQUE,
	cargo VARCHAR(40) NOT NULL,
	contrasena VARCHAR(40) NOT NULL,
	jefe VARCHAR(35),
	codigoArea INT,
	estado BOOLEAN NOT NULL,
	CONSTRAINT fk_identificacion FOREIGN KEY(identificacion) REFERENCES Persona(identificacion) ON UPDATE CASCADE ON DELETE NO ACTION,
	CONSTRAINT fk_jefe FOREIGN KEY(jefe) REFERENCES Empleado(identificacion) ON UPDATE CASCADE ON DELETE NO ACTION,
	CONSTRAINT fk_codigoArea FOREIGN KEY(codigoArea) REFERENCES Area(codigoArea) ON UPDATE CASCADE ON DELETE NO ACTION
);	

--Creacion de la tabla enfermera. Está relacionada con empleado
CREATE TABLE Enfermera(
	identificacion VARCHAR(35) NOT NULL PRIMARY KEY,
	anosExp INT NOT NULL,
	CONSTRAINT fk_identificacion FOREIGN KEY(identificacion) REFERENCES Empleado(identificacion) ON UPDATE CASCADE ON DELETE NO ACTION
);

--Creación de la tabla habilidades enfermera. Está relacionada con enfermera 
CREATE TABLE Habilidades_Enfermera(
	identificacion VARCHAR(35) NOT NULL,
	habilidad VARCHAR(40) NOT NULL,
	CONSTRAINT pk_habilidades PRIMARY KEY(identificacion, habilidad),
	CONSTRAINT fk_habilidades FOREIGN KEY(identificacion) REFERENCES Enfermera(identificacion) ON UPDATE CASCADE ON DELETE NO ACTION
);

--Creación de la tabla Médico. Está relacionada con empleado
CREATE TABLE Medico(
	identificacion VARCHAR(35) NOT NULL PRIMARY KEY,
	numeroLicencia INT NOT NULL,
	especialidad VARCHAR(40) NOT NULL,
	universidad VARCHAR(40) NOT NULL,
	CONSTRAINT fk_identificacion FOREIGN KEY(identificacion) REFERENCES Empleado(identificacion) ON UPDATE CASCADE ON DELETE NO ACTION
);

--Creación de la tabla Cita. Se relaciona con medico y paciente
CREATE TABLE Cita(
	fecha DATE NOT NULL,
	hora TIME NOT NULL,
	idMedico VARCHAR(35) NOT NULL,
	idPaciente VARCHAR(35) NOT NULL,
	estado BOOL NOT NULL,
	CONSTRAINT pk_cita PRIMARY KEY(fecha, hora, idMedico),
	CONSTRAINT fk_idMedico FOREIGN KEY(idMedico) REFERENCES Medico(identificacion) ON UPDATE CASCADE ON DELETE NO ACTION, 
	CONSTRAINT fk_idPaciente FOREIGN KEY(idPaciente) REFERENCES Paciente(identificacion) ON UPDATE CASCADE ON DELETE NO ACTION
);



--Creación de la tabla medicamentos (ejem: ibuprofeno, acetaminofen, etc). 
CREATE TABLE Medicamentos(
	codigoMedicamento VARCHAR(30) NOT NULL PRIMARY KEY,
	nombre VARCHAR(30) NOT NULL,
	costo REAL NOT NULL,
	descripcion TEXT NOT NULL,
	estado BOOL NOT NULL
);
--Secuencia para las causas

DROP SEQUENCE IF EXISTS causa_seq;
CREATE SEQUENCE causa_seq;
--Creación de la tabla Causa.
CREATE TABLE Causa(
	codigoCausa VARCHAR(30) NOT NULL PRIMARY KEY,
	nombre VARCHAR(30) NOT NULL UNIQUE,
	descripcion TEXT NOT NULL,
	estado BOOL NOT NULL
);
ALTER TABLE Causa ALTER codigoCausa SET DEFAULT nextval('causa_seq');
--Secuencia para las historias clinicas
DROP SEQUENCE IF EXISTS hist_seq;
CREATE SEQUENCE hist_seq;
--Creación de la tabla HistoriaClinica. Está relacionada con Paciente.
CREATE TABLE HistoriaClinica(
	numHistoria VARCHAR(35) NOT NULL PRIMARY KEY,
	fechaAper timestamp NOT NULL,
	idPaciente VARCHAR(35) NOT NULL,
	CONSTRAINT fk_idPacHC FOREIGN KEY(idPaciente) REFERENCES Paciente(identificacion) ON UPDATE CASCADE ON DELETE NO ACTION
);
ALTER TABLE HistoriaClinica ALTER numHistoria SET DEFAULT nextval('hist_seq');
--Creación de la tabla Camas_Paciente. Se relaciona con Cama y Paciente.
CREATE TABLE Camas_Paciente(
	idPaciente VARCHAR(35) NOT NULL,
	numeroCama VARCHAR(20) NOT NULL,
	fechaAsignacion DATE NOT NULL,
	CONSTRAINT pk_camas_paciente PRIMARY KEY(idPaciente, numeroCama, fechaAsignacion), 
	CONSTRAINT fk_idPacCP FOREIGN KEY(idPaciente) REFERENCES Paciente(identificacion) ON UPDATE CASCADE ON DELETE NO ACTION
);

--Creación de la tabla Formula. Se relaciona con Medicamentos, historia clinica y medico.
CREATE TABLE Formula(
	idMedicamento VARCHAR(20) NOT NULL,
	idMedico VARCHAR(35) NOT NULL,
	numHistoria VARCHAR(35) NOT NULL,
	fechaAsignacion timestamp NOT NULL,
	CONSTRAINT pk_formula PRIMARY KEY(idMedico, idMedicamento, numHistoria, fechaAsignacion), 
	CONSTRAINT fk_idNumHist FOREIGN KEY(numHistoria) REFERENCES HistoriaClinica(numHistoria) ON UPDATE CASCADE ON DELETE NO ACTION,
	CONSTRAINT fk_idMedicamento FOREIGN KEY(idMedicamento) REFERENCES Medicamentos(codigoMedicamento) ON UPDATE CASCADE ON DELETE NO ACTION,
	CONSTRAINT fk_idMedicoOnFormula FOREIGN KEY(idMedico) REFERENCES Medico(identificacion) ON UPDATE CASCADE ON DELETE NO ACTION

);
--Secuencia para las campanas
DROP SEQUENCE IF EXISTS camp_seq;
CREATE SEQUENCE camp_seq;
--Creación de la tabla Campana. Se relaciona con Medico.
CREATE TABLE Campana(
	codigoCampana VARCHAR(35) NOT NULL PRIMARY KEY,
	fecha timestamp NOT NULL,
	nombre VARCHAR(30) NOT NULL UNIQUE,
	objetivo TEXT NOT NULL,
	idResponsable VARCHAR(35) NOT NULL,
	estado BOOL NOT NULL,
	CONSTRAINT fk_idResp FOREIGN KEY(idResponsable) REFERENCES Medico(identificacion) ON UPDATE CASCADE ON DELETE NO ACTION
);
ALTER TABLE Campana ALTER codigoCampana SET DEFAULT nextval('camp_seq');
--Creación de la tabla Pacientes_Campana. Relaciona a Paciente con Cama.
CREATE TABLE Pacientes_Campana(
	idPaciente VARCHAR(35) NOT NULL,
	idCampana VARCHAR(35) NOT NULL,
	CONSTRAINT pk_pacientes_campana PRIMARY KEY(idPaciente, idCampana), 
	CONSTRAINT fk_idPacPC FOREIGN KEY(idPaciente) REFERENCES Paciente(identificacion) ON UPDATE CASCADE ON DELETE NO ACTION,
	CONSTRAINT fk_idCampPC FOREIGN KEY(idPaciente) REFERENCES Paciente(identificacion) ON UPDATE CASCADE ON DELETE NO ACTION
);
--Secuencia para los registros
DROP SEQUENCE IF EXISTS registro_seq;
CREATE SEQUENCE registro_seq;
--Creación de la tabla RegistroHC. Relaciona con Historia Clinica, medico y causa.
CREATE TABLE RegistroHC(
	codigoRegistro VARCHAR(35) NOT NULL PRIMARY KEY,
	numHistoria VARCHAR(35) NOT NULL,
	--codigoCausa VARCHAR (30) NOT NULL,
	idMedico VARCHAR(35) NOT NULL,
	fecha timestamp NOT NULL,
	precio REAL NOT NULL,
	--CONSTRAINT pk_registroHC PRIMARY KEY(codigoCausa, numHistoria, idMedico,fecha), 
	CONSTRAINT fk_numHC FOREIGN KEY(numHistoria) REFERENCES HistoriaClinica(numHistoria) ON UPDATE CASCADE ON DELETE NO ACTION,
	--CONSTRAINT fk_codCau FOREIGN KEY(codigoCausa) REFERENCES Causa(codigoCausa) ON UPDATE CASCADE ON DELETE NO ACTION,
	CONSTRAINT fk_idMed FOREIGN KEY(idMedico) REFERENCES Medico(identificacion) ON UPDATE CASCADE ON DELETE NO ACTION	
);
ALTER TABLE RegistroHC ALTER codigoRegistro SET DEFAULT nextval('registro_seq');
--Tabla Causas_Registro que permite almacenar las causas de un registro
CREATE TABLE Causas_Registro(
	codigoCausa VARCHAR (30) NOT NULL,
	codigoRegistro VARCHAR(35) NOT NULL,
	CONSTRAINT pk_causasregistro PRIMARY KEY(codigoCausa,codigoRegistro), 
	CONSTRAINT fk_codCau FOREIGN KEY(codigoCausa) REFERENCES Causa(codigoCausa) ON UPDATE CASCADE ON DELETE NO ACTION
);
--------------------------------------------------------------------------------------------
--Creacion empleado por defecto
INSERT INTO area VALUES(1, 'Area1', 'Desc', true);
INSERT INTO persona VALUES ('123', 'bra', 'rod', '3230000', 'Cra X');
INSERT INTO empleado VALUES ('123', 10, 'bra@aol.com', 'Administrador', 'bra',  NULL , NULL, true);
--Creacion enfermera
INSERT INTO persona VALUES ('789', 'Alvaro', 'Martinez', '4540000', 'Cra zX');
INSERT INTO empleado VALUES ('789', 10, 'alv@aol.com', 'Enfermera', 'alv',  NULL , 1, true);
INSERT INTO enfermera VALUES ('789', 1);
INSERT INTO Habilidades_Enfermera VALUES ('789', 'muchas habilidades');
INSERT INTO Habilidades_Enfermera VALUES ('789', 'mas habilidades');

