package dev.patika.creditapplication.repository;

import dev.patika.creditapplication.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
//CustomerRepository
public interface CustomerRepository extends JpaRepository<Customer,Long> {
    //To find that IdentityNumber is already exist
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

    //To find that PhoneNumber is already exist
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

    //To find that Id is already exist
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

    //To get customer monthly salary according to identity number
    @Query("SELECT c.monthlySalary FROM Customer c WHERE c.identityNumber=:identityNumber")
    Double getCustomerSalaryByIdentityNumber(String identityNumber);

    //To get customer according to identity number
    Customer getCustomerByIdentityNumber(String identityNumber);
}
