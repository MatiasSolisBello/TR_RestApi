/*
DROP TABLE ADMIN;
DROP TABLE CLIENTE;
DROP TABLE SERVICIOS;
DROP TABLE DEPARTAMENTO;
DROP TABLE RESERVA;
DROP TABLE CHECKIN;
DROP TABLE CHECKOUT;


SELECT * FROM admin;
SELECT * FROM CLIENTE;
SELECT * FROM departamento;
SELECT * FROM RESERVA;
SELECT * FROM servicios
SELECT * FROM CHECKIN;
SELECT * FROM CHECKOUT;
*/

CREATE TABLE admin (
    rut       NUMBER(9) NOT NULL,
    nombre    VARCHAR2(100) NOT NULL,
    correo    VARCHAR2(100) NOT NULL,
    password  VARCHAR2(100) NOT NULL
);

ALTER TABLE admin ADD CONSTRAINT admin_pk PRIMARY KEY ( rut );

CREATE TABLE cliente (
    rut       NUMBER(9) NOT NULL,
    nombre    VARCHAR2(100) NOT NULL,
    correo    VARCHAR2(100) NOT NULL,
    password  VARCHAR2(100) NOT NULL,
    telefono  VARCHAR2(20) NOT NULL
);

ALTER TABLE cliente ADD CONSTRAINT cliente_pk PRIMARY KEY ( rut );

CREATE TABLE departamento (
    id_depart    NUMBER(10) NOT NULL,
    precio       NUMBER(5) NOT NULL,
    estado       VARCHAR2(100) NOT NULL,
    ciudad       VARCHAR2(100) NOT NULL,
    descripcion  VARCHAR2(100) NOT NULL,
    foto         BLOB
);

ALTER TABLE departamento ADD CONSTRAINT departamento_pk PRIMARY KEY ( id_depart );

CREATE TABLE reserva (
    id_reserva     NUMBER(10) NOT NULL,
    precio_total   NUMBER(10) NOT NULL,
    descripcion    VARCHAR2(100) NOT NULL,
    fecha_llegada  DATE NOT NULL,
    fecha_salida   DATE NOT NULL,
    id_depart      NUMBER(10) NOT NULL,
    rut            NUMBER(9) NOT NULL,
    id_servicio    NUMBER(10) NOT NULL
);

ALTER TABLE reserva ADD CONSTRAINT reserva_pk PRIMARY KEY ( id_reserva );

CREATE TABLE servicios (
    id_servicio  NUMBER(10) NOT NULL,
    nombre       VARCHAR2(100) NOT NULL,
    descripcion  CLOB NOT NULL,
    precio       NUMBER NOT NULL
);

ALTER TABLE servicios ADD CONSTRAINT servicios_pk PRIMARY KEY ( id_servicio );

CREATE TABLE checkin (
    id           NUMBER(5, 5) NOT NULL,
    condiciones  VARCHAR2(100) NOT NULL,
    id_reserva   NUMBER(10) NOT NULL
);

ALTER TABLE checkin ADD CONSTRAINT checkin_pk PRIMARY KEY ( id );

CREATE TABLE checkout (
    id          NUMBER(5, 5) NOT NULL,
    estado      VARCHAR2(100) NOT NULL,
    multa       NUMBER,
    problemas   VARCHAR2(100) NOT NULL,
    id_reserva  NUMBER(10) NOT NULL
);

ALTER TABLE checkout ADD CONSTRAINT checkout_pk PRIMARY KEY ( id );

--------------------------------------------------
        --LLAVES FORANEAS
--------------------------------------------------
ALTER TABLE checkin
    ADD CONSTRAINT checkin_reserva_fk FOREIGN KEY ( id_reserva )
        REFERENCES reserva ( id_reserva );

ALTER TABLE checkout
    ADD CONSTRAINT checkout_reserva_fk FOREIGN KEY ( id_reserva )
        REFERENCES reserva ( id_reserva );
        
ALTER TABLE reserva
    ADD CONSTRAINT reserva_cliente_fk FOREIGN KEY ( rut )
        REFERENCES cliente ( rut );

ALTER TABLE reserva
    ADD CONSTRAINT reserva_departamento_fk FOREIGN KEY ( id_depart )
        REFERENCES departamento ( id_depart );

