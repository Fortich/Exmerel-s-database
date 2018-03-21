SELECT 
    vent_empC_emp_id, detV_prod_id
FROM
    venta
        JOIN
    detalleventa ON vent_factura_id = detV_vent_factura
WHERE
    vent_empC_emp_id = 'ID de la empresa';

SELECT 
    emp_nombre, emp_id, ren_equ_pro_ID
FROM
    renta
        JOIN
    empresa ON ren_empC_emp_ID = emp_id
WHERE
    ren_equ_pro_ID = 'ID del equipo';

SELECT 
    emp_id, emp_nombre, sed_id, sed_direccion
FROM
    empresa
        JOIN
    sede ON emp_id = sed_emp_id
WHERE
    emp_id = 'ID empresa';

SELECT 
    emp_nombre,
    emp_id,
    per_nombre,
    per_apellido,
    per_cedula,
    vent_costoTotal,
    detV_prod_id,
    detV_costo
FROM
    venta
        JOIN
    empresa
        JOIN
    detalleventa
        JOIN
    persona ON vent_empC_emp_id = emp_id
        AND vent_factura_id = detV_prod_id
        AND vent_ven_fun_per_cedula = per_cedula
WHERE
    vent_factura_id = 'ID Factura';
