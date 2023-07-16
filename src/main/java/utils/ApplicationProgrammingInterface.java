package utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.logging.Logger;

// ?? Vi phạm SRP: lớp có nhiều trách nhiệm riêng biệt, nên tách DateFormatter, LOGGER ra riêng
// SRP: > 1 lý do để thay đổi: Xác thực qua cái khác không phải token (session) => thay đổi get
// Nếu muốn đổi dữ liệu trả về => JSON => phải thay đổi
// OCP: Nếu có thêm cả put, delete mở rộng trong tương lai => sủa trực tiếp => OCP
public class ApplicationProgrammingInterface {

	public static DateFormat DATE_FORMATTER = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	private static Logger LOGGER = Utils.getLogger(Utils.class.getName());

	public static String get(String url, String token) throws Exception {
		LOGGER.info("Request URL: " + url + "\n");
		HttpURLConnection connection = setupConnection(url);

		connection.setRequestMethod("GET");
		connection.setRequestProperty("Authorization", "Bearer " + token);
		BufferedReader input = new BufferedReader(new InputStreamReader(connection.getInputStream()));
		String inputLine;
		StringBuilder response = new StringBuilder(); // ising StringBuilder for the sake of memory and performance
		while ((inputLine = input.readLine()) != null)
			System.out.println(inputLine);
		response.append(inputLine + "\n");
		in.close();
		LOGGER.info("Response Info: " + response.substring(0, response.length() - 1).toString());
		return response.substring(0, response.length() - 1).toString();
	}

	public static String post(String url, String data) throws IOException {
		allowMethods("PATCH");
		HttpURLConnection connection = setupConnection(url);
		connection.setRequestMethod("PATCH");
		String payload = data;
		LOGGER.info("Request Info:\nRequest URL: " + url + "\n" + "Payload Data: " + payload + "\n");

		Writer writer = new BufferedWriter(new OutputStreamWriter(connection.getOutputStream()));
		writer.write(payload);
		writer.close();
		BufferedReader input;
		String inputLine;
		if (conn.getResponseCode() / 100 == 2) {
			input = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		} else {
			input = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
		}
		StringBuilder response = new StringBuilder();
		while ((inputLine = input.readLine()) != null)
			response.append(inputLine);
		input.close();
		LOGGER.info("Respone Info: " + response.toString());
		return response.toString();
	}

	private static HttpURLConnection setupConnection(String url) throws IOException {
		HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
		connection.setDoInput(true);
		connection.setDoOutput(true);
		connection.setRequestProperty("Content-Type", "application/json");
		return connection;
	}

	private static void allowMethods(String... methods) {
		try {
			Field methodsField = HttpURLConnection.class.getDeclaredField("methods");
			methodsField.setAccessible(true);

			Field modifiersField = Field.class.getDeclaredField("modifiers");
			modifiersField.setAccessible(true);
			modifiersField.setInt(methodsField, methodsField.getModifiers() & ~Modifier.FINAL);

			String[] oldMethods = (String[]) methodsField.get(null);
			Set<String> methodsSet = new LinkedHashSet<>(Arrays.asList(oldMethods));
			methodsSet.addAll(Arrays.asList(methods));
			String[] newMethods = methodsSet.toArray(new String[0]);

			methodsField.set(null/* static field */, newMethods);
		} catch (NoSuchFieldException | IllegalAccessException e) {
			throw new IllegalStateException(e);
		}
	}
}
