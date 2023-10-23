package br.com.rodolfo.user.produces;

import br.com.rodolfo.user.dto.EmailDto;
import br.com.rodolfo.user.models.User;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class UserProduces {

    private final RabbitTemplate rabbitTemplate;

    public UserProduces(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @Value(value = "${broker.queue.email.name}")
    private String routingKey;

    public void publishMessageEmail(User user){
        var emailDto = new EmailDto();
        emailDto.setUserId(user.getUserId());
        emailDto.setEmailTo(user.getEmail());
        emailDto.setSubject("Cadastro Realizado com Sucesso");
        emailDto.setText(user.getName() + ", Seja bem Vindo(a) \n Agradecemos o cadastro");
        rabbitTemplate.convertAndSend("", routingKey, emailDto);
    }
}
