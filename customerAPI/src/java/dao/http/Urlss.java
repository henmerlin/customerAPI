/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.http;

/**
 *
 * @author G0041775
 */
public enum Urlss {

    CADASTRO_STEALER("http://10.40.198.168:8080/stealerAPI/oss/"),
    CADASTRO_NETWORK("http://10.200.35.67:80/networkInventoryAPI/networkInventory/"),
    FULLTEST("http://10.200.35.67:80/fulltestAPI/fulltest/co"),
    CONF_REDE("http://localhost:8080/fulltestAPI/configPorta/getConfiabilidadeRede"),
    ONTS_DISP("http://localhost:8080/fulltestAPI/configPorta/unsetOntFromOlt"),
    SET_ONT("http://localhost:8080/fulltestAPI/configPorta/setOntToOlt");

    private final String valor;

    private Urlss(String url) {
        valor = url;
    }

    public String getUrl() {
        return valor;
    }

    public String getValor() {
        return valor;
    }

    public static Urlss find(String url) {
        return Urlss.valueOf(url);
    }

}
