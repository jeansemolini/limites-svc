package br.com.coffeeandit.limitessvc.events;

import br.com.coffeeandit.limitessvc.dto.TransactionDto;
import br.com.coffeeandit.limitessvc.service.LimiteDiarioService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@Slf4j
public class LimiteConsumer {

    private LimiteDiarioService limiteDiarioService;
    private ObjectMapper objectMapper;

    public LimiteConsumer(LimiteDiarioService limiteDiarioService, ObjectMapper objectMapper) {
        this.limiteDiarioService = limiteDiarioService;
        this.objectMapper = objectMapper;
    }
    @KafkaListener(topics = "${app.topic}")
    public void onConsume(final String message) {
        try {
            TransactionDto transactionDto = getTransaction(message);
            limiteDiarioService.validarLimiteDiario(transactionDto);
        } catch (JsonProcessingException e) {
            log.error(e.getMessage());
        }
    }

    private TransactionDto getTransaction(String message) throws JsonProcessingException {
        TransactionDto transactionDto = objectMapper.readValue(message, TransactionDto.class);
        transactionDto.setData(LocalDateTime.now());
        return transactionDto;
    }
}
