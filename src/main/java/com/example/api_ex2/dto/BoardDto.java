package com.example.api_ex2.dto;

import com.example.api_ex2.domain.entity.BoardEntity;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class BoardDto {
    private Long no;
    private String writer;
    private String title;
    private String content;
    private Long hit;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;

    public BoardEntity toEntity(){
        BoardEntity boardEntity = BoardEntity.builder()
                .no(no)
                .writer(writer)
                .title(title)
                .content(content)
                .hit(hit)
                .build();
        return boardEntity;
    }

    @Builder
    public BoardDto(Long no, String title, String content, String writer, Long hit,LocalDateTime createdDate, LocalDateTime modifiedDate){
        this.no=no;
        this.writer=writer;
        this.content=content;
        this.title=title;
        this.hit=hit;
        this.createdDate=createdDate;
        this.modifiedDate=modifiedDate;
    }
}
