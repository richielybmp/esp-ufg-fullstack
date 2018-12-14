import { Feed } from "./feed/feed";
import { PlaylistModel } from "model/playlist";
import * as $ from 'jquery' // import $ from 'jquery';

export class App {
  message: string;
  novaPlaylist: string;
  playlists: PlaylistModel[];

  constructor() {
    this.message = 'Minhas Playlists';
    this.playlists = Feed.feedCardList();
  }

  criarPlaylist() {
    console.log($('.ui.modal'));
    // $('.ui.modal').modal('show');
  }
}
