package dev.patika.creditapplication.service;

import dev.patika.creditapplication.dto.CustomerDTO;
import dev.patika.creditapplication.exceptions.BadRequestException;
import dev.patika.creditapplication.exceptions.CustomerNotFoundException;
import dev.patika.creditapplication.mappers.CustomerMapper;
import dev.patika.creditapplication.model.Customer;
import dev.patika.creditapplication.model.TransactionLogger;
import dev.patika.creditapplication.model.enumeration.TransactionLogType;
import dev.patika.creditapplication.repository.CustomerRepository;
import dev.patika.creditapplication.repository.TransactionLoggerRepository;
import dev.patika.creditapplication.util.ClientRequestInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;
    @Autowired
    private ClientRequestInfo clientRequestInfo;
    @Autowired
    private TransactionLoggerRepository transactionLoggerRepository;


    @Transactional
    public Optional<Customer> saveCustomer(CustomerDTO customerDTO){
        boolean isExists = customerRepository.selectExistsIdentityNumber(customerDTO.getIdentityNumber());
        boolean isExistPhoneNumber = customerRepository.selectExistsPhoneNumber(customerDTO.getPhoneNumber());

        if(customerDTO.getIdentityNumber().endsWith("1") || customerDTO.getIdentityNumber().endsWith("3") || customerDTO.getIdentityNumber().endsWith("5") || customerDTO.getIdentityNumber().endsWith("7") || customerDTO.getIdentityNumber().endsWith("9") )
            throw  new BadRequestException("tc tek sayı ile bitemez");
        if(isExists){
            throw new BadRequestException("Customer with Identity Number : " + customerDTO.getIdentityNumber() + " is already exists!");
        }
        else if(isExistPhoneNumber){
            throw new BadRequestException("Customer with phone number : " + customerDTO.getPhoneNumber() + " is already exists!");
        }



        Customer customer = customerMapper.mapFromCustomerDTOtoCustomer(customerDTO);
        this.saveTransactionToDatabase(customer,TransactionLogType.SAVE_CUSTOMER);
        return Optional.of(customerRepository.save(customer));
    }
    @Transactional
        public void deleteById(Long id) {
        customerRepository.deleteById(id);
    }

    @Transactional(readOnly = true)
    public List<Customer> findAll() {
        List<Customer> customerList = new ArrayList<>();
        Iterable<Customer> customerIter = customerRepository.findAll();
        customerIter.iterator().forEachRemaining(customerList::add);
        return customerList;
    }


    @Transactional
    public Optional<Customer> updateCustomerById(CustomerDTO customerDTO){
        Customer customer = customerMapper.mapFromCustomerDTOtoCustomer(customerDTO);
        boolean isExists = customerRepository.selectExistsIdentityNumber(customerDTO.getIdentityNumber());
        boolean isExistPhoneNumber = customerRepository.selectExistsPhoneNumber(customerDTO.getPhoneNumber());
        boolean isExistId = customerRepository.selectExistsId(customerDTO.getId());
        if(!isExistId){
            throw new CustomerNotFoundException("Customer with Id : " + customerDTO.getId() + " is not found!");
        }



        this.saveTransactionToDatabase(customer, TransactionLogType.UPDATE_CUSTOMER);
        return Optional.of(customerRepository.save(customer));
    }

    public Optional<Customer> findById(Long id) {
        return customerRepository.findById(id);
    }

    private void saveTransactionToDatabase(Customer customer, TransactionLogType transactionLogType) {
        TransactionLogger transactionLogger = new TransactionLogger();
        transactionLogger.setIdentityNumber(customer.getIdentityNumber());
        transactionLogger.setTransactionDateTime(LocalDate.now());

        transactionLogger.setClientUrl(clientRequestInfo.getClientUrl());
        transactionLogger.setClientIpAddress(clientRequestInfo.getClientIpAddress());
        transactionLogger.setSessionActivityId(clientRequestInfo.getSessionActivityId());
        transactionLogger.setTransactionLogType(transactionLogType);
        transactionLoggerRepository.save(transactionLogger);
    }
}
