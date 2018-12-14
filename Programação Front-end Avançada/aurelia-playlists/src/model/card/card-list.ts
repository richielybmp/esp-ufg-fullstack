import { transient } from "aurelia-framework";

import { PlaylistModel } from "../playlist";

@transient()
export class CardListModel{
    playlists: PlaylistModel;

    constructor(playlists: PlaylistModel){
        this.playlists = playlists;
    }
}