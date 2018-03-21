/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bases;

import java.awt.Color;
import java.awt.Toolkit;
import java.io.File;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.LinkedList;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author fortich
 */
public class admin_gral extends javax.swing.JFrame {

    public static String user;
    Connection c;

    /**
     * Creates new form NewJFrame
     */
    public admin_gral(String user, Connection c) {
        this.c = c;
        initComponents();
        this.user = user;
        this.setVisible(true);
        llenarTabla(tablaRentas, "vw_rentas");
        llenarTabla(tablaServicios, "vw_servicios");
        llenarTabla(tablaVentas, "vw_ventas");
        llenarTabla(tablaCompras, "vw_compras");
        tablaRentas.getTableHeader().setReorderingAllowed(false);
        tablaServicios.getTableHeader().setReorderingAllowed(false);
        tablaVentas.getTableHeader().setReorderingAllowed(false);
        tablaCompras.getTableHeader().setReorderingAllowed(false);
    }

    public void llenarTabla(JTable tabla, String vista) {
        try {
            DefaultTableModel modeloTabla = new DefaultTableModel();
            Statement s = c.createStatement();
            ResultSet ventas = s.executeQuery("select * from " + vista + ";");
            ResultSetMetaData datos = ventas.getMetaData();
            int columnas = datos.getColumnCount();

            if (vista.equals("vw_rentas")) {
                cambiosRenta = new LinkedList<>();
                tipoRenta = new LinkedList<>();
                for (int i = 0; i < columnas; i++) {
                    tipoRenta.add(datos.getColumnClassName(i + 1));
                    modeloTabla.addColumn(datos.getColumnName(i + 1));
                }
                modeloTabla.addTableModelListener(new TableModelListener() {
                    @Override
                    public void tableChanged(TableModelEvent e) {
                        Object[] dataToChange = new Object[modeloTabla.getColumnCount()];
                        for (int i = 0; i < dataToChange.length; i++) {
                            dataToChange[i] = modeloTabla.getValueAt(e.getLastRow(), i);
                        }
                        cambiosRenta.add(dataToChange);
                    }
                });
            } else if (vista.equals("vw_ventas")) {
                cambiosVenta = new LinkedList<>();
                tipoVenta = new LinkedList<>();
                for (int i = 0; i < columnas; i++) {
                    tipoVenta.add(datos.getColumnClassName(i + 1));
                    modeloTabla.addColumn(datos.getColumnName(i + 1));
                }
                modeloTabla.addTableModelListener(new TableModelListener() {
                    @Override
                    public void tableChanged(TableModelEvent e) {
                        Object[] dataToChange = new Object[modeloTabla.getColumnCount()];
                        for (int i = 0; i < dataToChange.length; i++) {
                            dataToChange[i] = modeloTabla.getValueAt(e.getLastRow(), i);
                        }
                        cambiosVenta.add(dataToChange);
                    }
                });
            } else if (vista.equals("vw_compras")) {

                cambiosCompra = new LinkedList<>();
                tipoCompra = new LinkedList<>();
                for (int i = 0; i < columnas; i++) {
                    tipoCompra.add(datos.getColumnClassName(i + 1));
                    modeloTabla.addColumn(datos.getColumnName(i + 1));
                }
                modeloTabla.addTableModelListener(new TableModelListener() {
                    @Override
                    public void tableChanged(TableModelEvent e) {
                        Object[] dataToChange = new Object[modeloTabla.getColumnCount()];
                        for (int i = 0; i < dataToChange.length; i++) {
                            dataToChange[i] = modeloTabla.getValueAt(e.getLastRow(), i);
                        }
                        cambiosCompra.add(dataToChange);
                    }
                });
            } else {
                cambiosServicio = new LinkedList<>();
                tipoServicio = new LinkedList<>();
                for (int i = 0; i < columnas; i++) {
                    tipoServicio.add(datos.getColumnClassName(i + 1));
                    modeloTabla.addColumn(datos.getColumnName(i + 1));
                }
                modeloTabla.addTableModelListener(new TableModelListener() {
                    @Override
                    public void tableChanged(TableModelEvent e) {
                        Object[] dataToChange = new Object[modeloTabla.getColumnCount()];
                        for (int i = 0; i < dataToChange.length; i++) {
                            dataToChange[i] = modeloTabla.getValueAt(e.getLastRow(), i);
                        }
                        cambiosServicio.add(dataToChange);
                    }
                });
            }
            while (ventas.next()) {
                Object[] filas = new Object[columnas];
                for (int i = 0; i < columnas; i++) {
                    filas[i] = ventas.getObject(i + 1);
                }
                modeloTabla.addRow(filas);
            }
            tabla.setModel(modeloTabla);
            cambiosVenta = new LinkedList<>();
            cambiosRenta = new LinkedList<>();
            cambiosCompra = new LinkedList<>();
            cambiosServicio = new LinkedList<>();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    LinkedList<Object[]> cambiosVenta = new LinkedList<>();
    LinkedList<String> tipoVenta = new LinkedList<>();

    LinkedList<Object[]> cambiosRenta = new LinkedList<>();
    LinkedList<String> tipoRenta = new LinkedList<>();

    LinkedList<Object[]> cambiosCompra = new LinkedList<>();
    LinkedList<String> tipoCompra = new LinkedList<>();

    LinkedList<Object[]> cambiosServicio = new LinkedList<>();
    LinkedList<String> tipoServicio = new LinkedList<>();

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton2 = new javax.swing.JButton();
        jTabbedPane9 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaServicios = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tablaVentas = new javax.swing.JTable();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jPanel12 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tablaCompras = new javax.swing.JTable();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();
        jPanel11 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaRentas = new javax.swing.JTable();
        jButton15 = new javax.swing.JButton();
        jButton16 = new javax.swing.JButton();
        jButton17 = new javax.swing.JButton();
        jButton18 = new javax.swing.JButton();
        labelPersona = new javax.swing.JLabel();
        labelAdministrativo = new javax.swing.JLabel();
        labelFuncionario = new javax.swing.JLabel();
        labelTecnico = new javax.swing.JLabel();
        labelVendedor = new javax.swing.JLabel();
        labelEmpresa = new javax.swing.JLabel();
        labelProveedor = new javax.swing.JLabel();
        labelProducto = new javax.swing.JLabel();
        labelCliente = new javax.swing.JLabel();
        labelInsumo = new javax.swing.JLabel();
        labelEquipo = new javax.swing.JLabel();
        labelBitacoras = new javax.swing.JLabel();
        labelBitacoraCompra = new javax.swing.JLabel();
        labelBitacoraSede = new javax.swing.JLabel();
        labelBitacoraVenta = new javax.swing.JLabel();
        labelBitacoraRenta = new javax.swing.JLabel();
        labelPersona16 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        labelBitacoras1 = new javax.swing.JLabel();
        labelBitacoras2 = new javax.swing.JLabel();

        jButton2.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(254, 254, 254));
        setLocation(new java.awt.Point(0, 0));
        setPreferredSize(new java.awt.Dimension(1100, 550));
        setResizable(false);
        setSize(new java.awt.Dimension(1100, 550));

        jTabbedPane9.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N

        tablaServicios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tablaServicios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaServiciosMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tablaServicios);

