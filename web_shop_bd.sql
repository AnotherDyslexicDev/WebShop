-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema web_shop_bd
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema web_shop_bd
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `web_shop_bd` DEFAULT CHARACTER SET utf8 ;
USE `web_shop_bd` ;

-- -----------------------------------------------------
-- Table `web_shop_bd`.`roles`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `web_shop_bd`.`roles` (
  `idRol` INT NOT NULL AUTO_INCREMENT,
  `nombreRol` VARCHAR(45) NOT NULL,
  `descripcion` VARCHAR(45) NOT NULL,
  `creado` TIMESTAMP NOT NULL,
  `actualizado` TIMESTAMP NOT NULL,
  PRIMARY KEY (`idRol`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `web_shop_bd`.`usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `web_shop_bd`.`usuario` (
  `idUsuario` INT NOT NULL AUTO_INCREMENT,
  `nombreUsuario` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `telefono` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `direccion` VARCHAR(45) NOT NULL,
  `creado` TIMESTAMP NOT NULL,
  `actualizado` TIMESTAMP NOT NULL,
  `token` VARCHAR(50) NOT NULL,
  `roles_idRol` INT NOT NULL,
  PRIMARY KEY (`idUsuario`),
  INDEX `fk_usuario_roles_idx` (`roles_idRol` ASC) VISIBLE,
  CONSTRAINT `fk_usuario_roles`
    FOREIGN KEY (`roles_idRol`)
    REFERENCES `web_shop_bd`.`roles` (`idRol`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `web_shop_bd`.`categorias`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `web_shop_bd`.`categorias` (
  `idCategoria` INT NOT NULL AUTO_INCREMENT,
  `idCategoriaPadre` INT,
  `nombreCategoria` VARCHAR(45) NOT NULL,
  `descripcion` VARCHAR(150) NOT NULL,
  `creado` TIMESTAMP NOT NULL,
  `actualizado` TIMESTAMP NOT NULL,
  PRIMARY KEY (`idCategoria`),
  CONSTRAINT `fk_categorias_categorias`
    FOREIGN KEY (`idCategoriaPadre`)
    REFERENCES `categorias` (`idCategoria`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `web_shop_bd`.`carrito`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `web_shop_bd`.`carrito` (
  `idCarrito` INT NOT NULL AUTO_INCREMENT,
  `subTotal` INT NOT NULL,
  `total` INT NOT NULL,
  `creado` TIMESTAMP NOT NULL,
  `actualizado` TIMESTAMP NOT NULL,
  `usuario_idUsuario` INT NOT NULL,
  PRIMARY KEY (`idCarrito`),
  INDEX `fk_carrito_usuario1_idx` (`usuario_idUsuario` ASC) VISIBLE,
  CONSTRAINT `fk_carrito_usuario1`
    FOREIGN KEY (`usuario_idUsuario`)
    REFERENCES `web_shop_bd`.`usuario` (`idUsuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `web_shop_bd`.`formapago`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `web_shop_bd`.`formapago` (
  `idFormaPago` INT NOT NULL AUTO_INCREMENT,
  `nombreFormaPago` VARCHAR(45) NOT NULL,
  `creada` TIMESTAMP NOT NULL,
  `actualizada` TIMESTAMP NOT NULL,
  PRIMARY KEY (`idFormaPago`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `web_shop_bd`.`venta`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `web_shop_bd`.`venta` (
  `idVenta` INT NOT NULL AUTO_INCREMENT,
  `subTotalVenta` INT NOT NULL,
  `totalVenta` INT NOT NULL,
  `creado` TIMESTAMP NOT NULL,
  `actualizado` TIMESTAMP NOT NULL,
  `usuario_idUsuario` INT NOT NULL,
  `formapago_idFormaPago` INT NOT NULL,
  PRIMARY KEY (`idVenta`),
  INDEX `fk_venta_usuario1_idx` (`usuario_idUsuario` ASC) VISIBLE,
  INDEX `fk_venta_formapago1_idx` (`formapago_idFormaPago` ASC) VISIBLE,
  CONSTRAINT `fk_venta_usuario1`
    FOREIGN KEY (`usuario_idUsuario`)
    REFERENCES `web_shop_bd`.`usuario` (`idUsuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_venta_formapago1`
    FOREIGN KEY (`formapago_idFormaPago`)
    REFERENCES `web_shop_bd`.`formapago` (`idFormaPago`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `web_shop_bd`.`proveedores`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `web_shop_bd`.`proveedores` (
  `idProveedor` INT NOT NULL AUTO_INCREMENT,
  `nombreProveedor` VARCHAR(45) NOT NULL,
  `rutProveedor` VARCHAR(45) NOT NULL,
  `direccionProveedor` VARCHAR(45) NOT NULL,
  `telefonoProveedor` VARCHAR(45) NOT NULL,
  `correoProveedor` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idProveedor`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `web_shop_bd`.`productos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `web_shop_bd`.`productos` (
  `idProducto` INT NOT NULL AUTO_INCREMENT,
  `nombreProducto` VARCHAR(45) NOT NULL,
  `descripcion` VARCHAR(45) NOT NULL,
  `precio` INT NOT NULL,
  `stock` INT NOT NULL,
  `creado` TIMESTAMP NOT NULL,
  `actualizado` TIMESTAMP NOT NULL,
  `imagen` VARCHAR(100) NOT NULL,
  `categorias_idCategoria` INT NOT NULL,
  `proveedores_idProveedor` INT NOT NULL,
  `imagenSlider` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`idProducto`),
  INDEX `fk_productos_categorias1_idx` (`categorias_idCategoria` ASC) VISIBLE,
  INDEX `fk_productos_proveedores1_idx` (`proveedores_idProveedor` ASC) VISIBLE,
  CONSTRAINT `fk_productos_categorias1`
    FOREIGN KEY (`categorias_idCategoria`)
    REFERENCES `web_shop_bd`.`categorias` (`idCategoria`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_productos_proveedores1`
    FOREIGN KEY (`proveedores_idProveedor`)
    REFERENCES `web_shop_bd`.`proveedores` (`idProveedor`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `web_shop_bd`.`detalleventa`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `web_shop_bd`.`detalleventa` (
  `idDetalleVenta` INT NOT NULL AUTO_INCREMENT,
  `creado` TIMESTAMP NOT NULL,
  `actualizado` TIMESTAMP NOT NULL,
  `venta_idVenta` INT NOT NULL,
  `productos_idProducto` INT NOT NULL,
  PRIMARY KEY (`idDetalleVenta`),
  INDEX `fk_detalleventa_venta1_idx` (`venta_idVenta` ASC) VISIBLE,
  INDEX `fk_detalleventa_productos1_idx` (`productos_idProducto` ASC) VISIBLE,
  CONSTRAINT `fk_detalleventa_venta1`
    FOREIGN KEY (`venta_idVenta`)
    REFERENCES `web_shop_bd`.`venta` (`idVenta`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_detalleventa_productos1`
    FOREIGN KEY (`productos_idProducto`)
    REFERENCES `web_shop_bd`.`productos` (`idProducto`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `web_shop_bd`.`detallecarrito`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `web_shop_bd`.`detallecarrito` (
  `idDetalleCarrito` INT NOT NULL AUTO_INCREMENT,
  `creado` TIMESTAMP NOT NULL,
  `actualizado` TIMESTAMP NOT NULL,
  `carrito_idCarrito` INT NOT NULL,
  `productos_idProducto` INT NOT NULL,
  PRIMARY KEY (`idDetalleCarrito`),
  INDEX `fk_detallecarrito_carrito1_idx` (`carrito_idCarrito` ASC) VISIBLE,
  INDEX `fk_detallecarrito_productos1_idx` (`productos_idProducto` ASC) VISIBLE,
  CONSTRAINT `fk_detallecarrito_carrito1`
    FOREIGN KEY (`carrito_idCarrito`)
    REFERENCES `web_shop_bd`.`carrito` (`idCarrito`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_detallecarrito_productos1`
    FOREIGN KEY (`productos_idProducto`)
    REFERENCES `web_shop_bd`.`productos` (`idProducto`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `web_shop_bd`.`slider`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `web_shop_bd`.`slider` (
  `idSlider` INT NOT NULL AUTO_INCREMENT,
  `creado` TIMESTAMP NOT NULL,
  `actualizado` TIMESTAMP NOT NULL,
  `productos_idProducto` INT NOT NULL,
  `imagenSlider` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`idSlider`),
  INDEX `fk_slider_productos1_idx` (`productos_idProducto` ASC) VISIBLE,
  CONSTRAINT `fk_slider_productos1`
    FOREIGN KEY (`productos_idProducto`)
    REFERENCES `web_shop_bd`.`productos` (`idProducto`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;
-- Insertar rol "Administrador"
INSERT INTO web_shop_bd.roles (nombreRol, descripcion, creado, actualizado)
VALUES ('Administrador', 'Rol con permisos de administrador', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());

-- Insertar rol "Usuario"
INSERT INTO web_shop_bd.roles (nombreRol, descripcion, creado, actualizado)
VALUES ('Usuario', 'Rol para usuarios regulares', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());

-- Insertar categoría raíz "Implementos deportivos"
INSERT INTO `web_shop_bd`.`categorias` (`idCategoriaPadre`, `nombreCategoria`, `descripcion`, `creado`, `actualizado`)
VALUES (NULL, 'Implementos deportivos', 'Implementos deportivos para diferentes actividades físicas', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());

-- Insertar subcategoría "Mancuernas"
INSERT INTO `web_shop_bd`.`categorias` (`idCategoriaPadre`, `nombreCategoria`, `descripcion`, `creado`, `actualizado`)
VALUES (1, 'Mancuernas', 'Mancuernas de diferentes pesos', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());

-- Insertar subcategoría "Yoga"
INSERT INTO `web_shop_bd`.`categorias` (`idCategoriaPadre`, `nombreCategoria`, `descripcion`, `creado`, `actualizado`)
VALUES (1, 'Yoga', 'Implementos para yoga', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());

-- Insertar subcategoría "Equipamiento de fitness"
INSERT INTO `web_shop_bd`.`categorias` (`idCategoriaPadre`, `nombreCategoria`, `descripcion`, `creado`, `actualizado`)
VALUES (1, 'Equipamiento de fitness', 'Aparatos para hacer ejercico', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
-- Insert Proveedor
INSERT INTO `web_shop_bd`.`proveedores` (`nombreProveedor`, `rutProveedor`, `direccionProveedor`, `telefonoProveedor`, `correoProveedor`)
VALUES ('David Morales Palta', '15763620-0', 'principal 297', '+56989738297', 'contacto@fullstackdavid.com');

-- insert productos
-- Insertar producto "Kit Yoga"
INSERT INTO web_shop_bd.productos (nombreProducto, descripcion, precio, stock, creado, actualizado, imagen, categorias_idCategoria, proveedores_idProveedor, imagenSlider)
VALUES ('Kit Yoga', 'Set de implementos para la práctica de Yoga', 25000, 10, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP(), '/img/kit_yoga_400.webp', 3, 1, '/img/kit_yoga.webp');

-- Insertar producto "Kit Mancuernas"
INSERT INTO web_shop_bd.productos (nombreProducto, descripcion, precio, stock, creado, actualizado, imagen, categorias_idCategoria, proveedores_idProveedor, imagenSlider)
VALUES ('Kit Mancuernas', 'Set de mancuernas de diferentes pesos', 35000, 8, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP(), '/img/kit_mancuernas_400.webp', 2, 1, '/img/kit_mancuernas.webp');

-- Insertar producto "Ab Wheel"
INSERT INTO web_shop_bd.productos (nombreProducto, descripcion, precio, stock, creado, actualizado, imagen, categorias_idCategoria, proveedores_idProveedor, imagenSlider)
VALUES ('Ab Wheel', 'Rueda de ejercicio para trabajar el abdomen', 15000, 15, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP(), '/img/ab_wheel_400.webp', 4, 1, '/img/AB_Weel.webp');

INSERT INTO web_shop_bd.slider (productos_idProducto,imagenSlider,creado,actualizado) VALUES (1,'/img/kit_yoga.webp', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
INSERT INTO web_shop_bd.slider (productos_idProducto,imagenSlider,creado,actualizado) VALUES (2,'/img/kit_mancuernas.webp', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
INSERT INTO web_shop_bd.slider (productos_idProducto,imagenSlider,creado,actualizado) VALUES (3,'/img/AB_Weel.webp', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
