package co.com.toures.b2c.products.model.admpro;

public class ProductRequest {

    private String tipoProducto;
    private int pageSize;
    private int pageNumber;
    private String sortBy;

    public ProductRequest() {
    }

    public ProductRequest(String tipoProducto, int pageSize, int pageNumber, String sortBy) {
        this.tipoProducto = tipoProducto;
        this.pageSize = pageSize;
        this.pageNumber = pageNumber;
        this.sortBy = sortBy;
    }

    public String getTipoProducto() {
        return tipoProducto;
    }

    public void setTipoProducto(String tipoProducto) {
        this.tipoProducto = tipoProducto;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public String getSortBy() {
        return sortBy;
    }

    public void setSortBy(String sortBy) {
        this.sortBy = sortBy;
    }
}
