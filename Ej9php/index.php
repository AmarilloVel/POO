<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
    <title>Ejercicio 9</title>
</head>
<body>
    <div class="container m-2 ">
        <h3 class="border-bottom" >Calculos geometricos</h3>
        <div class="input-group mb-3">
            <div class="input-group-prepend"><!lo que aparecera antes de la lista desplegable->
                <label for="figura" class="input-group-text">Figuras</label>
            </div>
            <select name="figura" id="figura" class="custom-select">
                <option selected="">--</option>
                <option value="1">Circulo</option>
                <option value="2">Rectangulo</option>
                <option value="3">Triangulo</option>
                <option value="4">Trapecio</option>
            </select>
            
            
        </div>
        
    </div>
    <div class="container m-2">
        <form action="" id="form-figura"><!lo rellenaremos mediante app.js mediante el DOM
        
        </form>
    </div>


    <div class="container mx-2 mt-4">
        <div class="alert alert-success" role="alert"> <! aqui pondremos los resultados->
            <small><b>Resultados</b></small>
            <p id="resultado">
            
            </p>
        </div>
    </div>
    <script src="/resources/js/app.js"></script>
    
</body>

</html>