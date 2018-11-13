<?php
header("Access-Control-Allow-Origin: *");
header("Content-Type: application/json; charset=UTF-8");
header("Access-Control-Allow-Methods: POST, GET");
header("Access-Control-Max-Age: 3600");
header("Access-Control-Allow-Headers: Content-Type, Access-Control-Allow-Headers, Authorization, X-Requested-With");

include_once '../objects/sessao.php';
include_once '../config/database.php';
include_once '../controllers/sessao_controller.php';

$db = new Database();
$sessao_controler = new SessaoController($db);

if ($_SERVER['REQUEST_METHOD'] === 'POST') {
	$dado = json_decode(file_get_contents("php://input"));
	$sessao = new Sessao();
	$sessao->id_filme = $dado->id_filme;
	$sessao->horario = $dado->horario;
	$sessao->sala = $dado->sala;
	$sessao->cinema = $dado->cinema;
	$sessao->total_ingressos = $dado->total_ingressos;
	
	if($sessao_controler->create($sessao)){
		echo json_encode($sessao);
	}
} else if($_SERVER['REQUEST_METHOD'] === 'GET') {
	if(isset($_GET['filme']) && !empty($_GET['filme'])) {
		echo json_encode($sessao_controler->find_by_filme($_GET['filme']));
	} else {
		echo '{"mensagem" : "?filme = x"}';
	}
}


?>