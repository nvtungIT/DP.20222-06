package utils;
import ApplicationProgrammingInterface;

public class POST extends ApplicationProgrammingInterface {
    @override
    public static setupMethod(HttpURLConnection conn, String token, String data) {
        super.allowMethods("PATCH");
        conn.setRequestMethod("PATCH");
		conn.setRequestProperty("Authorization", "Bearer " + token);
    }
    @Override
    public static String progress(HttpURLConnection conn) {
        String payload = data;
		LOGGER.info("Request Info:\nRequest URL: " + url + "\n" + "Payload Data: " + payload + "\n");

		Writer writer = new BufferedWriter(new OutputStreamWriter(conn.getOutputStream()));
		writer.write(payload);
		writer.close();
		BufferedReader in;
		String inputLine;
		if (conn.getResponseCode() / 100 == 2) {
			in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		} else {
			in = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
		}
		StringBuilder response = new StringBuilder();
		while ((inputLine = in.readLine()) != null)
			response.append(inputLine);
		in.close();
		LOGGER.info("Respone Info: " + response.toString());
		return response.toString();
    }
}