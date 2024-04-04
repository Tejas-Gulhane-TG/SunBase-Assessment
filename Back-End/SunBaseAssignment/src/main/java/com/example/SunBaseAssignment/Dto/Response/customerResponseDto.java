package com.example.SunBaseAssignment.Dto.Response;


import lombok.*;
import lombok.experimental.FieldDefaults;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class customerResponseDto {

    String Uid;

    String message;

    Date joinedOn;

    String firstName;

    String lastName;

    String street;

    String address;

    String city;

    String state;

    String email;

    String phone;
}