import { Query } from "src/app/model/Request/ElasticSearch/query";
import { NumericDictionary } from "lodash";

export class ElasticRequest {
    query: Query;
    from: number;
    size: number;
}