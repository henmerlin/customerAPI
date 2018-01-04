/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.service;

import br.net.gvt.efika.customer.EfikaCustomer;
import dao.factory.FactoryDAO;
import dao.http.HttpDAO;
import io.swagger.model.GenericRequest;
import model.requests.RequestFactory;
import util.GsonUtil;

public class CustomerFinderImpl implements CustomerFinder {

    private static final HttpDAO httpDAO = FactoryDAO.createHttpDAO();

    @Override
    public EfikaCustomer getCustomer(GenericRequest req) throws Exception {
        return GsonUtil.getGson().fromJson(
                httpDAO.post(
                        Urls.CADASTRO_STEALER.getValor(),
                        RequestFactory.customerRequest(req),
                        ContentType.JSON.getValor()),
                EfikaCustomer.class);
    }

}