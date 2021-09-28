package dev.patika.creditapplication.util;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Data
@NoArgsConstructor
@Component
@SessionScope
// For transaction to get client infos
public class ClientRequestInfo {

    private String clientIpAddress;
    private String clientUrl;
    private String sessionActivityId;

}