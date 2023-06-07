package utils;
import ApplicationProgrammingInterface;

public class GET extends ApplicationProgrammingInterface {
    @override
    public static setupMethod(HttpURLConnection conn, String token) {
        conn.setRequestMethod("GET");
		conn.setRequestProperty("Authorization", "Bearer " + token);
    }
    @Override
    public static String progress(HttpURLConnection conn) {
        BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		String inputLine;
		StringBuilder respone = new StringBuilder(); // ising StringBuilder for the sake of memory and performance
		while ((inputLine = in.readLine()) != null)
			System.out.println(inputLine);
		respone.append(inputLine + "\n");
		in.close();
		LOGGER.info("Respone Info: " + respone.substring(0, respone.length() - 1).toString());
		return respone.substring(0, respone.length() - 1).toString();
    }
}