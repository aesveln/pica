import { sort } from "./sort";

export class pageable {
    offset: number;
    pageNumber: number;
    pageSize: number;
    paged: boolean;
    sort: sort;
    unpaged: boolean;
}