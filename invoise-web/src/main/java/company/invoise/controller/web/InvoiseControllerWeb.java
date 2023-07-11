package company.invoise.controller.web;

import company.invoise.core.controller.InvoiseControllerInterface;
import company.invoise.core.entity.Invoise;
import company.invoise.core.service.InvoiseServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

//@Component : permet d'indiquer que c'est un component
@Controller
public class InvoiseControllerWeb implements InvoiseControllerInterface {

    @Autowired
    private InvoiseServiceInterface invoiseService;
    public void createInvoise(){
        System.out.println( " this is the web interface " );

        String customerName = "Tesla";
        Invoise invoise = new Invoise();
        invoise.setCustomerName(customerName);


        invoiseService.createInvoise(invoise);
    }

    public InvoiseServiceInterface getInvoiseService() {
        return invoiseService;
    }

    public void setInvoiseService(InvoiseServiceInterface invoiseService) {
        this.invoiseService = invoiseService;
    }

    @RequestMapping("/invoise-home")
    public @ModelAttribute("invoises") List<Invoise> displayInvoise(){
        System.out.println(" Afficher la liste des facturations existants ");

        List<Invoise> invoises = invoiseService.listInvoise();

        return invoises;
    }
}
