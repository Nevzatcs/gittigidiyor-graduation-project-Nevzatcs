package dev.patika.creditapplication.service;

import dev.patika.creditapplication.dto.CustomerDTO;
import dev.patika.creditapplication.exceptions.CustomerIsAlreadyExistException;
import dev.patika.creditapplication.exceptions.CustomerNotFoundException;
import dev.patika.creditapplication.mappers.CustomerMapper;
import dev.patika.creditapplication.model.Customer;
import dev.patika.creditapplication.model.TransactionLogger;
import dev.patika.creditapplication.model.enumeration.CreditScoreResult;
import dev.patika.creditapplication.model.enumeration.TransactionLogType;
import dev.patika.creditapplication.repository.CustomerRepository;
import dev.patika.creditapplication.repository.TransactionLoggerRepository;
import dev.patika.creditapplication.util.ClientRequestInfo;
import dev.patika.creditapplication.util.CustomerValidatorUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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

        if(isExists){
            throw new CustomerIsAlreadyExistException("Customer with Identity Number : " + customerDTO.getIdentityNumber() + " is already exists!");
        }
        else if(isExistPhoneNumber){
            throw new CustomerIsAlreadyExistException("Customer with phone number : " + customerDTO.getPhoneNumber() + " is already exists!");
        }



        Customer customer = customerMapper.mapFromCustomerDTOtoCustomer(customerDTO);
        this.saveTransactionToDatabase(customer,TransactionLogType.SAVE_CUSTOMER);
        return Optional.of(customerRepository.save(customer));
    }
    @Transactional
        public void deleteById(Long id) {
        Optional<Customer> customer = customerRepository.findById(id);
        this.saveTransactionToDatabase(customer.get(), TransactionLogType.DELETE_CUSTOMER );
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
        boolean isExistId = customerRepository.selectExistsId(id);
        if(!isExistId){
            throw new CustomerNotFoundException("Customer with Id : " + id + " is not exist!");
        }
        return customerRepository.findById(id);
    }



    private void saveTransactionToDatabase(Customer customer, TransactionLogType transactionLogType) {
        TransactionLogger transactionLogger = new TransactionLogger();
        transactionLogger.setIdentityNumber(customer.getIdentityNumber());
        transactionLogger.setTransactionDateTime(LocalDate.now());
        transactionLogger.setCreditScoreResult(CreditScoreResult.CUSTOMER_LOG);
        transactionLogger.setClientUrl(clientRequestInfo.getClientUrl());
        transactionLogger.setClientIpAddress(clientRequestInfo.getClientIpAddress());
        transactionLogger.setSessionActivityId(clientRequestInfo.getSessionActivityId());
        transactionLogger.setTransactionLogType(transactionLogType);
        transactionLoggerRepository.save(transactionLogger);
    }

    public Page<List<TransactionLogger>> getAllTransactionsWithDate(String transactionDate, Integer page, Integer size, Pageable pageable) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
        CustomerValidatorUtil.validateTransactionDate(transactionDate, formatter);
        LocalDate transactionDateResult = LocalDate.parse(transactionDate, formatter);
        if(page != null && size != null){
            pageable = PageRequest.of(page, size);
        }
        return this.transactionLoggerRepository.findAllTransactionByTransactionDate(transactionDateResult, pageable);
    }
}
