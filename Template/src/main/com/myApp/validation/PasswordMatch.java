package main.com.myApp.validation;



import org.springframework.messaging.handler.annotation.Payload;

import javax.validation.Constraint;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = PasswordMatchValidator.class)
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface PasswordMatch {

    String message() default "The password fields must match";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
