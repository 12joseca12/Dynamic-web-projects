package com.JCSG.cocheModelos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

public class ModeloMod {

    public DataSource origenDatos;

    public ModeloMod(DataSource origenDatos) {
        this.origenDatos = origenDatos;
    }
    
    

    public List<Modelos> getModelos() throws Exception {
        List<Modelos> modelos = new ArrayList<>();
        Connection miConexion = null;
        Statement miStatement = null;
        ResultSet miResultset = null;

        try {
            // Establecer conexión
            miConexion = origenDatos.getConnection();

            // Crear sentencia SQL y statement
            String instruccionSql = "SELECT * FROM modelos";
            miStatement = miConexion.createStatement();

            // Ejecutar SQL
            miResultset = miStatement.executeQuery(instruccionSql);

            // Recorrer ResultSet
            while (miResultset.next()) {
            	int id=miResultset.getInt("id");
                String marca = miResultset.getString("marca");
                String modelo = miResultset.getString("modelo");
                String motor = miResultset.getString("motor");
                int potencia = miResultset.getInt("potencia");
                Date fecha = miResultset.getDate("fecha_registro");

                Modelos tempMod = new Modelos(id, marca, modelo, motor, potencia, fecha);
                modelos.add(tempMod);
            }
        }catch(Exception e) {
            	
            }
        

        return modelos;
    }



	public void agregarNuevoModelo(Modelos nuevoModelo) throws Exception {
		// TODO Auto-generated method stub
		
		Connection miConexion=null;
		PreparedStatement miStatement=null;
		
		try {
			
		miConexion=origenDatos.getConnection();
			
		String Sql="INSERT INTO modelos (marca, modelo, motor, potencia, fecha_registro) VALUES ( ?, ?, ?, ?, ?)";
		
		miStatement=miConexion.prepareStatement(Sql);
		miStatement.setString(1, nuevoModelo.getMarca());
		miStatement.setString(2, nuevoModelo.getModelo());
		miStatement.setString(3, nuevoModelo.getMotor());
		miStatement.setInt(4, nuevoModelo.getPotencia());
		java.util.Date utilDate=nuevoModelo.getFecha();
		java.sql.Date fechaConvertida=new java.sql.Date(utilDate.getTime());
		miStatement.setDate(5, fechaConvertida);
		miStatement.execute();
		
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			miStatement.close();
			miConexion.close();
		}
		
	}



	public Modelos getModelo(String idModelo) {
		// TODO Auto-generated method stub
		Modelos elModelo=null;
		Connection miConexion=null;
		PreparedStatement miStatement=null;
		ResultSet miResultset=null;
		idModelo = idModelo.replaceAll("[^\\d]", "");
		int miId = Integer.parseInt(idModelo);
		 
		
		try {
			
		miConexion=origenDatos.getConnection();
		String sql="SELECT * FROM modelos WHERE ID=?";
		miStatement=miConexion.prepareStatement(sql);
		miStatement.setInt(1, miId);
		miResultset=miStatement.executeQuery();
		
		if(miResultset.next()) {
			int id=miResultset.getInt("id");
            String marca = miResultset.getString("marca");
            String modelo = miResultset.getString("modelo");
            String motor = miResultset.getString("motor");
            int potencia = miResultset.getInt("potencia");
            Date fecha = miResultset.getDate("fecha_registro");

            elModelo= new Modelos(id, marca, modelo, motor, potencia, fecha);
		}else {
			throw new Exception("No se ha encontrado el vehiculo con id= "+idModelo);
		}
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return elModelo;
	}



	public void actualizarNuevoModelo(Modelos modeloActualizado) throws Exception{
		// TODO Auto-generated method stub
		
		Connection miConexion=null;
		PreparedStatement miStatement=null;
		try {
		miConexion=origenDatos.getConnection();
		String sql="UPDATE modelos SET marca=?, modelo=?, motor=?, potencia=?, fecha_registro=? WHERE id=?";
		miStatement=miConexion.prepareStatement(sql);
		miStatement.setString(1, modeloActualizado.getMarca());
		miStatement.setString(2, modeloActualizado.getModelo());
		miStatement.setString(3, modeloActualizado.getMotor());
		miStatement.setInt(4, modeloActualizado.getPotencia());
		java.util.Date utilDate=modeloActualizado.getFecha();
		java.sql.Date fechaConvertida=new java.sql.Date(utilDate.getTime());
		miStatement.setDate(5, fechaConvertida);
		miStatement.setInt(6, modeloActualizado.getId());
		miStatement.execute();
		}finally {
			miStatement.close();
			miConexion.close();
		}
		
	}



	public void eliminarProducto(String idEl) throws Exception{
		// TODO Auto-generated method stub
		
		Connection miConexion=null;
		PreparedStatement miStatement=null;
		try {
		miConexion=origenDatos.getConnection();
		String sql="DELETE FROM modelos WHERE id=?";
		miStatement=miConexion.prepareStatement(sql);
		miStatement.setString(1, idEl);
		miStatement.execute();
		}finally {
			miStatement.close();
			miConexion.close();
		}
		
	}

   
}
