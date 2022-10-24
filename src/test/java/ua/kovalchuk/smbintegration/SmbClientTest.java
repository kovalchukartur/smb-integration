package ua.kovalchuk.smbintegration;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import ua.kovalchuk.smbintegration.client.SmbClient;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@ActiveProfiles("local")
class SmbClientTest {

    @Autowired
    private SmbClient smbClient;

    @Test
    void whenGetFileIsSuccess() {
        String file = smbClient.getFile();
        assertNotNull(file);
    }
}