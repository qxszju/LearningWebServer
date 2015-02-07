package road.to.cto.HelloWorld.custom.dao;

import road.to.cto.HelloWorld.custom.model.Customer;

public interface CustomerDAO {
    public void insert(Customer customer);
    public Customer findByCustomerId(int custId);
}
