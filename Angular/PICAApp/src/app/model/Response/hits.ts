import { hits } from "./subHits/hits";

export class Hits{
    total:number;
    max_score:number;
    hits:Array<hits>;
}