package com.capgemini.project.farecalculator.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;
import org.springframework.data.annotation.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Passenger {
    @Id
    private String id;
    private String firstName;
    private String middleName;
    private String lastName;
    @Range(min=5, max=120, message="age must be 5 to 100")
    private Integer age;
    private String gender;
    private String seatNo;

}
