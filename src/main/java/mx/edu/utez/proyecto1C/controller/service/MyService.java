package mx.edu.utez.proyecto1C.controller.service;

import mx.edu.utez.proyecto1C.controller.dto.RequestEnvioDTO;
import mx.edu.utez.proyecto1C.controller.dto.RequestHospedajeDTO;
import mx.edu.utez.proyecto1C.controller.dto.RequestRentaDTO;
import mx.edu.utez.proyecto1C.controller.exception.ReglaNegocioException;
import org.springframework.stereotype.Service;

@Service
public class MyService {

    public double cotizarEnvio(RequestEnvioDTO payload) {
        double volumen = payload.getLargo_Cm() * payload.getAncho_Cm() * payload.getAlto_Cm();

        if (volumen > 1000000) {
            throw new ReglaNegocioException("No debe de haber paquetes con volumen mayor a 1,000,000 cm^3");
        }


        double costo = 80;

        costo = costo + payload.getPeso_Kg() * 12;

        if (volumen > 50000) {
            costo = costo + 100;

        }

        if (payload.getTipo_Envio().equals("EXPRESS")) {
            costo = costo * 1.40;

        } else if (payload.getTipo_Envio().equals("MISMO_DIA")) {
            costo = costo * 1.70;

        }



        if (payload.getValor_Declarado() > 10000) {
            costo = costo + payload.getValor_Declarado() * 0.02;

        }

        return redondear(costo);
    }

    public double cotizar_Renta(RequestRentaDTO payload) {
        if (payload.getTipo_Vehiculo().equals("CAMIONETA") && payload.getEdad_Conductor() < 25) {
            throw new ReglaNegocioException("No se puede rentar una CAMIONETA si el conductor es menor de 25 años");

        }


        double costo_Diario = 0;

        switch (payload.getTipo_Vehiculo()) {
            case "COMPACTO" -> costo_Diario = 550;
            case "SEDAN" -> costo_Diario = 700;
            case "SUV" -> costo_Diario = 950;
            case "CAMIONETA" -> costo_Diario = 1200;

        }

        double costo_Renta = costo_Diario * payload.getDias_Renta();


        int km_Incluidos = payload.getDias_Renta() * 100;
        int km_Adicionales = payload.getKilometros_Estimados() - km_Incluidos;
        double cargo_Km = 0;
        if (km_Adicionales > 0) {
            cargo_Km = km_Adicionales * 4;

        }


        double cargo_Edad = 0;

        if (payload.getEdad_Conductor() >= 18 && payload.getEdad_Conductor() <= 24) {
            cargo_Edad = (costo_Renta + cargo_Km) * 0.15;

        }

        double seguro = 0;
        if (payload.isSeguro_Completo()) {
            seguro = 180 * payload.getDias_Renta();

        }

        double descuento = 0;
        if (payload.getDias_Renta() >= 7) {
            descuento = costo_Renta * 0.10;

        }

        double total = costo_Renta - descuento + cargo_Km + cargo_Edad + seguro;
        return redondear(total);
    }

    public double cotizarHospedaje(RequestHospedajeDTO payload) {

        double costo_Noche = 0;
        int capacidad = 0;

        switch (payload.getTipo_Habitacion()) {
            case "INDIVIDUAL" -> { costo_Noche = 700; capacidad = 1; }
            case "DOBLE" -> { costo_Noche = 1100; capacidad = 2; }
            case "SUITE" -> { costo_Noche = 1800; capacidad = 4; }

        }

        if (payload.getNumero_Huespedes() > capacidad) {
            throw new ReglaNegocioException("La habitación " + payload.getTipo_Habitacion()
                    + " solo permite " + capacidad + " persona(s)");

        }

        int noches = payload.getNumero_Noches();
        double costo_Hospedaje = costo_Noche * noches;
        double ajuste_Temporada = 0;

        if (payload.getTemporada().equals("BAJA")) {
            ajuste_Temporada = -(costo_Hospedaje * 0.10);
        } else if (payload.getTemporada().equals("ALTA")) {
            ajuste_Temporada = costo_Hospedaje * 0.25;
        }

        double desayuno = 0;
        if (payload.isIncluye_Desayuno()) {
            desayuno = payload.getNumero_Huespedes() * noches * 150;
        }

        double estacionamiento = 0;
        if (payload.isIncluye_Estacionamiento()) {
            estacionamiento = noches * 100;
        }

        double descuento = 0;
        if (noches >= 7) {
            descuento = (costo_Hospedaje + ajuste_Temporada) * 0.08;
        }

        double subtotal = costo_Hospedaje + ajuste_Temporada - descuento + desayuno + estacionamiento;
        double impuesto = subtotal * 0.04;
        double total = subtotal + impuesto;

        return redondear(total);
    }

    private double redondear(double valor) {
        return Math.round(valor * 100.0) / 100.0;
    }
}