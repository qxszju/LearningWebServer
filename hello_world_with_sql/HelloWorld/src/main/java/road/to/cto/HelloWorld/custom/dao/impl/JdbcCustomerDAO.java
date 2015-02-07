package road.to.cto.HelloWorld.custom.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import road.to.cto.HelloWorld.custom.dao.CustomerDAO;
import road.to.cto.HelloWorld.custom.model.Customer;

public class JdbcCustomerDAO implements CustomerDAO {
    
    private DataSource dataSource;
    
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public JdbcCustomerDAO() {
        // TODO Auto-generated constructor stub
       
    }

    @Override
    public void insert(Customer customer) {
        // TODO Auto-generated method stub
        String sql = "INSERT INTO CUSTOMER " +
                "(CUST_ID, NAME, AGE) VALUES (?, ?, ?)";
        Connection conn = null;
 
        try {
            conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, customer.getCustId());
            ps.setString(2, customer.getName());
            ps.setInt(3, customer.getAge());
            ps.executeUpdate();
            ps.close();
 
        } catch (SQLException e) {
            throw new RuntimeException(e);
 
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {}
            }
        }
    }

    @Override
    public Customer findByCustomerId(int custId) {
        // TODO Auto-generated method stub
        String sql = "SELECT * FROM CUSTOMER WHERE CUST_ID = ?";
        
        Connection conn = null;
 
        try {
            conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, custId);
            Customer customer = null;
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                customer = new Customer(
                    rs.getInt("CUST_ID"),
                    rs.getString("NAME"), 
                    rs.getInt("Age")
                );
            }
            rs.close();
            ps.close();
            return customer;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (conn != null) {
                try {
                conn.close();
                } catch (SQLException e) {}
            }
        }
    }

}
