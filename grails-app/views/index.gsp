<!doctype html>
<html>
    <head>
        <meta name="layout" content="main"/>
        <title>RentCar</title>

        <asset:link rel="icon" href="favicon.png" type="image" />
    </head>
    <body>

        <content tag="nav">   
            <li class="nav-item">
                <g:link controller="reserva" action="create">Faça sua Reserva!</g:link> 
            </li>
            
            <li class="nav-item">       
                 <a href="#" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Cadastre-se<span class="caret"></span></a>     
                 <ul class="dropdown-menu">        
                     <g:link controller="clienteFisico" action="create">Pessoa Física</g:link> 
                     <g:link controller="clienteJuridico" action="create">Pessoa Jurídica</g:link>
                     <g:link controller="carro" action="create">Carro</g:link>
                     <g:link controller="funcionario" action="create">Funcionário</g:link>    
                 </ul>     
             </li>
        </content>

        <div>
            <asset:image src="favicon.png" class="rentcar-logo"/>
        </div>
      
        <div id="content" role="main">        
            <section class="row colset-2-its">        
                <h1>Bem-Vindo ao RentCar</h1>        
                <p> Reserve já o aluguel do seu carro conosco! </p>
                <p> Com a nossa imensa variedade de carros, você achará um ideal para você. </p>
            </section>
        </div>

    </body>
</html>
