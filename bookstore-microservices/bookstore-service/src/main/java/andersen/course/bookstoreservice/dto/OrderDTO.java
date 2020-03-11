package andersen.course.bookstoreservice.dto;

import lombok.Data;

import java.util.List;

@Data
public class OrderDTO {

    private Long id;

    private Long userId;

    private Double totalPrice;

    private List<OrderItemDTO> books;

}
