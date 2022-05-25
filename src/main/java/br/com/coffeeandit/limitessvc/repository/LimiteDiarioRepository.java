package br.com.coffeeandit.limitessvc.repository;

import br.com.coffeeandit.limitessvc.entity.LimiteDiario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LimiteDiarioRepository extends CrudRepository<LimiteDiario, Long> {

    LimiteDiario findByAgenciaAndConta(Long agencia, Long conta);
}
