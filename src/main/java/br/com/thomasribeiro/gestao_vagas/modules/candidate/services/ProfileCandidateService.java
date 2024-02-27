package br.com.thomasribeiro.gestao_vagas.modules.candidate.services;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.thomasribeiro.gestao_vagas.modules.candidate.dto.ProfileCandidateResponseDTO;
import br.com.thomasribeiro.gestao_vagas.modules.candidate.repositories.CandidateRepository;

@Service
public class ProfileCandidateService {

    @Autowired
    private CandidateRepository candidateRepository;

    @SuppressWarnings("null")
    public ProfileCandidateResponseDTO execute(UUID idCandidate) {
        var candidate = this.candidateRepository.findById(idCandidate)
                .orElseThrow(() -> {
                    throw new UsernameNotFoundException("User not found");
                });

        var candidateDTO = ProfileCandidateResponseDTO.builder()
                .description(candidate.getDescription())
                .username(candidate.getUsername())
                .email(candidate.getEmail())
                .id(candidate.getId())
                .name(candidate.getName())
                .build();

        return candidateDTO;
    }

}
