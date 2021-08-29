package co.edu.unbosque.model.dao;

import co.edu.unbosque.model.Estudiante;

import java.util.ArrayList;

public class EstudianteDao {
    private static java.util.List<Estudiante> List = new ArrayList<>();

    public EstudianteDao(){

    }

    public static java.util.List<Estudiante> getList() {
        return List;
    }

    public static void setList(java.util.List<Estudiante> list) {
        List = list;
    }
}
