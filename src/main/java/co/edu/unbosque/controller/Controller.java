package co.edu.unbosque.controller;

import co.edu.unbosque.model.Estudiante;
import co.edu.unbosque.model.connection.Access;
import co.edu.unbosque.model.dao.EstudianteDao;
import co.edu.unbosque.view.Ventana;
import co.edu.unbosque.view.VentanaRegistrar;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;


public class Controller implements ActionListener {
    private static final String FICHEROACCESS = "src\\main\\resources\\database\\ACADEMIA.accdb";
    private Ventana ventana;
    private Access accesoMDB;
    private VentanaRegistrar ventanaRegistrar;

    public Controller() {
        accesoMDB = new Access(FICHEROACCESS);

        if (accesoMDB.conectarBD()) {

            ventana = new Ventana();
            listener();

            agregarDatosTabla();
        } else {
            JOptionPane.showMessageDialog(null, "Error en la conexión",
                    "Hey!", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void listener() {
        ventana.getRegistrarButton().addActionListener(this);
        ventana.getFiltrar().addActionListener(this);
        ventana.getSalir().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            //Abrir ventana Registrar
            if (e.getSource() == ventana.getRegistrarButton()) {
                ventanaRegistrar = new VentanaRegistrar();
                ventanaRegistrar.getRegistrar().addActionListener(this);
            }

            //Filtrar
            if (e.getSource() == ventana.getFiltrar()) {
                try {
                    if (ventana.getFiltrar().getText().isEmpty()) {
                        ventana.getTable().filtro("");
                    } else {
                        ventana.getTable().filtro(upperCaseFirst(ventana.getFiltrar().getText()));
                    }
                    ventana.repaint();
                } catch (Exception exception) {
                    JOptionPane.showMessageDialog(null,
                            "Caracteres no validos", "Advertencia", JOptionPane.WARNING_MESSAGE);
                }
            }

            //Salir
            if (e.getSource() == ventana.getSalir()) {
                accesoMDB.desconectarBD();
                System.exit(0);
            }

            //Registrar Estudiante
            if (e.getSource() == ventanaRegistrar.getRegistrar()) {
                if (!ventanaRegistrar.getApellidos().getText().equals("")
                        && !ventanaRegistrar.getNombres().getText().equals("")
                        && ventanaRegistrar.getSexo().getSelectedIndex() != 0
                        && !ventanaRegistrar.getEdad().getText().equals("")
                        && ventanaRegistrar.getCurso().getSelectedIndex() != 0) {
                    try {
                        accesoMDB.insertarEstudiante(
                                "Estudiante",
                                ventanaRegistrar.getApellidos().getText(),
                                ventanaRegistrar.getNombres().getText(),
                                Objects.requireNonNull(ventanaRegistrar.getSexo().getSelectedItem()).toString(),
                                Integer.parseInt(ventanaRegistrar.getEdad().getText()),
                                Objects.requireNonNull(ventanaRegistrar.getCurso().getSelectedItem()).toString());
                        ventanaRegistrar.dispose();
                        ventana.getTable().reset();
                        agregarDatosTabla();
                        JOptionPane.showMessageDialog(null, "Registro completado");
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "El compo de edad es de tipo numero",
                                "Hey!", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null,
                            "Hay campos vacíos", "Advertencia", JOptionPane.WARNING_MESSAGE);
                }
            }
        }catch(Exception ignore){

        }
    }

    private void agregarDatosTabla() {
        accesoMDB.agregarRegistrosALaLista(
                "Estudiante", "Matricula", "Apellidos",
                "Nombres", "Sexo", "Edad", "Curso"
        );

        EstudianteDao.getList().sort((o1, o2) -> o1.getApellidos().compareTo(o2.getApellidos()));

        for (Estudiante estudiante : EstudianteDao.getList()) {
            ventana.getTable().add(
                    estudiante.getMatricula(), estudiante.getApellidos(),
                    estudiante.getNombres(), estudiante.getSexo(),
                    estudiante.getEdad(), estudiante.getCurso()
            );
        }

        ventana.repaint();
    }

    private static String upperCaseFirst(String val) {
        String cadena = val.toLowerCase();
        char[] arr = cadena.toCharArray();
        arr[0] = Character.toUpperCase(arr[0]);
        return new String(arr);
    }
}
