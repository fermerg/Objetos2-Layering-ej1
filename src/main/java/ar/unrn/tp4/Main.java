package ar.unrn.tp4;

import ar.unrn.tp4.database.JDBConnection;
import ar.unrn.tp4.ui.UserInterface;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {

        UserInterface ui = new UserInterface();
        ui.setupUIComponents();
        JDBConnection jdbConnection = new JDBConnection();
        jdbConnection.setupBaseDeDatos();

    }
}

