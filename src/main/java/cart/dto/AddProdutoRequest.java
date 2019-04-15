package cart.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AddProdutoRequest {
    private Long id;

    public AddProdutoRequest(Long id) {
        this.id = id;
    }

    public AddProdutoRequest() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
