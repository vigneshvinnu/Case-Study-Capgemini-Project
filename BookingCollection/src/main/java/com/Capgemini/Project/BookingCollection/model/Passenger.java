package com.Capgemini.Project.BookingCollection.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;
import org.springframework.data.annotation.Id;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Passenger {

    private String firstName;
    private String lastName;
    @Range(min=5, max=120, message="age must be 5 to 100")
    private Integer age;
    private String gender;

}
