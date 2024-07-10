/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package formulainfoapp;

/**
 *
 * @author panda
 */
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.TableRowSorter;

public class Formula1ViewerFrame extends javax.swing.JFrame {

private JTextField searchField;
private JButton searchButton;
private JTabbedPane tabbedPane;

// Modelos de tabla para cada pestaña
private DefaultTableModel driversTableModel;
private DefaultTableModel lapsTableModel;
private DefaultTableModel pitStopsTableModel;
private DefaultTableModel racesTableModel;
private DefaultTableModel raceTimeTableModel;
private DefaultTableModel seasonsTableModel;
private DefaultTableModel constructorsTableModel;

// Constructor
public Formula1ViewerFrame() {
    initComponents();
}

// Inicialización de componentes
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

    // Agregar pestañas para cada categoría
    addDriversTab();
    addLapsTab();
    addPitStopsTab();
    addRacesTab();
    addRaceTimeTab();
    addSeasonsTab();
    addConstructorsTab();

    // ActionListener para el botón de búsqueda
    searchButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            String searchText = searchField.getText().toLowerCase();

            // Filtrar cada tabla según su respectivo modelo
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
    setLocationRelativeTo(null); // Centrar JFrame en la pantalla
    setVisible(true); // Hacer visible el JFrame
}

// Método para agregar la pestaña de Drivers
private void addDriversTab() {
    String[] columnNames = {"Order", "Name", "Nationality", "Number", "Date"};
    driversTableModel = new DefaultTableModel(columnNames, 0);
    JTable driversTable = new JTable(driversTableModel);
    JScrollPane driversScrollPane = new JScrollPane(driversTable);
    JPanel driversPanel = new JPanel();
    driversPanel.add(driversScrollPane);
    tabbedPane.addTab("Drivers", driversPanel);

    // Ejemplo de datos para Drivers (se pueden cargar desde alguna fuente de datos)
    Object[][] driverData = {
            {1, "Lewis Hamilton", "British", 44, "1985-01-07"},
            {2, "Max Verstappen", "Dutch", 33, "1997-09-30"},
            {3, "Charles Leclerc", "Monégasque", 16, "1997-10-16"},
            {4, "Valtteri Bottas", "Finnish", 77, "1989-08-28"},
            {5, "Lando Norris", "British", 4, "1999-11-13"},
            {6, "Daniel Ricciardo", "Australian", 3, "1989-07-01"},
            {7, "Sebastian Vettel", "German", 5, "1987-07-03"},
            {8, "Kimi Räikkönen", "Finnish", 7, "1979-10-17"},
            {9, "Carlos Sainz Jr.", "Spanish", 55, "1994-09-01"},
            {10, "Fernando Alonso", "Spanish", 14, "1981-07-29"},         
            {11, "Esteban Ocon", "French", 31, "1996-09-17"},               
            {12, "Sergio Pérez", "Mexican", 11, "1990-01-26"},               
            {13, "Nico Hülkenberg", "German", 27, "1987-08-19"},               
            {14, "Yuki Tsunoda", "Japanese", 22, "2000-05-11"},               
            {15, "George Russell", "British", 63, "1998-02-15"},                
            {16, "Nicholas Latifi", "Canadian", 6, "1995-06-29"},              
            {17, "Pierre Gasly", "French", 10, "1996-02-07"},              
            {18, "Antonio Giovinazzi", "Italian", 99, "1993-12-14"},              
            {19, "Mick Schumacher", "German", 47, "1999-03-22"},              
            {20, "Robert Kubica", "Polish", 88, "1984-12-07"},               
            {21, "Nikita Mazepin", "Russian", 9, "1999-03-02"},               
            {22, "Kevin Magnussen", "Danish", 20, "1992-10-05"},              
            {23, "Romain Grosjean", "French", 8, "1986-04-17"},              
            {24, "Pastor Maldonado", "Venezuelan", 13, "1985-03-10"},               
            {25, "Jolyon Palmer", "British", 30, "1991-01-20"},               
            {26, "Felipe Nasr", "Brazilian", 12, "1992-08-21"},               
            {27, "Esteban Gutiérrez", "Mexican", 21, "1991-08-05"},        
            {28, "Daniil Kvyat", "Russian", 26, "1994-04-26"},               
            {29, "Marcus Ericsson", "Swedish", 9, "1990-09-02"},               
            {30, "Max Chilton", "British", 4, "1991-04-21"},
            {31, "Jules Bianchi", "French", 17, "1989-08-03"},                
            {32, "Adrian Sutil", "German", 99, "1983-01-11"},                
            {33, "Jean-Éric Vergne", "French", 25, "1990-04-25"},              
            {34, "Paul di Resta", "British", 11, "1986-04-16"},              
            {35, "Vitaly Petrov", "Russian", 10, "1984-09-08"},               
            {36, "Timo Glock", "German", 24, "1982-03-18"},             
            {37, "Sébastien Buemi", "Swiss", 23, "1988-10-31"},               
            {38, "Nelson Piquet Jr.", "Brazilian", 8, "1985-07-25"},              
            {39, "Kazuki Nakajima", "Japanese", 17, "1985-01-11"},               
            {40, "Giancarlo Fisichella", "Italian", 3, "1973-01-14"},             
            {41, "Takuma Sato", "Japanese", 55, "1977-01-28"},             
            {42, "Anthony Davidson", "British", 36, "1979-04-18"},            
            {43, "Alexander Albon", "Thai", 23, "1996-03-23"},
            {44, "Pascal Wehrlein", "German", 94, "1994-10-18"},
            {45, "Stoffel Vandoorne", "Belgian", 5, "1992-03-26"},
            {46, "Jenson Button", "British", 22, "1980-01-19"},
            {47, "Rio Haryanto", "Indonesian", 88, "1993-01-22"},
            {48, "Will Stevens", "British", 28, "1991-06-28"},
            {49, "Roberto Merhi", "Spanish", 98, "1991-03-22"}
    };

    // Agregar los datos al modelo de la tabla de Drivers
    for (Object[] row : driverData) {
        driversTableModel.addRow(row);
    }
}

