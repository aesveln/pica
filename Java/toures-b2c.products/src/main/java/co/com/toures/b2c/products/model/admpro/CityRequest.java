package co.com.toures.b2c.products.model.admpro;

public class CityRequest {

    private int pageSize;
    private int pageNumber;
    private String sortBy;

    public CityRequest() {
    }

    public CityRequest(int pageSize, int pageNumber, String sortBy) {
        this.pageSize = pageSize;
        this.pageNumber = pageNumber;
        this.sortBy = sortBy;
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
