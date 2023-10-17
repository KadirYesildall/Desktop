package Coding.rentACar.core.utilities.exceptions;

import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ValidationProblemDetails extends ProblemDetails {
    private Map<String, String> validationErrors;
}
