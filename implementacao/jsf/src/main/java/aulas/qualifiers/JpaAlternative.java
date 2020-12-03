package aulas.qualifiers;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

import javax.inject.Qualifier;

@Qualifier
@Target(ElementType.TYPE)
//@Retention(RUNTIME)
public @interface JpaAlternative {

}
