package ir.wallet.springboot.web.validation;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = AgeFatherConstraintValidator.class)
@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface AgeFatherConstraint {
    String message() default "If age is less than 18, fatherCode must be provided";
    String TrooperStatusMessage() default "If age is 18 or older, Trooper status must be provided.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
