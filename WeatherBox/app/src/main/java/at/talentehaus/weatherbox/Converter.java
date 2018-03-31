package at.talentehaus.weatherbox;

import java.util.Base64;

public class Converter {
    static String encodeBase64(String code) {
        return Base64.getEncoder().encodeToString(code.getBytes());
    }

    static String decodeBase64(String code) {
        return new String(Base64.getDecoder().decode(code));
    }
}
