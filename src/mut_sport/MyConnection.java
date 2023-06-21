/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mut_sport;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author cash
 */
public class MyConnection {
    
    public static Connection getconection(){
    Connection con = null;

    try{
        Class.forName("com.mysql.cj.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project? useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","");
    }catch(Exception ex){
        System.out.println(ex.getMessage());
    }
    return con;
    }
}
//db?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC