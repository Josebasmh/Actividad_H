package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import conexion.ConexionMysql;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Persona;

public class PersonaDao {

    private ConexionMysql conexion;

    public ObservableList<Persona> cargarPersonas()  {
    	
    	ObservableList<Persona> persona = FXCollections.observableArrayList();
        try {
            conexion = new ConexionMysql();        	
        	String consulta = "select * from Persona;";
        	PreparedStatement pstmt = conexion.getConexion().prepareStatement(consulta);      
        	ResultSet rs = pstmt.executeQuery();   				
			while (rs.next()) {
	            int idPersona = rs.getInt("idPersona");
	            String nombre = rs.getString("nombre");
	            String apellidos = rs.getString("apellidos");
	            int edad = rs.getInt("edad");
	            Persona p = new Persona(nombre,apellidos,edad);
	            persona.add(p);
            }		              
			 rs.close();
	    } catch (SQLException e) {	    	
	    	e.printStackTrace();
	    }    
        return persona;    
    }
    
    public boolean eliminarPersona(Persona p) {
    	String consulta = "DELETE FROM Persona WHERE nombre = '" + p.getNombre() + "';";
    	PreparedStatement pstmt;
		try {
			pstmt = conexion.getConexion().prepareStatement(consulta);
			//ResultSet rs = pstmt.executeQuery();
			pstmt.executeQuery();
			return true;
		} catch (SQLException e) {
			return false;
		}      
    }
}
