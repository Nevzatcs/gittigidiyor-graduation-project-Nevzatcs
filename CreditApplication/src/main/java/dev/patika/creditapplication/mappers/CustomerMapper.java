package dev.patika.creditapplication.mappers;

import dev.patika.creditapplication.dto.CustomerDTO;
import dev.patika.creditapplication.model.Customer;
import org.mapstruct.Mapper;

@Mapper
public interface CustomerMapper {
    Customer mapFromCustomerDTOtoCustomer(CustomerDTO customerDTO);
    CustomerDTO mapFromCustomertoCustomerDTO(Customer customer);
}
