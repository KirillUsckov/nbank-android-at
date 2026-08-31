package framework.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum SuccessfulToasts {
    LOGIN("Успешный вход", "Добро пожаловать!");
    private final String title;
    private final String description;
}
