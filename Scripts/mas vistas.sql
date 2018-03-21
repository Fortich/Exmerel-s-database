
/*servicios  con nombre de tecnico ordenados por costo*/

 CREATE VIEW vw_servicios as (select ser_ID as ID,ser_tec_fun_per_Cedula as Cedula_tecnico,CONCAT(per_nombre, CONCAT(' ', per_apellido)) AS Nombre, ser_Fecha_llegada as Llegada,ser_Fecha_salida as Salida , dets_Costo as Costo from servicio join detalleservicio on ser_id=dets_ser_id join persona on per_cedula=ser_tec_fun_per_cedula order by  Costo desc);

 /*ultimas 50 compras*/
 CREATE VIEW vw_compras as (select com_factura as factura,com_pro_emp_id as Proveedor,com_adm_fun_per_cedula as Cedula_Administrativo,CONCAT(per_nombre, CONCAT(' ', per_apellido)) AS Nombre,com_fecha as fecha,com_costoTotal as Costo from compra join persona on com_adm_fun_per_cedula=per_cedula order by Fecha desc );
 

 /*empresas clientes ordenadas por cantidad de sedes*/
 
 CREATE VIEW vw_clientes as (select emp_nombre,count(sed_emp_id) as N_sedes from empresa join empresacliente on emp_id=empc_emp_id join sede on empc_emp_id=sed_emp_id group by emp_id order by N_sedes desc);


 /*ADMINISTRATIVOS ordenados por cantidad de compras*/
 CREATE VIEW vw_administrativos_compras as (select CONCAT(per_nombre, CONCAT(' ', per_apellido)) AS Nombre, count(com_adm_fun_per_cedula) as Compras from persona join compra on per_cedula=com_adm_fun_per_cedula group by per_cedula);

/*tecnicos agrupados por eps*/
create view tecnicos_eps as
select fun_eps, count(fun_ger_fun_per_cedula) from  tecnico join funcionario on tec_fun_per_cedula=fun_per_cedula group by fun_eps;


 /*total de equipos rentados agrupados por empresa */

create view equipos_por_empresa as (Select emp_nombre,count(ren_sed_emp_id) from empresa join renta on  emp_id=ren_sed_emp_id group by emp_id );
select * from equipos_por_empresa;
