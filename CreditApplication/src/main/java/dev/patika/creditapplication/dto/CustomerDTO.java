package dev.patika.creditapplication.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.format.annotation.NumberFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
public class CustomerDTO {
    @ApiModelProperty(hidden = true)
    private Long id;

    @ApiModelProperty(example = "Nevzat")
    @NotBlank(message = "First Name is mandatory")
    private String firstName;

    @ApiModelProperty(example = "Samur")
    @NotBlank(message = "Last Name is mandatory")
    private String lastName;

    @ApiModelProperty(example = "2500.0")
    @NotNull(message = "Monthly salary is mandatory")
    @NumberFormat(style = NumberFormat.Style.NUMBER)
    private double monthlySalary;

    @ApiModelProperty(example = "11111111111")
    @NotBlank(message = "Identity number is mandatory")
    private String identityNumber;

    @ApiModelProperty(example = "5331234545")
    @NotBlank(message = "Phone number is mandatory")
    private String phoneNumber;


}
