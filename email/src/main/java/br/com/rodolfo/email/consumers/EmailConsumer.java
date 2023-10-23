package br.com.rodolfo.email.consumers;

import br.com.rodolfo.email.dto.EmailDto;
import br.com.rodolfo.email.models.Email;
import br.com.rodolfo.email.services.EmailService;
import com.fasterxml.jackson.databind.util.BeanUtil;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.BeanUtils;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class EmailConsumer {

    private final EmailService emailService;

    public EmailConsumer(EmailService emailService) {
        this.emailService = emailService;
    }

    @RabbitListener(queues = "${broker.queue.email.name}")
    public void listenEmailQueue(@Payload EmailDto emailDto){
        var email = new Email();
        BeanUtils.copyProperties(emailDto,email);
        emailService.sendEmail(email);
        System.out.println(emailDto);
    }
}
