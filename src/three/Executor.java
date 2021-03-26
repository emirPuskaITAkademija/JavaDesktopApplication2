package three;

import three.connection.ConnectionPool;
import three.dao.ShowDao;
import three.gui.ShowPanel;
import three.model.Show;
import two.combo.ComboBoxExecutor;
import two.combo.ComboBoxPanel;

import javax.swing.*;
import java.sql.SQLException;
import java.util.List;

public class Executor {
    public static void main(String[] args) throws SQLException{

        SwingUtilities.invokeLater(Executor::createGUI);
    }


    static void createGUI(){
        try {
            System.out.println(Thread.currentThread());
            JFrame frame = new JFrame(" Shows from DATABASE");
            frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            ConnectionPool connectionPool = new ConnectionPool();
            ShowDao showDao = new ShowDao(connectionPool);
            ShowPanel showPanel = new ShowPanel(showDao);
            frame.setContentPane(showPanel);
            frame.setSize(400, 300);
            frame.setVisible(true);
        }catch (SQLException e){
            System.err.println(e.getMessage());
        }
    }
}
