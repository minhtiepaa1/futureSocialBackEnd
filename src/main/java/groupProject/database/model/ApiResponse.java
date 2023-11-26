package groupProject.database.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApiResponse {
    private String message;
    private Object data;
    public ApiResponse(String message, Object data){
        this.message = message;
        this.data = data;
    }
}
