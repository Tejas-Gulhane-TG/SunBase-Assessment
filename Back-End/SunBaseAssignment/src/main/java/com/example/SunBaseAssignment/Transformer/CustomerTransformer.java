package com.example.SunBaseAssignment.Transformer;


import com.example.SunBaseAssignment.Dto.Request.customerRequestDto;
import com.example.SunBaseAssignment.Dto.Response.customerResponseDto;
import com.example.SunBaseAssignment.Model.Customer;

public class CustomerTransformer {

//    Transformer to convert customerRequestDto to customer object

    public static Customer customerRequestDtoToCustomer(customerRequestDto customerRequestDto){
        return Customer.builder()
                .firstName(customerRequestDto.getFirstName())
                .lastName(customerRequestDto.getLastName())
                .email(customerRequestDto.getEmail())
                .phone(customerRequestDto.getPhone())
                .city(customerRequestDto.getCity())
                .address(customerRequestDto.getAddress())
                .state(customerRequestDto.getState())
                .street(customerRequestDto.getStreet())
                .build();
    }

//    Transformer to convert customer object to customerResponseDto

    public static customerResponseDto customerToCustomerResponseDto(Customer customer){
        return customerResponseDto.builder()
                .Uid(customer.getUid())
                .firstName(customer.getFirstName())
                .lastName(customer.getLastName())
                .email(customer.getEmail())
                .phone(customer.getPhone())
                .state(customer.getState())
                .street(customer.getStreet())
                .address(customer.getAddress())
                .joinedOn(customer.getJoinedOn())
                .phone(customer.getPhone())
                .city(customer.getCity())
                .build();
    }
}