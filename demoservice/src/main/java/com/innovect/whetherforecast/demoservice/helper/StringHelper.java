package com.innovect.whetherforecast.demoservice.helper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.ResourceUtils;

import com.google.gson.Gson;
import com.innovect.whetherforecast.demoservice.response.ErrorEntity;
import com.innovect.whetherforecast.demoservice.response.Errors;

public class StringHelper {

	private static final Logger logger = LoggerFactory.getLogger(StringHelper.class);

	/**
	 * This method will check given string value is Null or Empty
	 * 
	 * @param s String value.
	 * @return boolean value
	 */
	public static boolean isNullOrEmpty(String s) {
		boolean status = false;
		if (null == s) {
			return true;
		}
		if (s.isEmpty() || s.equalsIgnoreCase("NULL")) {
			status = true;
		}

		if (s.isEmpty() || s.equalsIgnoreCase("")) {
			status = true;
		}

		return status;
	}

	public static ErrorEntity getErrorEntityFromCode(int errorId) {
		Errors errorsList = getErrorsListFromJSONFile();
		if (errorsList != null) {
			ArrayList<ErrorEntity> errors = errorsList.getErrors();
			for (ErrorEntity error : errors) {
				if (error.getErrorId() == errorId) {
					return error;
				}
			}
		}
		return null;
	}

	public static Errors getErrorsListFromJSONFile() {
		Errors errorsList = null;
		Gson gson = new Gson();

		File file;
		try {

			file = ResourceUtils.getFile("classpath:" + "errors.json");

			// String filePath = StringConstants.FilePaths.ERROR_JSON_FILE_PATH;
			// file = new File(filePath);

			// Read File Content
			String content = new String(Files.readAllBytes(file.toPath()));

			errorsList = gson.fromJson(content, Errors.class);

		} catch (IOException e) {
			logger.error("Exception!:{} ", e);
		}
		return errorsList;
	}
}
