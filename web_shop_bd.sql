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
CREATE SCHEMA IF NOT EXISTS `web_shop_bd` DEFAULT CHARACTER SET utf8mb3 ;
USE `web_shop_bd` ;

-- -----------------------------------------------------
-- Table `web_shop_bd`.`estados`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `web_shop_bd`.`estados` (
  `idEstado` INT NOT NULL AUTO_INCREMENT,
  `nombreEstado` VARCHAR(45) NOT NULL,
  `creado` TIMESTAMP NOT NULL,
  `actualizado` TIMESTAMP NOT NULL,
  PRIMARY KEY (`idEstado`))
ENGINE = InnoDB
AUTO_INCREMENT = 5
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `web_shop_bd`.`roles`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `web_shop_bd`.`roles` (
  `idRol` INT NOT NULL AUTO_INCREMENT,
  `nombreRol` VARCHAR(45) NOT NULL,
  `descripcion` VARCHAR(45) NOT NULL,
  `creado` TIMESTAMP NOT NULL,
  `actualizado` TIMESTAMP NOT NULL,
  `estados_idEstado` INT NOT NULL,
  PRIMARY KEY (`idRol`),
  INDEX `fk_roles_estados1_idx` (`estados_idEstado` ASC) VISIBLE,
  CONSTRAINT `fk_roles_estados1`
    FOREIGN KEY (`estados_idEstado`)
    REFERENCES `web_shop_bd`.`estados` (`idEstado`))
ENGINE = InnoDB
AUTO_INCREMENT = 5
DEFAULT CHARACTER SET = utf8mb3;


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
  `token` VARCHAR(50) NULL DEFAULT NULL,
  `roles_idRol` INT NOT NULL,
  `estados_idEstado` INT NOT NULL,
  `setExpirationDate` DATETIME(6) NULL DEFAULT NULL,
  PRIMARY KEY (`idUsuario`),
  INDEX `fk_usuario_roles_idx` (`roles_idRol` ASC) VISIBLE,
  INDEX `fk_usuario_estados1_idx` (`estados_idEstado` ASC) VISIBLE,
  CONSTRAINT `fk_usuario_estados1`
    FOREIGN KEY (`estados_idEstado`)
    REFERENCES `web_shop_bd`.`estados` (`idEstado`),
  CONSTRAINT `fk_usuario_roles`
    FOREIGN KEY (`roles_idRol`)
    REFERENCES `web_shop_bd`.`roles` (`idRol`))
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = utf8mb3;


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
  `estados_idEstado` INT NOT NULL,
  PRIMARY KEY (`idCarrito`),
  INDEX `fk_carrito_usuario1_idx` (`usuario_idUsuario` ASC) VISIBLE,
  INDEX `fk_carrito_estados1_idx` (`estados_idEstado` ASC) VISIBLE,
  CONSTRAINT `fk_carrito_usuario1`
    FOREIGN KEY (`usuario_idUsuario`)
    REFERENCES `web_shop_bd`.`usuario` (`idUsuario`),
  CONSTRAINT `fk_carrito_estados1`
    FOREIGN KEY (`estados_idEstado`)
    REFERENCES `web_shop_bd`.`estados` (`idEstado`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `web_shop_bd`.`categorias`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `web_shop_bd`.`categorias` (
  `idCategoria` INT NOT NULL AUTO_INCREMENT,
  `idCategoriaPadre` INT NULL DEFAULT NULL,
  `nombreCategoria` VARCHAR(45) NOT NULL,
  `descripcion` VARCHAR(150) NOT NULL,
  `creado` TIMESTAMP NOT NULL,
  `actualizado` TIMESTAMP NOT NULL,
  `estados_idEstado` INT NOT NULL,
  PRIMARY KEY (`idCategoria`),
  INDEX `fk_categorias_categorias` (`idCategoriaPadre` ASC) VISIBLE,
  INDEX `fk_categorias_estados1_idx` (`estados_idEstado` ASC) VISIBLE,
  CONSTRAINT `fk_categorias_categorias`
    FOREIGN KEY (`idCategoriaPadre`)
    REFERENCES `web_shop_bd`.`categorias` (`idCategoria`),
  CONSTRAINT `fk_categorias_estados1`
    FOREIGN KEY (`estados_idEstado`)
    REFERENCES `web_shop_bd`.`estados` (`idEstado`))
ENGINE = InnoDB
AUTO_INCREMENT = 9
DEFAULT CHARACTER SET = utf8mb3;


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
  `estados_idEstado` INT NOT NULL,
  PRIMARY KEY (`idProveedor`),
  INDEX `fk_proveedores_estados1_idx` (`estados_idEstado` ASC) VISIBLE,
  CONSTRAINT `fk_proveedores_estados1`
    FOREIGN KEY (`estados_idEstado`)
    REFERENCES `web_shop_bd`.`estados` (`idEstado`))
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = utf8mb3;


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
  `categoria_idCategoria` INT NULL DEFAULT NULL,
  `proveedor_idProveedor` INT NULL DEFAULT NULL,
  `estados_idEstado` INT NOT NULL,
  PRIMARY KEY (`idProducto`),
  INDEX `fk_productos_categorias1_idx` (`categorias_idCategoria` ASC) VISIBLE,
  INDEX `fk_productos_proveedores1_idx` (`proveedores_idProveedor` ASC) VISIBLE,
  INDEX `FK5c89mnk73yfvi74djxxbdo3ri` (`categoria_idCategoria` ASC) VISIBLE,
  INDEX `FKn28bgxwxwaudiupba729gsmp6` (`proveedor_idProveedor` ASC) VISIBLE,
  INDEX `fk_productos_estados1_idx` (`estados_idEstado` ASC) VISIBLE,
  CONSTRAINT `FK5c89mnk73yfvi74djxxbdo3ri`
    FOREIGN KEY (`categoria_idCategoria`)
    REFERENCES `web_shop_bd`.`categorias` (`idCategoria`),
  CONSTRAINT `fk_productos_categorias1`
    FOREIGN KEY (`categorias_idCategoria`)
    REFERENCES `web_shop_bd`.`categorias` (`idCategoria`),
  CONSTRAINT `fk_productos_estados1`
    FOREIGN KEY (`estados_idEstado`)
    REFERENCES `web_shop_bd`.`estados` (`idEstado`),
  CONSTRAINT `fk_productos_proveedores1`
    FOREIGN KEY (`proveedores_idProveedor`)
    REFERENCES `web_shop_bd`.`proveedores` (`idProveedor`),
  CONSTRAINT `FKn28bgxwxwaudiupba729gsmp6`
    FOREIGN KEY (`proveedor_idProveedor`)
    REFERENCES `web_shop_bd`.`proveedores` (`idProveedor`))
