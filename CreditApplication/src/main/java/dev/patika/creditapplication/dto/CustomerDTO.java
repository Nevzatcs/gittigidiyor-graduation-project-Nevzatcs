package dev.patika.creditapplication.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.NumberFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDTO {
    @ApiModelProperty(hidden = true)
    private Long id;

    @ApiModelProperty(example = "Nevzat")
    @NotBlank(message = "First Name is mandatory")
    @Pattern(regexp = "^\\p{L}+$", message = "Please check your First Name !")
    private String firstName;

    @ApiModelProperty(example = "Samur")
    @NotBlank(message = "Last Name is mandatory")
    @Pattern(regexp = "^\\p{L}+$", message = "Please check your Last Name !")
    private String lastName;

    @ApiModelProperty(example = "2500.0")
    @NotNull(message = "Monthly salary is mandatory")
    @NumberFormat(style = NumberFormat.Style.NUMBER)
    private double monthlySalary;

    @ApiModelProperty(example = "11111111112")
    @NotBlank(message = "Identity number is mandatory")
    @Pattern(regexp ="^[1-9]{1}[0-9]{9}[02468]{1}$", message = "Please check your Identity Number !")
    private String identityNumber;

    @ApiModelProperty(example = "05331234545")
    @NotBlank(message = "Phone number is mandatory")
    @Pattern(regexp = "^(05)[0-9]{9}$", message = "Please check your Phone Number !")
    private String phoneNumber;


}
