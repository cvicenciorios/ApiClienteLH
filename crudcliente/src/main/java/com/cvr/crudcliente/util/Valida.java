package com.cvr.crudcliente.util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PropertiesLoaderUtils;

public class Valida {

	private ClassPathResource resource = new ClassPathResource(APPLICATION_PROPERTIES);
	private static final String APPLICATION_PROPERTIES = "application.properties";
	private String driver;
	private String url;
	private String user;
	private String pass;
		
	public Valida() {
		this.configura();
	}
	
	public void configura() {
		ClassPathResource resource = new ClassPathResource(APPLICATION_PROPERTIES);
		try {
			
			Properties properties = PropertiesLoaderUtils.loadProperties(resource);
			this.driver = properties.getProperty("spring.datasource.driver-class-name");
			this.url = properties.getProperty("spring.datasource.url");
			this.user = properties.getProperty("spring.datasource.username");
			this.pass = properties.getProperty("spring.datasource.password");
			
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}
	
	public boolean validaRutExistente(String rut) {

		boolean retorno = false;

		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		int cant = 0;		
		
		try {
			
			Class.forName(driver);
			con=DriverManager.getConnection(url,user,pass);
			pst=con.prepareStatement("SELECT * FROM CLIENTE WHERE RUT = ?");
			pst.setString(1, rut);
			rs=pst.executeQuery();
			
			while(rs.next()) {
				cant++;
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if(cant!=0) {
			retorno = true;
		}
		
		return retorno;
	}
	
	public boolean validaCorreoUnico(String correo) {

		boolean retorno = false;

		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		int cant = 0;		
		
		try {
			
			Class.forName(driver);
			con=DriverManager.getConnection(url,user,pass);
			pst=con.prepareStatement("SELECT * FROM CLIENTE WHERE CORREO = ?");
			pst.setString(1, correo);
			rs=pst.executeQuery();
			
			while(rs.next()) {
				cant++;
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if(cant!=0) {
			retorno = true;
		}
		
		return retorno;
	}
	
}