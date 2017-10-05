package seedu.address.model.person;

import static java.util.Objects.requireNonNull;

import java.net.MalformedURLException;
import java.net.URL;

import seedu.address.commons.exceptions.IllegalValueException;

public class Homepage {
    public static final String MESSAGE_HOMEPAGE_CONSTRAINTS =
            "Person homepage should be a valid URL";
    public final String value;

    /**
     * Validates given homepage.
     *
     * @throws IllegalValueException if given homepage string is invalid.
     */
    public Homepage(String homepage) throws IllegalValueException {
        requireNonNull(homepage);
        String trimmedHomepage = homepage.trim();
        if (!isValidHomepage(trimmedHomepage)) {
            throw new IllegalValueException(MESSAGE_HOMEPAGE_CONSTRAINTS);
        }
        this.value = trimmedHomepage;
    }

    /**
     * For sole use by {@code ParserUtil} to reset homepage
     */
    public Homepage() {
        this.value = null;
    }

    /**
     * Returns if a given string is a valid person email.
     */
    public static boolean isValidHomepage(String test) {
        try {
            URL url = new URL(test);
        } catch (MalformedURLException e) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Email // instanceof handles nulls
                && this.value.equals(((Email) other).value)); // state check
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }
}
