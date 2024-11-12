package br.com.matheusleal.produce.app.service;

import br.com.matheusleal.produce.app.config.RabbitMQConfig;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import static br.com.matheusleal.produce.app.config.RabbitMQConfig.EXG_MARKETPLACE;
import static br.com.matheusleal.produce.app.config.RabbitMQConfig.RK_PRODUCT_LOG;

@Service
@RequiredArgsConstructor
@Slf4j
public class StringService {
    private final RabbitTemplate rabbitTemplate;

    public void produce(String message) {
        log.info("Received message: {}", message);
        rabbitTemplate.convertAndSend(EXG_MARKETPLACE, RK_PRODUCT_LOG, message);
    }

}
