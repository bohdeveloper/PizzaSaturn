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
public class DaoMySqlUsuario implements Dao<Usuario> {
    private static final String URL_BD = "jdbc:mysql://localhost:3306/pizzasaturn";
    private static final String USUARIO_BD = "root";
    private static final String PASSWORD_BD = "";
    private static final String SQL_SELECT = "SELECT * FROM usuarios u JOIN roles r ON r.id = u.rol_id ORDER BY r.id";
    private static final String SQL_SELECT_ID = "SELECT * FROM usuarios WHERE id = ?";
    private static final String SQL_INSERT = "INSERT INTO usuarios (username, email, password, rol_id) VALUES(?,?,?,?)";
    private static final String SQL_UPDATE = "UPDATE usuarios SET username=?,email=?,password=?,rol_id=? WHERE id=?";
    private static final String SQL_DELETE = "DELETE FROM usuarios WHERE id = ?";

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

    @Override
    public Usuario obtenerPorId(long id) {

        try {
            Connection con = obtenerConexion();
            PreparedStatement ps = con.prepareStatement(SQL_SELECT_ID);
            ps.setLong(1, id);

            ResultSet rs = ps.executeQuery();

            Usuario usuario = null;

            while (rs.next()) {
                usuario = new Usuario(rs.getLong("u.id"), rs.getString("u.username"), rs.getString("u.email"),
                        rs.getString("u.password"), null);

                usuario.setRol(new Rol(rs.getLong("r.id"), rs.getString("r.nombre"), null));

            }

            return usuario;
        } catch (SQLException e) {
            throw new DalException("No se ha encontrado el usuario con id: " + id, e);
        }

    }

    @Override
    public Usuario insertar(Usuario usuario) {
        try (Connection con = obtenerConexion(); PreparedStatement ps = con.prepareStatement(SQL_INSERT)) {
            ps.setString(1, usuario.getUsername());
            ps.setString(2, usuario.getEmail());
            ps.setString(3, usuario.getPassword());
            ps.setLong(4, usuario.getRol().getId());

            if (ps.executeUpdate() != 1) {
                throw new DalException("Se ha insertado un número de registros erroneo");
            } else {
                ResultSet rs = ps.getGeneratedKeys();
                rs.next();
                usuario.setId(rs.getLong(1));
                return usuario;
            }

        } catch (SQLException e) {
            throw new DalException("No se ha podido añadir el usuario: " + usuario, e);
        }
    }

    @Override
    public Usuario modificar(Usuario usuario) {
        try (Connection con = obtenerConexion(); PreparedStatement ps = con.prepareStatement(SQL_UPDATE)) {
            ps.setString(1, usuario.getUsername());
            ps.setString(2, usuario.getEmail());
            ps.setString(3, usuario.getPassword());
            ps.setLong(4, usuario.getRol().getId());
            ps.setLong(5, usuario.getId());

            if (ps.executeUpdate() != 1) {
                throw new DalException("Se ha modificar un número de registros erroneo");
            } else {
                return usuario;
            }

        } catch (SQLException e) {
            throw new DalException("No se ha podido modificar el usuario: " + usuario, e);
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
