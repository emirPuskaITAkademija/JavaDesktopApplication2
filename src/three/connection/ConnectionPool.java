package three.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ConnectionPool {
    private final int NUMBER_OF_CONNECTIONS = 10;

    private List<Connection> availableConnections = new ArrayList<>();
    private List<Connection> unavailableConnections = new ArrayList<>();

    public ConnectionPool() throws SQLException{
      for(int i = 0; i< NUMBER_OF_CONNECTIONS; i++){
         Connection connection = createConnection();
         availableConnections.add(connection);
      }
    }

    private Connection createConnection() throws SQLException {
        Connection connection = DriverManager.getConnection(ConnectionProperties.URL.getValue(), ConnectionProperties.USERNAME.getValue(), ConnectionProperties.PASSWORD.getValue());
        return connection;
    }

    public Connection getConnection(){
        if(availableConnections.isEmpty()){
            throw new RuntimeException("Nemam ti dostupnih konekcija");
        }else{
            Connection connection = availableConnections.get(availableConnections.size()-1);
            availableConnections.remove(connection);
            unavailableConnections.add(connection);
            return connection;
        }
    }

    public boolean releaseConnection(Connection connection){
        if(null != connection){
            unavailableConnections.remove(connection);
            availableConnections.add(connection);
            return true;
        }else{
            return false;
        }
    }
}
