package com.example.SunBaseAssignment.Dto.Response;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ResponseFromSunBase {

    String uuid;

    String first_name;

    String last_name;

    String street;

    String address;

    String city;

    String state;

    String email;

    String phone;
}


