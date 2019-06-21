package com.porto.portal.utils;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.porto.portal.exception.LogNegocioException;

@Component
public class GerarLogNegociosUtils {

	private static final Logger LOG = LoggerFactory.getLogger(GerarLogNegociosUtils.class);

	public void gerarArquivo(Object logNegocioDTO) throws LogNegocioException {
		

		ObjectMapper mapper = new ObjectMapper();

		try {
			String logJson = mapper.writeValueAsString(logNegocioDTO);
			LOG.info("Recebendo dados Log Negócio: " + "\n" + logJson);

		} catch (IOException e) {
			String mensagemErroLog = "Erro ao criar o log de negocio: ";
			LOG.error(mensagemErroLog + e.getMessage());
			throw new LogNegocioException(mensagemErroLog, e);
		}

	}

}
