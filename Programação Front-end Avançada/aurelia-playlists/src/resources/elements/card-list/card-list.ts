import { bindable, autoinject, computedFrom } from "aurelia-framework";

import { PlaylistModel } from "../../../model/playlist";

@autoinject()
export class CardList{
    
    @bindable
    list: PlaylistModel[];

    constructor(){
    }

}