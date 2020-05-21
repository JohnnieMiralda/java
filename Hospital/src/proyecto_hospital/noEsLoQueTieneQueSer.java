/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_hospital;

import java.util.InputMismatchException;

/**
 *
 * @author johnn
 */
public class noEsLoQueTieneQueSer extends InputMismatchException{

    public noEsLoQueTieneQueSer() {
        super("variable incorrecta");
    }
    
}
