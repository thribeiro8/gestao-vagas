package br.com.thomasribeiro.gestao_vagas.modules.candidate.services;

import static org.assertj.core.api.Assertions.assertThat; // para importar o assertThat()
import static org.mockito.Mockito.when;

import java.util.Optional;
import java.util.UUID;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import br.com.thomasribeiro.gestao_vagas.exceptions.JobNotFoundException;
import br.com.thomasribeiro.gestao_vagas.exceptions.UserNotFoundException;
import br.com.thomasribeiro.gestao_vagas.modules.candidate.entities.CandidateEntity;
import br.com.thomasribeiro.gestao_vagas.modules.candidate.repositories.CandidateRepository;
import br.com.thomasribeiro.gestao_vagas.modules.company.repositories.JobRepository;

@ExtendWith(MockitoExtension.class) // para poder fazer a inicialização dos objetos
public class ApplyJobCandidateServiceTest {

    @InjectMocks // injeta dados mockados (parecido com autowired só que para testes)
    private ApplyJobCandidateService applyJobCandidateService;

    @Mock // informar para classe que esse mock é uma dependência do InjectMock
    private CandidateRepository candidateRepository;

    @Mock
    private JobRepository jobRepository;

    @Test
    @DisplayName("Should not be able to apply job with candidate not found")
    public void shouldNotBeAbleToApplyJobWithCandidateNotFound() {
        try {
            this.applyJobCandidateService.execute(null, null);
        } catch (Exception e) {
            assertThat(e).isInstanceOf(UserNotFoundException.class);
        }
    }

    @Test
    @DisplayName("Should not be able to apply job with job not found")
    public void shouldNotBeAbleToApplyJobWithJobNotFound() {
        UUID idCandidate = UUID.randomUUID();

        CandidateEntity candidate = new CandidateEntity();
        candidate.setId(idCandidate);

        when(this.candidateRepository.findById(idCandidate)).thenReturn(Optional.of(candidate));

        try {
            this.applyJobCandidateService.execute(idCandidate, null);
        } catch (Exception e) {
            assertThat(e).isInstanceOf(JobNotFoundException.class);
        }

    }

}
