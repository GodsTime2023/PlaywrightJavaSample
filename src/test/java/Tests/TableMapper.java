package Tests;

import dto.proto.WebForm;

import java.util.Map;
import java.util.Optional;

public class TableMapper {
    private static final String FULL_NAME = "FullName";
    private static final String EMAIL = "Email";
    private static final String CURRENT_ADDRESS = "CurrentAddress";
    private static final String PERMANENT_ADDRESS = "ParmanentAddress";

    protected WebForm decodeWebForm(Map<String, String> row) {
        if (row == null) {
            throw new IllegalArgumentException("Input row map cannot be null");
        }
        return new WebForm(
                getValue(row, FULL_NAME),
                getValue(row, EMAIL),
                getValue(row, CURRENT_ADDRESS),
                getValue(row, PERMANENT_ADDRESS));
    }

    private String getValue(Map<String, String> row, String key) {
        return Optional.ofNullable(row.get(key)).orElse("");
    }
}
