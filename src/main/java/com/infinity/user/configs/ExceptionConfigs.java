package com.infinity.user.configs;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Map;

@Getter
@Setter
@Component
@ConfigurationProperties(prefix = "control")
public class ExceptionConfigs {

    public static final String PERSONALIZADA = "perzonalisada";
    public static final String SYSTEM ="system";

    private Map<String,String> exception;

    public String getTipoException (final String tipo){
        return exception.get(tipo);
    }

}
