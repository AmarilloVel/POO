<?php
require_once 'Controllers/CirculoController.php';
require_once 'Controllers/RectanguloController.php';
require_once 'Controllers/TrianguloController.php';
require_once 'Controllers/TrapecioController.php';
/*Geometria del circulo*/

//creamos una variable la cual busca el parametro que le estamos señalando "circ" ||
$ec = in_array("circ",array_keys(filter_input_array(INPUT_GET)));//in array es una funcion que regresa un valor booleano si existe el dato en el


if($ec){
    
    //OBTENCION DE DATOS POR METODO POST 
    $datos = filter_input_array(INPUT_POST);//manera segura decia el profe


    $radio = $datos["r"];


    $circ = new CirculoController($radio);


    echo $circ->realizarCalculos();

   
}
//rectangulo
$er = in_array("rect",array_keys(filter_input_array(INPUT_GET)));

if($er){
    
    $datos = filter_input_array(INPUT_POST);
    $base = $datos["b"];
    $altura = $datos["a"];

    $rec = new RectanguloController($base,$altura);

    echo $rec->realizarCalculos();
}

//triangulo

$etri = in_array("tria",array_keys(filter_input_array(INPUT_GET)));
if($etri){
    $datos = filter_input_array(INPUT_POST);
    $base = $datos["b"];
    $altura = $datos["a"];
    $lado = $datos["l"];
    $lado2 = $datos["l2"];

    $tria = new TrianguloController($base,$altura,$lado,$lado2);

    echo $tria->realizarCalculos();


}

//trapecio
$etrap = in_array("trap",array_keys(filter_input_array(INPUT_GET)));
if($etrap){
    $datos = filter_input_array(INPUT_POST);
    $base = $datos["b"];
    $altura = $datos["a"];
    $lado1 = $datos["l1"];
    $base2 = $datos["b2"];
    $lado2 = $datos["l2"];


    $trap = new TrapecioController($base,$altura,$base2,$lado1,$lado2);

    echo $trap->realizarCalculos();


}



?>