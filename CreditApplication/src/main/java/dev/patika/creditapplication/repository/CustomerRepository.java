package dev.patika.creditapplication.repository;

import dev.patika.creditapplication.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long> {

    //Customer findBySsid(String ssid);
    @Query("SELECT " +
            "  CASE " +
            "   WHEN " +
            "       COUNT(c)>0 " +
            "   THEN " +
            "       TRUE " +
            "   ELSE " +
            "       FALSE " +
            "   END " +
            "FROM Customer c " +
            "WHERE c.identityNumber = ?1")
    boolean selectExistsIdentityNumber(String identityNumber);

    @Query("SELECT " +
            "  CASE " +
            "   WHEN " +
            "       COUNT(c)>0 " +
            "   THEN " +
            "       TRUE " +
            "   ELSE " +
            "       FALSE " +
            "   END " +
            "FROM Customer c " +
            "WHERE c.phoneNumber = ?1")
    boolean selectExistsPhoneNumber(String phoneNumber);

    @Query("SELECT " +
            "  CASE " +
            "   WHEN " +
            "       COUNT(c)>0 " +
            "   THEN " +
            "       TRUE " +
            "   ELSE " +
            "       FALSE " +
            "   END " +
            "FROM Customer c " +
            "WHERE c.id = ?1")
    boolean selectExistsId(Long id);


    @Query("SELECT c.monthlySalary FROM Customer c WHERE c.identityNumber=:identityNumber")
    Double getCustomerSalaryByIdentityNumber(String identityNumber);

    Customer getCustomerByIdentityNumber(String identityNumber);
}
