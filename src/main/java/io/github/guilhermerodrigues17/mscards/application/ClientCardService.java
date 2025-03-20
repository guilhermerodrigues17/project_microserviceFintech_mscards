package io.github.guilhermerodrigues17.mscards.application;

import io.github.guilhermerodrigues17.mscards.domain.ClientCard;
import io.github.guilhermerodrigues17.mscards.infra.repository.ClientCardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClientCardService {

    private final ClientCardRepository repository;

    public List<ClientCard> listCardsByCpf(String cpf) {
        return repository.findByCpf(cpf);
    }
}
