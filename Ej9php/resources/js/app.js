const app ={
  
    figura : document.querySelector("#figura"),
    form : document.querySelector("#form-figura"),
    resultado : document.querySelector("#resultado"),

    url : "/app/app.php",

    perparaFormulario : function(){

        var html = "";
        switch(this.figura.value){
            case "1" : html = `
                        <div class="form-group">
                            <label for="radio" >Radio</label>
                            <input type="number" class="form-control" id="radio" name="radio" step="any" placeholder="0.0">
                        </div>`; break;
            case "2" : html=`
                        <div class="form-group">
                            <label for="base" >Base</label>
                            <input type="number" class="form-control" id="base" name="base" step="any" placeholder="0.0">
                        </div>
                        <div class="form-group">
                            <label for="altura" >Altura</label>
                            <input type="number" class="form-control" id="altura" name="altura" step="any" placeholder="0.0">
                        </div>`;break;
            case "3" : html=`
                        <div class="form-group">
                            <label for="base" >Base</label>
                            <input type="number" class="form-control" id="base" name="base" step="any" placeholder="0.0">
                        </div>
                        <div class="form-group">
                            <label for="altura" >Altura</label>
                            <input type="number" class="form-control" id="altura" name="altura" step="any" placeholder="0.0">
                        </div>
                        <div class="form-group">
                            <label for="lado" > Lado</label>
                            <input type="number" class="form-control" id="lado" name="lado" step="any" placeholder="0.0">
                        </div>
                        <div class="form-group">
                            <label for="lado2" > Lado2</label>
                            <input type="number" class="form-control" id="lado2" name="lado2" step="any" placeholder="0.0">
                        </div>`;break;
            case "4" : html=`
                        <div class="form-group">
                            <label for="base" >Base</label>
                            <input type="number" class="form-control" id="base" name="base" step="any" placeholder="0.0">
                        </div>
                        <div class="form-group">
                            <label for="altura" >Altura</label>
                            <input type="number" class="form-control" id="altura" name="altura" step="any" placeholder="0.0">
                        </div>
                        <div class="form-group">
                            <label for="base2" > Base2</label>
                            <input type="number" class="form-control" id="base2" name="base2" step="any" placeholder="0.0">
                        </div>
                        <div class="form-group">
                            <label for="lado1" > Lado1</label>
                            <input type="number" class="form-control" id="lado1" name="lado1" step="any" placeholder="0.0">
                        </div>
                        <div class="form-group">
                            <label for="lado2" > Lado2</label>
                            <input type="number" class="form-control" id="lado2" name="lado2" step="any" placeholder="0.0">
                        </div>`;break;
                        

        }
        html += `<button type="submit" class="btn btn-primary">Calcular</button>`;
        this.form.innerHTML = html;

    },


    realizarCalculos : function(){

        var datos = new FormData();//objeto de js
        if(this.figura.value === "1"){

            let radio = document.querySelector("#radio").value;
            datos.append("r",radio);
            
        }
        if(this.figura.value === "2"){

            let altura = document.querySelector("#altura").value;
            let base = document.querySelector("#base").value;

            datos.append("a",altura);
            datos.append("b",base); 
        }
        if(this.figura.value === "3"){
            
            let altura  = document.querySelector("#altura").value;
            let base = document.querySelector("#base").value;
            let lado = document.querySelector("#lado").value;
            let lado2 = document.querySelector("#lado2").value;


            datos.append("a",altura);
            datos.append("b",base);
            datos.append("l",lado); 
            datos.append("l2",lado2); 
  
        }
        if(this.figura.value === "4"){
            
            let altura  = document.querySelector("#altura").value;
            let base = document.querySelector("#base").value;
            let lado = document.querySelector("#lado1").value;
            let base2 = document.querySelector("#base2").value;
            let lado2 = document.querySelector("#lado2").value;

            datos.append("a",altura);
            datos.append("b",base);
            datos.append("l1",lado); 
            datos.append("b2",base2); 
            datos.append("l2",lado2); 
        }

        let route = "";
        switch(this.figura.value){
            case "1" : route = "?circ"; break;
            case "2" : route = "?rect"; break;
            case "3" : route = "?tria"; break;
            case "4" : route = "?trap"; break;
        }

        //completamos la ruta con la seleccion del cliente mediante el fetch 
        fetch(app.url + route,{//concatenamos la ruta para que llegue como parametro/ llega como metodo GET
            method : "POST",
            body : datos
            
        }).then(response => response.json()
        ).then( resp => {
            let html = `
                    <b>Area:</b>&nbsp;<u>${resp.a}</u><br>
                    <b>Perimetro:</b>&nbsp;<u>${resp.p}</u>
            `;
            this.resultado.innerHTML = html; 
        }).catch(err => console.log("hubo un error: ",err));
        

        
     }



};

//esto es para cuando hacemos un cambio en la seleccion de la lista(figuras) ejecute lo que esta en preparaF....
window.onload = function(){
    app.figura.addEventListener("change", () => app.perparaFormulario());//callback function 

    app.form.addEventListener("submit", e => {

        e.preventDefault();//prevenimos que haga un post porque lo estamos haciendo manual
        e.stopPropagation();
        app.realizarCalculos();
    });
};