CREATE DATABASE IF NOT EXISTS integrador_cac CHARACTER SET latin1 COLLATE latin1_spanish_ci;

USE integrador_cac;

CREATE TABLE IF NOT EXISTS oradores(
    id_oradores INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(25) NOT NULL,
    apellido VARCHAR(25) NOT NULL,
    mail VARCHAR(25) NOT NULL,
    tema VARCHAR(25) NOT NULL,
    fecha_alta timestamp DEFAULT CURRENT_TIMESTAMP
);

-- Insertar 10 registros de ejemplo
INSERT INTO oradores (nombre, apellido, mail, tema) VALUES
('Sergio', 'Cardozo', 'scardozo.sc@gmail.com', 'PHP'),
('Juan', 'Pedro', 'correo2@gmail.com', 'Java'),
('Esteban', 'Juarez', 'correo3@gmail.com', 'Ciberseguridad'),
('Jane', 'Doe', 'correo4@gmail.com', '.Net'),
('Natalia', 'Natalia', 'correo5@gmail.com', 'Vue'),
('Roberto', 'Gimenez', 'correo6@gmail.com', 'Angular'),
('Agustin', 'Cardozo', 'correo7@gmail.com', 'Javascript'),
('Esteban', 'Jimenez', 'correo8@gmail.com', 'Phyton'),
('Carlos', 'Romero', 'correo9@gmail.com', 'React'),
('Cristian', 'Kraft', 'correo10@gmail.com', 'Java');