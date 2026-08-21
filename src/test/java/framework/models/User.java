package framework.models;

import framework.constants.Regexes;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.kduskov.annotations.GeneratingRule;
import ru.kduskov.enums.GenerationsRules;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
    @GeneratingRule(regex = Regexes.USERNAME)
    private String username;
    @GeneratingRule(valueKey = GenerationsRules.PASSWORD, minLength = 8, maxLength = 128)
    private String password;
}
