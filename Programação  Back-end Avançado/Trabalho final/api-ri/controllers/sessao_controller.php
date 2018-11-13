<?php

class SessaoController {
	private $conn;
	public static $table_name = "sessoes";
	
	public function __construct($db){
		$this->conn = $db->conn;
	}
	
	public function create($sessao){
		if($statement = $this->conn->prepare('INSERT INTO "'.SessaoController::$table_name.'" ("id_filme", "horario", "sala", "cinema", "total_ingressos")
			VALUES (:id_filme, :horario, :sala, :cinema, :total_ingressos)')){
				$statement->bindValue(':id_filme', $sessao->id_filme);
				$statement->bindValue(':horario', $sessao->horario);
				$statement->bindValue(':sala', $sessao->sala);
				$statement->bindValue(':cinema', $sessao->cinema);
				$statement->bindValue(':total_ingressos', $sessao->total_ingressos);
				if($statement->execute()){
					$sessao->id = $this->conn->lastInsertRowID();
					return true;
				}
		} else {
			return false;
		}
	}
	
	public function find_by_filme($id_filme){
		$sessoes=array();
		if($statement = $this->conn->prepare('SELECT id, id_filme, horario, sala, cinema, total_ingressos FROM "'.SessaoController::$table_name.'" WHERE id_filme = :id_filme')) {
			$statement->bindValue(':id_filme', $id_filme);
			$result = $statement->execute();
			$i=0;
			while($arr=$result->fetchArray(SQLITE3_ASSOC)) {
				$sessoes[$i]["id"] = $arr["id"];
				$sessoes[$i]["id_filme"] = $arr["id_filme"];
				$sessoes[$i]["horario"] = $arr["horario"];
				$sessoes[$i]["sala"] = $arr["sala"];
				$sessoes[$i]["cinema"] = $arr["cinema"];
				$sessoes[$i]["total_ingressos"] = $arr["total_ingressos"];
				$i++;
			}
		}
		return $sessoes;
	}
}

?>