import { PLATFORM } from "aurelia-pal";
import {FrameworkConfiguration} from 'aurelia-framework';

export function configure(config: FrameworkConfiguration) {
  config.globalResources([
    PLATFORM.moduleName("./elements/card-list/card-list")
  ]);
}
