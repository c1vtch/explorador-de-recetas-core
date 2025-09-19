package com.francisco.explorador_de_recetas.controladores;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@Controller
public class ControladorRecetas {
    private static String[] listaRecetas = {"Pizza", "Espagueti","Lasaña"};
    private static HashMap<String, String []> recetasConIngredientes = new HashMap<String, String[]>();   
    
    public ControladorRecetas() {
	String [] pizza = {"Pan", "Salsa de tomate", "Queso", "Pepperoni"};
	recetasConIngredientes.put("Pizza", pizza);
	String [] espagueti = {"Pasta", "Salsa de tomate", "Carne molida", "Queso parmesano"};
	recetasConIngredientes.put("Espagueti", espagueti);
	String [] lasaña = {"Pasta", "Salsa de tomate", "Queso", "Albahaca", "Espinaca", "Champiñones"};
	recetasConIngredientes.put("Lasaña", lasaña);

}
    @GetMapping("/recetas")
    public static String obtenerTodasLasRecetas(Model model){
        model.addAttribute("recetas", listaRecetas);
        return "recetas";
    }


    // no agregue en caso de nombre vacio ya que el core no lo pide
    @GetMapping("/recetas/{nombre}")
    public String obtenerRecetaPorNombre(@PathVariable String nombre, Model model){
        boolean recipeFound = false;
        for(Map.Entry<String, String[]> recetas : recetasConIngredientes.entrySet()){
            String nombreReceta = recetas.getKey();
            String[] ingredientes = recetas.getValue();
            if(nombreReceta.equals(nombre)){
                recipeFound = true;
                model.addAttribute("nombreReceta", nombreReceta);
                model.addAttribute("ingredientes", ingredientes);
                break;
            }
        }
        model.addAttribute("recetaEncontrada", recipeFound);
        return "detalleReceta";
    }
}