// Métodos para agregar las demás pestañas (Laps, Pit Stops, Races, Race Time, Seasons, Constructors)
private void addLapsTab() {
    String[] columnNames = {"Order", "Driver", "Lap Time"};
    lapsTableModel = new DefaultTableModel(columnNames, 0);
    JTable lapsTable = new JTable(lapsTableModel);
    JScrollPane lapsScrollPane = new JScrollPane(lapsTable);
    JPanel lapsPanel = new JPanel();
    lapsPanel.add(lapsScrollPane);
    tabbedPane.addTab("Laps", lapsPanel);

    // Ejemplo de datos para Laps (se pueden cargar desde alguna fuente de datos)
    Object[][] lapsData = {
            {"1", "Lewis Hamilton", "1:31.235"},
            {"2", "Max Verstappen", "1:31.567"},
            {"3", "Charles Leclerc", "1:32.019"},
            {"4", "Valtteri Bottas", "1:32.123"},
            {"5", "Lando Norris", "1:32.456"},
            {"6", "Daniel Ricciardo", "1:32.789"},
            {"7", "Sebastian Vettel", "1:33.123"},
            {"8", "Kimi Räikkönen", "1:33.456"},
            {"9", "Carlos Sainz Jr.", "1:33.789"},
            {"10", "Fernando Alonso", "1:34.123"},
            {"11", "Esteban Ocon", "1:34.456"},
            {"12", "Sergio Pérez", "1:34.789"},
            {"13", "Nico Hülkenberg", "1:35.123"},
            {"14", "Yuki Tsunoda", "1:35.456"},
            {"15", "George Russell", "1:35.789"},
            {"16", "Nicholas Latifi", "1:36.123"},
            {"17", "Pierre Gasly", "1:36.456"},
            {"18", "Antonio Giovinazzi", "1:36.789"},
            {"19", "Mick Schumacher", "1:37.123"},
            {"20", "Robert Kubica", "1:37.456"},
            {"21", "Nikita Mazepin", "1:37.789"},
            {"22", "Kevin Magnussen", "1:38.123"},                
            {"23", "Romain Grosjean", "1:38.456"},                
            {"24", "Pastor Maldonado", "1:38.789"},               
            {"25", "Jolyon Palmer", "1:39.123"},              
            {"26", "Felipe Nasr", "1:39.456"},               
            {"27", "Esteban Gutiérrez", "1:39.789"},              
            {"28", "Daniil Kvyat", "1:40.123"},               
            {"29", "Marcus Ericsson", "1:40.456"},              
            {"30", "Max Chilton", "1:40.789"},               
            {"31", "Jules Bianchi", "1:41.123"},               
            {"32", "Adrian Sutil", "1:41.456"},             
            {"33", "Jean-Éric Vergne", "1:41.789"},              
            {"34", "Paul di Resta", "1:42.123"},              
            {"35", "Vitaly Petrov", "1:42.456"},             
            {"36", "Timo Glock", "1:42.789"},            
            {"37", "Sébastien Buemi", "1:43.123"},           
            {"38", "Nelson Piquet Jr.", "1:43.456"},              
            {"39", "Kazuki Nakajima", "1:43.789"},             
            {"40", "Giancarlo Fisichella", "1:44.123"},            
            {"41", "Takuma Sato", "1:44.456"},             
            {"42", "Anthony Davidson", "1:44.789"},            
            {"43", "Alexander Albon", "1:45.123"},              
            {"44", "Pascal Wehrlein", "1:45.456"},              
            {"45", "Stoffel Vandoorne", "1:45.789"},
            {"46", "Jenson Button", "1:46.123"},
            {"47", "Rio Haryanto", "1:46.456"},
            {"48", "Will Stevens", "1:46.789"},
            {"49", "Roberto Merhi", "1:47.123"}    
    };

    // Agregar los datos al modelo de la tabla de Laps
    for (Object[] row : lapsData) {
        lapsTableModel.addRow(row);
    }
}


