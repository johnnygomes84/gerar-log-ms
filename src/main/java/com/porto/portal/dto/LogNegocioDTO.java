package com.porto.portal.dto;

import java.util.List;

import lombok.Data;

@Data
public class LogNegocioDTO {

	private String cpf;
	private String codigoTransacao;
	private String ipOrigem;
	private AcaoDTO acao;
	private Boolean sucesso;
	private String responseCode;
	private DadosPessoaDTO dadosPessoa;
	private List<Object> dadosProdutos = null;
	private List<DadosIntegracaoDTO> dadosIntegracoes = null;


}
