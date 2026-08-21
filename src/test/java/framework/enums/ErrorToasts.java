package framework.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ErrorToasts {
    LOGIN_401("Ошибка авторизации", "Request failed with status code 401", true);
    private final String title;
    private final String description;
    private final boolean isPartOfDescription;
}
