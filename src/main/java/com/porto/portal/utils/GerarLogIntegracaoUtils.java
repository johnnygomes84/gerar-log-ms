package com.porto.portal.utils;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.porto.portal.exception.LogIntegracaoException;

@Component
public class GerarLogIntegracaoUtils {

	private static final Logger LOG = LoggerFactory.getLogger(GerarLogIntegracaoUtils.class);

	public void gerarArquivo(Object logIntegracaoDTO) throws LogIntegracaoException {

		ObjectMapper mapper = new ObjectMapper();

		try {
			String logJson = mapper.writeValueAsString(logIntegracaoDTO);

			LOG.info("Recebendo dados Log Integração: " + "\n" + logJson);

		} catch (IOException e) {
			String mensagemErroLog = "Erro ao criar o log de integracao:";
			LOG.error(mensagemErroLog + e.getMessage());
			throw new LogIntegracaoException(mensagemErroLog, e);
		}

	}

}
