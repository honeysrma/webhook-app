package com.webhook.common.service;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.webhook.constants.UtilConstant;
import com.webhook.dto.APIResponseDto;

public interface UtilityService {

	ObjectMapper getObjectMapper();

	ResponseEntity<APIResponseDto> returnErrorMessages(BindingResult result);
	
	static HttpHeaders convertMapToHttpHeaders(Map<String, String> headersMap) {
		HttpHeaders headers = new HttpHeaders();

		for (Map.Entry<String, String> entry : headersMap.entrySet()) {
			String key = entry.getKey();
			String value = entry.getValue();
			headers.set(key, value);
		}

		return headers;
	}
	
	static Map<String, String> convertStringToMap(String inputString) {
        Map<String, String> resultMap = Arrays.stream(inputString.split(UtilConstant.STRING_COMMA))
                .map(entry -> entry.split(UtilConstant.STRING_SEMI_COLON))
                .collect(Collectors.toMap(
                        parts -> parts[0],
                        parts -> parts[1]
                ));
        resultMap.forEach((key, value) -> System.out.println(key + " -> " + value));
        return resultMap;
    }
	
	static List<String> convertStringToList(String inputString) {
        List<String> list = Arrays.asList(inputString.split(UtilConstant.STRING_COMMA));
        return list;
    }

	String convertDtoToJson(APIResponseDto apiResponseDto);

	List<String> getSkipAPIList();

	List<String> getAllowedCallTypes();
	
}
