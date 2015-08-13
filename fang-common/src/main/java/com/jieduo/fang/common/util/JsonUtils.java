package com.jieduo.fang.common.util;

import java.io.IOException;
import java.io.StringWriter;
import java.util.Collections;
import java.util.Map;

import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.JsonParser.Feature;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializerProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @author lyh
 *
 */
public class JsonUtils {

	private static Logger LOGGER = LoggerFactory.getLogger(JsonUtils.class);
	private static final ObjectMapper mapper = new ObjectMapper();
	// private static JsonFactory jsonFactory = new JsonFactory();

	@SuppressWarnings("unchecked")
	public static Map<String, Object> jsonToMap(String json) {
		mapper.configure(Feature.ALLOW_SINGLE_QUOTES, true);
		try {
			Map<String, Object> map = mapper.readValue(json, Map.class);
			return map;
		} catch (IOException e) {
			LOGGER.error("JsonUtils jsonToMap error, json=" + json, e);
		}
		return null;
	}

	public static <T> T mapToObject(Map<String, String> map, Class<T> clazz) {
		T value = null;
		try {
			if (clazz == Map.class) {
				return clazz.cast(map);
			}
			value = mapper.readValue(mapToJson(map), clazz);
		} catch (Exception e) {
			LOGGER.error("JsonUtils mapToObject error, map=" + map, e);
		}
		return value;
	}

	public static String mapToJson(Map<String, String> map) {
		StringWriter writer = new StringWriter();
		JsonGenerator jsonGenerator = null;
		try {
			jsonGenerator = mapper.getJsonFactory().createJsonGenerator(writer);
			mapper.writeValue(jsonGenerator, map);
		} catch (IOException e) {
			LOGGER.error("JsonUtils mapToJson error, map=" + map, e);
		} finally {
			try {
				if (jsonGenerator != null) {
					jsonGenerator.close();
				}
			} catch (IOException e) {
				LOGGER.error("", e);
			}
		}
		return writer.toString();
	}

	/**
	 * Bean对象转换json字符串
	 * 
	 * @param value
	 *            对象
	 * @return JSON
	 */
	public static String objectToJson(Object value) {
		if (value instanceof String) {
			return String.valueOf(value);
		}
		
		StringWriter writer = new StringWriter();
		JsonGenerator jsonGenerator = null;
		try {
			jsonGenerator = mapper.getJsonFactory().createJsonGenerator(writer);
			mapper.writeValue(jsonGenerator, value);
		} catch (IOException e) {
			LOGGER.error("JsonUtils objectToJson error", e);
		} finally {
			try {
				if (jsonGenerator != null) {
					jsonGenerator.close();
				}
			} catch (IOException e) {
				LOGGER.error("", e);
			}
		}
		return writer.toString();
	}

	/**
	 * json字符串转换为对应Bean对象
	 * 
	 * @param json
	 * @param clazz
	 * @return
	 */
	public static <V> V jsonToObject(String json, Class<V> clazz) {
		mapper.configure(Feature.ALLOW_SINGLE_QUOTES, true);
		V value = null;
		try {
			if (clazz == String.class) {
				return clazz.cast(json);
			}
			value = mapper.readValue(json, clazz);
		} catch (Exception e) {
			LOGGER.error("JsonUtils jsonToObject error, json=" + json, e);
		}
		return value;
	}

	/*public static String toJson(Object obj) {
		String json = "";
		Writer w = new StringWriter();
		try {
			JsonGenerator jg = jsonFactory.createJsonGenerator(w);
			jg.useDefaultPrettyPrinter();
			ObjectMapper mapper = new ObjectMapper();

			SerializationConfig c = mapper.getSerializationConfig();

			// 最新忽略Null值的属性方法
			c.setSerializationInclusion(Inclusion.NON_NULL);

			mapper.setSerializationConfig(c);
			mapper.writeValue(jg, obj);
			json = w.toString();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				w.close();
				w = null;
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return json;
	}*/

	/**
	 * 返回JSON数据构造成的Map
	 * 
	 * @param jsonText
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public static Map readToMap(String jsonText) {
		ObjectMapper o = new ObjectMapper();
		Map maps = null;
		try {
			maps = o.readValue(jsonText, Map.class);
			return maps;
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return Collections.EMPTY_MAP;
	}

}

class NullSerializer extends JsonSerializer<Object> {

	public void serialize(Object value, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
		// jgen.writeString("");
	}
}
