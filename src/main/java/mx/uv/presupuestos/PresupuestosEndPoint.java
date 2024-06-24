package mx.uv.presupuestos;

import java.math.BigDecimal; 

import mx.uv.p.presupuestos.PresupuestoResponse;
import mx.uv.p.presupuestos.PresupuestoRequest;
import mx.uv.p.presupuestos.AfectacionPresupuestalRequest;
import mx.uv.p.presupuestos.AfectacionPresupuestalResponse;
/*import mx.uv.p.presupuestos.AgregarpresupuestoRequest;
import mx.uv.p.presupuestos.AgregarpresupuestoResponse;
import mx.uv.p.presupuestos.QuitarpresupuestoRequest;
import mx.uv.p.presupuestos.QuitarpresupuestoResponse; */


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;


@Endpoint
public class PresupuestosEndPoint {
  //  List<Presupuesto> presupuestos = new ArrayList<>();
  //  List<Afectacion> afectacion = new ArrayList<>();

    @Autowired
    private PresupuestoService service;

    @PayloadRoot(localPart = "PresupuestoRequest", namespace = "p.uv.mx/presupuestos")
    @ResponsePayload
    public PresupuestoResponse presupuestos(@RequestPayload PresupuestoRequest peticion){
        PresupuestoResponse response = new PresupuestoResponse();

        try{
        String id = peticion.getIdDependencia();
        Presupuestos presupuesto = service.getPresupuestoById(id);
    //    Presupuestos presupuesto = service.getPresupuestoById(Integer.parseInt(peticion.getPresupuesto()));

        if (presupuesto != null) {
            response.setPresupuesto(new BigDecimal(presupuesto.getPresupuesto()));
       //     response.setMensaje("Presupuesto encontrado");
        } else {
       //     response.setMensaje("Presupuesto no encontrado para el cliente ID: " + peticion.getPresupuesto());
        }
    }catch(Exception e){
      //  response.setMensaje("Ocurrió un error: " + e.getMessage());

    }

        return response;
    }

    @PayloadRoot(localPart = "AfectacionPresupuestalRequest", namespace = "p.uv.mx/presupuestos")
    @ResponsePayload
    public AfectacionPresupuestalResponse afectacion(@RequestPayload AfectacionPresupuestalRequest peticion){
        AfectacionPresupuestalResponse response = new AfectacionPresupuestalResponse();

        try{
        String id = peticion.getIdDependencia();
        Afectacion afectacion = service.getAfectacionById(id);
    //    Presupuestos presupuesto = service.getPresupuestoById(Integer.parseInt(peticion.getPresupuesto()));

        if (afectacion != null) {
            response.setEstado(afectacion.isEstado());
      //      response.setMensaje("Presupuesto encontrado");
        } else {
        //    response.setMecnsaje("Presupuesto no encontrado para el cliente ID: " + peticion.getPresupuesto());
        }
    }catch(Exception e){
    //    response.setMensaje("Ocurrió un error: " + e.getMessage());

    }

        return response;
    }
/*
    @PayloadRoot(localPart = "AgregarpresupuestoRequest", namespace = "p.uv.mx/presupuestos")
    @ResponsePayload
    public AgregarpresupuestoResponse agregar(@RequestPayload AgregarpresupuestoResponse peticion){
        AgregarpresupuestoResponse response = new PresupuestoResponse();

        try{
        Integer id = Integer.parseInt(peticion.getPresupuesto());
        Presupuestos presupuesto = service.getPresupuestoById(id);
    //    Presupuestos presupuesto = service.getPresupuestoById(Integer.parseInt(peticion.getPresupuesto()));

        if (presupuesto != null) {
            response.setPresupuesto(presupuesto.getPresupuesto());
      //      response.setMensaje("Presupuesto encontrado");
        } else {
        //    response.setMensaje("Presupuesto no encontrado para el cliente ID: " + peticion.getPresupuesto());
        }
    }catch(Exception e){
    //    response.setMensaje("Ocurrió un error: " + e.getMessage());

    }

        return response;
    }
    
    @PayloadRoot(localPart = "QuitarpresupuestoRequest", namespace = "p.uv.mx/presupuestos")
    @ResponsePayload
    public QuitarpresupuestoResponse quitar(@RequestPayload QuitarpresupuestoResponse peticion){
        QuitarpresupuestoResponse response = new PresupuestoResponse();

        try{
        Integer id = Integer.parseInt(peticion.getPresupuesto());
        Presupuestos presupuesto = service.getPresupuestoById(id);
    //    Presupuestos presupuesto = service.getPresupuestoById(Integer.parseInt(peticion.getPresupuesto()));

        if (presupuesto != null) {
            response.setPresupuesto(presupuesto.getPresupuesto());
      //      response.setMensaje("Presupuesto encontrado");
        } else {
        //    response.setMensaje("Presupuesto no encontrado para el cliente ID: " + peticion.getPresupuesto());
        }
    }catch(Exception e){
    //    response.setMensaje("Ocurrió un error: " + e.getMessage());

    }

        return response;
    } */
}