--Proyecto Base de datos, Clinica DB : Daniel Correa , Alvaro Martienez , Brayan Rodriguez

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
	descripcion TEXT NOT NULL
);

--Creación de la tabla cama (ejem: cama1, cama2, etc). Está relacionada con Area
CREATE TABLE Cama(
	numeroCama VARCHAR(20) PRIMARY KEY NOT NULL,
	estado BOOLEAN NOT NULL,
	descripcion TEXT NOT NULL,
	codigoArea INT NOT NULL,
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
	CONSTRAINT fk_identificacion FOREIGN KEY(identificacion) REFERENCES Persona(identificacion) ON UPDATE CASCADE ON DELETE NO ACTION 
);

--Creacion de la tabla empleado. Está relacionada con persona, con ella misma (como jefe) y con area (a la que pertenece)
CREATE TABLE Empleado(
	identificacion VARCHAR(35) NOT NULL PRIMARY KEY,
	salario INT NOT NULL,
	email VARCHAR(40) NOT NULL UNIQUE,
	cargo VARCHAR(40) NOT NULL,
	jefe VARCHAR(35),
	codigoArea INT,
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
	costo MONEY NOT NULL,
	descripcion TEXT NOT NULL
);

--Creación de la tabla Causa.
CREATE TABLE Causa(
	codigoCausa VARCHAR(30) NOT NULL PRIMARY KEY,
	nombre VARCHAR(30) NOT NULL,
	descripcion VARCHAR(30) NOT NULL
);

--Creación de la tabla HistoriaClinica. Está relacionada con Paciente.
CREATE TABLE HistoriaClinica(
	numHistoria VARCHAR(35) NOT NULL PRIMARY KEY,
	fechaAper DATE NOT NULL,
	idPaciente VARCHAR(35) NOT NULL,
	CONSTRAINT fk_idPacHC FOREIGN KEY(idPaciente) REFERENCES Paciente(identificacion) ON UPDATE CASCADE ON DELETE NO ACTION
);

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
	fechaAsignacion DATE NOT NULL,
	CONSTRAINT pk_formula PRIMARY KEY(idMedico, idMedicamento, numHistoria, fechaAsignacion), 
	CONSTRAINT fk_idNumHist FOREIGN KEY(numHistoria) REFERENCES HistoriaClinica(numHistoria) ON UPDATE CASCADE ON DELETE NO ACTION,
	CONSTRAINT fk_idMedicamento FOREIGN KEY(idMedicamento) REFERENCES Medicamentos(codigoMedicamento) ON UPDATE CASCADE ON DELETE NO ACTION,
	CONSTRAINT fk_idMedicoOnFormula FOREIGN KEY(idMedico) REFERENCES Medico(identificacion) ON UPDATE CASCADE ON DELETE NO ACTION

);

--Creación de la tabla Campana. Se relaciona con Medico.
CREATE TABLE Campana(
	codigoCampana VARCHAR(35) NOT NULL PRIMARY KEY,
	fecha DATE NOT NULL,
	nombre VARCHAR(30) NOT NULL,
	objetivo VARCHAR(99) NOT NULL,
	idResponsable VARCHAR(35) NOT NULL,
	CONSTRAINT fk_idResp FOREIGN KEY(idResponsable) REFERENCES Medico(identificacion) ON UPDATE CASCADE ON DELETE NO ACTION
);

--Creación de la tabla Pacientes_Campana. Relaciona a Paciente con Cama.
CREATE TABLE Pacientes_Campana(
	idPaciente VARCHAR(35) NOT NULL,
	idCampana VARCHAR(35) NOT NULL,
	CONSTRAINT pk_pacientes_campana PRIMARY KEY(idPaciente, idCampana), 
	CONSTRAINT fk_idPacPC FOREIGN KEY(idPaciente) REFERENCES Paciente(identificacion) ON UPDATE CASCADE ON DELETE NO ACTION,
	CONSTRAINT fk_idCampPC FOREIGN KEY(idPaciente) REFERENCES Paciente(identificacion) ON UPDATE CASCADE ON DELETE NO ACTION
);

--Creación de la tabla RegistroHC. Relaciona con Historia Clinica, medico y causa.
CREATE TABLE RegistroHC(
	numHistoria VARCHAR(35) NOT NULL,
	codigoCausa VARCHAR (30) NOT NULL,
	idMedico VARCHAR(35) NOT NULL,
	fecha DATE NOT NULL,
	precio INT NOT NULL,
	CONSTRAINT pk_registroHC PRIMARY KEY(codigoCausa, numHistoria, idMedico), 
	CONSTRAINT fk_numHC FOREIGN KEY(numHistoria) REFERENCES HistoriaClinica(numHistoria) ON UPDATE CASCADE ON DELETE NO ACTION,
	CONSTRAINT fk_codCau FOREIGN KEY(codigoCausa) REFERENCES Causa(codigoCausa) ON UPDATE CASCADE ON DELETE NO ACTION,
	CONSTRAINT fk_idMed FOREIGN KEY(idMedico) REFERENCES Medico(identificacion) ON UPDATE CASCADE ON DELETE NO ACTION	
);

------------------------------------------------------------------------------------------
--Creacion empleado por defecto
INSERT INTO area VALUES(1, 'Area1', 'Desc');
INSERT INTO persona VALUES ('123', 'bra', 'rod', '3230000', 'Cra X');
INSERT INTO empleado VALUES ('123', 10, 'bra@aol.com', 'Administrador', NULL , NULL);
