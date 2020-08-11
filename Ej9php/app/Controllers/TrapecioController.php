<?php

require_once 'FiguraController.php';

class TrapecioController extends FiguraController{

    private $base = 0;
    private $altura = 0;
    private $lado1 = 0;
    private $lado2= 0;
    private $base2=0;

    public function __construct($b, $a, $b2,$l1,$l2){

        $this->base = $b;
        $this->altura = $a;
        $this->lado1  = $l1;
        $this->base2 = $b2;
        $this->lado2 = $l2;

    }

    public function calculaPerimetro(){
        $this->perimetro = $this->base+$this->base2+$this->lado1+$this->lado2;
    }

    public function calculaArea(){
        $this->area = $this->altura * (($this->base + $this->base2)/2);
    }


}