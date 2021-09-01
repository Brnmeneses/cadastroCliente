/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.projetoposjava.client;

import br.projetoposjava.entity.Cidade;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author brnme
 */
public class RestClienteClient {
    
    private List<Cidade> cidades;
    private ObjectMapper mapper = new ObjectMapper();
    private WebTarget webTarget;
    private Client client;
    private static final String BASE_URI = "http://maventest.herokuapp.com/mavenTest-1.0-SNAPSHOT/webresources/";

    public RestClienteClient() {
        client = javax.ws.rs.client.ClientBuilder.newClient();
        webTarget = client.target(BASE_URI).path("cidade");
    }
    
    public List<Cidade> getAll() {
        cidades = new ArrayList<>();
        Invocation.Builder builder = webTarget.request(MediaType.APPLICATION_JSON);
        
        try {
            cidades = mapper.readValue(builder.get(String.class), new TypeReference<List<Cidade>>(){});
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return cidades;
    }
}
