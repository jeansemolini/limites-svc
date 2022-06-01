package br.com.coffeeandit.limitessvc.service;

import br.com.coffeeandit.limitessvc.entity.LimiteDiario;
import br.com.coffeeandit.limitessvc.repository.LimiteDiarioRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class LimiteDiarioService {

    LimiteDiarioRepository limiteDiarioRepository;
    @Value("${limite.valor:0}")
    private BigDecimal valorDiario;

    public LimiteDiarioService(LimiteDiarioRepository limiteDiarioRepository) {
        this.limiteDiarioRepository = limiteDiarioRepository;
    }

    public Optional<LimiteDiario> buscarLimiteDiario(final Long agencia, final Long conta) {
        final Optional<LimiteDiario> limiteDiario = limiteDiarioRepository.findByAgenciaAndConta(agencia, conta);
        if (limiteDiario.isEmpty()) {
            var limite = new LimiteDiario();
            limite.setAgencia(agencia);
            limite.setConta(conta);
            limite.setValor(valorDiario);
            limite.setData(LocalDateTime.now());
            return Optional.of(limiteDiarioRepository.save(limite));
        }
        return limiteDiario;
    }

    public Optional<LimiteDiario> findById(Long id) {
        return limiteDiarioRepository.findById(id);
    }
}
