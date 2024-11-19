package Aplicacion;

import Config.HibernateUtil;
import Modelo.Socio;
import Vista.VistaConexion;
import java.util.ArrayList;
import java.util.Scanner;
import javax.persistence.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
/**
 *
 * @author Adria
 */
public class ProyectoDDSI {

    public static void main(String[] args) {
      VistaConexion vista = new VistaConexion();
        
        // Configurar la visibilidad y otras propiedades
        vista.setTitle("Inicio de Sesión");
        vista.setLocationRelativeTo(null); // Centra la ventana en la pantalla
        vista.setVisible(true);
    
}}
