package br.com.e2etreinamento.backend_academia.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Repository;

import br.com.e2etreinamento.backend_academia.model.Aluno;

@Repository
public class AlunoRepository {

    // Armazenamento em memória usando o email como chave
    private final Map<String, Aluno> bancoEmMemoria = new ConcurrentHashMap<>();

    public Aluno salvar(Aluno aluno) {
        bancoEmMemoria.put(aluno.getEmail().toLowerCase(), aluno);
        return aluno;
    }

    public List<Aluno> buscarTodos() {
        return new ArrayList<>(bancoEmMemoria.values());
    }

    public Optional<Aluno> buscarPorEmail(String email) {
        if (email == null) return Optional.empty();
        return Optional.ofNullable(bancoEmMemoria.get(email.toLowerCase()));
    }

    public Optional<Aluno> buscarPorNome(String nome) {
        return bancoEmMemoria.values().stream()
                .filter(aluno -> aluno.getNome().equalsIgnoreCase(nome))
                .findFirst();
    }

    public boolean deletar(String email) {
        if (email == null) return false;
        return bancoEmMemoria.remove(email.toLowerCase()) != null;
    }
}
