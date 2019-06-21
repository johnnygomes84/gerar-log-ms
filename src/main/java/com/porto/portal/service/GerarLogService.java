package com.porto.portal.service;

import com.porto.portal.dto.LogIntegracaoDTO;
import com.porto.portal.dto.LogNegocioDTO;
import com.porto.portal.exception.LogIntegracaoException;
import com.porto.portal.exception.LogNegocioException;

public interface GerarLogService {
	
	void gerarLogIntegracao(LogIntegracaoDTO logIntegracaoDTO) throws LogIntegracaoException;
	
	void gerarLogNegocio(LogNegocioDTO logNegocioDTO) throws LogNegocioException;

}
