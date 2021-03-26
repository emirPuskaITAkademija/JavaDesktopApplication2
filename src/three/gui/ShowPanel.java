package three.gui;

import three.dao.ShowDao;
import three.model.Show;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

/**
 * List<Show>  ----- MODEL ---- JTable
 */
public class ShowPanel extends JPanel {


    private JTable showTable;
    private ShowDao showDao;

    public ShowPanel(ShowDao showDao){
        this.showDao = showDao;
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        showTable = new JTable();
        Vector<String> columnNames = createColumnNames();
        Vector<Vector<Object>> tableData = createTableData();
        ShowModel showModel = new ShowModel(columnNames,tableData);
        showTable.setModel(showModel);
        add(new JScrollPane(showTable));
    }

    private Vector<String> createColumnNames(){
        Vector<String> columnNames =showDao.getColumnNames();
        /*columnNames.add("Show ID");
        columnNames.add("Title");
        columnNames.add("Number of seasons");
        columnNames.add("Year");*/
        return columnNames;
    }

    private Vector<Vector<Object>> createTableData(){
        Vector<Vector<Object>> tableData = new Vector<Vector<Object>>();
        try {
            List<Show> showList = showDao.retrieveAll();
            for(Show show: showList){
                Vector<Object> rowData = new Vector<>();
                rowData.addElement(show.getShowId());//0 showId
                rowData.addElement(show.getShowTitle());//1 showTitle
                rowData.addElement(show.getNumSeasons());
                rowData.addElement(show.getInitialYear());
                tableData.addElement(rowData);
            }
        }catch (SQLException e){
            System.err.println(e.getMessage());
        }
        return tableData;
    }




    private class ShowModel extends AbstractTableModel{

        private Vector<String> columnNames;
        private Vector<Vector<Object>> tableData;

        public ShowModel(Vector<String> columnNames, Vector<Vector<Object>> tableData){
            this.columnNames = columnNames;
            this.tableData = tableData;
        }


        @Override
        public int getRowCount() {
            return tableData.size();
        }

        @Override
        public int getColumnCount() {
            return columnNames.size();
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            Vector<Object> rowData = tableData.get(rowIndex);
            Object value = rowData.get(columnIndex);
            System.out.println(value);
            return value;
        }

        @Override
        public String getColumnName(int column) {
            return columnNames.get(column);
        }

        @Override
        public boolean isCellEditable(int rowIndex, int columnIndex) {
            return columnIndex==1;
        }

        @Override
        public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
            Vector<Object> rowData = tableData.get(rowIndex);
            rowData.remove(columnIndex);
            rowData.add(columnIndex, aValue);
            fireTableCellUpdated(rowIndex, columnIndex);
            int showId = (int)rowData.get(0);
            String showTitle =(String) aValue;
            try {
                Show show = showDao.retrieve(showId);
                show.setShowTitle(showTitle);
                showDao.update(show);
            }catch (SQLException e){
                System.err.println(e.getMessage());
            }
        }
    }
}
