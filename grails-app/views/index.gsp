<!doctype html>
<html>
    <head>
        <meta name="layout" content="main"/>
        <title>Alugue um carro</title>

        <asset:link rel="icon" href="favicon.png" type="image" />
    </head>
    <body>

        <content tag="nav">   
            <li>
                <g:link controller="carro">Carros Disponíveis</g:link> 
            </li>
            
            <li class="dropdown">       
                 <a href="#" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Cadastre-se<span class="caret"></span></a>     
                 <ul class="dropdown-menu">        
                     <g:link controller="clienteFisico">Pessoa Física</g:link> 
                     <g:link controller="clienteJuridico">Pessoa Jurídica</g:link>    
                 </ul>     
             </li>
        </content>

        <div>
            <center>
                <asset:image src="favicon.png" style="height: 300px;"/>
            </center>
        </div>
      
        <div id="content" role="main">        
            <section class="row colset-2-its">        
                <h1>Bem-Vindo ao RentCar</h1>        
                <p> Reserve já o aluguel do seu carro conosco! </p>
                <p> Com a nossa imensa variedade de carros, com certeza, você achará um para você com um ótimo preço </p>
            </section>
        </div>

    </body>
</html>
