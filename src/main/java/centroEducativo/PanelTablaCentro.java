package centroEducativo;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import java.awt.GridBagLayout;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import centroEducativo.controladores.ControladorEstudiante;

import javax.swing.JComboBox;
import javax.swing.JButton;

public class PanelTablaCentro extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
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
        frame.setSize(819, 708);

        // Crear los componentes que irán dentro del SplitPane
        JPanel panelSuperior = new JPanel();

        JPanel panelInferior = new JPanel();

        // Crear el JSplitPane y configurarlo
        JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, panelSuperior, panelInferior);
        
        JTable jTable = new JTable(dtm);
        
        dtm = getDefaultTableModelNoEditable();
        
        JScrollPane scrollTable = new JScrollPane(jTable);
        panelSuperior.add(scrollTable);
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
        
        textField = new JTextField();
        GridBagConstraints gbc_textField = new GridBagConstraints();
        gbc_textField.gridwidth = 12;
        gbc_textField.insets = new Insets(0, 0, 5, 5);
        gbc_textField.fill = GridBagConstraints.HORIZONTAL;
        gbc_textField.gridx = 2;
        gbc_textField.gridy = 0;
        panelInferior.add(textField, gbc_textField);
        textField.setColumns(10);
        
        JLabel lblPrimerApellido = new JLabel("Primer Apellido:");
        GridBagConstraints gbc_lblPrimerApellido = new GridBagConstraints();
        gbc_lblPrimerApellido.anchor = GridBagConstraints.EAST;
        gbc_lblPrimerApellido.insets = new Insets(0, 0, 5, 5);
        gbc_lblPrimerApellido.gridx = 1;
        gbc_lblPrimerApellido.gridy = 1;
        panelInferior.add(lblPrimerApellido, gbc_lblPrimerApellido);
        
        textField_1 = new JTextField();
        GridBagConstraints gbc_textField_1 = new GridBagConstraints();
        gbc_textField_1.gridwidth = 12;
        gbc_textField_1.insets = new Insets(0, 0, 5, 5);
        gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
        gbc_textField_1.gridx = 2;
        gbc_textField_1.gridy = 1;
        panelInferior.add(textField_1, gbc_textField_1);
        textField_1.setColumns(10);
        
        JLabel lblNewLabel_1 = new JLabel("Segundo Apellido:");
        GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
        gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel_1.gridx = 1;
        gbc_lblNewLabel_1.gridy = 2;
        panelInferior.add(lblNewLabel_1, gbc_lblNewLabel_1);
        
        textField_8 = new JTextField();
        GridBagConstraints gbc_textField_8 = new GridBagConstraints();
        gbc_textField_8.gridwidth = 12;
        gbc_textField_8.insets = new Insets(0, 0, 5, 5);
        gbc_textField_8.fill = GridBagConstraints.HORIZONTAL;
        gbc_textField_8.gridx = 2;
        gbc_textField_8.gridy = 2;
        panelInferior.add(textField_8, gbc_textField_8);
        textField_8.setColumns(10);
        
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
        
        JComboBox comboBox = new JComboBox();
        GridBagConstraints gbc_comboBox = new GridBagConstraints();
        gbc_comboBox.gridwidth = 12;
        gbc_comboBox.insets = new Insets(0, 0, 5, 5);
        gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
        gbc_comboBox.gridx = 2;
        gbc_comboBox.gridy = 3;
        panelInferior.add(comboBox, gbc_comboBox);
        
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
        
        textField_2 = new JTextField();
        GridBagConstraints gbc_textField_2 = new GridBagConstraints();
        gbc_textField_2.gridwidth = 12;
        gbc_textField_2.insets = new Insets(0, 0, 5, 5);
        gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
        gbc_textField_2.gridx = 2;
        gbc_textField_2.gridy = 4;
        panelInferior.add(textField_2, gbc_textField_2);
        textField_2.setColumns(10);
        
        JLabel lblNewLabel_4 = new JLabel("Direccion:");
        GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
        gbc_lblNewLabel_4.anchor = GridBagConstraints.EAST;
        gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel_4.gridx = 1;
        gbc_lblNewLabel_4.gridy = 5;
        panelInferior.add(lblNewLabel_4, gbc_lblNewLabel_4);
        
        textField_3 = new JTextField();
        GridBagConstraints gbc_textField_3 = new GridBagConstraints();
        gbc_textField_3.gridwidth = 12;
        gbc_textField_3.insets = new Insets(0, 0, 5, 5);
        gbc_textField_3.fill = GridBagConstraints.HORIZONTAL;
        gbc_textField_3.gridx = 2;
        gbc_textField_3.gridy = 5;
        panelInferior.add(textField_3, gbc_textField_3);
        textField_3.setColumns(10);
        
        JLabel lblNewLabel_5 = new JLabel("Email:");
        GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
        gbc_lblNewLabel_5.anchor = GridBagConstraints.EAST;
        gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel_5.gridx = 1;
        gbc_lblNewLabel_5.gridy = 6;
        panelInferior.add(lblNewLabel_5, gbc_lblNewLabel_5);
        
        textField_4 = new JTextField();
        GridBagConstraints gbc_textField_4 = new GridBagConstraints();
        gbc_textField_4.gridwidth = 12;
        gbc_textField_4.insets = new Insets(0, 0, 5, 5);
        gbc_textField_4.fill = GridBagConstraints.HORIZONTAL;
        gbc_textField_4.gridx = 2;
        gbc_textField_4.gridy = 6;
        panelInferior.add(textField_4, gbc_textField_4);
        textField_4.setColumns(10);
        
        JLabel lblTelefono = new JLabel("Telefono:");
        GridBagConstraints gbc_lblTelefono = new GridBagConstraints();
        gbc_lblTelefono.anchor = GridBagConstraints.EAST;
        gbc_lblTelefono.insets = new Insets(0, 0, 5, 5);
        gbc_lblTelefono.gridx = 1;
        gbc_lblTelefono.gridy = 7;
        panelInferior.add(lblTelefono, gbc_lblTelefono);
        
        textField_5 = new JTextField();
        GridBagConstraints gbc_textField_5 = new GridBagConstraints();
        gbc_textField_5.gridwidth = 12;
        gbc_textField_5.insets = new Insets(0, 0, 5, 5);
        gbc_textField_5.fill = GridBagConstraints.HORIZONTAL;
        gbc_textField_5.gridx = 2;
        gbc_textField_5.gridy = 7;
        panelInferior.add(textField_5, gbc_textField_5);
        textField_5.setColumns(10);
        
        JLabel lblNewLabel_6 = new JLabel("Color Preferido:");
        GridBagConstraints gbc_lblNewLabel_6 = new GridBagConstraints();
        gbc_lblNewLabel_6.anchor = GridBagConstraints.EAST;
        gbc_lblNewLabel_6.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel_6.gridx = 1;
        gbc_lblNewLabel_6.gridy = 8;
        panelInferior.add(lblNewLabel_6, gbc_lblNewLabel_6);
        
        textField_6 = new JTextField();
        GridBagConstraints gbc_textField_6 = new GridBagConstraints();
        gbc_textField_6.gridwidth = 12;
        gbc_textField_6.insets = new Insets(0, 0, 5, 5);
        gbc_textField_6.fill = GridBagConstraints.HORIZONTAL;
        gbc_textField_6.gridx = 2;
        gbc_textField_6.gridy = 8;
        panelInferior.add(textField_6, gbc_textField_6);
        textField_6.setColumns(10);
        
        JButton btnNewButton = new JButton("Cambiar Color");
        GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
        gbc_btnNewButton.insets = new Insets(0, 0, 5, 0);
        gbc_btnNewButton.gridx = 14;
        gbc_btnNewButton.gridy = 8;
        panelInferior.add(btnNewButton, gbc_btnNewButton);
        splitPane.setResizeWeight(0.5); // Configura la distribución inicial de tamaño entre los componentes

        // Añadir el JSplitPane al frame y hacerlo visible
        frame.getContentPane().add(splitPane);
        frame.setVisible(true);
    }
	private DefaultTableModel getDefaultTableModelNoEditable () {
		DefaultTableModel dtm = new DefaultTableModel() {
			
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

}
