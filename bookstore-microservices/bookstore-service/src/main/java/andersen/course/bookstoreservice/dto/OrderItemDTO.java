package andersen.course.bookstoreservice.dto;

import lombok.Data;

@Data
public class OrderItemDTO {

    private Long id;

    private Long bookId;

    private String name;

    private Double price;

}
