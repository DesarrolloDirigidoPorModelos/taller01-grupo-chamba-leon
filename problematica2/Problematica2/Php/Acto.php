<?php
/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.31.1.5860.78bb27cc6 modeling language!*/

class Acto
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Acto Attributes
  private $nombre;
  private $lugar;
  private $fecha;
  private $costo;
  private $empresa;

  //Acto Associations
  private $supervisor;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public function __construct($aNombre, $aLugar, $aFecha, $aCosto, $aEmpresa, $aSupervisor)
  {
    $this->nombre = $aNombre;
    $this->lugar = $aLugar;
    $this->fecha = $aFecha;
    $this->costo = $aCosto;
    $this->empresa = $aEmpresa;
    $didAddSupervisor = $this->setSupervisor($aSupervisor);
    if (!$didAddSupervisor)
    {
      throw new Exception("Unable to create acto due to supervisor. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public function setNombre($aNombre)
  {
    $wasSet = false;
    $this->nombre = $aNombre;
    $wasSet = true;
    return $wasSet;
  }

  public function setLugar($aLugar)
  {
    $wasSet = false;
    $this->lugar = $aLugar;
    $wasSet = true;
    return $wasSet;
  }

  public function setFecha($aFecha)
  {
    $wasSet = false;
    $this->fecha = $aFecha;
    $wasSet = true;
    return $wasSet;
  }

  public function setCosto($aCosto)
  {
    $wasSet = false;
    $this->costo = $aCosto;
    $wasSet = true;
    return $wasSet;
  }

  public function setEmpresa($aEmpresa)
  {
    $wasSet = false;
    $this->empresa = $aEmpresa;
    $wasSet = true;
    return $wasSet;
  }

  public function getNombre()
  {
    return $this->nombre;
  }

  public function getLugar()
  {
    return $this->lugar;
  }

  public function getFecha()
  {
    return $this->fecha;
  }

  public function getCosto()
  {
    return $this->costo;
  }

  public function getEmpresa()
  {
    return $this->empresa;
  }

  public function getSupervisor()
  {
    return $this->supervisor;
  }

  public function setSupervisor($aSupervisor)
  {
    $wasSet = false;
    if ($aSupervisor == null)
    {
      return $wasSet;
    }
    
    $existingSupervisor = $this->supervisor;
    $this->supervisor = $aSupervisor;
    if ($existingSupervisor != null && $existingSupervisor != $aSupervisor)
    {
      $existingSupervisor->removeActo($this);
    }
    $this->supervisor->addActo($this);
    $wasSet = true;
    return $wasSet;
  }

  public function equals($compareTo)
  {
    return $this == $compareTo;
  }

  public function delete()
  {
    $placeholderSupervisor = $this->supervisor;
    $this->supervisor = null;
    $placeholderSupervisor->removeActo($this);
  }

}
?>