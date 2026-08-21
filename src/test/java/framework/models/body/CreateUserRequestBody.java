package framework.models.body;

import framework.constants.GenerationsRegexes;
import framework.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.kduskov.annotations.GeneratingRule;
import ru.kduskov.enums.GenerationsRules;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateUserRequestBody {
    @GeneratingRule(regex = GenerationsRegexes.USERNAME)
    private String username;
    @GeneratingRule(regex = GenerationsRegexes.NAME)
    private String name;
    @GeneratingRule(valueKey = GenerationsRules.PASSWORD, minLength = 8, maxLength = 128)
    private String password;

    private Role role = Role.USER;

    public CreateUserRequestBody(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public String toString() {
        return "CreateUserRequestBody{ username=" + username + ", passwordIsNotNull=" + !password.isEmpty() + ", role=" + role + "}";
    }
}