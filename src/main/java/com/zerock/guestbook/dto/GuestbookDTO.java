package com.zerock.guestbook.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Data
@Builder
@Component
@NoArgsConstructor
@AllArgsConstructor
public class GuestbookDTO {

    private Long gno;

    @NotBlank
    @Size(min = 1)
    private String title;

    @NotBlank
    @Size(min = 1)
    private String content;

    @NotBlank
    private String writer;
    private LocalDateTime regDate, modDate;
}
