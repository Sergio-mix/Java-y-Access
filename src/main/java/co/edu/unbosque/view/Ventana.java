package co.edu.unbosque.view;

import com.sun.awt.AWTUtilities;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;

public class Ventana extends JFrame {
    private TablaDeEstudiantes table;
    private JLabel titulo;
    private JLabel buscar;
    private JTextField filtrar;
    private JButton registrarButton;
    private JButton salir;

    public Ventana() {
        setLayout(null);

        setSize(1200, 700);
        setUndecorated(true);
        setVisible(true);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBackground(new Color(241, 245, 248));

        Shape forma = new RoundRectangle2D.Double(0, 0, this.getBounds().width, this.getBounds().height, 30, 30);
        AWTUtilities.setWindowShape(this, forma);

        titulo = new JLabel("Estudiantes");
        titulo.setBounds(520, 45, 200, 25);
        titulo.setFont(new Font("Arial", Font.BOLD, 30));
        add(titulo);

        Border border = BorderFactory.createLineBorder(new Color(243, 240, 240), 2);
        Border borderButton = BorderFactory.createLineBorder(new Color(22, 191, 132), 2);
        Border borderButtonSalir = BorderFactory.createLineBorder(new Color(196, 21, 51), 2);

        table = new TablaDeEstudiantes();
        table.setBounds(100, 150, 1000, 400);
        table.setBounds(100, 150, 1000, 400);
        table.setBackground(new Color(255, 255, 255));
        table.setForeground(new Color(101, 107, 109, 255));
        table.setFont(new Font("Arial", Font.BOLD, 18));
        table.setEnabled(false);
        JScrollPane scroll=new JScrollPane(table);
        scroll.setBounds(100, 150, 1000, 400);
        scroll.setBackground(new Color(255, 255, 255));
        scroll.setBorder(border);
        add(scroll);

        buscar = new JLabel("Buscar:");
        buscar.setBounds(270, 105, 100, 30);
        buscar.setFont(new Font("Arial", Font.BOLD, 18));
        buscar.setForeground(new Color(101, 107, 109, 255));
        add(buscar);

        filtrar = new JTextField();
        filtrar.setBounds(350, 100, 500, 40);
        filtrar.setBorder(border);
        filtrar.setBackground(new Color(255, 255, 255));
        filtrar.setFont(new Font("Arial", Font.BOLD, 16));
        filtrar.setForeground(new Color(113, 122, 125, 255));
        add(filtrar);

        registrarButton = new JButton("Registrar");
        registrarButton.setBounds(370,580,450,35);
        registrarButton.setBorder(borderButton);
        registrarButton.setBackground(new Color(18, 226, 153));
        registrarButton.setForeground(new Color(255, 255, 255));
        registrarButton.setFont(new Font("Arial", Font.BOLD, 16));
        add(registrarButton);

        salir = new JButton("Salir");
        salir.setBounds(1050,20,100,30);
        salir.setBorder(borderButtonSalir);
        salir.setBackground(new Color(234, 57, 90));
        salir.setForeground(new Color(255, 255, 255));
        salir.setFont(new Font("Arial", Font.BOLD, 16));
        add(salir);

        repaint();
    }

    public TablaDeEstudiantes getTable() {
        return table;
    }

    public JTextField getFiltrar() {
        return filtrar;
    }

    public JButton getRegistrarButton() {
        return registrarButton;
    }

    public JButton getSalir() {
        return salir;
    }
}
