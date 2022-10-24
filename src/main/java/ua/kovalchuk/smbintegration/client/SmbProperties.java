package ua.kovalchuk.smbintegration.client;

import javax.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.annotation.Validated;

@Getter
@Setter
@Validated
@Configuration
@ConfigurationProperties(prefix = "smb")
public class SmbProperties {

    @NotEmpty
    private String username;
    @NotEmpty
    private String password;
    @NotEmpty
    private String path;
}