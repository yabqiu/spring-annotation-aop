package cc.unmi;

import cc.unmi.aspects.MethodStartAspect;
import cc.unmi.config.AppConfig;
import cc.unmi.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.inject.Inject;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

@ContextConfiguration(classes = AppConfig.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class HelloAopTest {

    @Inject
    private UserService userService;

    @Before
    public void setup() {
        MethodStartAspect.clearStartTime();
    }

    @Test
    public void testSettingMethodStartTimeInThreadLocal() {
        userService.fetchUserById(9999);

        assertThat(MethodStartAspect.getStartTime(), notNullValue());
    }
}