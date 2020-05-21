/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_hospital;

import java.io.EOFException;

/**
 *
 * @author johnn
 */
public class termino extends EOFException{
    public termino(){
        super("se termino el file");
    }
}
