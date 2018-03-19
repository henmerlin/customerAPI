package br.net.gvt.efika.customerAPI.rest;

import br.net.gvt.efika.customer.model.dto.CustomerRequest;
import br.net.gvt.efika.efika_customer.model.customer.EfikaCustomer;
import br.net.gvt.efika.customerAPI.model.CertificationResponse;
import javax.validation.Valid;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaResteasyServerCodegen", date = "2018-01-04T13:39:04.668Z")
public abstract class CertificationApiService {

    public abstract Response certification(@Valid CustomerRequest body, SecurityContext securityContext)
            throws NotFoundException;

    public abstract Response findByCustomer(@Valid EfikaCustomer body, SecurityContext securityContext)
            throws Exception;

    public abstract Response getCertificationById(String id, SecurityContext securityContext)
            throws NotFoundException;

    public abstract Response updateCertification(CertificationResponse body, SecurityContext securityContext)
            throws NotFoundException;

    public abstract Response confiabilidadeRede(CustomerRequest body, SecurityContext securityContext)
            throws NotFoundException;

    public abstract Response ontsDisponiveis(CustomerRequest body, SecurityContext securityContext)
            throws NotFoundException;

    public abstract Response setOntToOlt(CustomerRequest body, SecurityContext securityContext)
            throws NotFoundException;
}
