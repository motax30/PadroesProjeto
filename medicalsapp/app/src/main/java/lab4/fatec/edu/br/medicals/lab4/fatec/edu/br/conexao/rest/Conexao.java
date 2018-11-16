package lab4.fatec.edu.br.medicals.lab4.fatec.edu.br.conexao.rest;

import android.os.StrictMode;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;

import lab4.fatec.edu.br.medicals.lab4.fatec.edu.br.medicals.entities.Convenio;
import lab4.fatec.edu.br.medicals.lab4.fatec.edu.br.medicals.entities.Endereco;
import lab4.fatec.edu.br.medicals.lab4.fatec.edu.br.medicals.entities.Profissional;

public class Conexao {
    private static final String USER_AGENT = "Mozilla/5.0";

    // HTTP GET request
    public static String getJSONFromAPI(String url) throws Exception {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();

        // optional default is GET
        con.setRequestMethod("GET");

        //add request header
        con.setRequestProperty("User-Agent", USER_AGENT);

        int responseCode = con.getResponseCode();
        System.out.println("\nSending 'GET' request to URL : " + url);
        System.out.println("Response Code : " + responseCode);

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        return response.toString();
    }

    public static List<Convenio> findAllItems(String json){
        List<Convenio> conveniosEncontrados = new LinkedList<>();
        Gson gson = new GsonBuilder().create();
        Type type = new TypeToken<List<Convenio>>(){}.getType();
        List<Convenio> retornoJson = gson.fromJson(json,type);
        for (Convenio c:retornoJson) {
            Convenio c1 = new Convenio();
            c1.setNome(c.getNome());
            c1.setEspecialidades(c.getEspecialidades()!=null?c.getEspecialidades():null);
            conveniosEncontrados.add(c1);
        }
        return conveniosEncontrados;
    }
}