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

import org.springframework.stereotype.Repository;

@Repository
public class DaoMySqlRolUsuario implements Dao<Rol> {
    private static final String URL_BD = "jdbc:mysql://localhost:3306/pizzasaturn";
    private static final String USUARIO_BD = "root";
    private static final String PASSWORD_BD = "";
    private static final String SQL_SELECT = "SELECT * FROM roles";
    private static final String SQL_SELECT_ID = "SELECT * FROM roles WHERE id = ?";
    private static final String SQL_INSERT = "INSERT INTO roles (nombre) VALUES(?)";
    private static final String SQL_UPDATE = "UPDATE roles SET nombre=? WHERE id=?";
    private static final String SQL_DELETE = "DELETE FROM roles WHERE id = ?";

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

    @Override
    public Iterable<Rol> obtenerTodos() {
        try (Connection con = obtenerConexion()) {
            PreparedStatement ps = con.prepareStatement(SQL_SELECT);
            ResultSet rs = ps.executeQuery();

            ArrayList<Rol> roles = new ArrayList<>();

            while (rs.next()) {
                roles.add(new Rol(rs.getLong("u.id"), rs.getString("u.nombre")));
            }

            return roles;
        } catch (Exception e) {
            throw new DalException("Error al obtener todos los registros", e);
        }
    }

    @Override
    public Rol obtenerPorId(long id) {

        try {
            Connection con = obtenerConexion();
            PreparedStatement ps = con.prepareStatement(SQL_SELECT_ID);
            ps.setLong(1, id);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
               Rol rol = new Rol(rs.getLong("r.id"), rs.getString("r.nombre"));
            }

            return rol;
        } catch (SQLException e) {
            throw new DalException("No se ha encontrado el usuario con id: " + id, e);
        }

    }

    @Override
    public Rol insertar(Rol rol) {
        try (Connection con = obtenerConexion(); PreparedStatement ps = con.prepareStatement(SQL_INSERT)) {
            ps.setString(1, rol.getNombre());
          
            if (ps.executeUpdate() != 1) {
                throw new DalException("Se ha insertado un número de registros erroneo");
            } else {
                ResultSet rs = ps.getGeneratedKeys();
                rs.next();
                rol.setId(rs.getLong(1));
                return rol;
            }

        } catch (SQLException e) {
            throw new DalException("No se ha podido añadir el rol: " + rol, e);
        }
    }

    @Override
    public Rol modificar(Rol rol) {
        try (Connection con = obtenerConexion(); PreparedStatement ps = con.prepareStatement(SQL_UPDATE)) {
            ps.setString(1, rol.getNombre());
            ps.setLong(2, rol.getId());

            if (ps.executeUpdate() != 1) {
                throw new DalException("Se ha modificar un número de registros erroneo");
            } else {
                return rol;
            }

        } catch (SQLException e) {
            throw new DalException("No se ha podido modificar el rol: " + rol, e);
        }
    }

    @Override
	public void borrar(long id) {
		try (Connection con = obtenerConexion(); PreparedStatement ps = con.prepareStatement(SQL_DELETE)) {
			ps.setLong(1, id);

			if (ps.executeUpdate() != 1) {
				throw new DalException("Se ha borrado un número de registros diferente de uno");
			}
		} catch (Exception e) {
			throw new DalException("No se ha podido borrar el registro cuyo id es " + id, e);
		}
	}
}
