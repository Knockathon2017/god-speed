package ginie.enums;

/**
 * Created by dhruvr on 6/8/16.
 */
public enum Result {

    FAILURE(0),
    SUCCESS(1);
    public final int value;

    Result(final int value) {
        this.value = value;
    }
}