        jButton1.setText("Actualizar servicio");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton4.setText("Guardar cambios");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("Deshacer cambios");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setText("Borrar filas");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton3.setText("Agregar servicio");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 902, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton6))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton4)
                    .addComponent(jButton5)
                    .addComponent(jButton6)
                    .addComponent(jButton3))
                .addGap(0, 12, Short.MAX_VALUE))
        );

        jTabbedPane9.addTab("Servicios", jPanel3);

        tablaVentas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tablaVentas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaVentasMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tablaVentas);

        jButton7.setText("Agregar venta");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setText("Guardar cambios");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton9.setText("Deshacer cambios");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jButton10.setText("Borrar filas");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 902, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButton7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton10))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton7)
                    .addComponent(jButton8)
                    .addComponent(jButton9)
                    .addComponent(jButton10))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane9.addTab("Ventas", jPanel1);

        tablaCompras.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tablaCompras.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaComprasMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tablaCompras);

        jButton11.setText("Agregar compra");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        jButton12.setText("Guardar cambios");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        jButton13.setText("Deshacer cambios");
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });

        jButton14.setText("Borrar filas");
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 902, Short.MAX_VALUE)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButton11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton14))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton11)
                    .addComponent(jButton12)
                    .addComponent(jButton13)
                    .addComponent(jButton14))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane9.addTab("Compras", jPanel12);

        tablaRentas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tablaRentas.setCursor(new java.awt.Cursor(java.awt.Cursor.W_RESIZE_CURSOR));
        jScrollPane1.setViewportView(tablaRentas);

        jButton15.setText("Agregar renta");
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });

        jButton16.setText("Guardar cambios");
        jButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton16ActionPerformed(evt);
            }
        });

        jButton17.setText("Deshacer cambios");
        jButton17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton17ActionPerformed(evt);
            }
        });

        jButton18.setText("Borrar filas");
        jButton18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton18ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 902, Short.MAX_VALUE)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButton15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton18))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 424, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton15)
                    .addComponent(jButton16)
                    .addComponent(jButton17)
                    .addComponent(jButton18))
                .addContainerGap())
        );

        jTabbedPane9.addTab("Rentas", jPanel11);

        labelPersona.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        labelPersona.setText("Persona");
        labelPersona.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelPersonaMouseClicked(evt);
            }
        });

        labelAdministrativo.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        labelAdministrativo.setText("Administrativo");
        labelAdministrativo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelAdministrativoMouseClicked(evt);
            }
        });

        labelFuncionario.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        labelFuncionario.setText("Funcionario");
        labelFuncionario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelFuncionarioMouseClicked(evt);
            }
        });

        labelTecnico.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        labelTecnico.setText("Técnico");
        labelTecnico.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelTecnicoMouseClicked(evt);
            }
        });

        labelVendedor.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        labelVendedor.setText("Vendedor");
        labelVendedor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelVendedorMouseClicked(evt);
            }
        });

        labelEmpresa.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        labelEmpresa.setText("Empresa");
        labelEmpresa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelEmpresaMouseClicked(evt);
            }
        });

        labelProveedor.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        labelProveedor.setText("Proveedor");
        labelProveedor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelProveedorMouseClicked(evt);
            }
        });

        labelProducto.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        labelProducto.setText("Producto");
        labelProducto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelProductoMouseClicked(evt);
            }
        });

        labelCliente.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        labelCliente.setText("Cliente");
        labelCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelClienteMouseClicked(evt);
            }
        });

        labelInsumo.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        labelInsumo.setText("Insumo");
        labelInsumo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelInsumoMouseClicked(evt);
            }
        });

        labelEquipo.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        labelEquipo.setText("Equipo");
        labelEquipo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelEquipoMouseClicked(evt);
            }
        });

        labelBitacoras.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        labelBitacoras.setText("Bitácoras");

        labelBitacoraCompra.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        labelBitacoraCompra.setText("Bitácora compra");
        labelBitacoraCompra.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelBitacoraCompraMouseClicked(evt);
            }
        });

        labelBitacoraSede.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        labelBitacoraSede.setText("Bitácora sede");
        labelBitacoraSede.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelBitacoraSedeMouseClicked(evt);
            }
        });

        labelBitacoraVenta.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        labelBitacoraVenta.setText("Bitácora venta");
        labelBitacoraVenta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelBitacoraVentaMouseClicked(evt);
            }
        });

        labelBitacoraRenta.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        labelBitacoraRenta.setText("Bitácora renta");
        labelBitacoraRenta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelBitacoraRentaMouseClicked(evt);
            }
        });

        labelPersona16.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        labelPersona16.setText("Bitácora servicio");
        labelPersona16.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelPersona16MouseClicked(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Noto Sans CJK TC Light", 1, 14)); // NOI18N
        jLabel1.setText("Mi cuenta");

        labelBitacoras1.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        labelBitacoras1.setText("Reportes");

        labelBitacoras2.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        labelBitacoras2.setText("Búsquedas");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelPersona, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(labelFuncionario, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(labelAdministrativo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(labelTecnico, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(labelVendedor, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(labelEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(36, 36, 36))
                                    .addComponent(labelCliente, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(labelProveedor, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(labelProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(36, 36, 36))
                                        .addComponent(labelEquipo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(labelInsumo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(labelBitacoras, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(36, 36, 36))
                                            .addComponent(labelBitacoraSede, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(labelBitacoraCompra, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(labelBitacoraVenta, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(labelBitacoraRenta, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(labelPersona16, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addComponent(labelBitacoras1)
                            .addComponent(labelBitacoras2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                        .addComponent(jTabbedPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 910, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(22, 22, 22))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTabbedPane9))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(labelPersona)
                .addGap(0, 0, 0)
                .addComponent(labelFuncionario)
                .addGap(1, 1, 1)
                .addComponent(labelAdministrativo, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(labelTecnico)
                .addGap(0, 0, 0)
                .addComponent(labelVendedor)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelEmpresa)
                .addGap(0, 0, 0)
                .addComponent(labelCliente)
                .addGap(1, 1, 1)
                .addComponent(labelProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelProducto)
                .addGap(0, 0, 0)
                .addComponent(labelEquipo)
                .addGap(1, 1, 1)
                .addComponent(labelInsumo, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labelBitacoras)
                .addGap(0, 0, 0)
                .addComponent(labelBitacoraSede)
                .addGap(1, 1, 1)
                .addComponent(labelBitacoraCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(labelBitacoraVenta)
                .addGap(0, 0, 0)
                .addComponent(labelBitacoraRenta)
                .addGap(0, 0, 0)
                .addComponent(labelPersona16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelBitacoras1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelBitacoras2)
                .addGap(72, 72, 72))
        );

        jTabbedPane9.getAccessibleContext().setAccessibleName("tab");
        labelPersona.getAccessibleContext().setAccessibleName("labelPersona");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void labelPersonaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelPersonaMouseClicked
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new muestraYCambia("select * from vw_persona;", c, "persona").setVisible(true);
            }
        });
    }//GEN-LAST:event_labelPersonaMouseClicked

    private void labelFuncionarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelFuncionarioMouseClicked
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new muestraYCambia("select * from vw_funcionario;", c, "funcionario").setVisible(true);
            }
        });
    }//GEN-LAST:event_labelFuncionarioMouseClicked

    private void labelAdministrativoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelAdministrativoMouseClicked
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new muestraYCambia("select * from vw_administrativos;", c, "administrativo").setVisible(true);
            }
        });
    }//GEN-LAST:event_labelAdministrativoMouseClicked

    private void labelTecnicoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelTecnicoMouseClicked
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new muestraYCambia("select * from vw_tecnicos;", c, "tecnico").setVisible(true);
            }
        });
    }//GEN-LAST:event_labelTecnicoMouseClicked

    private void labelVendedorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelVendedorMouseClicked
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new muestraYCambia("select * from vw_vendedores;", c, "vendedor").setVisible(true);
            }
        });
    }//GEN-LAST:event_labelVendedorMouseClicked

    private void labelEmpresaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelEmpresaMouseClicked
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new muestraYCambia("select * from vw_empresa;", c, "empresa").setVisible(true);
            }
        });
    }//GEN-LAST:event_labelEmpresaMouseClicked

    private void labelClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelClienteMouseClicked
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new muestraYCambia("select * from vw_Clientes;", c, "empresaCliente").setVisible(true);
            }
        });
    }//GEN-LAST:event_labelClienteMouseClicked

    private void labelProveedorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelProveedorMouseClicked
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new muestraYCambia("select * from vw_proveedores;", c, "proveedor").setVisible(true);
            }
        });
    }//GEN-LAST:event_labelProveedorMouseClicked

    private void labelProductoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelProductoMouseClicked
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new muestraYCambia("select * from vw_productos;", c, "producto").setVisible(true);
            }
        });
    }//GEN-LAST:event_labelProductoMouseClicked

    private void labelEquipoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelEquipoMouseClicked
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new muestraYCambia("select * from vw_equipos;", c, "equipo").setVisible(true);
            }
        });
    }//GEN-LAST:event_labelEquipoMouseClicked

    private void labelInsumoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelInsumoMouseClicked
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new muestraYCambia("select * from vw_insumos;", c, "insumo").setVisible(true);
            }
        });
    }//GEN-LAST:event_labelInsumoMouseClicked

    private void tablaServiciosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaServiciosMouseClicked
        int col = tablaServicios.columnAtPoint(evt.getPoint());
        if (col == 0) {
            int row = tablaServicios.rowAtPoint(evt.getPoint());
            int id_Servicio = (int) tablaServicios.getValueAt(row, col);
            new muestraYCambia("call detalleServicio_select(" + id_Servicio + ");", c, "detalleServicio").setVisible(true);
        }
    }//GEN-LAST:event_tablaServiciosMouseClicked

    private void tablaVentasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaVentasMouseClicked
        int col = tablaVentas.columnAtPoint(evt.getPoint());
        if (col == 0) {
            int row = tablaVentas.rowAtPoint(evt.getPoint());
            int id_Venta = (int) tablaVentas.getValueAt(row, col);
            new muestraYCambia("call detalleVenta_select(" + id_Venta + ");", c, "detalleVenta").setVisible(true);
        }
    }//GEN-LAST:event_tablaVentasMouseClicked

    private void tablaComprasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaComprasMouseClicked
        int col = tablaCompras.columnAtPoint(evt.getPoint());
        if (col == 0) {
            int row = tablaCompras.rowAtPoint(evt.getPoint());
            int id_Compra = (int) tablaCompras.getValueAt(row, col);
            new muestraYCambia("call detalleCompra_select(" + id_Compra + ");", c, "detalleCompra").setVisible(true);
        }
    }//GEN-LAST:event_tablaComprasMouseClicked

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        for (Object[] cambioActual : cambiosServicio) {
            try {
                Statement s = c.createStatement();
                StringBuilder query = new StringBuilder();
                query.append("call servicio_update(");
                for (int i = 0; i < cambioActual.length; i++) {
                    String tipob = tipoServicio.get(i);
                    if (tipob.endsWith("Integer") || tipob.endsWith("Double") || tipob.endsWith("Long") || cambioActual[i] == null) {
                        query.append(cambioActual[i]);
                    } else {
                        query.append("\"" + cambioActual[i] + "\"");
                    }
                    if (i != cambioActual.length - 1) {
                        query.append(", ");
                    }
                }
                query.append(");");
                System.out.println(query.toString());
                s.executeQuery(query.toString());
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        llenarTabla(tablaServicios, "vw_servicios");
        cambiosServicio = new LinkedList<>();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        llenarTabla(tablaServicios, "vw_servicios");
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        int[] filas = (tablaServicios.getSelectedRows());
        try {
            Statement s = c.createStatement();
            for (int i = 0; i < filas.length; i++) {
                String query = "call servicio_delete(" + tablaServicios.getValueAt(filas[i], 0) + ");";
                s.execute(query);
            }
            llenarTabla(tablaServicios, "vw_servicios");
        } catch (Exception e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        for (Object[] cambioActual : cambiosVenta) {
            try {
                Statement s = c.createStatement();
                StringBuilder query = new StringBuilder();
                query.append("call venta_update(");
                for (int i = 0; i < cambioActual.length; i++) {
                    String tipob = tipoVenta.get(i);
                    if (tipob.endsWith("Integer") || tipob.endsWith("Double") || tipob.endsWith("Long") || cambioActual[i] == null) {
                        query.append(cambioActual[i]);
                    } else {
                        query.append("\"" + cambioActual[i] + "\"");
                    }
                    if (i != cambioActual.length - 1) {
                        query.append(", ");
                    }
                }
                query.append(");");
                System.out.println(query.toString());
                s.executeQuery(query.toString());
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        llenarTabla(tablaVentas, "vw_ventas");
        cambiosVenta = new LinkedList<>();
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        llenarTabla(tablaVentas, "vw_ventas");
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        int[] filas = (tablaVentas.getSelectedRows());
        try {
            Statement s = c.createStatement();
            for (int i = 0; i < filas.length; i++) {
                String query = "call venta_delete(" + tablaVentas.getValueAt(filas[i], 0) + ");";
                s.execute(query);
            }
            llenarTabla(tablaVentas, "vw_ventas");
        } catch (Exception e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new formatoVenta("venta", c).setVisible(true);
            }
        });
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new formatoVenta("compra", c).setVisible(true);
                
            }
        });
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        for (Object[] cambioActual : cambiosCompra) {
            try {
                Statement s = c.createStatement();
                StringBuilder query = new StringBuilder();
                query.append("call compra_update(");
                for (int i = 0; i < cambioActual.length; i++) {
                    String tipob = tipoCompra.get(i);
                    if (tipob.endsWith("Integer") || tipob.endsWith("Double") || tipob.endsWith("Long") || cambioActual[i] == null) {
                        query.append(cambioActual[i]);
                    } else {
                        query.append("\"" + cambioActual[i] + "\"");
                    }
                    if (i != cambioActual.length - 1) {
                        query.append(", ");
                    }
                }
                query.append(");");
                System.out.println(query.toString());
                s.executeQuery(query.toString());
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        llenarTabla(tablaCompras, "vw_compras");
        cambiosCompra = new LinkedList<>();
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        llenarTabla(tablaCompras, "vw_compras");
    }//GEN-LAST:event_jButton13ActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        int[] filas = (tablaCompras.getSelectedRows());
        try {
            Statement s = c.createStatement();
            for (int i = 0; i < filas.length; i++) {
                String query = "call compra_delete(" + tablaCompras.getValueAt(filas[i], 0) + ");";
                s.execute(query);
            }
            llenarTabla(tablaCompras, "vw_compras");
        } catch (Exception e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_jButton14ActionPerformed

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new formatoRenta(c).setVisible(true);
            }
        });
    }//GEN-LAST:event_jButton15ActionPerformed

    private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton16ActionPerformed
        for (Object[] cambioActual : cambiosRenta) {
            try {
                Statement s = c.createStatement();
                StringBuilder query = new StringBuilder();
                query.append("call renta_update(");
                for (int i = 0; i < cambioActual.length; i++) {
                    String tipob = tipoRenta.get(i);
                    if (tipob.endsWith("Integer") || tipob.endsWith("Double") || tipob.endsWith("Long") || cambioActual[i] == null) {
                        query.append(cambioActual[i]);
                    } else {
                        query.append("\"" + cambioActual[i] + "\"");
                    }
                    if (i != cambioActual.length - 1) {
                        query.append(", ");
                    }
                }
                query.append(");");
                System.out.println(query.toString());
                s.executeQuery(query.toString());
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        llenarTabla(tablaRentas, "vw_rentas");
        cambiosRenta = new LinkedList<>();
    }//GEN-LAST:event_jButton16ActionPerformed

    private void jButton17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton17ActionPerformed
        llenarTabla(tablaRentas, "vw_rentas");
    }//GEN-LAST:event_jButton17ActionPerformed

    private void jButton18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton18ActionPerformed
        int[] filas = (tablaRentas.getSelectedRows());
        try {
            Statement s = c.createStatement();

            for (int i = 0; i < filas.length; i++) {
                String query = "call renta_delete(" + tablaRentas.getValueAt(filas[i], 0) + ");";
                s.execute(query);
            }
            llenarTabla(tablaRentas, "vw_rentas");
        } catch (Exception e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_jButton18ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new fromatoServicioRealizado(c).setVisible(true);
            }
        });
    }//GEN-LAST:event_jButton1ActionPerformed

    private void labelBitacoraSedeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelBitacoraSedeMouseClicked
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new soloMuestra("select * from vw_bit_sede;", c, "").setVisible(true);
            }
        });
    }//GEN-LAST:event_labelBitacoraSedeMouseClicked

    private void labelBitacoraCompraMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelBitacoraCompraMouseClicked
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new soloMuestra("select * from vw_bit_compra;", c, "").setVisible(true);
            }
        });
    }//GEN-LAST:event_labelBitacoraCompraMouseClicked

    private void labelBitacoraVentaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelBitacoraVentaMouseClicked
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new soloMuestra("select * from vw_bit_venta;", c, "").setVisible(true);
            }
        });
    }//GEN-LAST:event_labelBitacoraVentaMouseClicked

    private void labelBitacoraRentaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelBitacoraRentaMouseClicked
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new soloMuestra("select * from vw_bit_renta;", c, "").setVisible(true);
            }
        });
    }//GEN-LAST:event_labelBitacoraRentaMouseClicked

    private void labelPersona16MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelPersona16MouseClicked
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new soloMuestra("select * from vw_bit_servicio;", c, "").setVisible(true);
            }
        });
    }//GEN-LAST:event_labelPersona16MouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new formatoSolicitudServicio(c).setVisible(true);
            }
        });
    }//GEN-LAST:event_jButton3ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane9;
    private javax.swing.JLabel labelAdministrativo;
    private javax.swing.JLabel labelBitacoraCompra;
    private javax.swing.JLabel labelBitacoraRenta;
    private javax.swing.JLabel labelBitacoraSede;
    private javax.swing.JLabel labelBitacoraVenta;
    private javax.swing.JLabel labelBitacoras;
    private javax.swing.JLabel labelBitacoras1;
    private javax.swing.JLabel labelBitacoras2;
    private javax.swing.JLabel labelCliente;
    private javax.swing.JLabel labelEmpresa;
    private javax.swing.JLabel labelEquipo;
    private javax.swing.JLabel labelFuncionario;
    private javax.swing.JLabel labelInsumo;
    private javax.swing.JLabel labelPersona;
    private javax.swing.JLabel labelPersona16;
    private javax.swing.JLabel labelProducto;
    private javax.swing.JLabel labelProveedor;
    private javax.swing.JLabel labelTecnico;
    private javax.swing.JLabel labelVendedor;
    private javax.swing.JTable tablaCompras;
    private javax.swing.JTable tablaRentas;
    private javax.swing.JTable tablaServicios;
    private javax.swing.JTable tablaVentas;
    // End of variables declaration//GEN-END:variables
}
