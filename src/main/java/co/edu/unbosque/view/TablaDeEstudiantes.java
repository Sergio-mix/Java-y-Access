package co.edu.unbosque.view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class TablaDeEstudiantes extends JTable {
    private final DefaultTableModel modelo;

    public TablaDeEstudiantes() {
        modelo = new DefaultTableModel();
        modelo.addColumn("Matricula");
        modelo.addColumn("Apellidos");
        modelo.addColumn("Nombres");
        modelo.addColumn("Sexo");
        modelo.addColumn("Edad");
        modelo.addColumn("Curso");

        modelo.addRow(new Object[]{"Matricula", "Apellidos", "Nombres", "Sexo", "Edad", "Curso"});

        setModel(modelo);
    }

    public void add(Long matricula, String apillidos, String nombres, String sexo, Integer edad, String curso) {
        modelo.addRow(new Object[]{matricula, apillidos, nombres, sexo, edad, curso});
    }

    public void filtro(String consulta) {
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<>(modelo);
        setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(consulta, 5));
    }

    public void reset() {
        modelo.setRowCount(0);
        modelo.addRow(new Object[]{"Matricula", "Apellidos", "Nombres", "Sexo", "Edad", "Curso"});
    }
}