ALTER TABLE reserva
    ADD CONSTRAINT reserva_servicios_fk FOREIGN KEY ( id_servicio )
        REFERENCES servicios ( id_servicio );

--------------------------------------------------
        --AUTO INCREMENTABLES
--------------------------------------------------

--AUTO INCREMENT DEPARTAMENTO
CREATE SEQUENCE depart_seq START WITH 1 INCREMENT BY 1;

CREATE OR REPLACE TRIGGER depart_trigger
BEFORE INSERT
ON departamento
REFERENCING NEW AS NEW
FOR EACH ROW
BEGIN
SELECT depart_seq.nextval INTO :NEW.ID_DEPART FROM dual;
END;

INSERT INTO DEPARTAMENTO( PRECIO, ESTADO, CIUDAD, DESCRIPCION) VALUES
(20000, 'DISPONIBLE', 'VALDIVIA', '2 BAÑOS, 2 HABITACIONES');

INSERT INTO DEPARTAMENTO( PRECIO, ESTADO, CIUDAD, DESCRIPCION) VALUES
(30000, 'DISPONIBLE', 'VALDIVIA', '2 BAÑOS, 4 HABITACIONES');

INSERT INTO DEPARTAMENTO( PRECIO, ESTADO, CIUDAD, DESCRIPCION) VALUES
(50000, 'EN REPARACION', 'VALDIVIA', '3 BAÑOS, 5 HABITACIONES');

--AUTO INCREMENT SERVICIOS
CREATE SEQUENCE servicios_seq START WITH 1 INCREMENT BY 1;

CREATE OR REPLACE TRIGGER servicios_trigger
BEFORE INSERT
ON servicios
REFERENCING NEW AS NEW
FOR EACH ROW
BEGIN
SELECT servicios_seq.nextval INTO :NEW.ID_servicio FROM dual;
END;

INSERT INTO servicios( NOMBRE, DESCRIPCION, PRECIO) VALUES
( 'Internet VTR', 'Internet 2 MB', 3000);

INSERT INTO servicios( NOMBRE, DESCRIPCION, PRECIO) VALUES
( 'Cable', '2 canales', 2000);

INSERT INTO servicios( NOMBRE, DESCRIPCION, PRECIO) VALUES
( 'Amoblado', '1 cama', 3000);


--AUTO INCREMENT RESERVA
CREATE SEQUENCE RESERVA_seq START WITH 1 INCREMENT BY 1;

CREATE OR REPLACE TRIGGER RESERVA_trigger
BEFORE INSERT
ON RESERVA
REFERENCING NEW AS NEW
FOR EACH ROW
BEGIN
SELECT RESERVA_seq.nextval INTO :NEW.ID_RESERVA FROM dual;
END;

--INSERCCION DATOS ADMIN
INSERT INTO ADMIN(RUT, NOMBRE, CORREO, PASSWORD) VALUES
('200589696', 'John Constantine', 'john.const@deathmail.com', '202cb962ac59075b964b07152d234b70');

--INSERCCION DATOS CLIENTE
INSERT INTO CLIENTE(RUT, NOMBRE, CORREO, TELEFONO, PASSWORD) VALUES
('190229626', 'German Acevedo', 'ger.acevedo@deathmail.com',57947395, '202cb962ac59075b964b07152d234b70');


--------------------------------------------------
        --CREAR DATOS EN RESERVA 
--------------------------------------------------
--AUTO INCREMENT CHECKIN
CREATE SEQUENCE CHECKIN_SEQ START WITH 1 INCREMENT BY 1;

CREATE OR REPLACE TRIGGER CHECKIN_trigger
BEFORE INSERT
ON CHECKIN
REFERENCING NEW AS NEW
FOR EACH ROW
BEGIN
SELECT CHECKIN_seq.nextval INTO :NEW.ID FROM dual;
END;

--AUTO INCREMENT CHECKOUT
CREATE SEQUENCE CHECKOUT_SEQ START WITH 1 INCREMENT BY 1;

CREATE OR REPLACE TRIGGER CHECKOUT_trigger
BEFORE INSERT
ON CHECKOUT
REFERENCING NEW AS NEW
FOR EACH ROW
BEGIN
SELECT CHECKOUT_seq.nextval INTO :NEW.ID FROM dual;
END;