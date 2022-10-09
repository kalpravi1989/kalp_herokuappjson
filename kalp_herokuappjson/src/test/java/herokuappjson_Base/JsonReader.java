package herokuappjson_Base;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonReader {

	private String username;
	private String password;

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public void getdata(int index) {
		JSONParser jsonParser = new JSONParser();
		FileReader reader = null;
		Object obj = null;

		try {
			reader = new FileReader("./src/test/resources/Testdata.json");
			obj = jsonParser.parse(reader);
		} catch (FileNotFoundException e1) {

			e1.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		} catch (ParseException e) {

			e.printStackTrace();
		}
		JSONArray data = (JSONArray) obj;

		JSONObject jsonobj = (JSONObject) data.get(index);

		username = (String) jsonobj.get("username");
		password = (String) jsonobj.get("password");


	}
			
		



		




}
