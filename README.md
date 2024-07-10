**CAPTURA DEL CODIGO**
![](https://i.ibb.co/KzsGhWR/21.png)

**EXPLICACION DEL CODIGO**

Este código implementa una interfaz gráfica de usuario (GUI) para visualizar datos relacionados con la Fórmula 1, utilizando la biblioteca Swing de Java. La aplicación permite a los usuarios buscar y filtrar información en varias categorías como pilotos, vueltas, paradas en boxes, carreras, tiempos de carrera, temporadas y constructores.

***1. Importaciones:***

	import javax.swing.*;
	import javax.swing.table.DefaultTableModel;
	import java.awt.*;
	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;
	import javax.swing.table.TableRowSorter;

Estas líneas importan las clases necesarias para crear la GUI, modelos de 		tabla, manejar eventos y organizar el diseño de los componentes.


**2. Clase Formula1ViewerFrame:**

	public class Formula1ViewerFrame extends javax.swing.JFrame {

Esta es la clase principal que extiende JFrame, lo que la convierte en una ventana de la aplicación.


**3.Atributos de la clase:**

	private JTextField searchField;
	private JButton searchButton;
	private JTabbedPane tabbedPane;
	private DefaultTableModel driversTableModel;
	private DefaultTableModel lapsTableModel;
	private DefaultTableModel pitStopsTableModel;
	private DefaultTableModel racesTableModel;
	private DefaultTableModel raceTimeTableModel;
	private DefaultTableModel seasonsTableModel;
	private DefaultTableModel constructorsTableModel;

Aquí se definen los componentes de la GUI y los modelos de tabla para cada pestaña.

**4.Constructor:**

	public Formula1ViewerFrame() {
    	initComponents();
	}

El constructor llama al método initComponents para inicializar los componentes de la GUI.

**5.Inicialización de componentes:**

	private void initComponents() {
    	setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
	    setTitle("Formula 1 Viewer");

    	searchField = new JTextField(20);
    	searchButton = new JButton("Search");
    	tabbedPane = new JTabbedPane();

    	JPanel searchPanel = new JPanel();
    	searchPanel.add(new JLabel("Search: "));
    	searchPanel.add(searchField);
    	searchPanel.add(searchButton);

    	getContentPane().setLayout(new BorderLayout());
    	getContentPane().add(searchPanel, BorderLayout.NORTH);
    	getContentPane().add(tabbedPane, BorderLayout.CENTER);

    	addDriversTab();
    	addLapsTab();
    	addPitStopsTab();
    	addRacesTab();
    	addRaceTimeTab();
    	addSeasonsTab();
    	addConstructorsTab();

    	searchButton.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
            	String searchText = searchField.getText().toLowerCase();
            	filterDriversTable(searchText);
            	filterTable(lapsTableModel, searchText);
            	filterTable(pitStopsTableModel, searchText);
            	filterTable(racesTableModel, searchText);
            	filterTable(raceTimeTableModel, searchText);
            	filterTable(seasonsTableModel, searchText);
            	filterTable(constructorsTableModel, searchText);
        	}
    	});

    	pack();
    	setLocationRelativeTo(null);
    	setVisible(true);
	}


Este método configura la ventana principal, añade un campo de búsqueda, un botón de búsqueda y un panel con pestañas. También define los ActionListener para el botón de búsqueda y llama a los métodos para añadir las pestañas de datos.

**6.Método addDriversTab:**

	private void addDriversTab() {
    	String[] columnNames = {"Order", "Name", "Nationality", "Number", "Date"};
    	driversTableModel = new DefaultTableModel(columnNames, 0);
    	JTable driversTable = new JTable(driversTableModel);
    	JScrollPane driversScrollPane = new JScrollPane(driversTable);
    	JPanel driversPanel = new JPanel();
    	driversPanel.add(driversScrollPane);
    	tabbedPane.addTab("Drivers", driversPanel);

    	Object[][] driverData = {
        	{1, "Lewis Hamilton", "British", 44, "1985-01-07"},
        	// ... otros datos ...
    	};

    	for (Object[] row : driverData) {
        	driversTableModel.addRow(row);
    	}
	}


Este método crea una pestaña para mostrar los datos de los pilotos. Define las columnas, el modelo de la tabla y añade algunos datos de ejemplo.


**7.Métodos para otras pestañas:**

Similar al método 'addDriversTab', hay métodos para añadir pestañas de vueltas (addLapsTab), paradas en boxes (addPitStopsTab), carreras (addRacesTab), tiempos de carrera (addRaceTimeTab), temporadas (addSeasonsTab) y constructores (addConstructorsTab).


**8. Método filterTable:**

	private void filterTable(DefaultTableModel tableModel, String searchText) {
    	TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(tableModel);
    	sorter.setRowFilter(RowFilter.regexFilter("(?i)" + searchText));
    	// Aquí se aplicaría el filtro al JTable correspondiente
	}

Este método filtra las filas de una tabla basándose en el texto de búsqueda introducido por el usuario.


**9. Método filterDriversTable:**

	private void filterDriversTable(String searchText) {
    	TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(driversTableModel);
    	sorter.setRowFilter(RowFilter.regexFilter("(?i)" + searchText));
    	// Aquí se aplicaría el filtro a la tabla de drivers
	}

Similar a filterTable, pero específico para la tabla de pilotos.

**RESUMEN DEL CODIGO**

En resumen, este código crea una aplicación GUI que permite visualizar y filtrar información de Fórmula 1 en varias categorías mediante el uso de pestañas y tablas, proporcionando una experiencia de usuario interactiva para explorar los datos de manera más eficiente.
