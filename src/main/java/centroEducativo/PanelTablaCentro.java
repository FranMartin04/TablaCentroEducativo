package centroEducativo;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTable;

public class PanelTablaCentro extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTable table;


	public PanelTablaCentro() {
		JFrame frame = new JFrame("SplitPane Demo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        // Crear los componentes que irán dentro del SplitPane
        JPanel panelSuperior = new JPanel();

        JPanel panelInferior = new JPanel();

        // Crear el JSplitPane y configurarlo
        JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, panelSuperior, panelInferior);
        
        table = new JTable();
        panelSuperior.add(table);
        splitPane.setResizeWeight(0.5); // Configura la distribución inicial de tamaño entre los componentes

        // Añadir el JSplitPane al frame y hacerlo visible
        frame.getContentPane().add(splitPane);
        frame.setVisible(true);
    }

}
