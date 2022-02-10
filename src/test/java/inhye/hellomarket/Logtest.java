package inhye.hellomarket;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class Logtest {

    private static final Logger logger = LoggerFactory.getLogger(Logtest.class);

    @Test
    void 로그테스트(){
        logger.info("hello~~!");
    }
}
