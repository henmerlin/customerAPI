/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.service.finder;

import dao.http.Urls;
import dao.http.ContentType;
import br.net.gvt.efika.customer.EfikaCustomer;
import dao.factory.FactoryDAO;
import dao.http.HttpDAO;
import dao.request.CustomerRequest;
import io.swagger.model.GenericRequest;
import dao.request.RequestFactory;
import java.nio.charset.Charset;
import util.JacksonMapper;

public class CustomerFinderImpl implements CustomerFinder {


    @Override
    public EfikaCustomer getCustomer(GenericRequest req) throws Exception {
        JacksonMapper<EfikaCustomer> mapper = new JacksonMapper(EfikaCustomer.class);
        return mapper.deserialize(FactoryDAO.createHttpDAO().post(
                Urls.CADASTRO_STEALER.getUrl(),
                RequestFactory.customerRequest(req),
                ContentType.JSON.getValor(), Charset.forName("UTF-8")));
    }

}