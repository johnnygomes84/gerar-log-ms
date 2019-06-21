package com.porto.portal.dto;

import lombok.Data;

@Data
public class LogIntegracaoDTO {

	private String cpf;
	private String codigoTransacao;
	private String siglaIntegacao;
	private String metodo;
	private String dataHoraChamada;
	private String tempoConexao;
	private String tempoExecucao;
	private String responseCode;
	private Boolean sucesso;
	private String request;
	private String response;
	private String tipoErro;
	private String stackTrace;
	
	
}
