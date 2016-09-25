package data.dto;

import com.sun.xml.internal.ws.developer.Serialization;
import data.dto.base.BaseDto;

/**
 * User: nikpodrivnik
 * Date: 25/09/16
 */

@Serialization
public class ContactDto extends BaseDto {
    private String firstName;
    private String secondName;
    private String middleName;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

}
