package mx.edu.utez.proyecto1C.controller;

import mx.edu.utez.proyecto1C.controller.dto.RequestBodyDTO;
import org.springframework.web.bind.annotation.*;

@RestController  //Si devolvemosun objeto lo devuelve en formato json
@CrossOrigin({"*"})  //Todos los origenes
@RequestMapping("my-services")
public class MyController {

    @GetMapping
    public String miPrimerService(){
        return "Hello world el pepe";
    }

    @GetMapping("/servicio2")
    public String servicio2(){

        return "Segundo servicio";
    }

    @PostMapping
    public String servicio3(){
        return "Este es el servicio3";
    }

    ///
    @GetMapping("/path/{id}")
    public String pathvariable(@PathVariable String id) {

        return "el path variable es: "+ id;
    }

    @PostMapping("/body")
    public String body(@RequestBody RequestBodyDTO payload){

        System.out.println(payload.getEdad());
        System.out.println(payload.getNombre());

        return "cadena";


    }


    //Tarea 3 2 servicios



//servicio fizzBuzz
    @GetMapping("/servicioFizzBuzz/{n}")
    public String servicioFizzBuzz(@PathVariable int n){
        for (int i = 1; i <= n; i++) {

            if (i % 3 == 0 && i % 5 == 0) {

                System.out.println("Fizz Buzz");

            }
            else if (i % 3 == 0) {

                System.out.println("Fizz");


            }

            else if (i % 5 == 0) {

                System.out.println("Buzz");

            }
            else {



                System.out.println(i);

            }
        }
        return "Chavez Garcia Miguel ";
    }





    //Servicio fibonacci

    @GetMapping("/servicioFibonacci/{n}")
    public String servicioFibonacci(@PathVariable int n) {


        int ultnum = 1;
        int primnum = 0;



        System.out.print(primnum + " " +ultnum);

        for (int i = 2; i <= n-1; i++) {


            int signum = primnum+ultnum;
            primnum = ultnum;

            ultnum = signum;

            System.out.print( " " +ultnum);
        }



        return "Chavez Garcia Miguel ";
    }



}





