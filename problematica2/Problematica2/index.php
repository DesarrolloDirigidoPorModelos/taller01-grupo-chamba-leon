<?php 
    include $_SERVER['DOCUMENT_ROOT']."/ejemplo1/Php/Acto.php";
    include $_SERVER['DOCUMENT_ROOT']."/ejemplo1/Php/Supervisor.php";
    
    $objSupervisor=new Supervisor("Diego Chamba",null);
   

    $objActo=new Acto(
        "Presentación artistica",
        "San Sebastian",
        "2022-10-15",
        1.50,
        "Zona espec",
        $objSupervisor
    );
    // echo get_class($objSupervisor);
    //imprimir_vars($vegetariano);
    // print_r($objActo->getNombre());
    print_r($objActo);
?>