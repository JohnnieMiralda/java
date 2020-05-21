/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_hospital;

import java.io.EOFException;
import java.io.File;
import java.io.RandomAccessFile;
import java.io.IOException;
import java.util.Date;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class logica {

    int contadorDoctores = 0;
    private RandomAccessFile Docs, Usus, Citas, Pacie;
///////////log

    public logica() {
        try {

            Docs = new RandomAccessFile("Informacion/doctores.med", "rw");
            Usus = new RandomAccessFile("Informacion/usuario.med", "rw");
            Citas = new RandomAccessFile("Informacion/citas.med", "rw");
            Pacie = new RandomAccessFile("Informacion/pacientes.med", "rw");

            iniciarCodigo();

        } catch (IOException e) {
            System.out.println("Esto no deberia de estar pasando");
        }
    }

    private void iniciarCodigo() throws IOException {
        if (Usus.length() == 0) {
            Usus.writeUTF("admin");
            Usus.writeUTF("rorhospital");
            Usus.writeUTF("Administrador");
            Usus.close();
        }
    }

    public boolean LogIn(String usuario, String contra) throws IOException {
        Usus.seek(0);
        while (true) {
            try {
                String usu = Usus.readUTF();
                String cont = Usus.readUTF();
                String nom = Usus.readUTF();
                if (usu.equals(usuario) && cont.equals(contra)) {
                    return true;
                }
            } catch (EOFException e) {
                break;
            } catch (NullPointerException e) {

            } catch (IOException ex) {
                Logger.getLogger(logica.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }

//////////////// usuarios
    public boolean BuscarUsuario(String usuario, String contra) {
        try {
            Usus.seek(0);
        } catch (IOException ex) {
            Logger.getLogger(logica.class.getName()).log(Level.SEVERE, null, ex);
        }

        while (true) {
            try {
                String usu = Usus.readUTF();
                String cont = Usus.readUTF();
                String nom = Usus.readUTF();
                if (usu.equals(usuario) && cont.equals(contra)) {
                    return true;
                }
            }  catch (termino e) {
                break;
            } catch (Excepto_johnnie e) {
                e.getMessage();
            } catch (noEsLoQueTieneQueSer ex) {
                ex.getMessage();
            }catch(IOException i){
                i.getMessage();
            }
        }
        return false;
    }

    public boolean CrearUsuario(String usuar, String contra, String nombre) throws IOException {

        if (LogIn(usuar, contra) == false) {
            Usus.seek(Usus.length());
            Usus.writeUTF(usuar);
            Usus.writeUTF(contra);
            Usus.writeUTF(nombre);

            return true;
        }

        return false;
    }

    public String getInfoUu(String usuario, String contra, int elque) throws IOException {
        Usus.seek(0);
        long point1 = 0;
        long point2 = 0;
        long point3 = 0;

        while (true) {
            try {
                point1 = Usus.getFilePointer();
                String usu = Usus.readUTF();
                point2 = Usus.getFilePointer();
                String cont = Usus.readUTF();
                point3 = Usus.getFilePointer();
                String nom = Usus.readUTF();
                if (usu.equals(usuario) && cont.equals(contra)) {
                    switch (elque) {
                        case 1:
                            Usus.seek(point1);
                            return Usus.readUTF();
                        case 2:
                            Usus.seek(point2);
                            return Usus.readUTF();
                        case 3:
                            Usus.seek(point3);
                            return Usus.readUTF();
                        default:
                            break;
                    }
                }
            }  catch (termino e) {
                break;
            } catch (Excepto_johnnie e) {
                e.getMessage();
            } catch (noEsLoQueTieneQueSer ex) {
                ex.getMessage();
            }
        }

        return null;
    }

    public void EditarUsuario(String cambio, String usuario, String contra, int elque) {
        boolean cambiar = false;
        try {
            Usus.seek(0);
        } catch (IOException ex) {
            Logger.getLogger(logica.class.getName()).log(Level.SEVERE, null, ex);
        }
        long point1 = 0;
        long point2 = 0;
        long point3 = 0;

        while (true) {
            try {
                point1 = Usus.getFilePointer();
                String usu = Usus.readUTF();
                point2 = Usus.getFilePointer();
                String cont = Usus.readUTF();
                point3 = Usus.getFilePointer();
                String nom = Usus.readUTF();
                if (usu.equals(usuario) && cont.equals(contra)) {
                    cambiar = true;
                    switch (elque) {
                        case 2:
                            Usus.seek(point2);
                            Usus.writeUTF(cambio);
                            break;
                        case 3:
                            Usus.seek(point3);
                            Usus.writeUTF(cambio);
                            break;
                        case 1:
                            Usus.seek(point1);
                            Usus.writeUTF(cambio);
                            break;
                        default:
                            break;
                    }
                }

                if (cambiar == true) {
                    break;
                }
            }  catch (termino e) {
                break;
            } catch (Excepto_johnnie e) {
                e.getMessage();
            } catch (noEsLoQueTieneQueSer ex) {
                ex.getMessage();
            }catch(IOException es){
                
            }
        }

    }

    public String getUSu(int x) throws IOException, EOFException {

        while (true) {
            try {
                String usu = Usus.readUTF().toUpperCase();
                String cont = Usus.readUTF().toUpperCase();
                String nom = Usus.readUTF().toUpperCase();

                String us = "Nombre: " + nom + " Usuario: " + usu;
                String prueba = "q";
                return us;
            } catch (termino e) {
                break;
            } catch (Excepto_johnnie e) {
                e.getMessage();
            } catch (noEsLoQueTieneQueSer ex) {
                ex.getMessage();
            }
        }
        return null;
    }

    public long getUsuSize() throws IOException {
        return Usus.length();
    }

//////////////doctores
    public void CrearDoctor(int cod, String Nombre, String Email, int telefono, String especialidad, int honorario) throws IOException {
        Docs.seek(Docs.length());

        //meto el codigo
        Docs.writeInt(cod);
        //meto nombre
        Docs.writeUTF(Nombre);
        //meto email
        Docs.writeUTF(Email);
        //meto numero
        Docs.writeInt(telefono);
        //meto especialidad
        Docs.writeUTF(especialidad);
        //meto honorarios
        Docs.writeInt(honorario);
        //meto activo
        Docs.writeBoolean(true);

        /*
        int codigo= Docs.readInt();
        String nombre= Docs.readUTF();
        String email= Docs.readUTF();
        int numero= Docs.readInt();
        String especialidad= Docs.readUTF();
        int honorario= Docs.readInt();
        boolean activado= Docs.readBoolean();
         */
    }

    public boolean ActivarDesactivar(int x) {
        try {
            Docs.seek(0);
        } catch (IOException ex) {
            Logger.getLogger(logica.class.getName()).log(Level.SEVERE, null, ex);
        }
        while (true) {
            try {
                int codigo = Docs.readInt();
                long point = 0;
                boolean anterior = true;
                if (codigo == x) {
                    //cambio activado
                    String nombre = Docs.readUTF();
                    String email = Docs.readUTF();
                    int numero = Docs.readInt();
                    String especialidad = Docs.readUTF();
                    int honorario = Docs.readInt();
                    point = Docs.getFilePointer();
                    boolean activado = Docs.readBoolean();
                    anterior=activado;
                    if (anterior == true) {
                        Docs.seek(point);
                        Docs.writeBoolean(false);
                    } else if (anterior == false) {
                        Docs.seek(point);
                        Docs.writeBoolean(true);
                    }
                    return true;
                }
                String nombre = Docs.readUTF();
                String email = Docs.readUTF();
                int numero = Docs.readInt();
                String especialidad = Docs.readUTF();
                int honorario = Docs.readInt();
                boolean activado = Docs.readBoolean();
            }  catch (termino e) {
                break;
            } catch (Excepto_johnnie e) {
                e.getMessage();
            } catch (noEsLoQueTieneQueSer ex) {
                ex.getMessage();
            }catch(IOException o){
                o.getMessage();
            }
        }
        return false;
    }

    public boolean CambiarHonorario(int x, int hon) {
        try {
            Docs.seek(0);
        } catch (IOException ex) {
            Logger.getLogger(logica.class.getName()).log(Level.SEVERE, null, ex);
        }
        while (true) {
            try {
                int codigo = Docs.readInt();
                if (codigo == x) {
                    //cambio honorario
                    String nombre = Docs.readUTF();
                    String email = Docs.readUTF();
                    int numero = Docs.readInt();
                    String especialidad = Docs.readUTF();
                    Docs.writeInt(hon);
                    return true;
                }
                String nombre = Docs.readUTF();
                String email = Docs.readUTF();
                int numero = Docs.readInt();
                String especialidad = Docs.readUTF();
                int honorario = Docs.readInt();
                boolean activado = Docs.readBoolean();

            }  catch (termino e) {
                e.getMessage();
                break;
            } catch (Excepto_johnnie e) {
                e.getMessage();
            } catch (noEsLoQueTieneQueSer ex) {
                ex.getMessage();
            }catch(IOException o){
                o.getMessage();
            }
        }
        return false;
    }

    public int CodigoDoctor() throws IOException {
        Docs.seek(0);
        int contador = 1;
        while (Docs.getFilePointer() < Docs.length()) {
            Docs.readInt();
            Docs.readUTF();
            Docs.readUTF();
            Docs.readInt();
            Docs.readUTF();
            Docs.readInt();
            Docs.readBoolean();
            contador++;
        }

        /*
        Docs.seek(0);
        int cod = Docs.readInt();
        Docs.seek(0);
        Docs.writeInt(cod + 1);*/
        return contador;
    }

    public String GetDoc(int x) {
        while (true) {
            try {
                int codigo = Docs.readInt();
                String nombre = Docs.readUTF();
                String email = Docs.readUTF();
                int numero = Docs.readInt();
                String especialidad = Docs.readUTF();
                int honorario = Docs.readInt();
                boolean activado = Docs.readBoolean();
                if (activado == true) {
                    String doc = "Codigo: " + codigo + " Nombre: " + nombre.toUpperCase() + " Email: " + email.toUpperCase() + " Numero: " + numero + " Especialidad: " + especialidad.toUpperCase() + " Estado: " + activado;
                    return doc;
                }
            } catch (EOFException e) {
                break;
            } catch (NullPointerException e) {

            } catch (IOException ex) {
                Logger.getLogger(logica.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }

    public long getLenthDoc() throws IOException {
        return Docs.length();
    }

/////////////citas
    public int getcodigoCita(){
        try {
            Citas.seek(0);
        } catch (IOException ex) {
            Logger.getLogger(logica.class.getName()).log(Level.SEVERE, null, ex);
        }
        int contador=1;
        while(true){try{
            Citas.readInt();
            Citas.readInt();
            Citas.readInt();
            Citas.readUTF();
            Citas.readUTF();
            Citas.readUTF();
            Citas.readUTF();
            Citas.readInt();
            contador++;
        }  catch (EOFException e) {
                break;
            } catch (NullPointerException e) {

            } catch (IOException ex) {
                Logger.getLogger(logica.class.getName()).log(Level.SEVERE, null, ex);
            }
        }return contador;
    }
    public void CrearCita(int codcit, int coddoc, int codpacien, String fecha, String descripcion, String tipo) throws IOException {
        if(codcit==1){
        Citas.seek(0);
        Citas.writeInt(codcit);
        Citas.writeInt(coddoc);
        Citas.writeInt(codpacien);
        Citas.writeUTF(fecha);
        Citas.writeUTF(descripcion);
        Citas.writeUTF(tipo);
        Citas.writeUTF("PENDIENTE");
        Citas.writeInt(0);}
        else if(codcit!=1){
        Citas.seek(Citas.length());
        Citas.writeInt(codcit);
        Citas.writeInt(coddoc);
        Citas.writeInt(codpacien);
        Citas.writeUTF(fecha);
        Citas.writeUTF(descripcion);
        Citas.writeUTF(tipo);
        Citas.writeUTF("PENDIENTE");
        Citas.writeInt(0);}

    }
    public String GetFecha(int x){
        try {
            Citas.seek(0);
        } catch (IOException ex) {
            Logger.getLogger(logica.class.getName()).log(Level.SEVERE, null, ex);
        }
        while(true){try{
           int cod=Citas.readInt();
           int doc=Citas.readInt();
           int pac=Citas.readInt();
           String  fecha=Citas.readUTF();
           String  des=Citas.readUTF();
           String  tipo=Citas.readUTF();
           String  estado=Citas.readUTF();
           int  costo=Citas.readInt();
           
           if(cod==x){
               return fecha;
           }
        } catch (EOFException e) {
                break;
            } catch (NullPointerException e) {

            } catch (IOException ex) {
                Logger.getLogger(logica.class.getName()).log(Level.SEVERE, null, ex);
            }
        }return null;
    }
    public boolean CambiarFecha(int x, String f){
        try {
            Citas.seek(0);
        } catch (IOException ex) {
            Logger.getLogger(logica.class.getName()).log(Level.SEVERE, null, ex);
        }
        long point=0;
        while(true){try{
           int cod=Citas.readInt();
           int doc=Citas.readInt();
           int pac=Citas.readInt();
           point= Citas.getFilePointer();
           String  fecha=Citas.readUTF();
           String  des=Citas.readUTF();
           String  tipo=Citas.readUTF();
           String  estado=Citas.readUTF();
           int  costo=Citas.readInt();
           
           if(cod==x){
               Citas.seek(point);
               Citas.writeUTF(f);
               return true;
           }
        } catch (EOFException e) {
                return false;
            } catch (NullPointerException e) {

            } catch (IOException ex) {
                Logger.getLogger(logica.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void setpointercitas() throws IOException{
        Citas.seek(0);
    }
    public boolean vrificar(int x){
        try {
            Citas.seek(0);
        } catch (IOException ex) {
            Logger.getLogger(logica.class.getName()).log(Level.SEVERE, null, ex);
        }
        boolean res=false;
        while(true){try{
           int cod=Citas.readInt();
           int doc=Citas.readInt();
           int pac=Citas.readInt();
           String  fecha=Citas.readUTF();
           String  des=Citas.readUTF();
           String  tipo=Citas.readUTF();
           String  estado=Citas.readUTF();
           int  costo=Citas.readInt();
           
           if(cod==x){
               res= true;
           }
        } catch (EOFException e) {
                return res;
            } catch (NullPointerException e) {

            } catch (IOException ex) {
                Logger.getLogger(logica.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    public String getInfoCita(int x){
        try {
            Citas.seek(0);
        } catch (IOException ex) {
            Logger.getLogger(logica.class.getName()).log(Level.SEVERE, null, ex);
        }
        while(true){try{
           int cod=Citas.readInt();
           int doc=Citas.readInt();
           int pac=Citas.readInt();
           String  fecha=Citas.readUTF();
           String  des=Citas.readUTF();
           String  tipo=Citas.readUTF();
           String  estado=Citas.readUTF();
           int  costo=Citas.readInt();
           
           if(cod==x){
               String d= "Codigo de cita "+cod+" codigo de doctor: "+doc+" codigo paciente "+pac+" fecha de la cita "+fecha+" Tipo de cita"+tipo+" etado"+estado;
               return d;
           }
        } catch (EOFException e) {
                return null;
            } catch (NullPointerException e) {

            } catch (IOException ex) {
                Logger.getLogger(logica.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
//////////////pacientes
    public long GetpacieSice() throws IOException {
        return Pacie.length();
    }

    public String GEtPaciente() {

        String ver = " ";
        while (true) {
            try {
                int cod = Pacie.readInt();
                String nom = Pacie.readUTF();
                int num = Pacie.readInt();
                String email = Pacie.readUTF();
                String cumple = Pacie.readUTF();
                Pacie.readUTF();

                ver = "Nombre: " + nom + " Codigo: " + cod + " Numero de telefono: " + num + " Email: " + email + " Fecha de naciemiento: " + cumple;
                return ver;
            } catch (EOFException e) {
                break;
            } catch (NullPointerException e) {

            } catch (IOException ex) {
                Logger.getLogger(logica.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }

    public int CodigoPacinete() throws IOException {
        int contador = 1;
        Pacie.seek(0);
        while (Pacie.getFilePointer() < Pacie.length()) {
            Pacie.readInt();
            Pacie.readUTF();
            Pacie.readInt();
            Pacie.readUTF();
            Pacie.readUTF();
            Pacie.readUTF();
            contador++;
        }
        return contador;
    }

    public String verPAciente(int x) {
        try {
            Pacie.seek(0);
        } catch (IOException ex) {
            Logger.getLogger(logica.class.getName()).log(Level.SEVERE, null, ex);
        }
        String ver = " ";
        while (true) {
            try {
                int cod = Pacie.readInt();
                String nom = Pacie.readUTF();
                int num = Pacie.readInt();
                String email = Pacie.readUTF();
                String cumple = Pacie.readUTF();
                Pacie.readUTF();
                if (cod == x) {
                    ver = "Nombre: " + nom + " Codigo: " + cod + " Numero de telefono: " + num + " Email: " + email + " Fecha de naciemiento: " + cumple;
                    break;
                }
            } catch (EOFException e) {
                break;
            } catch (NullPointerException e) {

            } catch (IOException ex) {
                Logger.getLogger(logica.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return ver;
    }

    public void AgregarPaciente(int codigo, String nombre, int telefono, String email, String fecha, String historial) throws IOException {
        Pacie.seek(Pacie.length());
        Pacie.writeInt(codigo);
        Pacie.writeUTF(nombre);
        Pacie.writeInt(telefono);
        Pacie.writeUTF(email);
        Pacie.writeUTF(fecha);
        Pacie.writeUTF(historial);
    }

///////////verificaciones
    public boolean VerificarExiste(int usu, int doc) {
        try {
            Docs.seek(0);
        } catch (IOException ex) {
            Logger.getLogger(logica.class.getName()).log(Level.SEVERE, null, ex);
        }
        boolean ver = false;
        while (true) {
            try {
                int codigo = Docs.readInt();
                String nombre = Docs.readUTF();
                String emails = Docs.readUTF();
                int numero = Docs.readInt();
                String Especialidad = Docs.readUTF();
                int honorario = Docs.readInt();
                boolean activado = Docs.readBoolean();

                if (codigo == doc) {
                    ver = activado;
                }
            } catch (EOFException e) {
                break;
            } catch (NullPointerException e) {

            } catch (IOException ex) {
                Logger.getLogger(logica.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        //verificar si el paceinte existe
        return ver;

    }

    public boolean VerificarEmail(String email) {
        try {
            Docs.seek(0);
        } catch (IOException ex) {
            Logger.getLogger(logica.class.getName()).log(Level.SEVERE, null, ex);
        }
        while (true) {
            try {

                int codigo = Docs.readInt();
                String nombre = Docs.readUTF();
                String emails = Docs.readUTF();
                int numero = Docs.readInt();
                String Especialidad = Docs.readUTF();
                int honorario = Docs.readInt();
                boolean activado = Docs.readBoolean();

                if (emails.equals(email)) {
                    return true;
                }

            } catch (EOFException e) {
                break;
            } catch (NullPointerException e) {

            } catch (IOException ex) {
                Logger.getLogger(logica.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }

    public boolean VerificarUsusario(String usus) {
        try {
            Usus.seek(0);
        } catch (IOException ex) {
            Logger.getLogger(logica.class.getName()).log(Level.SEVERE, null, ex);
        }
        boolean prue = true;
        while (true) {
            try {
                String usu = Usus.readUTF();
                String cont = Usus.readUTF();
                String nom = Usus.readUTF();
                if (usu.equals(usus)) {
                    prue = false;
                    break;
                }
            } catch (EOFException e) {
                break;
            } catch (NullPointerException e) {

            } catch (IOException ex) {
                Logger.getLogger(logica.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return prue;
    }

}
