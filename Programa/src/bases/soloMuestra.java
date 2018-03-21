/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bases;

import java.sql.Connection;
import java.sql.*;
import java.util.LinkedList;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author fortich
 */
public class soloMuestra extends javax.swing.JFrame {

    /**
     * Creates new form comoQuieras
     */
    DefaultTableModel modeloTabla = new DefaultTableModel();
    String nombreDeTabla;
    Connection c;
    String consulta;

    public soloMuestra(String consulta, Connection c, String tabla) {
        initComponents();
        this.c = c;
        nombreDeTabla = tabla;
        modeloTabla = new DefaultTableModel();
        this.consulta = consulta;
        jTable.getTableHeader().setReorderingAllowed(false);
        actualizarTabla();
    }

    public void actualizarTabla() {
        try {
            modeloTabla = new DefaultTableModel();
            Statement s = c.createStatement();
            ResultSet ventas = s.executeQuery(consulta);
            ResultSetMetaData datos = ventas.getMetaData();
            int columnas = datos.getColumnCount();
            for (int i = 0; i < columnas; i++) {
                System.out.println(datos.getColumnClassName(i+1));
                tipo.add(datos.getColumnClassName(i+1));
                modeloTabla.addColumn(datos.getColumnName(i + 1));
            }
            while (ventas.next()) {
                Object[] filas = new Object[columnas];
                for (int i = 0; i < columnas; i++) {
                    filas[i] = ventas.getObject(i + 1);
                }
                modeloTabla.addRow(filas);
            }
            modeloTabla.addTableModelListener(new TableModelListener() {
                @Override
                public void tableChanged(TableModelEvent e) {
                    Object[] dataToChange = new Object[modeloTabla.getColumnCount()];
                    for (int i = 0; i < dataToChange.length; i++) {
                        dataToChange[i] = modeloTabla.getValueAt(e.getLastRow(), i);
                    }
                    cambios.add(dataToChange);
                }
            });
            jTable.setModel(modeloTabla);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    LinkedList<Object[]> cambios = new LinkedList<>();
    LinkedList<String> tipo = new LinkedList<>();

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jTable.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 376, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 572, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(78, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable;
    // End of variables declaration//GEN-END:variables
}