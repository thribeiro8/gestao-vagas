package br.com.thomasribeiro.gestao_vagas.modules.company.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;
import lombok.Data;

@Data
public class CreateJobDTO {

    @Schema(example = "Vaga para pessoa desenvolvedora pleno", requiredMode = RequiredMode.REQUIRED)
    private String description;
    @Schema(example = "Gympass, plano de saúde", requiredMode = RequiredMode.REQUIRED)
    private String benefits;
    @Schema(example = "Pleno", requiredMode = RequiredMode.REQUIRED)
    private String level;
}
