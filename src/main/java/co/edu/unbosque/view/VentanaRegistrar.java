package co.edu.unbosque.view;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class VentanaRegistrar extends JFrame {
    private JLabel titulo;
    private JTextField apellidos;
    private JTextField nombres;
    private JComboBox<String> sexo;
    private JTextField edad;
    private JComboBox<String> curso;
    private JButton registrar;

    public VentanaRegistrar() {
        setLayout(null);

        setSize(400, 700);
        setVisible(true);
        setResizable(false);
        setLocationRelativeTo(null);
        setBackground(new Color(241, 245, 248));

        Border border = BorderFactory.createLineBorder(new Color(243, 240, 240), 2);
        Border borderButton = BorderFactory.createLineBorder(new Color(22, 191, 132), 2);

        titulo = new JLabel("Registrar");
        titulo.setBounds(130, 20, 200, 25);
        titulo.setFont(new Font("Arial", Font.BOLD, 25));
        add(titulo);

        JLabel apellido = new JLabel("Apellidos");
        apellido.setBounds(50, 70, 200, 25);
        apellido.setFont(new Font("Arial", Font.BOLD, 16));
        add(apellido);

        apellidos = new JTextField();
        apellidos.setBounds(50, 100, 280, 40);
        apellidos.setBorder(border);
        apellidos.setBackground(new Color(255, 255, 255));
        apellidos.setFont(new Font("Arial", Font.BOLD, 16));
        apellidos.setForeground(new Color(113, 122, 125, 255));
        add(apellidos);

        JLabel nombre = new JLabel("Nombres");
        nombre.setBounds(50, 170, 200, 25);
        nombre.setFont(new Font("Arial", Font.BOLD, 16));
        add(nombre);

        nombres = new JTextField();
        nombres.setBounds(50, 200, 280, 40);
        nombres.setBorder(border);
        nombres.setBackground(new Color(255, 255, 255));
        nombres.setFont(new Font("Arial", Font.BOLD, 16));
        nombres.setForeground(new Color(113, 122, 125, 255));
        add(nombres);

        JLabel sexo2 = new JLabel("Sexo");
        sexo2.setBounds(50, 270, 200, 25);
        sexo2.setFont(new Font("Arial", Font.BOLD, 16));
        add(sexo2);

        sexo = new JComboBox<>();
        sexo.addItem("Seleccione...");
        sexo.addItem("F");
        sexo.addItem("M");
        sexo.setBounds(50, 300, 280, 40);
        sexo.setBorder(border);
        sexo.setBackground(new Color(255, 255, 255));
        sexo.setFont(new Font("Arial", Font.BOLD, 16));
        sexo.setForeground(new Color(113, 122, 125, 255));
        add(sexo);

        JLabel edad2 = new JLabel("Edad");
        edad2.setBounds(50, 370, 200, 25);
        edad2.setFont(new Font("Arial", Font.BOLD, 16));
        add(edad2);

        edad = new JTextField();
        edad.setBounds(50, 400, 280, 40);
        edad.setBorder(border);
        edad.setBackground(new Color(255, 255, 255));
        edad.setFont(new Font("Arial", Font.BOLD, 16));
        edad.setForeground(new Color(113, 122, 125, 255));
        add(edad);

        JLabel curso2 = new JLabel("Curso");
        curso2.setBounds(50, 470, 200, 25);
        curso2.setFont(new Font("Arial", Font.BOLD, 16));
        add(curso2);

        curso = new JComboBox<>();
        curso.addItem("Seleccione...");
        curso.addItem("Access");
        curso.addItem("Word");
        curso.addItem("Windows");
        curso.setBounds(50, 500, 280, 40);
        curso.setBorder(border);
        curso.setBackground(new Color(255, 255, 255));
        curso.setFont(new Font("Arial", Font.BOLD, 16));
        curso.setForeground(new Color(113, 122, 125, 255));
        add(curso);

        registrar = new JButton("Registrar");
        registrar.setBounds(90,580,200,35);
        registrar.setBorder(borderButton);
        registrar.setBackground(new Color(18, 226, 153));
        registrar.setForeground(new Color(255, 255, 255));
        registrar.setFont(new Font("Arial", Font.BOLD, 16));
        add(registrar);

        repaint();
    }

    public JTextField getApellidos() {
        return apellidos;
    }

    public JTextField getNombres() {
        return nombres;
    }

    public JComboBox<String> getSexo() {
        return sexo;
    }

    public JTextField getEdad() {
        return edad;
    }

    public JComboBox<String> getCurso() {
        return curso;
    }

    public JButton getRegistrar() {
        return registrar;
    }
}
