import { transient } from "aurelia-framework";

@transient()
export class PlaylistModel{
    nome: string;
    coverImage: string;
    musicas: any[];
    seguidores: number;

    constructor(nome, coverImage){
        this.nome = nome;
        this.coverImage = coverImage;
        this.musicas = [];
        this.seguidores = 0;
    }
}