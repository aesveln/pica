import { pageable } from "./pageable";
import { DtoProduct } from "../Dto/Products/DtoProduct";
import { sort } from "./sort";

export class productos {
    content: Array<DtoProduct>;
    first: boolean;
    last: boolean;
    number: number;
    numberOfElements: number;
    pageable: pageable;
    size: number;
    sort: sort;
    totalElements: number;
    totalPages: number;
}