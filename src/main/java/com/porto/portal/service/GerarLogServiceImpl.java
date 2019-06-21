package com.porto.portal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.porto.portal.dto.LogIntegracaoDTO;
import com.porto.portal.dto.LogNegocioDTO;
import com.porto.portal.exception.LogIntegracaoException;
import com.porto.portal.exception.LogNegocioException;
import com.porto.portal.utils.GerarLogIntegracaoUtils;
import com.porto.portal.utils.GerarLogNegociosUtils;

@Service
public class GerarLogServiceImpl implements GerarLogService {
	
	
	@Autowired
	private GerarLogIntegracaoUtils logIntegracaoUtil;
	
	@Autowired
	private GerarLogNegociosUtils logNegocioUtil;

	@Override
	public void gerarLogIntegracao(LogIntegracaoDTO logIntegracaoDTO) throws LogIntegracaoException {
		logIntegracaoUtil.gerarArquivo(logIntegracaoDTO);
		
	}

	@Override
	public void gerarLogNegocio(LogNegocioDTO logNegocioDTO) throws LogNegocioException {
		logNegocioUtil.gerarArquivo(logNegocioDTO);
		
	}

}
