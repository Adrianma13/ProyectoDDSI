package Aplicacion;

import Config.HibernateUtil;
import Modelo.Socio;
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
        Scanner escaner = new Scanner(System.in);

        int i = 1;
        while (i != 0) {
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            Session sesion = sessionFactory.openSession();
            Transaction tr = sesion.beginTransaction();
            Menu menu = new Menu();
            i = escaner.nextInt();
            switch (i) {
                
                case 1 -> {
                    try {
                        Query consulta = sesion.createQuery("FROM Socio S", Socio.class);
                        ArrayList<Socio> socios = (ArrayList<Socio>) consulta.getResultList();
                        for (Socio socio : socios) {
                            System.out.println(socio.getNombre());
                        }
                    } catch (ExceptionInInitializerError e) {
                        tr.rollback();
                        System.out.println("Error en la recuperacion" + e.getMessage());
                    } finally {
                        if (sesion != null && sesion.isOpen()) {
                            sesion.close();
                        }
                    }
                }
                    case 2 -> {
                        try {
                            Query consulta = sesion.createNativeQuery("SELECT * FROM SOCIO S", Socio.class);
                            ArrayList<Socio> socios = (ArrayList<Socio>) consulta.getResultList();
                            for (Socio socio : socios) {
                                System.out.println(socio.getNombre());
                            }
                        } catch (ExceptionInInitializerError e) {
                            tr.rollback();
                            System.out.println("Error en la recuperacion" + e.getMessage());
                        } finally {
                            if (sesion != null && sesion.isOpen()) {
                                sesion.close();
                            }
                        }
                }

                case 3 -> {
                    try {
                        Query consulta = sesion.createNamedQuery("Socio.findAll", Socio.class);
                        ArrayList<Socio> socios = (ArrayList<Socio>) consulta.getResultList();
                        for (Socio socio : socios) {
                            System.out.println(socio.getNombre());
                        }
                    } catch (ExceptionInInitializerError e) {
                        tr.rollback();
                        System.out.println("Error en la recuperacion" + e.getMessage());
                    } finally {
                        if (sesion != null && sesion.isOpen()) {
                            sesion.close();
                        }
                    }
                }
                case 4 -> {
                    try {
                        Query consulta = sesion.createQuery("SELECT s.nombre,s.telefono FROM Socio s");
                        ArrayList<Object[]> socios = (ArrayList<Object[]>) consulta.getResultList();
                        for (Object[] s : socios) {
                            System.out.println(s[0] + "\t" + s[1]);
                        }
                    } catch (ExceptionInInitializerError e) {
                        tr.rollback();
                        System.out.println("Error en la recuperacion" + e.getMessage());
                    } finally {
                        if (sesion != null && sesion.isOpen()) {
                            sesion.close();
                        }
                    }
                }
                case 5 -> {
                    System.out.println("Introduce el nombre de la categoria. ");
                    String cat = null;
                    cat = escaner.next();
                    try {
                        //  Query consulta = sesion.createQuery("SELECT s.nombre,s.correo FROM Socio s ");
                        Query consulta = sesion.createQuery("SELECT s.nombre,s.categoria FROM Socio s ");
                        ArrayList<Object[]> socios = (ArrayList<Object[]>) consulta.getResultList();
                        for (Object[] s : socios) {
                            System.out.println(s[0] + "\t" + s[1]);
                        }
                    } catch (ExceptionInInitializerError e) {
                        tr.rollback();
                        System.out.println("Error en la recuperacion" + e.getMessage());
                    } finally {
                        if (sesion != null && sesion.isOpen()) {
                            sesion.close();
                        }
                    }
                }

                case 6 -> {
                }
                case 7 -> {
                }
                case 8 -> {
                }
                case 9 -> {
                }
                case 10 -> {
                }

                default -> throw new AssertionError();
            }
        }
    }
}
