<?php

require_once 'FiguraController.php';

class RectanguloController extends FiguraController{

    private $base =0;
    private $altura =0;

    public function __construct($b,$a){
        $this->base = $b;
        $this->altura = $a;

    }

    public function calculaArea(){
        $this->area = $this->base * $this->altura;
    }

    public function calculaPerimetro(){
        $this->perimetro = 2 * ($this->base + $this->altura);
    }

}