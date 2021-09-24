package dev.patika.creditapplication.mappers;

import dev.patika.capstone.dto.CustomerDTO;
import dev.patika.capstone.model.Customer;
import org.mapstruct.Mapper;

@Mapper
public interface CustomerMapper {
    Customer mapFromCustomerDTOtoCustomer(CustomerDTO customerDTO);

}
