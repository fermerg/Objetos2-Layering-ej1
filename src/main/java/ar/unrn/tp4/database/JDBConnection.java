package ar.unrn.tp4.database;

import ar.unrn.tp4.modelo.Participante;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JDBConnection {
    private Connection dbConn;

    public void setupBaseDeDatos() throws SQLException {
        String url = "jdbc:derby://localhost:1527/participantes";
        String user = "app";
        String password = "app";
        this.dbConn = DriverManager.getConnection(url, user, password);
    }

    public void agregarParticipante(Participante participante) {
        try {
            PreparedStatement st = dbConn.prepareStatement("insert into participantes(nombre, telefono, region) values(?,?,?)");
            st.setString(1, participante.nombre());
            st.setString(2, participante.telefono());
            st.setString(3, participante.region());
            st.executeUpdate();
            st.close();
        } catch (SQLException e) {
            throw new RuntimeException("No se pudo agregar participante", e);
        }
    }
}
