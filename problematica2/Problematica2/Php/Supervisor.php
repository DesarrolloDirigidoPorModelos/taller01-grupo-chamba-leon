<?php
/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.31.1.5860.78bb27cc6 modeling language!*/

class Supervisor
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Supervisor Attributes
  private $nombre;
  private $acto;

  //Supervisor Associations
  private $actos;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public function __construct($aNombre, $aActo)
  {
    $this->nombre = $aNombre;
    $this->acto = $aActo;
    $this->actos = array();
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

  public function setActo($aActo)
  {
    $wasSet = false;
    $this->acto = $aActo;
    $wasSet = true;
    return $wasSet;
  }

  public function getNombre()
  {
    return $this->nombre;
  }

  public function getActo()
  {
    return $this->acto;
  }

  public function getActo_index($index)
  {
    $aActo = $this->actos[$index];
    return $aActo;
  }

  public function getActos()
  {
    $newActos = $this->actos;
    return $newActos;
  }

  public function numberOfActos()
  {
    $number = count($this->actos);
    return $number;
  }

  public function hasActos()
  {
    $has = $this->numberOfActos() > 0;
    return $has;
  }

  public function indexOfActo($aActo)
  {
    $wasFound = false;
    $index = 0;
    foreach($this->actos as $acto)
    {
      if ($acto->equals($aActo))
      {
        $wasFound = true;
        break;
      }
      $index += 1;
    }
    $index = $wasFound ? $index : -1;
    return $index;
  }

  public static function minimumNumberOfActos()
  {
    return 0;
  }

  public function addActoVia($aNombre, $aLugar, $aFecha, $aCosto, $aEmpresa)
  {
    return new Acto($aNombre, $aLugar, $aFecha, $aCosto, $aEmpresa, $this);
  }

  public function addActo($aActo)
  {
    $wasAdded = false;
    if ($this->indexOfActo($aActo) !== -1) { return false; }
    $existingSupervisor = $aActo->getSupervisor();
    $isNewSupervisor = $existingSupervisor != null && $this !== $existingSupervisor;
    if ($isNewSupervisor)
    {
      $aActo->setSupervisor($this);
    }
    else
    {
      $this->actos[] = $aActo;
    }
    $wasAdded = true;
    return $wasAdded;
  }

  public function removeActo($aActo)
  {
    $wasRemoved = false;
    //Unable to remove aActo, as it must always have a supervisor
    if ($this !== $aActo->getSupervisor())
    {
      unset($this->actos[$this->indexOfActo($aActo)]);
      $this->actos = array_values($this->actos);
      $wasRemoved = true;
    }
    return $wasRemoved;
  }

  public function addActoAt($aActo, $index)
  {  
    $wasAdded = false;
    if($this->addActo($aActo))
    {
      if($index < 0 ) { $index = 0; }
      if($index > $this->numberOfActos()) { $index = $this->numberOfActos() - 1; }
      array_splice($this->actos, $this->indexOfActo($aActo), 1);
      array_splice($this->actos, $index, 0, array($aActo));
      $wasAdded = true;
    }
    return $wasAdded;
  }

  public function addOrMoveActoAt($aActo, $index)
  {
    $wasAdded = false;
    if($this->indexOfActo($aActo) !== -1)
    {
      if($index < 0 ) { $index = 0; }
      if($index > $this->numberOfActos()) { $index = $this->numberOfActos() - 1; }
      array_splice($this->actos, $this->indexOfActo($aActo), 1);
      array_splice($this->actos, $index, 0, array($aActo));
      $wasAdded = true;
    } 
    else 
    {
      $wasAdded = $this->addActoAt($aActo, $index);
    }
    return $wasAdded;
  }

  public function equals($compareTo)
  {
    return $this == $compareTo;
  }

  public function delete()
  {
    foreach ($this->actos as $aActo)
    {
      $aActo->delete();
    }
  }

}
?>