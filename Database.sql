CREATE TABLE usuarios(
id_rut serial,
contraseña varchar(15),
nombre varchar(15),
apellido varchar(20),
tipo varchar,
correo varchar(30),
telefono int,
direccion varchar(40),
primary key(id_rut)
);
 
CREATE TABLE proveedores(
id_proveedores serial,
nombre varchar(30),
direccion varchar(30),
telefono int,
correo varchar(30),
web varchar(20),
primary key(id_proveedores)
);
 
CREATE TABLE articulos(
id_articulo serial,
categoria varchar(15),
titulo varchar(30),
autor varchar(20),
año int,
marca varchar(20),
ubicacion varchar(30),
dias_prestamo int,
id_proveedor serial references proveedores(id_proveedores),
precio int,
datos_extra text,
primary key(id_articulo)
);
 
CREATE TABLE ejemplares(
id_ejemplar serial,
id_articulo serial references articulos(id_articulo),
estado varchar(10),
primary key(id_ejemplar)
);
 
CREATE TABLE prestamos(
id_prestamos serial,
id_bibliotecario serial references usuarios(id_rut),
id_usuario serial references usuarios(id_rut),
id_ejemplar serial references ejemplares(id_ejemplar),
fecha_prestamo date,
fecha_devolucion date,
estado varchar(10),
primary key(id_prestamos)
);
