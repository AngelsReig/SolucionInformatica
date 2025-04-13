package SI1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DataBase {

    Connection c;

    Statement query;

    String user, password, databaseName;

    boolean connectat = false;

    public DataBase (String user, String password, String databaseName){
        this.user=user;
        this.password=password;
        this.databaseName=databaseName;
    }

    public void connect(){
        try {
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/"+databaseName, user, password);
            query = c.createStatement();
            System.out.println("Connectat a la BBDD! :) ");
            connectat = true;
        }
        catch(Exception e) {
            System.out.println(e);
        }
    }

    public String getInfo(String columnName, String tableName, String id, String key){
        try{
            String q = "SELECT " + columnName + " FROM " + tableName + " WHERE "+key+" = '"+id+"' " + ";";
            System.out.println(q);
            ResultSet resultSet = query.executeQuery(q);
            resultSet.next();
            return resultSet.getString(columnName);
        }catch(Exception e){
            System.out.println(e);
        } return null;
    }

    public int getNumFilesTable(String tableName) {
        String q = "DELECT COUNT(*) AS num FROM " + tableName;
        try {
            ResultSet resultSet = query.executeQuery(q);
            resultSet.next();
            return resultSet.getInt("num");
        } catch (Exception e) {
            System.out.println(e);
        }
        return 0;
    }

    public String[] getInfo(String tableName, String columnName){
        int n = getNumFilesTable(tableName);
        String[] info = new String[n];
        String q = "SELECT "+ columnName + " FROM " + tableName;
        try{
            ResultSet resultSet = query.executeQuery(q);
            int f=0;
            while(resultSet.next()){
                info[f] = resultSet.getString(1);
                f++;
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
        return info;
    }

    public String[][] getInfo(){
        int fn = getNumFilesTable("usuario");
        String[][] info = new String[fn][2];
        String q = " SELECT nombre, contrasena FROM usuario ORDER BY nombre ASC";
        try{
            ResultSet resultSet = query.executeQuery(q);
            int f=0;
            while(resultSet.next()){
                info[f][0] = resultSet.getString("nombre");
                info[f][1] = resultSet.getString("contrasena");
                f++;
            }
        }
        catch(Exception e){
            System.out.println();
        }
        return info;
    }

    public int getNumFilesQuerry(String q) {
        try {
            ResultSet resultSet = query.executeQuery(q);
            resultSet.next();
            return resultSet.getInt("num");
        } catch (Exception e) {
            System.out.println(e);
        }
        return 0;
    }

    public String[][] getUsuarioContrasena(){
        String qNF = "SELECT COUNT(*) AS num FROM usuario WHERE contrasena='password1'";
        int nf= getNumFilesQuerry(qNF);
        String[][] info= new String[nf][2];
        String q ="SELECT nombre, contrasena" + " FROM usuario" + " WHERE contrasena='password1'";
        System.out.println(q);
        try{
            ResultSet resultSet = query.executeQuery(q);
            int n=0;
            while (resultSet.next()){
                info[n][0] = resultSet.getString("nombre");
                info[n][1] = resultSet.getString("contrasena");
                n++;
            }
        }
        catch (Exception e){
            System.out.println(e);
        }

        return info;
    }

    /*public String getInfoUsuarioColeccion() {
        String qNF = "SELECT COUNT(*) AS num FROM coleccion c, usuario u WHERE c.usuario"
        int nf = getNumFilesQuerry(qNF);
    }

     */
}