private void addPitStopsTab() {
    String[] columnNames = {"Order", "Driver", "Stop Count"};
    pitStopsTableModel = new DefaultTableModel(columnNames, 0);
    JTable pitStopsTable = new JTable(pitStopsTableModel);
    JScrollPane pitStopsScrollPane = new JScrollPane(pitStopsTable);
    JPanel pitStopsPanel = new JPanel();
    pitStopsPanel.add(pitStopsScrollPane);
    tabbedPane.addTab("Pit Stops", pitStopsPanel);

    // Ejemplo de datos para Pit Stops (se pueden cargar desde alguna fuente de datos)
    Object[][] pitStopsData = {
            {"1", "Lewis Hamilton", 2},
            {"2", "Max Verstappen", 1},
            {"3", "Charles Leclerc", 3},
            {"4", "Valtteri Bottas", 2},
            {"5", "Lando Norris", 2},
            {"6", "Daniel Ricciardo", 1},
            {"7", "Sebastian Vettel", 3},
            {"8", "Kimi Räikkönen", 2},
            {"9", "Carlos Sainz Jr.", 1},
            {"10", "Fernando Alonso", 3},
            {"11", "Esteban Ocon", 2},
            {"12", "Sergio Pérez", 2},
            {"13", "Nico Hülkenberg", 1},
            {"14", "Yuki Tsunoda", 3},
            {"15", "George Russell", 2},
            {"16", "Nicholas Latifi", 2},
            {"17", "Pierre Gasly", 1},
            {"18", "Antonio Giovinazzi", 3},
            {"19", "Mick Schumacher", 2},
            {"20", "Robert Kubica", 2},
            {"21", "Nikita Mazepin", 1},
            {"22", "Kevin Magnussen", 3},
            {"23", "Romain Grosjean", 2},
            {"24", "Pastor Maldonado", 2},
            {"25", "Jolyon Palmer", 1},
            {"26", "Felipe Nasr", 3},
            {"27", "Esteban Gutiérrez", 2},
            {"28", "Daniil Kvyat", 2},
            {"29", "Marcus Ericsson", 1},
            {"30", "Max Chilton", 3},
            {"31", "Jules Bianchi", 2},
            {"32", "Adrian Sutil", 2},
            {"33", "Jean-Éric Vergne", 1},
            {"34", "Paul di Resta", 3},
            {"35", "Vitaly Petrov", 2},
            {"36", "Timo Glock", 2},
            {"37", "Sébastien Buemi", 1},
            {"38", "Nelson Piquet Jr.", 3},
            {"39", "Kazuki Nakajima", 2},
            {"40", "Giancarlo Fisichella", 2},
            {"41", "Takuma Sato", 1},
            {"42", "Anthony Davidson", 3},
            {"43", "Alexander Albon", 2},
            {"44", "Pascal Wehrlein", 2},
            {"45", "Stoffel Vandoorne", 1},
            {"46", "Jenson Button", 3},
            {"47", "Rio Haryanto", 2},
            {"48", "Will Stevens", 2},
            {"49", "Roberto Merhi", 1}
    };

    // Agregar los datos al modelo de la tabla de Pit Stops
    for (Object[] row : pitStopsData) {
        pitStopsTableModel.addRow(row);
    }
}


