drop schema main;
create schema main;
use main;


CREATE TABLE persona (
    per_cedula INTEGER PRIMARY KEY,
    per_telefono INTEGER NOT NULL,
    per_celular LONG NOT NULL,
    per_nombre VARCHAR(45) NOT NULL,
    per_apellido VARCHAR(45) NOT NULL,
    per_direccion VARCHAR(100) NOT NULL
);

CREATE TABLE funcionario (
    fun_per_cedula INTEGER PRIMARY KEY,
    fun_identificador VARCHAR(10) NOT NULL,
    fun_nacimiento DATE NOT NULL,
    fun_RH VARCHAR(3) NOT NULL,
    fun_eps VARCHAR(45) NOT NULL,
    fun_fondoPension VARCHAR(100) NOT NULL,
    fun_ger_fun_per_cedula INTEGER NULL,
    FOREIGN KEY (fun_per_cedula)
        REFERENCES persona (per_cedula)
);

CREATE TABLE gerente (
    ger_fun_per_cedula INTEGER PRIMARY KEY,
    FOREIGN KEY (ger_fun_per_cedula)
        REFERENCES funcionario (fun_per_cedula)
);

ALTER TABLE funcionario ADD FOREIGN KEY (fun_ger_fun_per_cedula) REFERENCES gerente(ger_fun_per_cedula);

CREATE TABLE tecnico (
    tec_fun_per_cedula INTEGER PRIMARY KEY,
    tec_experiencia INTEGER(2) NOT NULL,
    tec_areaLaboral VARCHAR(45) NOT NULL,
    FOREIGN KEY (tec_fun_per_cedula)
        REFERENCES funcionario (fun_per_cedula)
);

CREATE TABLE vendedor (
    ven_fun_per_cedula INTEGER PRIMARY KEY,
    ven_cantidadVentas INTEGER NOT NULL,
    ven_gananciaVentas DOUBLE NOT NULL,
    FOREIGN KEY (ven_fun_per_cedula)
        REFERENCES funcionario (fun_per_cedula)
);

CREATE TABLE administrativo (
    adm_fun_per_cedula INTEGER PRIMARY KEY,
    FOREIGN KEY (adm_fun_per_cedula)
        REFERENCES funcionario (fun_per_cedula)
);

CREATE TABLE empresa (
    emp_id INT8 PRIMARY KEY,
    emp_per_cedula INTEGER NOT NULL,
    emp_nombre VARCHAR(100) NOT NULL,
    FOREIGN KEY (emp_per_cedula)
        REFERENCES persona (per_cedula)
);

CREATE TABLE sede (
    sed_id INTEGER NOT NULL,
    sed_emp_id INT8 NOT NULL,
    sed_telefono INTEGER NOT NULL,
    sed_direccion varchar(45) NOT NULL,
    FOREIGN KEY (sed_emp_id)
        REFERENCES empresa (emp_id),
    PRIMARY KEY (sed_id , sed_emp_id)
);

CREATE TABLE proveedor (
    pro_emp_id INT8 PRIMARY KEY,
    FOREIGN KEY (pro_emp_id)
        REFERENCES empresa (emp_id)
);

CREATE TABLE empresaCliente (
    empC_emp_id INT8 PRIMARY KEY,
    FOREIGN KEY (empC_emp_id)
        REFERENCES empresa (emp_id)
);

CREATE TABLE producto (
    prod_id VARCHAR(45) PRIMARY KEY,
    prod_cant INTEGER NOT NULL
);

CREATE TABLE insumo (
    ins_prod_id VARCHAR(45) PRIMARY KEY,
    ins_descripcion VARCHAR(500) NULL,
    FOREIGN KEY (ins_prod_id)
        REFERENCES producto (prod_id)
);

CREATE TABLE equipo (
    equ_prod_id VARCHAR(45) PRIMARY KEY,
    equ_modelo VARCHAR(45) NOT NULL,
    equ_marca VARCHAR(45) NOT NULL,
    equ_contador INTEGER NOT NULL,
    equ_estado VARCHAR(500) NOT NULL,
    equ_ingreso DATE NULL,
    FOREIGN KEY (equ_prod_id)
        REFERENCES producto (prod_id)
);

