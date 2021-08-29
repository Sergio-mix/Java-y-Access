package co.edu.unbosque.model.connection;

import co.edu.unbosque.model.Estudiante;
import co.edu.unbosque.model.dao.EstudianteDao;
import com.healthmarketscience.jackcess.Database;
import com.healthmarketscience.jackcess.DatabaseBuilder;
import com.healthmarketscience.jackcess.Row;
import com.healthmarketscience.jackcess.Table;

import javax.swing.*;
import java.io.File;

public class Access {
    private String rutaBD;
    private Database BDAccess;

    public Access(String rutaBD) {
        this.rutaBD = rutaBD;
    }

    public boolean conectarBD() {
        try {
            BDAccess = DatabaseBuilder.open(new File(rutaBD));
            return true;
        } catch (Exception e) {
            System.out.println("Error al abrir BD [" + rutaBD + "]: " + e.getMessage());
            return false;
        }
    }

    public void agregarRegistrosALaLista(String nombreTabla, String campo1, String campo2, String campo3, String campo4,
                                         String campo5, String Campo6) {
        try {
            Table tabla = BDAccess.getTable(nombreTabla);
            EstudianteDao.getList().clear();
            for (Row registro : tabla) {
                Estudiante estudiante = new Estudiante();
                if (!campo1.equalsIgnoreCase(""))
                    estudiante.setMatricula(Long.parseLong(String.valueOf(registro.get(campo1))));
                if (!campo2.equalsIgnoreCase(""))
                    estudiante.setApellidos((String) registro.get(campo2));
                if (!campo3.equalsIgnoreCase(""))
                    estudiante.setNombres((String) registro.get(campo3));
                if (!campo4.equalsIgnoreCase(""))
                    estudiante.setSexo((String) registro.get(campo4));
                if (!campo5.equalsIgnoreCase(""))
                    estudiante.setEdad(Integer.parseInt(String.valueOf(registro.get(campo5))));
                if (!Campo6.equalsIgnoreCase(""))
                    estudiante.setCurso((String) registro.get(Campo6));

                EstudianteDao.getList().add(estudiante);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al mostrar tabla [" + nombreTabla + "]: " + e.getMessage(),
                    "Hey!", JOptionPane.ERROR_MESSAGE);

        }
    }

    public void insertarEstudiante(String nombreTabla, String apellinos, String nombres, String sexo, Integer edad,
                                   String curso) {
        try {
            Table table = BDAccess.getTable(nombreTabla);
            table.addRow(null, apellinos, nombres, sexo, edad, curso);
        } catch (Exception e) {
            System.out.println("Error al insertar registro en tabla [" + nombreTabla + "]: " + e.getMessage());
        }
    }

    // Cerrar la conexion a la base de datos
    public void desconectarBD() {
        try {
            BDAccess.close();
        } catch (Exception e) {
            System.out.println("Error al cerrar BD [" + rutaBD + "]: " + e.getMessage());
        }
    }
}