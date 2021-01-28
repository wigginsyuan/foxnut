package org.zzrc;

import com.zzrc.sdk.lotus.model.identity.UserIdentityDto;
import com.zzrc.sdk.lotus.service.UserIdentityRpcService;
import com.zzrc.sdk.whale.model.WhaleResponse;
import org.apache.dubbo.config.annotation.Reference;
import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.junit.runner.RunWith;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

@EnableDubbo
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/spring.xml"})
public class DubboTest extends AbstractTestNGSpringContextTests {
//    @Reference
//    public UserIdentityRpcService userIdentityRpcService;
    @Test
    public void testUserIdentityRpcService() {
        String userGid = "a0f1d02fad7a44929fd11c7f17f5967c";
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"spring/spring.xml"});
        context.start();
        UserIdentityRpcService userIdentityRpcService = (UserIdentityRpcService) context.getBean("demoProviderService");
        WhaleResponse<UserIdentityDto> userWhaleResp = userIdentityRpcService.getUserIdentityByUserGid(userGid);
        UserIdentityDto userIdentityDto = userWhaleResp.getBody();
    }
}
