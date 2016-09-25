package data.dto.base;

import com.sun.xml.internal.ws.developer.Serialization;

/**
 * User: nikpodrivnik
 * Date: 25/09/16
 */
@Serialization
public class BaseDto implements IDto {
    @Override
    public int getId() {
        return 0;
    }

    @Override
    public void setId(int id) {

    }
}
