<?php

if(isset($_POST['user'])){
    include_once '../controllers/filme_controller.php';
    $dados = [
        'form_params' => [
            'user' => $_POST['user'],
            'review' => $_POST['review']
        ]
    ];

    $id_filme = $_POST['id'];
    $filme_controller = new FilmeController();

    $url = 'http://localhost:3000/api/filmes/novoReview/'.$id_filme;
    $response =  $filme_controller->filmeReview($url, $dados);
    header("Location: ./index.php");

}else{
    header("Location: ./index.php");
}


?>