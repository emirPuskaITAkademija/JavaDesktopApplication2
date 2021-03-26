package three.dao;

import three.connection.ConnectionPool;
import three.model.Show;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class ShowDao implements Dao<Show>{
    private ConnectionPool connectionPool;

    public ShowDao(ConnectionPool connectionPool){
        this.connectionPool = connectionPool;
    }

    @Override
    public void create(Show entity) throws SQLException {

    }

    @Override
    public Show retrieve(int primaryKey) throws SQLException {
        String sqlQuery = "SELECT * FROM movies.shows WHERE show_id=?";
        Connection connection = connectionPool.getConnection();
        try(PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);){
            preparedStatement.setInt(1, primaryKey);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                Show show = new Show();
                show.setShowId(resultSet.getInt(1));
                show.setShowTitle(resultSet.getString(2));
                show.setNumSeasons(resultSet.getInt(3));
                show.setInitialYear(resultSet.getInt(4));
                return show;
            }

        }catch (SQLException e){
            System.err.println(e.getMessage());
        }
        connectionPool.releaseConnection(connection);
        return null;
    }

    @Override
    public List<Show> retrieveAll() throws SQLException {
        List<Show> showList = new ArrayList<>();
        String sqlQuery = "SELECT *FROM shows";
        Connection connection = connectionPool.getConnection();
        try(PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            ResultSet resultSet = preparedStatement.executeQuery();){
            while(resultSet.next()){
                Show show = new Show();
                show.setShowId(resultSet.getInt(1));
                show.setShowTitle(resultSet.getString(2));
                show.setNumSeasons(resultSet.getInt(3));
                show.setInitialYear(resultSet.getInt(4));
                showList.add(show);
            }
        }catch (SQLException e){
            System.err.println(e.getMessage());
        }
        connectionPool.releaseConnection(connection);
        return showList;
    }

    @Override
    public void update(Show entity) throws SQLException {
        String sqlUpdate = "UPDATE shows SET show_title = ? WHERE show_id = ?";
        Connection connection = connectionPool.getConnection();
        try(PreparedStatement ps = connection.prepareStatement(sqlUpdate);
            ){
            ps.setString(1, entity.getShowTitle());
            ps.setInt(2, entity.getShowId());
            int count = ps.executeUpdate();
            System.out.println("Broj ažuriranih objekata je: " + count);
        }catch (SQLException e){
            System.err.println(e.getMessage());
        }
        connectionPool.releaseConnection(connection);
    }

    @Override
    public void delete(Show entity) throws SQLException {

    }


    public Vector<String> getColumnNames(){
        Vector<String> columnNames = new Vector<>();
        String sqlQuery = "SELECT *FROM shows";
        Connection connection = connectionPool.getConnection();
        try(PreparedStatement ps = connection.prepareStatement(sqlQuery);
             ResultSet resultSet = ps.executeQuery()){
            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnNumbers = metaData.getColumnCount();
            for(int i = 1; i<=columnNumbers; i++){
                String columnName = metaData.getColumnName(i);
                columnNames.addElement(columnName);
            }
        }catch (SQLException e){
            System.err.println(e.getMessage());
        }
        return columnNames;
    }
}
