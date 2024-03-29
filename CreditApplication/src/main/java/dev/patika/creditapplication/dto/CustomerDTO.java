package dev.patika.creditapplication.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.NumberFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
@AllArgsConstructor
@NoArgsConstructor
//Implementation of models as a DTO
public class CustomerDTO {
    //@Pattern for inputs
    //NotBlank and NotNull implies that you cannot leave empty the field
    @ApiModelProperty(hidden = true)
    private Long id;

    @ApiModelProperty(example = "Nevzat")
    @NotBlank(message = "First Name is mandatory")
    @Pattern(regexp = "^[a-zA-ZöçşığüÖÇŞİĞÜ ,]+(\\s{0,1}[a-zA-ZöçşığüÖÇŞİĞÜ,])*$", message = "Connot contain special characters or numbers !")
    private String firstName;

    @ApiModelProperty(example = "Samur")
    @NotBlank(message = "Last Name is mandatory")
    @Pattern(regexp = "^[a-zA-ZöçşığüÖÇŞİĞÜ ,]+(\\s{0,1}[a-zA-ZöçşığüÖÇŞİĞÜ,])*$", message = "Connot contain special characters or numbers !")
    private String lastName;

    @ApiModelProperty(example = "2500.0")
    @NotNull(message = "Monthly salary is mandatory")
    @NumberFormat(style = NumberFormat.Style.NUMBER)
    private double monthlySalary;

    @ApiModelProperty(example = "11111111102")
    @NotBlank(message = "Identity number is mandatory")
    @Pattern(regexp ="^[1-9]{1}[0-9]{9}[02468]{1}$", message = "Please check your Identity Number !")
    private String identityNumber;

    @ApiModelProperty(example = "05331234545")
    @NotBlank(message = "Phone number is mandatory")
    @Pattern(regexp = "^(05)[0-9]{9}$", message = "Please check your Phone Number !")
    private String phoneNumber;


}
