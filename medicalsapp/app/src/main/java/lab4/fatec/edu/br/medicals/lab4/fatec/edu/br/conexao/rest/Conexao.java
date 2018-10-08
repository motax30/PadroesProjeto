package lab4.fatec.edu.br.medicals.lab4.fatec.edu.br.conexao.rest;

import com.google.gson.Gson;
import com.google.gson.JsonArray;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
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
    public static List<Convenio> getJSONFromAPI(String url) throws Exception {

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

        //System.out.println(response.toString());

        List<Convenio> found = findAllItems(new JSONArray(response.toString()));

        return found;
    }

    public static List<Convenio> findAllItems(JSONArray response){
        List<Convenio> conveniosEncontrados = new LinkedList<>();

        try {
            for (int i = 0; i < response.length(); i++) {
                JSONObject obj = response.getJSONObject(i);
                Gson gs = new Gson();
                conveniosEncontrados.add(gs.fromJson(obj.toString(),Convenio.class));
            }

        } catch (JSONException e) {
            // handle exception
        }
        return conveniosEncontrados;
    }

//    private static final String USER_AGENT = "Mozilla/5.0";
//
//    List<Convenio> conveniosCadastrados;
//
//    //Responsavel por carregar o Objeto JSON
//    public static String getJSONFromAPI(String url){
//        String retorno = "";
//
//        try {
//            URL apiEnd = new URL(url);
//            int codigoResposta;
//            HttpURLConnection conexao;
//            InputStream is;
//
//            conexao = (HttpURLConnection) apiEnd.openConnection();
//            conexao.setRequestMethod("GET");
//            conexao.setReadTimeout(15000);
//            conexao.setConnectTimeout(15000);
//            conexao.connect();
//
//            codigoResposta = conexao.getResponseCode();
//            if(codigoResposta < HttpURLConnection.HTTP_BAD_REQUEST){
//                is = conexao.getInputStream();
//            }else{
//                is = conexao.getErrorStream();
//            }
//
//            retorno = converterInputStreamToString(is);
//            is.close();
//            conexao.disconnect();
//
//        } catch (MalformedURLException e) {
//            e.printStackTrace();
//        }catch (IOException e){
//            e.printStackTrace();
//        }
//
//        return retorno;
//    }
//
//    private static String converterInputStreamToString(InputStream is){
//        StringBuffer buffer = new StringBuffer();
//        try{
//            BufferedReader br;
//            String linha;
//
//            br = new BufferedReader(new InputStreamReader(is));
//            while((linha = br.readLine())!=null){
//                buffer.append(linha);
//            }
//
//            br.close();
//        }catch(IOException e){
//            e.printStackTrace();
//        }
//
//        return buffer.toString();
//    }
//
//    public static List<Convenio> findAllItems(JSONArray response){
//        List<Convenio> conveniosEncontrados = new LinkedList<>();
//
//        try {
//            for (int i = 0; i < response.length(); i++) {
//                JSONObject obj = response.getJSONObject(i);
//                Gson gs = new Gson();
//                conveniosEncontrados.add(gs.fromJson(obj.toString(),Convenio.class));
//            }
//
//        } catch (JSONException e) {
//            // handle exception
//        }
//        return conveniosEncontrados;
//    }
//    public static List<Convenio> sendGet()throws  Exception{
//
//        String url = "https://localhost:8081/convenios";
//        URL obj = new URL(url);
//        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
//        con.setRequestMethod("GET");
//        con.setRequestProperty("User-Agent", USER_AGENT);
////        int responseCode = con.getResponseCode();
//        System.out.println("\nSending 'GET' request to URL : " + url);
////        System.out.println("Response Code : " + responseCode);
//        BufferedReader in = new BufferedReader(
//                new InputStreamReader(con.getInputStream()));
//        String inputLine;
//        StringBuffer response = new StringBuffer();
//
//        while ((inputLine = in.readLine()) != null) {
//            response.append(inputLine);
//        }
//        in.close();
//
//        List<Convenio> found = findAllItems(new JSONArray(response.toString()));
//        return found;
//    }


}