package com.bohdeveloper.pizzasaturn.dal.usuarios;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bohdeveloper.pizzasaturn.dal.DalException;
import com.bohdeveloper.pizzasaturn.dal.Dao;
import com.bohdeveloper.pizzasaturn.entidades.usuarios.Rol;
import com.bohdeveloper.pizzasaturn.entidades.usuarios.Usuario;

public class DaoMySqlUsuario implements Dao<Usuario> {
    private static final String URL_BD = "jdbc:mysql://localhost:3306/pizzasaturn";
    private static final String USUARIO_BD = "root";
    private static final String PASSWORD_BD = "";
    private static final String SQL_SELECT = "SELECT * FROM usuarios u JOIN roles r ON r.id = u.roles_id ORDER BY r.id";

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new DalException("No se ha podido cargar el driver", e);
        }
    }

    private static Connection obtenerConexion() {
        try {
            return DriverManager.getConnection(URL_BD, USUARIO_BD, PASSWORD_BD);
        } catch (SQLException e) {
            throw new DalException("No se ha encontrado la conexion a la base de datos", e);
        }
    }

    public Iterable<Usuario> obtenerTodos() {
        try (Connection con = obtenerConexion()) {
            PreparedStatement ps = con.prepareStatement(SQL_SELECT);
            ResultSet rs = ps.executeQuery();

            ArrayList<Usuario> usuarios = new ArrayList<>();

            Usuario usuario;

            while (rs.next()) {
                usuario = new Usuario(rs.getLong("u.id"), rs.getString("u.username"), rs.getString("u.email"),
                        rs.getString("u.password"), null);

                usuario.setRol(new Rol(rs.getLong("r.id"), rs.getString("r.nombre"), null));
                usuarios.add(usuario);
            }

            return usuarios;
        } catch (Exception e) {
            throw new DalException("Error al obtener todos los registros", e);
        }
    }
}
