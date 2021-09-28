package dev.patika.creditapplication.mappers;

import dev.patika.creditapplication.dto.CustomerDTO;
import dev.patika.creditapplication.model.Customer;
import org.mapstruct.Mapper;

@Mapper
// Mapper implementation for Customer
public interface CustomerMapper {
    Customer mapFromCustomerDTOtoCustomer(CustomerDTO customerDTO);
    CustomerDTO mapFromCustomertoCustomerDTO(Customer customer);
}