ENGINE = InnoDB
AUTO_INCREMENT = 7
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `web_shop_bd`.`detallecarrito`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `web_shop_bd`.`detallecarrito` (
  `idDetalleCarrito` INT NOT NULL AUTO_INCREMENT,
  `creado` TIMESTAMP NOT NULL,
  `actualizado` TIMESTAMP NOT NULL,
  `carrito_idCarrito` INT NOT NULL,
  `productos_idProducto` INT NOT NULL,
  `cantidad` INT NOT NULL,
  PRIMARY KEY (`idDetalleCarrito`),
  INDEX `fk_detallecarrito_carrito1_idx` (`carrito_idCarrito` ASC) VISIBLE,
  INDEX `fk_detallecarrito_productos1_idx` (`productos_idProducto` ASC) VISIBLE,
  CONSTRAINT `FK9mci6o811wdmo12ogv8f7oblv`
    FOREIGN KEY (`productos_idProducto`)
    REFERENCES `web_shop_bd`.`productos` (`idProducto`),
  CONSTRAINT `fk_detallecarrito_carrito1`
    FOREIGN KEY (`carrito_idCarrito`)
    REFERENCES `web_shop_bd`.`carrito` (`idCarrito`),
  CONSTRAINT `fk_detallecarrito_productos1`
    FOREIGN KEY (`productos_idProducto`)
    REFERENCES `web_shop_bd`.`productos` (`idProducto`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `web_shop_bd`.`formapago`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `web_shop_bd`.`formapago` (
  `idFormaPago` INT NOT NULL AUTO_INCREMENT,
  `nombreFormaPago` VARCHAR(45) NOT NULL,
  `creada` TIMESTAMP NOT NULL,
  `actualizada` TIMESTAMP NOT NULL,
  `estados_idEstado` INT NOT NULL,
  PRIMARY KEY (`idFormaPago`),
  INDEX `fk_formapago_estados1_idx` (`estados_idEstado` ASC) VISIBLE,
  CONSTRAINT `fk_formapago_estados1`
    FOREIGN KEY (`estados_idEstado`)
    REFERENCES `web_shop_bd`.`estados` (`idEstado`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


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
  CONSTRAINT `fk_venta_formapago1`
    FOREIGN KEY (`formapago_idFormaPago`)
    REFERENCES `web_shop_bd`.`formapago` (`idFormaPago`),
  CONSTRAINT `fk_venta_usuario1`
    FOREIGN KEY (`usuario_idUsuario`)
    REFERENCES `web_shop_bd`.`usuario` (`idUsuario`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


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
  CONSTRAINT `fk_detalleventa_productos1`
    FOREIGN KEY (`productos_idProducto`)
    REFERENCES `web_shop_bd`.`productos` (`idProducto`),
  CONSTRAINT `fk_detalleventa_venta1`
    FOREIGN KEY (`venta_idVenta`)
    REFERENCES `web_shop_bd`.`venta` (`idVenta`),
  CONSTRAINT `FKnv6k39bf2hg7g2qdul5ujtp7y`
    FOREIGN KEY (`productos_idProducto`)
    REFERENCES `web_shop_bd`.`productos` (`idProducto`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `web_shop_bd`.`slider`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `web_shop_bd`.`slider` (
  `idSlider` INT NOT NULL AUTO_INCREMENT,
  `creado` TIMESTAMP NOT NULL,
  `actualizado` TIMESTAMP NOT NULL,
  `productos_idProducto` INT NOT NULL,
  `imagenSlider` VARCHAR(100) NOT NULL,
  `estados_idEstado` INT NOT NULL,
  PRIMARY KEY (`idSlider`),
  INDEX `fk_slider_productos1_idx` (`productos_idProducto` ASC) VISIBLE,
  INDEX `fk_slider_estados1_idx` (`estados_idEstado` ASC) VISIBLE,
  CONSTRAINT `fk_slider_estados1`
    FOREIGN KEY (`estados_idEstado`)
    REFERENCES `web_shop_bd`.`estados` (`idEstado`),
  CONSTRAINT `fk_slider_productos1`
    FOREIGN KEY (`productos_idProducto`)
    REFERENCES `web_shop_bd`.`productos` (`idProducto`))
ENGINE = InnoDB
AUTO_INCREMENT = 7
DEFAULT CHARACTER SET = utf8mb3;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
