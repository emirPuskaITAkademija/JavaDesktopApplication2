package three.connection;

public enum ConnectionProperties {


    URL("jdbc:mysql://localhost:3306/movies?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false"),
    USERNAME("root"),
    PASSWORD("Admin2021!");

    private String value;

    private ConnectionProperties(String value){
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
