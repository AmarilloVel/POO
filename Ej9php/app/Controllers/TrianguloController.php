<?php
require_once 'FiguraController.php';

class TrianguloController extends FiguraController{

    private $base = 0;
    private $altura = 0;
    private $lado = 0;
    private $lado2 = 0;
    private $lado3 = 0;

    public function __construct($b, $a, $l,$l2){

        $this->base = $b;
        $this->altura = $a;
        $this->lado  = $l;
        $this->lado2  = $l2;

    }

    public function calculaPerimetro(){
        $this->perimetro = $this->lado + $this->lado2 + $this->base;
    }

    public function calculaArea(){
        $this->area = ($this->base * $this->altura)/2;
    }


}