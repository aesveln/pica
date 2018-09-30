import { DtospectacleType } from "./DtospectacleType";
import { DtoLodgingType } from "./DtoLodgingType";
import { DtotransportType } from "./DtotransportType";

export class DtoProduct {
    cod: string;
    cost: number;
    description: string;
    id: number;
    imageRef: string;
    lodgingType: DtoLodgingType;
    name: string;
    productType: string;
    spectacleType: DtospectacleType;
    transportType: DtotransportType;
}