private void addRacesTab() {
    String[] columnNames = {"Order", "Race", "Location", "Winner"};
    racesTableModel = new DefaultTableModel(columnNames, 0);
    JTable racesTable = new JTable(racesTableModel);
    JScrollPane racesScrollPane = new JScrollPane(racesTable);
    JPanel racesPanel = new JPanel();
    racesPanel.add(racesScrollPane);
    tabbedPane.addTab("Races", racesPanel);

    // Ejemplo de datos para Races (se pueden cargar desde alguna fuente de datos)
    Object[][] racesData = {
            {"Monaco Grand Prix", "Monte Carlo", "Max Verstappen"},
            {"Italian Grand Prix", "Monza", "Daniel Ricciardo"},
            {"Japanese Grand Prix", "Suzuka", "Lewis Hamilton"},
            {"Brazilian Grand Prix", "Interlagos", "Lewis Hamilton"},
            {"Australian Grand Prix", "Melbourne", "Valtteri Bottas"},
            {"Bahrain Grand Prix", "Sakhir", "Lewis Hamilton"},
            {"Spanish Grand Prix", "Barcelona", "Lewis Hamilton"},
            {"Austrian Grand Prix", "Spielberg", "Max Verstappen"},
            {"British Grand Prix", "Silverstone", "Lewis Hamilton"},
            {"Hungarian Grand Prix", "Budapest", "Lewis Hamilton"},
            {"Belgian Grand Prix", "Spa-Francorchamps", "Max Verstappen"},
            {"Dutch Grand Prix", "Zandvoort", "Max Verstappen"},
            {"French Grand Prix", "Le Castellet", "Max Verstappen"},
            {"United States Grand Prix", "Austin", "Lewis Hamilton"},
            {"Mexican Grand Prix", "Mexico City", "Max Verstappen"},
            {"Russian Grand Prix", "Sochi", "Lewis Hamilton"},
            {"Turkish Grand Prix", "Istanbul", "Lewis Hamilton"},
            {"Portuguese Grand Prix", "Portimão", "Lewis Hamilton"},
            {"Azerbaijan Grand Prix", "Baku City Circuit", "Sergio Pérez"},
            {"Saudi Arabian Grand Prix", "Jeddah", "Lewis Hamilton"},
            {"Abu Dhabi Grand Prix", "Yas Island", "Max Verstappen"},
            {"Emilia Romagna Grand Prix", "Imola", "Max Verstappen"},
            {"Styrian Grand Prix", "Spielberg", "Max Verstappen"},
            {"Tuscan Grand Prix", "Mugello", "Lewis Hamilton"},
            {"Eifel Grand Prix", "Nürburgring", "Lewis Hamilton"},
            {"Portuguese Grand Prix", "Algarve", "Lewis Hamilton"},
            {"Spanish Grand Prix", "Jerez", "Max Verstappen"},
            {"European Grand Prix", "Valencia", "Sebastian Vettel"},
            {"Canadian Grand Prix", "Montreal", "Lewis Hamilton"},
            {"Hungarian Grand Prix", "Hungaroring", "Lewis Hamilton"},
            {"Malaysian Grand Prix", "Sepang", "Daniel Ricciardo"},
            {"Singapore Grand Prix", "Marina Bay", "Sebastian Vettel"},
            {"South African Grand Prix", "Kyalami", "Mario Andretti"},
            {"Japanese Grand Prix", "Fuji", "Lewis Hamilton"},
            {"Indian Grand Prix", "Greater Noida", "Sebastian Vettel"},
            {"Korean Grand Prix", "Yeongam", "Sebastian Vettel"},
            {"Brazilian Grand Prix", "Jacarepaguá", "Nigel Mansell"},
            {"Mexican Grand Prix", "Hermanos Rodríguez", "Lewis Hamilton"},
            {"Russian Grand Prix", "Saint Petersburg", "Lewis Hamilton"},
            {"Spanish Grand Prix", "Montjuïc", "Jackie Stewart"},
            {"Swedish Grand Prix", "Anderstorp", "Niki Lauda"},
            {"Dutch Grand Prix", "Zandvoort", "Ayrton Senna"},
            {"British Grand Prix", "Brands Hatch", "Niki Lauda"},
            {"French Grand Prix", "Magny-Cours", "Alain Prost"},
            {"San Marino Grand Prix", "Imola", "Ayrton Senna"},
            {"Italian Grand Prix", "Monza", "Nelson Piquet"},
            {"Turkish Grand Prix", "Istanbul Park", "Felipe Massa"},
            {"Austrian Grand Prix", "Österreichring", "Alan Jones"},
            {"Portuguese Grand Prix", "Estoril", "Nigel Mansell"},
            {"Luxembourg Grand Prix", "Nürburgring", "Michael Schumacher"},
            {"European Grand Prix", "Donington Park", "Ayrton Senna"},
            {"Pacific Grand Prix", "Okayama", "Michael Schumacher"},
            {"Argentine Grand Prix", "Buenos Aires", "Ayrton Senna"},
            {"Mexican Grand Prix", "Magdalena Mixhuca", "Nigel Mansell"},
            {"Spanish Grand Prix", "Catalunya", "Niki Lauda"},
            {"Brazilian Grand Prix", "Jacarepaguá", "Emerson Fittipaldi"},
            {"Indianapolis 500", "Indianapolis", "Dario Franchitti"}
            // Agregar más datos según sea necesario
    };

    // Agregar los datos al modelo de la tabla de Races
    for (int i = 0; i < racesData.length; i++) {
        Object[] rowData = new Object[columnNames.length];
        rowData[0] = (i + 1); // Orden
        System.arraycopy(racesData[i], 0, rowData, 1, racesData[i].length); // Copia el resto de los datos
        racesTableModel.addRow(rowData);
    }
}


