--Proyecto Base de datos


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
	CONSTRAINT fk_codigoArea FOREIGN KEY(codigoArea) REFERENCES Area(codigoArea)
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
	CONSTRAINT fk_identificacion FOREIGN KEY(identificacion) REFERENCES Persona(identificacion)
);

--Creacion de la tabla empleado. Está relacionada con persona, con ella misma (como jefe) y con area (a la que pertenece)
CREATE TABLE Empleado(
	identificacion VARCHAR(35) NOT NULL PRIMARY KEY,
	salario INT NOT NULL,
	email VARCHAR(40) NOT NULL,
	cargo VARCHAR(40) NOT NULL,
	jefe VARCHAR(35) NOT NULL,
	codigoArea INT NOT NULL,
	CONSTRAINT fk_identificacion FOREIGN KEY(identificacion) REFERENCES Persona(identificacion),
	CONSTRAINT fk_jefe FOREIGN KEY(jefe) REFERENCES Empleado(identificacion),
	CONSTRAINT fk_codigoArea FOREIGN KEY(codigoArea) REFERENCES Area(codigoArea)
);	

--Creacion de la tabla enfermera. Está relacionada con empleado
CREATE TABLE Enfermera(
	identificacion VARCHAR(35) NOT NULL PRIMARY KEY,
	anosExp INT NOT NULL,
	CONSTRAINT fk_identificacion FOREIGN KEY(identificacion) REFERENCES Empleado(identificacion)
);

--Creación de la tabla habilidades enfermera. Está relacionada con enfermera 
CREATE TABLE Habilidades_Enfermera(
	identificacion VARCHAR(35) NOT NULL,
	habilidad VARCHAR(40) NOT NULL,
	CONSTRAINT pk_habilidades PRIMARY KEY(identificacion, habilidad)
);

--Creación de la tabla Médico. Está relacionada con empleado
CREATE TABLE Medico(
	identificacion VARCHAR(35) NOT NULL PRIMARY KEY,
	numeroLicencia INT NOT NULL,
	especialidad VARCHAR(40) NOT NULL,
	universidad VARCHAR(40) NOT NULL,
	CONSTRAINT fk_identificacion FOREIGN KEY(identificacion) REFERENCES Empleado(identificacion)
);


--Creación de la tabla medicamentos (ejem: ibuprofeno, acetaminofen, etc)
CREATE TABLE Medicamentos(
	codigoMedicamento VARCHAR(30) NOT NULL PRIMARY KEY,
	nombre VARCHAR(30) NOT NULL,
	costo MONEY NOT NULL,
	descripcion TEXT NOT NULL
);
