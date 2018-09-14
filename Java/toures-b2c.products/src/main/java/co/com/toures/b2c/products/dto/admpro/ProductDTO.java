package co.com.toures.b2c.products.dto.admpro;

public class ProductDTO {

    private Integer id;
    private String cod;
    private String name;
    private String description;
    private Long cost;
    private String imageRef;
    private String productType;
    private LodgingDTO lodgingType;
    private SpectacleDTO spectacleType;
    private TransportDTO transportType;


    public ProductDTO() {
    }

    public ProductDTO(Integer id, String cod, String name, String description, Long cost, String imageRef, String productType, LodgingDTO lodgingType, SpectacleDTO spectacleType, TransportDTO transportType) {
        this.id = id;
        this.cod = cod;
        this.name = name;
        this.description = description;
        this.cost = cost;
        this.imageRef = imageRef;
        this.productType = productType;
        this.lodgingType = lodgingType;
        this.spectacleType = spectacleType;
        this.transportType = transportType;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getCost() {
        return cost;
    }

    public void setCost(Long cost) {
        this.cost = cost;
    }

    public String getImageRef() {
        return imageRef;
    }

    public void setImageRef(String imageRef) {
        this.imageRef = imageRef;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public LodgingDTO getLodgingType() {
        return lodgingType;
    }

    public void setLodgingType(LodgingDTO lodgingType) {
        this.lodgingType = lodgingType;
    }

    public SpectacleDTO getSpectacleType() {
        return spectacleType;
    }

    public void setSpectacleType(SpectacleDTO spectacleType) {
        this.spectacleType = spectacleType;
    }

    public TransportDTO getTransportType() {
        return transportType;
    }

    public void setTransportType(TransportDTO transportType) {
        this.transportType = transportType;
    }
}
