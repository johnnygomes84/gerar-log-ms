package com.porto.portal.dto;

import lombok.Data;

@Data
public class DadosIntegracaoDTO {

	private String siglaIntegacao;
	private String metodo;
	private Boolean sucesso;
	private String dataHoraAcionamento;
	private Integer tempoResposta;

}
