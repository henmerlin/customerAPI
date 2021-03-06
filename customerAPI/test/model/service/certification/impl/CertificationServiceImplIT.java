/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.service.certification.impl;

import br.net.gvt.efika.model.certification.enuns.CertificationResult;
import model.entity.CustomerCertification;
import io.swagger.model.GenericRequest;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import util.JacksonMapper;

/**
 *
 * @author G0041775
 */
public class CertificationServiceImplIT {

    public CertificationServiceImplIT() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of fulltestByParam method, of class CertificationServiceImpl.
     */
    @Test
    public void testCertificationByParam() throws Exception {
        try {
            System.out.println("certificationByParam");
            GenericRequest req = new GenericRequest("1332321512", "G0041775");
            CertificationServiceImpl instance = new CertificationServiceImpl();
            CustomerCertification result = instance.certificationByParam(req);
            System.out.println("RESULTADO -> " + new JacksonMapper(CustomerCertification.class).serialize(result));
            assertTrue(result.getResultado() == CertificationResult.OK);
        } catch (Exception e) {
            e.printStackTrace();
            fail(e.getMessage());
        }

    }

}
