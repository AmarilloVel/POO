<?php

require_once 'FiguraController.php';

class CirculoController extends FiguraController{

    private $radio  = 0;
    public function __construct($r){

        $this->radio = $r;

    }

    public function calculaPerimetro(){
        $this->perimetro = 2 * pi() * $this->radio;
    }

    public function calculaArea(){
        $this->area = pi() * $this->radio** 2;
    }




}