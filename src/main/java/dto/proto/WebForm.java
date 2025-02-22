package dto.proto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter

public class WebForm {
    private final String fullName;
    private final String email;
    private final String currentAddress;
    private final String permanentAddress;

    public WebForm(String fullName, String email, String currentAddress, String permanentAddress) {
        this.fullName = fullName;
        this.email = email;
        this.currentAddress = currentAddress;
        this.permanentAddress = permanentAddress;
    }

    // Getters if needed
    public String getFullName() { return fullName; }
    public String getEmail() { return email; }
    public String getCurrentAddress() { return currentAddress; }
    public String getPermanentAddress() { return permanentAddress; }
}
