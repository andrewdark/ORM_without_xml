package darknsoft;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {

  public static void main(String[] args) {
    ApplicationContext apx = new AnnotationConfigApplicationContext(MyConfig.class);
    BasicDataSource dataSource = (BasicDataSource) apx.getBean("dataSource");
    Connection conn = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;
    try {
      conn = dataSource.getConnection();
      stmt = conn.prepareStatement("SELECT * FROM bookstore.authors");
      rs = stmt.executeQuery();
      if(rs.next()){
        System.out.println("id: " + rs.getInt("id"));
        System.out.println("id: " + rs.getString("firstname"));
        System.out.println("id: " + rs.getString("lastname"));
      }
    } catch (SQLException ex) {

    } finally {
      if (rs != null) {
        try {
          rs.close();
        } catch (SQLException e) {
        }
      }
      if (stmt != null) {
        try {
          stmt.close();
        } catch (SQLException e) {
        }
      }
      if (conn != null) {
        try {
          conn.close();
        } catch (SQLException e) {
        }

      }
    }
  }

}