private void addRaceTimeTab() {
    String[] columnNames = {"Order", "Race", "Time"};
    raceTimeTableModel = new DefaultTableModel(columnNames, 0);
    JTable raceTimeTable = new JTable(raceTimeTableModel);
    JScrollPane raceTimeScrollPane = new JScrollPane(raceTimeTable);
    JPanel raceTimePanel = new JPanel();
    raceTimePanel.add(raceTimeScrollPane);
    tabbedPane.addTab("Race Time", raceTimePanel);

    // Ejemplo de datos para Race Time (se pueden cargar desde alguna fuente de datos)
   Object[][] raceTimeData = {
        {"Monaco Grand Prix", "1:45:32"},
        {"Italian Grand Prix", "1:30:45"},
        {"Japanese Grand Prix", "1:28:59"},
        {"Brazilian Grand Prix", "1:32:15"},
        {"Australian Grand Prix", "1:27:58"},
        {"Bahrain Grand Prix", "1:32:45"},
        {"Spanish Grand Prix", "1:33:12"},
        {"Austrian Grand Prix", "1:29:54"},
        {"British Grand Prix", "1:28:32"},
        {"Hungarian Grand Prix", "1:34:21"},
        {"Belgian Grand Prix", "1:29:48"},
        {"Dutch Grand Prix", "1:31:57"},
        {"French Grand Prix", "1:27:39"},
        {"United States Grand Prix", "1:30:16"},
        {"Mexican Grand Prix", "1:31:50"},
        {"Russian Grand Prix", "1:33:27"},
        {"Turkish Grand Prix", "1:35:03"},
        {"Portuguese Grand Prix", "1:29:11"},
        {"Azerbaijan Grand Prix", "1:37:14"},
        {"Saudi Arabian Grand Prix", "1:34:29"},
        {"Abu Dhabi Grand Prix", "1:28:45"},
        {"Emilia Romagna Grand Prix", "1:31:58"},
        {"Styrian Grand Prix", "1:26:50"},
        {"Tuscan Grand Prix", "1:30:27"},
        {"Eifel Grand Prix", "1:32:06"},
        {"Portuguese Grand Prix", "1:29:39"},
        {"Spanish Grand Prix", "1:27:56"},
        {"European Grand Prix", "1:33:14"},
        {"Canadian Grand Prix", "1:28:37"},
        {"Hungarian Grand Prix", "1:30:54"},
        {"Malaysian Grand Prix", "1:36:22"},
        {"Singapore Grand Prix", "1:35:07"},
        {"South African Grand Prix", "1:32:45"},
        {"Japanese Grand Prix", "1:28:59"},
        {"Indian Grand Prix", "1:34:18"},
        {"Korean Grand Prix", "1:36:05"},
        {"Brazilian Grand Prix", "1:31:12"},
        {"Mexican Grand Prix", "1:29:56"},
        {"Russian Grand Prix", "1:32:40"},
        {"Spanish Grand Prix", "1:30:12"},
        {"Swedish Grand Prix", "1:28:51"},
        {"Dutch Grand Prix", "1:27:34"},
        {"British Grand Prix", "1:30:09"},
        {"French Grand Prix", "1:29:22"},
        {"San Marino Grand Prix", "1:32:18"},
        {"Italian Grand Prix", "1:27:44"},
        {"Turkish Grand Prix", "1:35:29"},
        {"Austrian Grand Prix", "1:29:58"},
        {"Portuguese Grand Prix", "1:29:11"}
};


    // Agregar los datos al modelo de la tabla de Race Time
    for (int i = 0; i < raceTimeData.length; i++) {
        Object[] rowData = new Object[columnNames.length];
        rowData[0] = (i + 1); // Orden
        System.arraycopy(raceTimeData[i], 0, rowData, 1, raceTimeData[i].length); // Copia el resto de los datos
        raceTimeTableModel.addRow(rowData);
    }
}


private void addSeasonsTab() {
    String[] columnNames = {"Season", "Champion"};
    seasonsTableModel = new DefaultTableModel(columnNames, 0);
    JTable seasonsTable = new JTable(seasonsTableModel);
    JScrollPane seasonsScrollPane = new JScrollPane(seasonsTable);
    JPanel seasonsPanel = new JPanel();
    seasonsPanel.add(seasonsScrollPane);
    tabbedPane.addTab("Seasons", seasonsPanel);

    // Ejemplo de datos para Seasons (se pueden cargar desde alguna fuente de datos)
    Object[][] seasonsData = {
            {"2020", "Lewis Hamilton"},
            {"2019", "Lewis Hamilton"},
            {"2018", "Lewis Hamilton"},
            {"2017", "Lewis Hamilton"},
            {"2016", "Nico Rosberg"},
            {"2015", "Lewis Hamilton"},
            {"2014", "Lewis Hamilton"},
            {"2013", "Sebastian Vettel"},
            {"2012", "Sebastian Vettel"},
            {"2011", "Sebastian Vettel"},
            {"2010", "Sebastian Vettel"},
            {"2009", "Jenson Button"},
            {"2008", "Lewis Hamilton"},
            {"2007", "Kimi Räikkönen"},
            {"2006", "Fernando Alonso"},
            {"2005", "Fernando Alonso"},
            {"2004", "Michael Schumacher"},
            {"2003", "Michael Schumacher"},
            {"2002", "Michael Schumacher"},
            {"2001", "Michael Schumacher"},
            {"2000", "Michael Schumacher"},
            {"1999", "Mika Häkkinen"},
            {"1998", "Mika Häkkinen"},
            {"1997", "Jacques Villeneuve"},
            {"1996", "Damon Hill"},
            {"1995", "Michael Schumacher"},
            {"1994", "Michael Schumacher"},
            {"1993", "Alain Prost"},
            {"1992", "Nigel Mansell"},
            {"1991", "Ayrton Senna"},
            {"1990", "Ayrton Senna"},
            {"1989", "Alain Prost"},
            {"1988", "Ayrton Senna"},
            {"1987", "Nelson Piquet"},
            {"1986", "Alain Prost"},
            {"1985", "Alain Prost"},
            {"1984", "Niki Lauda"},
            {"1983", "Nelson Piquet"},
            {"1982", "Keke Rosberg"},
            {"1981", "Nelson Piquet"},
            {"1980", "Alan Jones"},
            {"1979", "Jody Scheckter"},
            {"1978", "Mario Andretti"},
            {"1977", "Niki Lauda"},
            {"1976", "James Hunt"},
            {"1975", "Niki Lauda"},
            {"1974", "Emerson Fittipaldi"},
            {"1973", "Jackie Stewart"},
            {"1972", "Emerson Fittipaldi"}
    };

    // Agregar los datos al modelo de la tabla de Seasons
    for (Object[] row : seasonsData) {
        seasonsTableModel.addRow(row);
    }
}

   private void addConstructorsTab() {
    String[] columnNames = {"Order", "Constructor", "Nationality", "Championships"};
    constructorsTableModel = new DefaultTableModel(columnNames, 0);
    JTable constructorsTable = new JTable(constructorsTableModel);
    JScrollPane constructorsScrollPane = new JScrollPane(constructorsTable);
    JPanel constructorsPanel = new JPanel();
    constructorsPanel.add(constructorsScrollPane);
    tabbedPane.addTab("Constructors", constructorsPanel);

    // Ejemplo de datos para Constructors (se pueden cargar desde alguna fuente de datos)
    Object[][] constructorsData = {
            {1, "Mercedes", "German", 8},
            {2, "Red Bull Racing", "Austrian", 4},
            {3, "Ferrari", "Italian", 16},
            {4, "McLaren", "British", 8},
            {5, "Williams", "British", 9},
            {6, "Lotus", "British", 7},
            {7, "Renault", "French", 2},
            {8, "Benetton", "Italian", 2},
            {9, "Brabham", "British", 4},
            {10, "Cooper", "British", 2},
            {11, "Tyrrell", "British", 3},
            {12, "Matra", "French", 1},
            {13, "Alfa Romeo", "Italian", 2},
            {14, "BRM", "British", 1},
            {15, "Vanwall", "British", 1},
            {16, "Maserati", "Italian", 1},
            {17, "Ligier", "French", 2},
            {18, "March", "British", 1},
            {19, "Jordan", "Irish", 0},
            {20, "Sauber", "Swiss", 0},
            {21, "Force India", "Indian", 0},
            {22, "Alpine", "French", 2},
            {23, "Haas", "American", 0},
            {24, "Hesketh", "British", 1},
            {25, "Manor", "British", 0},
            {26, "Spyker", "Dutch", 0},
            {27, "Prost", "French", 0},
            {28, "Minardi", "Italian", 0},
            {29, "Stewart", "British", 0},
            {30, "Jaguar", "British", 0},
            {31, "BAR", "British", 0},
            {32, "Toyota", "Japanese", 0},
            {33, "Honda", "Japanese", 0},
            {34, "Brawn GP", "British", 1},
            {35, "Caterham", "Malaysian", 0},
            {36, "Marussia", "Russian", 0},
            {37, "Pacific Racing", "British", 0},
            {38, "Simtek", "British", 0},
            {39, "Lola", "British", 0},
            {40, "Zakspeed", "German", 0},
            {41, "ATS", "German", 0},
            {42, "Osella", "Italian", 0},
            {43, "Forti", "Italian", 0},
            {44, "Life", "Italian", 0},
            {45, "Fondmetal", "Italian", 0},
            {46, "AGS", "French", 0},
            {47, "Coloni", "Italian", 0},
            {48, "Onyx", "British", 0},
            {49, "Leyton House", "Japanese", 0}
    };

    // Agregar los datos al modelo de la tabla de Constructors
    for (Object[] row : constructorsData) {
        constructorsTableModel.addRow(row);
    }
}

