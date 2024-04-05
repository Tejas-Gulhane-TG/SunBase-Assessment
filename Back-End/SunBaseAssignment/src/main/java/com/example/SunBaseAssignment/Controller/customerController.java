package com.example.SunBaseAssignment.Controller;


import com.example.SunBaseAssignment.Dto.Request.customerRequestDto;
import com.example.SunBaseAssignment.Dto.Response.customerResponseDto;
import com.example.SunBaseAssignment.Exception.customerAlreadyExists;
import com.example.SunBaseAssignment.Exception.customerNotFound;
import com.example.SunBaseAssignment.Service.ApiService;
import com.example.SunBaseAssignment.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class customerController {

    @Autowired
    CustomerService customerService;

    @PostMapping("/create")
    public ResponseEntity<customerResponseDto> createCustomer(@RequestBody customerRequestDto customerRequestDto, @RequestParam boolean SyncDb){
        try{
            customerResponseDto customerResponseDto = customerService.createCustomer(customerRequestDto, SyncDb);
            return new ResponseEntity<>(customerResponseDto, HttpStatus.CREATED);
        }catch (customerAlreadyExists e){
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/update/{emailId}")
    public ResponseEntity<customerResponseDto> updateCustomer(@PathVariable String emailId, @RequestBody customerRequestDto customerRequestDto){
        try{
            customerResponseDto customerResponseDto = customerService.updateCustomer(emailId, customerRequestDto);
            return new ResponseEntity<>(customerResponseDto, HttpStatus.ACCEPTED);
        }catch(customerNotFound e){
            return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }


    @GetMapping("/getCustomers")
    public ResponseEntity<Page<customerResponseDto>> getAllCustomers(@RequestParam int pageNo, @RequestParam int rowsCount,
                                                                     @RequestParam(required = false)String sortBy,
                                                                     @RequestParam(required = false) String searchBy){

        Page<customerResponseDto> customerList = customerService.getAllCustomers(pageNo, rowsCount, sortBy, searchBy);
        return new ResponseEntity<>(customerList, HttpStatus.FOUND);

    }


    @GetMapping("/searchBy")
    public ResponseEntity<List<customerResponseDto>> searchByCol(@RequestParam String searchBy, @RequestParam String searchQuery){
        List<customerResponseDto> result = customerService.searchByCol(searchBy, searchQuery);
        return new ResponseEntity<>(result, HttpStatus.FOUND);
    }


    @GetMapping("/get/{email}")
    public ResponseEntity<customerResponseDto> getCustomerWithId(@PathVariable String email){

        try{
            customerResponseDto customerResponseDto = customerService.getCustomerWithId(email);
            return new ResponseEntity<customerResponseDto>(customerResponseDto, HttpStatus.FOUND);
        }catch (customerNotFound e){
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity deleteCustomer(@RequestParam String email){
        try {
            String result = customerService.deleteCustomer(email);
            return new ResponseEntity(result, HttpStatus.ACCEPTED);
        }catch (customerNotFound e){
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    ApiService apiService = new ApiService();
    @GetMapping("/syncDB")
    public Object[] getToken(){
        Object[] customers = apiService.getToken();
        return customers;
    }

}