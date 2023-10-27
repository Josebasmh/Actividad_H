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
        	String consulta = "select * from aviones;";
        	PreparedStatement pstmt = conexion.getConexion().prepareStatement(consulta);      
        	ResultSet rs = pstmt.executeQuery();   				
			while (rs.next()) {
	            int idAvion = rs.getInt("idPersona");
	            String nombre = rs.getString("nombre");
	            String apellidos = rs.getString("apellidos");
	            int edad = rs.getInt("edad");
	            Persona p = new Persona(nombre,apellidos,edad);
                
                
            }		              
			 rs.close();
	    } catch (SQLException e) {	    	
	    	e.printStackTrace();
	    }    
        return persona;    
    }

}
