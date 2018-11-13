<?php

class Database {
	public $conn;
	public $table_ingressos = "ingressos";
	public $table_sessoes = "sessoes";
    public function __construct() {
		$this->conn = new SQLite3('../ri.sqlite', SQLITE3_OPEN_CREATE | SQLITE3_OPEN_READWRITE);
		$this->conn->exec('PRAGMA foreign_keys = ON;');
		$this->create_table_sessoes();
		$this->create_table_ingressos();
	}
	
	public function create_table_sessoes(){
		$this->conn->query('CREATE TABLE IF NOT EXISTS "'.$this->table_sessoes.'" (
					"id" INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
					"id_filme" INTEGER NOT NULL,
					"horario" DATETIME NOT NULL,
					"sala" VARCHAR NOT NULL,
					"cinema" VARCHAR NOT NULL,
					"total_ingressos" INTEGER NOT NULL
				)');
	}
	
	public function create_table_ingressos(){
		$this->conn->query('CREATE TABLE IF NOT EXISTS "'.$this->table_ingressos.'" (
					"id" INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
					"id_sessao" INTEGER NOT NULL CONSTRAINT "ingressos_sessaoId" REFERENCES "sessoes" ( "id" ) ON UPDATE CASCADE ON DELETE CASCADE,
					"assento" VARCHAR NOT NULL,
					"valor" NUMERIC NOT NULL
				)');
	}
	
	
}

?>