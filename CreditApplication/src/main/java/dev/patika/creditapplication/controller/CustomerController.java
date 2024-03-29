package dev.patika.creditapplication.controller;

import dev.patika.creditapplication.model.TransactionLogger;
import dev.patika.creditapplication.service.CustomerService;
import dev.patika.creditapplication.dto.CustomerDTO;
import dev.patika.creditapplication.model.Customer;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/customer")
@RequiredArgsConstructor
// Endpoint configurations
public class CustomerController {
    private final CustomerService customerService;


    //To get all customers
    @GetMapping("/customers")
    public ResponseEntity<List<Customer>> findAll(){
        return new ResponseEntity<>(customerService.findAll(), HttpStatus.OK);
    }

    // To save customers
    @PostMapping("/save-customer")
    public ResponseEntity<Customer> saveCustomer(@RequestBody @Valid CustomerDTO customerDTO) {
        Optional<Customer> resultOptional = customerService.saveCustomer(customerDTO);

        if (resultOptional.isPresent()) {
            return new ResponseEntity<>(resultOptional.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    //To delete customer by Id
    @DeleteMapping(value = "/deleteById/{id}")
    public String deleteCustomerById(@PathVariable Long id) {
        customerService.deleteById(id);
        return "Customer with id: " + id + " is deleted...";
    }

    //To update customer by Id
    @PutMapping("/{id}")
    public String updateCustomer(@PathVariable Long id, @Valid CustomerDTO customerDTO, BindingResult result){
        if(result.hasErrors()){
            return "There is an error !";
        }
        customerService.updateCustomerById(customerDTO);

        return "Customer updated.";
    }

    //To find customer by Id
    @GetMapping(value = "/findById/{id}")
    public ResponseEntity<Customer> findCustomerById(@PathVariable Long id) {
        Optional<Customer> resultOptional = customerService.findCustomerById(id);
        if (resultOptional.isPresent()) {
            return new ResponseEntity<>(resultOptional.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
    //To get transactions
    @GetMapping("/get-transactions-by-date")
    public ResponseEntity<Page<List<TransactionLogger>>> getAllTransactionsWithDate(
            @ApiParam(value = "transaction query for user usage", example = "28/09/2021", required = true)
            @RequestParam String transactionDate,
            @RequestParam(required = false) Integer pageNumber,
            @RequestParam(required = false) Integer pageSize,
            @PageableDefault(page = 0, size = 10) Pageable pageable){
        return new ResponseEntity<>(this.customerService.getAllTransactionsWithDate(transactionDate, pageNumber, pageSize, pageable), HttpStatus.OK);
    }
}
