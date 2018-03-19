/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.net.gvt.efika.customerAPI.model.service.manobra.facade;

import br.net.gvt.efika.customer.model.manobra.enums.ConclusaoManobraEnum;
import br.net.gvt.efika.customer.model.manobra.enums.MotivoManobraEnum;
import br.net.gvt.efika.customerAPI.model.service.manobra.analitcs.AnaliseMotivo;
import br.net.gvt.efika.customerAPI.model.service.manobra.analitcs.AnaliseMotivoGeneric;
import br.net.gvt.efika.customerAPI.model.service.manobra.analitcs.Analiser;
import br.net.gvt.efika.customerAPI.model.service.manobra.analitcs.FinalizacaoManobra;
import br.net.gvt.efika.efika_customer.model.customer.EfikaCustomer;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author G0042204
 */
public class AnalisadorManobraFacade implements AnalisadorManobra {

    private final EfikaCustomer e;

    public AnalisadorManobraFacade(EfikaCustomer e) {
        this.e = e;
    }

    @Override
    public FinalizacaoManobra analisar() {
        FinalizacaoManobra f = new FinalizacaoManobra();

        List<AnaliseMotivo> lst = this.run();
        f.setAnalises(lst);
        f.setConclusao(this.processar(lst));
        f.setManobrar(this.verificarNecessidadeManobra(f.getConclusao().getConclusao()));

        return f;
    }

    public List<AnaliseMotivo> run() {
        List<AnaliseMotivo> list = new ArrayList<>();
        for (MotivoManobraEnum v : MotivoManobraEnum.values()) {
            Analiser a = new AnaliseMotivoGeneric(e.getAsserts(), v);
            AnaliseMotivo result = a.run();
            list.add(result);
        }
        return list;
    }

    public AnaliseMotivo processar(List<AnaliseMotivo> an) {
        for (AnaliseMotivo analiseMotivo : an) {
            if (analiseMotivo.getConclusao().equals(ConclusaoManobraEnum.PORTA_NOK)) {
                return analiseMotivo;
            }
        }

        for (AnaliseMotivo analiseMotivo : an) {
            if (analiseMotivo.getConclusao().equals(ConclusaoManobraEnum.TROCAR_MODEM)) {
                return analiseMotivo;
            }
        }

        return new AnaliseMotivo(null, ConclusaoManobraEnum.PORTA_OK);
    }

    public Boolean verificarNecessidadeManobra(ConclusaoManobraEnum c) {
        return c.equals(ConclusaoManobraEnum.PORTA_NOK);
    }

}
