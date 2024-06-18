package shx.cotacaodolar.controller;

import java.io.IOException;
import java.net.MalformedURLException;
import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import shx.cotacaodolar.model.Moeda;
import shx.cotacaodolar.service.MoedaService;


@RestController
@RequestMapping(value = "/")
@CrossOrigin
public class MoedaController {

    @Autowired
    private MoedaService moedaService;

    @GetMapping("/moeda/{data1}&{data2}")
    public List<Moeda> getCotacoesPeriodo(@PathVariable("data1") String startDate, @PathVariable("data2") String endDate, @RequestParam(value = "menorAtual", required = false, defaultValue = "false") boolean menorAtual) throws IOException, MalformedURLException, ParseException{
        return moedaService.getCotacoesPeriodo(startDate, endDate, menorAtual);
    }
    
    @GetMapping("/moeda/atual")
    public Moeda getCotacaoAtual() throws IOException, MalformedURLException, ParseException{
        return moedaService.getCotacaoAtual();
    }

    @GetMapping("/moeda/anterior")
    public Moeda getCotacaoDiaAnterior() throws IOException, MalformedURLException, ParseException{
        return moedaService.getCotacaoDiaAnterior();
    }
}
