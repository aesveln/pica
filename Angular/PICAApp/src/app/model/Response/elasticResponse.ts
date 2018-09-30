import { Shards } from "./shards";
import { Hits } from "./hits";

export class ElasticResponse{
    took: number;
    timed_out: boolean;
    _shards: Shards;
    hits: Hits;
}