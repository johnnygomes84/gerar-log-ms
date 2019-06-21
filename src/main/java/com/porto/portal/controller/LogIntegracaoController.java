package com.porto.portal.controller;

import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.porto.portal.dto.LogIntegracaoDTO;
import com.porto.portal.exception.LogIntegracaoException;
import com.porto.portal.response.Response;
import com.porto.portal.service.GerarLogService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/logintegracao")
@CrossOrigin(origins = "*")
public class LogIntegracaoController {

	private static final Logger LOG = LoggerFactory.getLogger(LogIntegracaoController.class);

	@Autowired
	private GerarLogService gerarLogService;

	@PostMapping("/salvar")
	@ApiOperation(value = "Salva os Logs de integração")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Retorno quando o log de integração é salvo com sucesso"),
			@ApiResponse(code = 400, message = "Erro ao criar o log de integracao")

	})
	public ResponseEntity<?> salvarLogsServico(@RequestBody LogIntegracaoDTO integracaoDTO) throws NoSuchAlgorithmException {

		LOG.info("Recebendo dados Log Negócio: " + integracaoDTO.toString());

		try {
			gerarLogService.gerarLogIntegracao(integracaoDTO);
		} catch (LogIntegracaoException e) {
			Response<LogIntegracaoDTO> response = new Response<LogIntegracaoDTO>();
			response.setErrors(Arrays.asList(e.getMessage()));
			return new ResponseEntity<Response<LogIntegracaoDTO>>(response, HttpStatus.BAD_REQUEST);
		}

		return ResponseEntity.ok(null);
	}

}
