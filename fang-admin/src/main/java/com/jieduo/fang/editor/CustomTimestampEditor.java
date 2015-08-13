package com.jieduo.fang.editor;

import java.beans.PropertyEditorSupport;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang.StringUtils;

/**
 * 
 * @author lyh
 *
 */
public class CustomTimestampEditor extends PropertyEditorSupport {

	private final SimpleDateFormat dateFormat;

	public CustomTimestampEditor(SimpleDateFormat dateFormat) {
		this.dateFormat = dateFormat;
	}

	@Override
	public void setAsText(String text) {
		if (StringUtils.isEmpty(text)) {
			setValue(null);
			return;
		}

		Date date = null;
		try {
			date = this.dateFormat.parse(text);
		} catch (ParseException e) {
			throw new IllegalArgumentException("Could not parse date", e);
		}
		if (date == null) {
			setValue(null);
			return;
		}

		setValue(new Timestamp(date.getTime()));
	}

	@Override
	public String getAsText() {
		Timestamp value = (Timestamp) getValue();
		return ((value != null) ? this.dateFormat.format(value) : "");
	}
}