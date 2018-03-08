package es.rvillalba.spring.mail;

import javax.annotation.Resource;
import javax.mail.Message;
import javax.mail.MessagingException;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import es.rvillalba.spring.unittest.context.AbstractSpringContext;
import com.icegreen.greenmail.util.GreenMail;
import com.icegreen.greenmail.util.GreenMailUtil;

@ActiveProfiles("dev")
@RunWith(SpringJUnit4ClassRunner.class)
public class EmailServiceTest extends AbstractSpringContext {

    @Resource
    private EmailService emailService;

    private GreenMail greenMail;

    private static final String USER_PASSWORD = "abcdef123";

    private static final String USER_NAME = "hascode";

    private static final String USER_EMAIL = "someone@localhost.com";

    private static final String EMAIL_SUBJECT = "Test SPRING E-Mail";

    private static final String EMAIL_TEXT = "This is a test e-mail for SPRING notifications.";

    @Before
    public void init() {
        greenMail = new GreenMail();
        greenMail.setUser(USER_EMAIL, USER_NAME, USER_PASSWORD);
        greenMail.start();
    }

    @Test
    public void testEmail() throws InterruptedException, MessagingException {
        emailService.sendSimpleMessage(USER_EMAIL, EMAIL_SUBJECT, EMAIL_TEXT);
        Assert.assertTrue(greenMail.waitForIncomingEmail(5000, 1));
        Message[] messages = greenMail.getReceivedMessages();
        Assert.assertEquals(EMAIL_SUBJECT, messages[0].getSubject());
        Assert.assertEquals(EMAIL_TEXT, GreenMailUtil.getBody(messages[0]));
    }

    @After
    public void cleanup() {
        greenMail.stop();
    }
}
