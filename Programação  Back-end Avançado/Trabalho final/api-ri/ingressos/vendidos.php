<?php
header("Access-Control-Allow-Origin: *");
header("Content-Type: application/json; charset=UTF-8");
header("Access-Control-Allow-Methods: POST, GET");
header("Access-Control-Max-Age: 3600");
header("Access-Control-Allow-Headers: Content-Type, Access-Control-Allow-Headers, Authorization, X-Requested-With");

include_once '../objects/ingresso.php';
include_once '../config/database.php';
include_once '../controllers/ingresso_controller.php';

$db = new Database();
$ingresso_controller = new IngressoController($db);

if ($_SERVER['REQUEST_METHOD'] === 'POST') {
	$dados = json_decode(file_get_contents("php://input"));
	$ingressos = $ingresso_controller->create_all($dados);
	echo json_encode($ingressos);
} else if($_SERVER['REQUEST_METHOD'] === 'GET') {
	if(isset($_GET['id_filme']) && !empty($_GET['id_filme'])) {
		echo '{"total" : '.$ingresso_controller->count_by_filme($_GET["id_filme"]).'}';
	} else {
		echo '{"mensagem" : "?id_filme = x"}';
	}
}


?>