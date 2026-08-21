package framework.resolvers;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.api.extension.ParameterResolutionException;
import org.junit.jupiter.api.extension.ParameterResolver;

import framework.annotations.CreateUser;
import framework.helpers.ApiHelper;
import framework.models.User;
import framework.models.body.CreateUserRequestBody;
import ru.kduskov.generators.RequestDataGenerator;

public class CreateUserParameterResolver implements ParameterResolver {
    @Override
    public boolean supportsParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
        return parameterContext.isAnnotated(CreateUser.class)
                && parameterContext.getParameter().getType().equals(User.class);
    }

    @Override
    public Object resolveParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
        CreateUserRequestBody userRequest =
                RequestDataGenerator.generateFilledObject(CreateUserRequestBody.class);
        ApiHelper.createUser(userRequest);
        return User.builder()
                .username(userRequest.getUsername())
                .password(userRequest.getPassword())
                .build();
    }
}
