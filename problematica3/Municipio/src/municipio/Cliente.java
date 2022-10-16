/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package municipio;
import java.util.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/**
 *
 * @author lleon
 */
public class Cliente
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Cliente Attributes
  private String nombre;
  private String apellido;
  private int dni;

  //Cliente Associations
  private List<Medidor> medidors;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Cliente(String aNombre, String aApellido, int aDni)
  {
    nombre = aNombre;
    apellido = aApellido;
    dni = aDni;
    medidors = new ArrayList<Medidor>();
  }
  //------------------------
  // METODO MOSTRAR
  //------------------------
  public void mostrar(){
      System.out.println("Su nombre es: "+nombre);
      System.out.println("Su apellido es: "+apellido);
      System.out.println("Su dni es: "+dni);
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setNombre(String aNombre)
  {
    boolean wasSet = false;
    nombre = aNombre;
    wasSet = true;
    return wasSet;
  }

  public boolean setApellido(String aApellido)
  {
    boolean wasSet = false;
    apellido = aApellido;
    wasSet = true;
    return wasSet;
  }

  public boolean setDni(int aDni)
  {
    boolean wasSet = false;
    dni = aDni;
    wasSet = true;
    return wasSet;
  }

  public String getNombre()
  {
    return nombre;
  }

  public String getApellido()
  {
    return apellido;
  }

  public int getDni()
  {
    return dni;
  }
  /* Code from template association_GetMany */
  public Medidor getMedidor(int index)
  {
    Medidor aMedidor = medidors.get(index);
    return aMedidor;
  }

  public List<Medidor> getMedidors()
  {
    List<Medidor> newMedidors = Collections.unmodifiableList(medidors);
    return newMedidors;
  }

  public int numberOfMedidors()
  {
    int number = medidors.size();
    return number;
  }

  public boolean hasMedidors()
  {
    boolean has = medidors.size() > 0;
    return has;
  }

  public int indexOfMedidor(Medidor aMedidor)
  {
    int index = medidors.indexOf(aMedidor);
    return index;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfMedidors()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */
  public Medidor addMedidor(String aMarcaMedidor, String aDireccion, int aCosto)
  {
    return new Medidor(aMarcaMedidor, aDireccion, aCosto, this);
  }

  public boolean addMedidor(Medidor aMedidor)
  {
    boolean wasAdded = false;
    if (medidors.contains(aMedidor)) { return false; }
    Cliente existingCliente = aMedidor.getCliente();
    boolean isNewCliente = existingCliente != null && !this.equals(existingCliente);
    if (isNewCliente)
    {
      aMedidor.setCliente(this);
    }
    else
    {
      medidors.add(aMedidor);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeMedidor(Medidor aMedidor)
  {
    boolean wasRemoved = false;
    //Unable to remove aMedidor, as it must always have a cliente
    if (!this.equals(aMedidor.getCliente()))
    {
      medidors.remove(aMedidor);
      wasRemoved = true;
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addMedidorAt(Medidor aMedidor, int index)
  {  
    boolean wasAdded = false;
    if(addMedidor(aMedidor))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfMedidors()) { index = numberOfMedidors() - 1; }
      medidors.remove(aMedidor);
      medidors.add(index, aMedidor);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveMedidorAt(Medidor aMedidor, int index)
  {
    boolean wasAdded = false;
    if(medidors.contains(aMedidor))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfMedidors()) { index = numberOfMedidors() - 1; }
      medidors.remove(aMedidor);
      medidors.add(index, aMedidor);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addMedidorAt(aMedidor, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    for(int i=medidors.size(); i > 0; i--)
    {
      Medidor aMedidor = medidors.get(i - 1);
      aMedidor.delete();
    }
  }


  public String toString()
  {
    return super.toString() + "["+
            "nombre" + ":" + getNombre()+ "," +
            "apellido" + ":" + getApellido()+ "," +
            "dni" + ":" + getDni()+ "]";
  }
}
