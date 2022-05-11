package by.andersen.laboratory.microservice.authorization.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientDto {

    private String firstName;

    private String lastName;

    private Long uid;

    @JsonFormat(pattern="yyyy-MM-dd")
    private Date dateOfBirth;

    private String role;
}
