package it.jpmorgan.parser;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author Matteo Onnis
 * @mail matteonnis@gmail.com
 */
public class ParseJsonData {

	@SuppressWarnings("unchecked")
	public List<Map<String, Object>> ParserStockData() {
		List<Map<String, Object>> myObjects = new ArrayList<Map<String, Object>>();
		ObjectMapper mapper = new ObjectMapper(); 
		try {

			myObjects = mapper.readValue(new File("data/dataStock.json"),
					List.class);

		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return myObjects;
	}

	@SuppressWarnings("unchecked")
	public List<Map<String, Object>> ParserTradeData() {
		List<Map<String, Object>> myObjects = new ArrayList<Map<String, Object>>();
		ObjectMapper mapper = new ObjectMapper(); // can reuse, share globally
		try {

			myObjects = mapper.readValue(new File("data/dataTrade.json"),
					List.class);

		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return myObjects;

	}

}
