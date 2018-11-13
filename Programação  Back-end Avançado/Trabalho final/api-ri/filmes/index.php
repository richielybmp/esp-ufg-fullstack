<?php

include_once '../controllers/filme_controller.php';

$filme_controller = new FilmeController();

$url = "http://localhost:3000/api/filmes";
$response =  $filme_controller->getFilmes($url);

//echo json_encode($response);

?>

<!doctype html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <title>Filmes e Reviews</title>
    <style>
        body{
            background-color: rgb(252, 252, 252);
        }
        .align-button{
            position: absolute;
            right: 20px;
            top: 20px;
        }
        .card-body{
            position: relative;
        }
        .container-titulo-page{
            width: 100%;
            height: 10vh;
            display: flex;
        }
        .titulo-page{
            display: flex;
            margin: auto auto;
        }
        .line{
            width: 100%;
            height: 1.5px;
            background-color: #F56600;
        }
    </style>
</head>
<body>
<div class="container">
    <div class="container-titulo-page">
        <h2 class="titulo-page">Todos os Filmes </h2>
    </div>
    <div id="accordion">

<?php

    foreach ($response as $filmes){

    ?>

        <div class="card">
            <div class="card-header" id="headingOne">
                <h5 class="mb-0">
                    <button class="btn btn-link" data-toggle="collapse" data-target="#<?php echo $filmes->_id ?>" aria-expanded="false" aria-controls="collapseOne">
                        <?php echo $filmes->titulo ?>
                    </button>
                </h5>
            </div>

            <div id="<?php echo $filmes->_id ?>" class="collapse" aria-labelledby="headingOne" data-parent="#accordion">
                <div class="card-body">
                    <button type="button" onclick="abrirModal('<?php echo $filmes->_id ?>')" class="btn btn-primary align-button" data-toggle="modal" data-target="#exampleModal" data-whatever="@mdo">Novo Review</button>
                    <p class="card-text">Diretor: <?php echo $filmes->diretor ?></p>
                    <p class="card-text">Gênero: <?php echo $filmes->genero ?></p>
                    <p class="card-text">Ano: <?php echo $filmes->ano ?></p>
                    <h3 class="card-title">Reviews</h3>

                    <div class="container">
                    <?php
                        foreach ($filmes->reviews as $review) {
                            ?>
                            <h1 class="line"></h1>
                            <p class="font-weight-bold "><?php echo $review->usuario ?></p>
                            <div class="container">
                                <p>Comentario: <?php echo $review->comentario ?></p>
                                <p>Data: <?php echo $review->data ?></p>
                            </div>
                            <?php
                        }
                    ?>
                    </div>
                </div>
            </div>
        </div>

    <?php
    }
    ?>
    </div>
</div>


<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Novo Review</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <form method="post" action="criar_review.php">
                    <div class="form-group">
                        <label for="recipient-name" class="col-form-label">Usuario:</label>
                        <input type="text" class="form-control" name="user" id="recipient-name" required autofocus>
                    </div>
                    <div class="form-group">
                        <label for="message-text" class="col-form-label">Review:</label>
                        <textarea class="form-control" name="review" id="message-text" required></textarea>
                    </div>
                    <input type="hidden" id="id_filme" name="id">
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                        <button type="submit" class="btn btn-primary">Send message</button>
                    </div>
                </form>
            </div>

        </div>
    </div>
</div>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script></body>
<script>

    function abrirModal(id){
        $('#id_filme').val(id);
    }

</script>
</html>