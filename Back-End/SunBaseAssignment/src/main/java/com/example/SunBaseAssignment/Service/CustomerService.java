package com.example.SunBaseAssignment.Service;



import com.example.SunBaseAssignment.Dto.Request.customerRequestDto;
import com.example.SunBaseAssignment.Dto.Response.customerResponseDto;
import org.springframework.data.domain.Page;

import java.util.List;

public interface CustomerService {

    customerResponseDto createCustomer(customerRequestDto customerRequestDto, boolean SyncDb);

    customerResponseDto updateCustomer(String email, customerRequestDto customerRequestDto);

    Page<customerResponseDto> getAllCustomers(int pageNo, int rowsCount, String sortBy, String searchBy);

    List<customerResponseDto> searchByCol(String searchBy, String searchQuery);

    customerResponseDto getCustomerWithId(String email);

    String deleteCustomer(String email);

}