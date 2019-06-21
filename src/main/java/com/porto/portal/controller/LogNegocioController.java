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

import com.porto.portal.dto.LogNegocioDTO;
import com.porto.portal.exception.LogNegocioException;
import com.porto.portal.response.Response;
import com.porto.portal.service.GerarLogService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/lognegocio")
@CrossOrigin(origins = "*")
public class LogNegocioController {

	private static final Logger LOG = LoggerFactory.getLogger(LogNegocioController.class);

	@Autowired
	private GerarLogService gerarLogService;

	@PostMapping("/salvar")
	@ApiOperation(value = "Salva os Logs de negocio")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Retorno quando o log de negocio é salvo com sucesso"),
			@ApiResponse(code = 400, message = "Erro ao criar o log de negocio")

	})
	public ResponseEntity<?> salvarLogsNegocio(@RequestBody LogNegocioDTO negocioDTO) throws NoSuchAlgorithmException {

		LOG.info("Recebendo Logs Integração: " + negocioDTO.toString());
		try {

			gerarLogService.gerarLogNegocio(negocioDTO);
		} catch (LogNegocioException e) {
			Response<LogNegocioDTO> response = new Response<LogNegocioDTO>();
			response.setErrors(Arrays.asList(e.getMessage()));
			return new ResponseEntity<Response<LogNegocioDTO>>(response, HttpStatus.BAD_REQUEST);
		}

		return ResponseEntity.ok(null);
	}
}
