package centroEducativo;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import java.awt.GridBagLayout;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import centroEducativo.controladores.ControladorEstudiante;

import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelTablaCentro extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField tfnombre;
	private JTextField tfpapellido;
	private JTextField tfdni;
	private JTextField tfdireccion;
	private JTextField tfemail;
	private JTextField tftelefono;
	private JTextField jtfcolor;
	private JTextField textField_7;
	private JTextField tfsapellido;
	private DefaultTableModel dtm = null;
	private Object datosEnTabla[][] = ControladorEstudiante.getDatosDeTabla();
	private String titulosEnTabla[] = ControladorEstudiante.getTitulosColumnas();

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PanelTablaCentro frame = new PanelTablaCentro();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public PanelTablaCentro() {
		JFrame frame = new JFrame("Gestion Centro Educativo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(804, 680);

        // Crear los componentes que irán dentro del SplitPane
        JPanel panelSuperior = new JPanel(new BorderLayout());

        JPanel panelInferior = new JPanel();

        // Crear el JSplitPane y configurarlo
        JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, panelSuperior, panelInferior);
        
        this.dtm = getDefaultTableModelNoEditable();
        JTable jTable = new JTable(dtm);
        
        dtm = getDefaultTableModelNoEditable();
        jTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    int selectedRow = jTable.getSelectedRow();
                    if (selectedRow != -1) { // Asegurarse de que se ha seleccionado una fila
                        // Obtener los datos de la fila seleccionada
                    	String id = jTable.getValueAt(selectedRow, 0).toString();
                        String nombre = (String) jTable.getValueAt(selectedRow, 1);
                        String primerApellido = (String) jTable.getValueAt(selectedRow, 2);
                        String segundoApellido = (String) jTable.getValueAt(selectedRow, 3);
                        String dni = (String) jTable.getValueAt(selectedRow, 4);
                        String direccion = (String) jTable.getValueAt(selectedRow, 5);
                        String email = (String) jTable.getValueAt(selectedRow, 6);
                        String telefono = (String) jTable.getValueAt(selectedRow, 7);
                        String color = (String) jTable.getValueAt(selectedRow, 8);

                        // Actualizar los campos del panel superior con los datos obtenidos
                        tfdni.setText(id);
                        tfnombre.setText(nombre);
                        tfpapellido.setText(primerApellido);
                        tfsapellido.setText(segundoApellido);
                        tfdni.setText(dni);
                        tfdireccion.setText(direccion);
                        tfemail.setText(email);
                        tftelefono.setText(telefono);
                        jtfcolor.setText(color);

                    }
                }
            }
        });
        
        JScrollPane scrollTable = new JScrollPane(jTable);
        panelSuperior.add(scrollTable, BorderLayout.CENTER);
        GridBagLayout gbl_panelInferior = new GridBagLayout();
        gbl_panelInferior.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        gbl_panelInferior.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        gbl_panelInferior.columnWeights = new double[]{0.0, 0.0, 1.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        gbl_panelInferior.rowWeights = new double[]{0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        panelInferior.setLayout(gbl_panelInferior);
        
        JLabel lblNewLabel = new JLabel("Nombre:");
        GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
        gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
        gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel.gridx = 1;
        gbc_lblNewLabel.gridy = 0;
        panelInferior.add(lblNewLabel, gbc_lblNewLabel);
        
        tfnombre = new JTextField();
        GridBagConstraints gbc_tfnombre = new GridBagConstraints();
        gbc_tfnombre.gridwidth = 12;
        gbc_tfnombre.insets = new Insets(0, 0, 5, 5);
        gbc_tfnombre.fill = GridBagConstraints.HORIZONTAL;
        gbc_tfnombre.gridx = 2;
        gbc_tfnombre.gridy = 0;
        panelInferior.add(tfnombre, gbc_tfnombre);
        tfnombre.setColumns(10);
        
        JLabel lblPrimerApellido = new JLabel("Primer Apellido:");
        GridBagConstraints gbc_lblPrimerApellido = new GridBagConstraints();
        gbc_lblPrimerApellido.anchor = GridBagConstraints.EAST;
        gbc_lblPrimerApellido.insets = new Insets(0, 0, 5, 5);
        gbc_lblPrimerApellido.gridx = 1;
        gbc_lblPrimerApellido.gridy = 1;
        panelInferior.add(lblPrimerApellido, gbc_lblPrimerApellido);
        
        tfpapellido = new JTextField();
        GridBagConstraints gbc_tfpapellido = new GridBagConstraints();
        gbc_tfpapellido.gridwidth = 12;
        gbc_tfpapellido.insets = new Insets(0, 0, 5, 5);
        gbc_tfpapellido.fill = GridBagConstraints.HORIZONTAL;
        gbc_tfpapellido.gridx = 2;
        gbc_tfpapellido.gridy = 1;
        panelInferior.add(tfpapellido, gbc_tfpapellido);
        tfpapellido.setColumns(10);
        
        JLabel lblNewLabel_1 = new JLabel("Segundo Apellido:");
        GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
        gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel_1.gridx = 1;
        gbc_lblNewLabel_1.gridy = 2;
        panelInferior.add(lblNewLabel_1, gbc_lblNewLabel_1);
        
        tfsapellido = new JTextField();
        GridBagConstraints gbc_tfsapellido = new GridBagConstraints();
        gbc_tfsapellido.gridwidth = 12;
        gbc_tfsapellido.insets = new Insets(0, 0, 5, 5);
        gbc_tfsapellido.fill = GridBagConstraints.HORIZONTAL;
        gbc_tfsapellido.gridx = 2;
        gbc_tfsapellido.gridy = 2;
        panelInferior.add(tfsapellido, gbc_tfsapellido);
        tfsapellido.setColumns(10);
        
        JScrollPane scrollPane = new JScrollPane();
        GridBagConstraints gbc_scrollPane = new GridBagConstraints();
        gbc_scrollPane.gridheight = 3;
        gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
        gbc_scrollPane.fill = GridBagConstraints.BOTH;
        gbc_scrollPane.gridx = 14;
        gbc_scrollPane.gridy = 0;
        panelInferior.add(scrollPane, gbc_scrollPane);
        
        JLabel lblNewLabel_2 = new JLabel("Sexo:");
        GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
        gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
        gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel_2.gridx = 1;
        gbc_lblNewLabel_2.gridy = 3;
        panelInferior.add(lblNewLabel_2, gbc_lblNewLabel_2);
        
        JComboBox jcbsexo = new JComboBox();
        GridBagConstraints gbc_jcbsexo = new GridBagConstraints();
        gbc_jcbsexo.gridwidth = 12;
        gbc_jcbsexo.insets = new Insets(0, 0, 5, 5);
        gbc_jcbsexo.fill = GridBagConstraints.HORIZONTAL;
        gbc_jcbsexo.gridx = 2;
        gbc_jcbsexo.gridy = 3;
        panelInferior.add(jcbsexo, gbc_jcbsexo);
        
        JButton btnNewButton_1 = new JButton("Cargar Imagen");
        GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
        gbc_btnNewButton_1.insets = new Insets(0, 0, 5, 0);
        gbc_btnNewButton_1.gridx = 14;
        gbc_btnNewButton_1.gridy = 3;
        panelInferior.add(btnNewButton_1, gbc_btnNewButton_1);
        
        JLabel lblNewLabel_3 = new JLabel("DNI:");
        GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
        gbc_lblNewLabel_3.anchor = GridBagConstraints.EAST;
        gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel_3.gridx = 1;
        gbc_lblNewLabel_3.gridy = 4;
        panelInferior.add(lblNewLabel_3, gbc_lblNewLabel_3);
        
        tfdni = new JTextField();
        GridBagConstraints gbc_tfdni = new GridBagConstraints();
        gbc_tfdni.gridwidth = 12;
        gbc_tfdni.insets = new Insets(0, 0, 5, 5);
        gbc_tfdni.fill = GridBagConstraints.HORIZONTAL;
        gbc_tfdni.gridx = 2;
        gbc_tfdni.gridy = 4;
        panelInferior.add(tfdni, gbc_tfdni);
        tfdni.setColumns(10);
        
        JLabel lblNewLabel_4 = new JLabel("Direccion:");
        GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
        gbc_lblNewLabel_4.anchor = GridBagConstraints.EAST;
        gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel_4.gridx = 1;
        gbc_lblNewLabel_4.gridy = 5;
        panelInferior.add(lblNewLabel_4, gbc_lblNewLabel_4);
        
        tfdireccion = new JTextField();
        GridBagConstraints gbc_tfdireccion = new GridBagConstraints();
        gbc_tfdireccion.gridwidth = 12;
        gbc_tfdireccion.insets = new Insets(0, 0, 5, 5);
        gbc_tfdireccion.fill = GridBagConstraints.HORIZONTAL;
        gbc_tfdireccion.gridx = 2;
        gbc_tfdireccion.gridy = 5;
        panelInferior.add(tfdireccion, gbc_tfdireccion);
        tfdireccion.setColumns(10);
        
        JLabel lblNewLabel_5 = new JLabel("Email:");
        GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
        gbc_lblNewLabel_5.anchor = GridBagConstraints.EAST;
        gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel_5.gridx = 1;
        gbc_lblNewLabel_5.gridy = 6;
        panelInferior.add(lblNewLabel_5, gbc_lblNewLabel_5);
        
        tfemail = new JTextField();
        GridBagConstraints gbc_tfemail = new GridBagConstraints();
        gbc_tfemail.gridwidth = 12;
        gbc_tfemail.insets = new Insets(0, 0, 5, 5);
        gbc_tfemail.fill = GridBagConstraints.HORIZONTAL;
        gbc_tfemail.gridx = 2;
        gbc_tfemail.gridy = 6;
        panelInferior.add(tfemail, gbc_tfemail);
        tfemail.setColumns(10);
        
        JLabel lblTelefono = new JLabel("Telefono:");
        GridBagConstraints gbc_lblTelefono = new GridBagConstraints();
        gbc_lblTelefono.anchor = GridBagConstraints.EAST;
        gbc_lblTelefono.insets = new Insets(0, 0, 5, 5);
        gbc_lblTelefono.gridx = 1;
        gbc_lblTelefono.gridy = 7;
        panelInferior.add(lblTelefono, gbc_lblTelefono);
        
        tftelefono = new JTextField();
        GridBagConstraints gbc_tftelefono = new GridBagConstraints();
        gbc_tftelefono.gridwidth = 12;
        gbc_tftelefono.insets = new Insets(0, 0, 5, 5);
        gbc_tftelefono.fill = GridBagConstraints.HORIZONTAL;
        gbc_tftelefono.gridx = 2;
        gbc_tftelefono.gridy = 7;
        panelInferior.add(tftelefono, gbc_tftelefono);
        tftelefono.setColumns(10);
        
        JLabel lblNewLabel_6 = new JLabel("Color Preferido:");
        GridBagConstraints gbc_lblNewLabel_6 = new GridBagConstraints();
        gbc_lblNewLabel_6.anchor = GridBagConstraints.EAST;
        gbc_lblNewLabel_6.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel_6.gridx = 1;
        gbc_lblNewLabel_6.gridy = 8;
        panelInferior.add(lblNewLabel_6, gbc_lblNewLabel_6);
        
        jtfcolor = new JTextField();
        GridBagConstraints gbc_jtfcolor = new GridBagConstraints();
        gbc_jtfcolor.gridwidth = 12;
        gbc_jtfcolor.insets = new Insets(0, 0, 5, 5);
        gbc_jtfcolor.fill = GridBagConstraints.HORIZONTAL;
        gbc_jtfcolor.gridx = 2;
        gbc_jtfcolor.gridy = 8;
        panelInferior.add(jtfcolor, gbc_jtfcolor);
        jtfcolor.setColumns(10);
        
        JButton btnNewButton = new JButton("Cambiar Color");
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		seleccionaColor(panelInferior);
        	}
        });
        GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
        gbc_btnNewButton.insets = new Insets(0, 0, 5, 0);
        gbc_btnNewButton.gridx = 14;
        gbc_btnNewButton.gridy = 8;
        panelInferior.add(btnNewButton, gbc_btnNewButton);
        
        JButton jbGuardar = new JButton("Guardar");
        GridBagConstraints gbc_jbGuardar = new GridBagConstraints();
        gbc_jbGuardar.gridx = 14;
        gbc_jbGuardar.gridy = 9;
        panelInferior.add(jbGuardar, gbc_jbGuardar);
        splitPane.setResizeWeight(0.5); // Configura la distribución inicial de tamaño entre los componentes

        // Añadir el JSplitPane al frame y hacerlo visible
        frame.getContentPane().add(splitPane);
        frame.setVisible(true);
    }
	private DefaultTableModel getDefaultTableModelNoEditable () {
		DefaultTableModel dtm = new DefaultTableModel(datosEnTabla, titulosEnTabla) {
			
			/**
			 * La sobreescritura de este método nos permite controlar qué celdas queremos que sean editables
			 */
			@Override
			public boolean isCellEditable(int row, int column) {
				if (column != 1) {
					return false;
				}
				return true;
			}
		};
		return dtm;
	}
	private void seleccionaColor(JPanel panelInferior) {
        JColorChooser jColorChooser = new JColorChooser();
        Color color = jColorChooser.showDialog(null, "Seleccione un Color", Color.gray);

        if (color != null) {
            String strColor = "#" + Integer.toHexString(color.getRGB()).substring(2);
            jtfcolor.setText(strColor);
            panelInferior.setBackground(color);
        }
    }

}
