package framework.models;

import framework.constants.Regexes;
import lombok.Builder;
import lombok.Data;
import ru.kduskov.annotations.GeneratingRule;
import ru.kduskov.enums.GenerationsRules;

@Data
@Builder
public class User {
    @GeneratingRule(regex = Regexes.USERNAME)
    private String username;
    @GeneratingRule(valueKey = GenerationsRules.PASSWORD)
    private String password;
}
