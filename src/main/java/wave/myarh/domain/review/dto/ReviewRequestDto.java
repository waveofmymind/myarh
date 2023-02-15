package wave.myarh.domain.review.dto;

import lombok.*;

@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class ReviewRequestDto {

    private int level;

    private String content;
}
