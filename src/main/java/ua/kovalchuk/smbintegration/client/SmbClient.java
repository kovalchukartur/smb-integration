package ua.kovalchuk.smbintegration.client;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import jcifs.smb.SmbFile;
import jcifs.smb.SmbFileInputStream;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class SmbClient {

    private final SmbProperties smbProperties;

    public SmbClient(SmbProperties smbProperties) {
        this.smbProperties = smbProperties;
    }

    @SneakyThrows
    public String getFile() {
        String username = smbProperties.getUsername();
        String password = smbProperties.getPassword();

        SmbFile file = new SmbFile("smb://" + username + ":" + password + "@" + smbProperties.getPath());
        SmbFileInputStream in = new SmbFileInputStream(file);

        Path localFile = Files.createTempFile("", "videoName.mp4");
        Files.copy(in, localFile, StandardCopyOption.REPLACE_EXISTING);

        log.info("Local file {}", localFile);
        return localFile.toString();
    }
}
