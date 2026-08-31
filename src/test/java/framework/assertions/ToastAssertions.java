package framework.assertions;

import static org.junit.jupiter.api.Assertions.assertAll;

import org.junit.jupiter.api.Assertions;

import framework.enums.ErrorToasts;
import framework.enums.SuccessfulToasts;

public class ToastAssertions {
    private static void assertToastTitleEquals(String expectedTitle, String actualTitle) {
        Assertions.assertEquals(
                expectedTitle,
                actualTitle,
                String.format(
                        "Toast title is not equal expected\nExpected:%s\nActual:%s",
                        expectedTitle,
                        actualTitle
                )
        );
    }

    private static void assertToastDescriptionContains(String expectedDescription, String actualDescription) {
        Assertions.assertTrue(
                actualDescription.contains(expectedDescription),
                String.format(
                        "Toast description is not contain expected\nExpected:%s\nActual:%s",
                        expectedDescription,
                        actualDescription
                )
        );

    }

    private static void assertToastDescriptionEquals(String expectedDescription, String actualDescription) {

        Assertions.assertTrue(
                actualDescription.contains(expectedDescription),
                String.format(
                        "Toast description is not equal expected\nExpected:%s\nActual:%s",
                        expectedDescription,
                        actualDescription
                )
        );
    }

    public static void assertErrorToast(ErrorToasts errorToast, String actualTitle, String actualDescription) {
        assertAll("Check error toast has expected title and description",
                () -> assertToastTitleEquals(errorToast.getTitle(), actualTitle),
                () -> {
                    if (errorToast.isPartOfDescription())
                        assertToastDescriptionContains(errorToast.getDescription(), actualDescription);
                    else
                        assertToastDescriptionEquals(errorToast.getDescription(), actualDescription);
                }
        );

    }

    public static void assertSuccessToast(SuccessfulToasts successfulToast, String actualTitle, String actualDescription) {
        assertAll("Check success toast has expected title and description",
                () -> assertToastTitleEquals(successfulToast.getTitle(), actualTitle),
                () -> assertToastDescriptionEquals(successfulToast.getDescription(), actualDescription));
    }
}