private void filterDriversTable(String searchText) {
    TableRowSorter<DefaultTableModel> rowSorter = new TableRowSorter<>(driversTableModel);
    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + searchText)); // Filtrar sin distinguir mayúsculas y minúsculas
    JTable driversTable = new JTable(driversTableModel);
    driversTable.setRowSorter(rowSorter);
    tabbedPane.setComponentAt(0, new JScrollPane(driversTable)); // Actualizar el panel de Drivers
}

private void filterTable(DefaultTableModel tableModel, String searchText) {
    TableRowSorter<DefaultTableModel> rowSorter = new TableRowSorter<>(tableModel);
    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + searchText)); // Filtrar sin distinguir mayúsculas y minúsculas
    JTable table = new JTable(tableModel);
    table.setRowSorter(rowSorter);
    int index = tabbedPane.indexOfTab(tableModel.getColumnName(0)); // Obtener el índice de la pestaña
    if (index != -1) {
        tabbedPane.setComponentAt(index, new JScrollPane(table)); // Actualizar el panel de la tabla correspondiente
    }
}

// Método principal para ejecutar la aplicación
public static void main(String[] args) {
    SwingUtilities.invokeLater(new Runnable() {
        public void run() {
            new Formula1ViewerFrame();
        }
    });}
}

