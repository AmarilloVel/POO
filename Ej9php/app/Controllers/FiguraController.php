<?php

abstract class FiguraController {
    public $perimetro;
    public $area;


    public function realizarCalculos(){

        $this->calculaPerimetro();
        $this->calculaArea();

        return json_encode(['a'=>$this->area,'p' =>$this->perimetro]);

    }

    public abstract function calculaPerimetro();
    public abstract function calculaArea();
    
}