CREATE TABLE compra (
    com_factura INTEGER PRIMARY KEY,
    com_pro_emp_id INT8 NOT NULL,
    com_adm_fun_per_cedula INTEGER NOT NULL,
    com_fecha DATE NOT NULL,
    com_costoTotal DOUBLE,
    FOREIGN KEY (com_pro_emp_id)
        REFERENCES proveedor (pro_emp_id),
    FOREIGN KEY (com_adm_fun_per_cedula)
        REFERENCES administrativo (adm_fun_per_cedula)
);

CREATE TABLE detalleCompra (
    detC_com_factura INTEGER NOT NULL,
    detC_prod_id VARCHAR(45) NOT NULL,
    detC_cantidad INTEGER NOT NULL,
    detC_costo DOUBLE NOT NULL,
    FOREIGN KEY (detC_com_factura)
        REFERENCES compra (com_factura),
    FOREIGN KEY (detC_prod_id)
        REFERENCES producto (prod_id),
    PRIMARY KEY (detC_com_factura , detC_prod_id)
);

CREATE TABLE venta (
    vent_factura_id INTEGER PRIMARY KEY,
    vent_ven_fun_per_cedula INTEGER NOT NULL,
    vent_empC_emp_id INT8 NOT NULL,
    vent_fecha DATE NOT NULL,
    vent_costoTotal DOUBLE NOT NULL,
    FOREIGN KEY (vent_ven_fun_per_cedula)
        REFERENCES vendedor (ven_fun_per_cedula),
    FOREIGN KEY (vent_empC_emp_id)
        REFERENCES empresaCliente (empC_emp_id)
);

CREATE TABLE servicio (
    ser_ID INTEGER PRIMARY KEY,
    ser_tec_fun_per_Cedula INT NOT NULL,
    ser_equ_pro_ID VARCHAR(45) NOT NULL,
    ser_empC_emp_ID INT8 NOT NULL,
    ser_Fecha_de_solicitud DATE NOT NULL,
    ser_Descripción VARCHAR(500) NULL,
    ser_Cobrable BOOLEAN NOT NULL,
    ser_Fecha_llegada DATE NULL,
    ser_Fecha_salida DATE NULL,
    ser_Hora_salida TIME NULL,
    ser_Trabajo_realizado VARCHAR(200) NULL,
    ser_Pendiente TINYINT(1) NOT NULL,
    ser_Contador_actual INT NOT NULL,
    FOREIGN KEY (ser_tec_fun_per_Cedula)
        REFERENCES tecnico (tec_fun_per_cedula),
    FOREIGN KEY (ser_equ_pro_ID)
        REFERENCES equipo (equ_prod_id),
    FOREIGN KEY (ser_empC_emp_ID)
        REFERENCES empresaCliente (empC_emp_id)
);

CREATE TABLE detalleVenta (
    detV_prod_id VARCHAR(45) NOT NULL,
    detV_vent_factura INTEGER NOT NULL,
    detV_cantidad INTEGER NOT NULL,
    detV_costo DOUBLE NOT NULL,
    FOREIGN KEY (detV_prod_id)
        REFERENCES producto (prod_id),
    FOREIGN KEY (detV_vent_factura)
        REFERENCES venta (vent_factura_id),
    PRIMARY KEY (detV_prod_id , detV_vent_factura)
);

CREATE TABLE renta (
    ren_ID INT PRIMARY KEY,
    ren_ven_fun_per_Cédula INT NOT NULL,
    ren_empC_emp_ID INT8 NOT NULL,
    ren_equ_pro_ID VARCHAR(45) NOT NULL,
    ren_Fecha_Inicio DATE NOT NULL,
    ren_Fecha_final DATE NOT NULL,
    ren_Costo_mensual INT NOT NULL,
    ren_Observaciones VARCHAR(500) NULL,
    FOREIGN KEY (ren_equ_pro_ID)
        REFERENCES equipo (equ_prod_ID),
    FOREIGN KEY (ren_ven_fun_per_Cédula)
        REFERENCES vendedor (ven_fun_per_cedula),
    FOREIGN KEY (ren_empC_emp_ID)
        REFERENCES empresaCliente (empC_emp_ID)
);

CREATE TABLE detalleServicio (
    Servicio_ser_ID INT PRIMARY KEY,
    Insumo_ins_pro_ID VARCHAR(45) NOT NULL,
    dets_Cantidad INT NOT NULL,
    dets_Costo INT NOT NULL,
    FOREIGN KEY (Servicio_ser_ID)
        REFERENCES servicio (ser_ID),
    FOREIGN KEY (Insumo_ins_pro_ID)
        REFERENCES insumo (ins_prod_ID)
);