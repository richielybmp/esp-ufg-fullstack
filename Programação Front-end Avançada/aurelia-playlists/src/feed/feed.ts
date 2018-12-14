import { PlaylistModel } from "../model/playlist";

export class Feed{
    static feedCardList(){
        let playlists = [];

        playlists.push(new PlaylistModel("Dubstep", "https://i.imgur.com/BmmDmxd.png"));
        playlists.push(new PlaylistModel("Rock", "https://i.imgur.com/BmmDmxd.png"));
        playlists.push(new PlaylistModel("Sertanejo", "https://i.imgur.com/BmmDmxd.png"));
        playlists.push(new PlaylistModel("Pop", "https://i.imgur.com/BmmDmxd.png"));
        playlists.push(new PlaylistModel("Rap", "https://i.imgur.com/BmmDmxd.png"));
        playlists.push(new PlaylistModel("Funk", "https://i.imgur.com/BmmDmxd.png"));
        playlists.push(new PlaylistModel("Hip-Hop", "https://i.imgur.com/BmmDmxd.png"));
        playlists.push(new PlaylistModel("Descubra", "https://i.imgur.com/BmmDmxd.png"));
    
        return playlists;
    }
}