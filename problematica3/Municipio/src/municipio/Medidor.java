/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package municipio;

/**
 *
 * @author lleon
 */
public class Medidor {
  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Medidor Attributes
  private String marcaMedidor;
  private String direccion;
  private int costo;

  //Medidor Associations
  private Cliente cliente;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Medidor(String aMarcaMedidor, String aDireccion, int aCosto, Cliente aCliente)
  {
    marcaMedidor = aMarcaMedidor;
    direccion = aDireccion;
    costo = aCosto;
    boolean didAddCliente = setCliente(aCliente);
    if (!didAddCliente)
    {
      throw new RuntimeException("Unable to create medidor due to cliente. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setMarcaMedidor(String aMarcaMedidor)
  {
    boolean wasSet = false;
    marcaMedidor = aMarcaMedidor;
    wasSet = true;
    return wasSet;
  }

  public boolean setDireccion(String aDireccion)
  {
    boolean wasSet = false;
    direccion = aDireccion;
    wasSet = true;
    return wasSet;
  }

  public boolean setCosto(int aCosto)
  {
    boolean wasSet = false;
    costo = aCosto;
    wasSet = true;
    return wasSet;
  }

  public String getMarcaMedidor()
  {
    return marcaMedidor;
  }

  public String getDireccion()
  {
    return direccion;
  }

  public int getCosto()
  {
    return costo;
  }
  /* Code from template association_GetOne */
  public Cliente getCliente()
  {
    return cliente;
  }
  /* Code from template association_SetOneToMany */
  public boolean setCliente(Cliente aCliente)
  {
    boolean wasSet = false;
    if (aCliente == null)
    {
      return wasSet;
    }

    Cliente existingCliente = cliente;
    cliente = aCliente;
    if (existingCliente != null && !existingCliente.equals(aCliente))
    {
      existingCliente.removeMedidor(this);
    }
    cliente.addMedidor(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    Cliente placeholderCliente = cliente;
    this.cliente = null;
    if(placeholderCliente != null)
    {
      placeholderCliente.removeMedidor(this);
    }
  }


  public String toString()
  {
    return super.toString() + "["+
            "marcaMedidor" + ":" + getMarcaMedidor()+ "," +
            "direccion" + ":" + getDireccion()+ "," +
            "costo" + ":" + getCosto()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "cliente = "+(getCliente()!=null?Integer.toHexString(System.identityHashCode(getCliente())):"null");
  }
}
