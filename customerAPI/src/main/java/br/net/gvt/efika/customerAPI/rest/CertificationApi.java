package br.net.gvt.efika.customerAPI.rest;

import br.net.gvt.efika.customer.model.dto.CustomerRequest;
import br.net.gvt.efika.efika_customer.model.customer.EfikaCustomer;
import br.net.gvt.efika.customerAPI.rest.factories.CertificationApiServiceFactory;
import br.net.gvt.efika.customerAPI.model.CertificationResponse;
import javax.validation.Valid;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.*;

@Path("/certification")
public class CertificationApi {

    private final CertificationApiService delegate = CertificationApiServiceFactory.getCertificationApi();

    @POST
    @Path("/execByParam")
    @Consumes({"application/json", "application/xml"})
    @Produces({"application/json", "application/xml"})
    public Response certification(@Valid CustomerRequest body, @Context SecurityContext securityContext)
            throws NotFoundException {
        return delegate.certification(body, securityContext);
    }

    @POST
    @Path("/findByCustomer")
    @Produces({"application/json", "application/xml"})
    public Response findByCustomer(@Valid EfikaCustomer body, @Context SecurityContext securityContext)
            throws Exception {
        return delegate.findByCustomer(body, securityContext);
    }

    @GET
    @Path("/{id}")
    @Produces({"application/json", "application/xml"})
    public Response getCertificationById(@PathParam("id") String id, @Context SecurityContext securityContext)
            throws NotFoundException {
        return delegate.getCertificationById(id, securityContext);
    }

    @PUT
    @Consumes({"application/json", "application/xml"})
    @Produces({"application/json", "application/xml"})
    public Response updateCertification(CertificationResponse body, @Context SecurityContext securityContext)
            throws NotFoundException {
        return delegate.updateCertification(body, securityContext);
    }

    @POST
    @Path("/confRede")
    @Produces({"application/json", "application/xml"})
    public Response confiabilidadeRede(CustomerRequest body, SecurityContext securityContext) throws NotFoundException {
        return delegate.confiabilidadeRede(body, securityContext);
    }

    @POST
    @Path("/ontsDisp")
    @Produces({"application/json", "application/xml"})
    public Response ontsDisponiveis(CustomerRequest body, SecurityContext securityContext) throws NotFoundException {
        return delegate.ontsDisponiveis(body, securityContext);
    }

    @POST
    @Path("/setOntToOlt")
    @Produces({"application/json", "application/xml"})
    public Response setOntToOlt(CustomerRequest body, SecurityContext securityContext) throws NotFoundException {
        return delegate.setOntToOlt(body, securityContext);
    }

}
