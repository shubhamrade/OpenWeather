package com.innovect.whetherforecast.demoservice.response;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;

public class BaseResponse {

	@JsonProperty("HasErrors")
	@SerializedName(value = "HasErrors")
	private boolean hasErrors;
	@JsonProperty("Errors")
	@SerializedName(value = "Errors")
	private String errors;

	public boolean isHasErrors() {
		return hasErrors;
	}

	public void setHasErrors(boolean hasErrors) {
		this.hasErrors = hasErrors;
	}

	public String getErrors() {
		return errors;
	}

	public void setErrors(String errors) {
		this.errors = errors;
	}

}
