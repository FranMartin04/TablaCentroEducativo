package centroEducativo.controladores;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import centroEducativo.entities.Estudiante;



public class ControladorEstudiante extends Controlador {
	
	private static ControladorEstudiante controller = null;

	public ControladorEstudiante() {
		super(Estudiante.class, "CentroEducativo");
	}
	public static ControladorEstudiante getControlador () {
		if (controller == null) {
			controller = new ControladorEstudiante();
		}
		return controller;
	}

	public static String[] getTitulosColumnas() {
		return new String[] {"Id", "Nombre", "1º apellido", "2º apellido", "Dni", "Direccion", "Email", "Telefono","Sexo","Color Preferido"};
	}
	public List<Estudiante> findAllPersonas () {
		List<Estudiante> entities = new ArrayList<Estudiante>();
		EntityManager em = getEntityManagerFactory().createEntityManager();
		try {			
			Query q = em.createNativeQuery("SELECT * FROM estudiante", Estudiante.class);
			entities = (List<Estudiante>) q.getResultList();
		}
		catch (NoResultException nrEx) {
		}
		em.close();
		return entities;
	}
	public static Object[][] getDatosDeTabla() {
		// Obtengo todas las personas
		List<Estudiante> estudiantes = ControladorEstudiante.getControlador().findAllPersonas();
		// Preparo una estructura para pasar al constructor de la JTable
		Object[][] datos = new Object[estudiantes.size()][8];
		// Cargo los datos de la lista de personas en la matriz de los datos
		for (int i = 0; i < estudiantes.size(); i++) {
			Estudiante estudiante = estudiantes.get(i);
			datos[i][0] = estudiante.getId();
			datos[i][1] = estudiante.getNombre();
			datos[i][2] = estudiante.getApellido1();
			datos[i][3] = estudiante.getApellido2();
			datos[i][4] = estudiante.getDni();
			datos[i][5] = estudiante.getDireccion();
			datos[i][6] = estudiante.getEmail();
			datos[i][7] = estudiante.getTelefono();
			datos[i][8] = estudiante.getIdTipologiaSexo();
			datos[i][9] = estudiante.getColorPreferido();
			
		}
		
		return datos;
	}
	
	
}
