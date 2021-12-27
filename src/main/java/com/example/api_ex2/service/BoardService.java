package com.example.api_ex2.service;

import com.example.api_ex2.domain.entity.BoardEntity;
import com.example.api_ex2.domain.repository.BoardRepository;
import com.example.api_ex2.dto.BoardDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class BoardService {
    private BoardRepository boardRepository;

    @Transactional
    public List<BoardDto> getBoardlist(){
        List<BoardEntity> boardEntities = boardRepository.findAll();
        List<BoardDto> boardDtoList = new ArrayList<>();

        for( BoardEntity boardEntity : boardEntities) {
            BoardDto boardDTO =BoardDto.builder()
                    .no(boardEntity.getNo())
                    .title(boardEntity.getTitle())
                    .writer(boardEntity.getWriter())
                    .content(boardEntity.getContent())
                    .createdDate(boardEntity.getCreatedDate())
                    .build();

            boardDtoList.add(boardDTO);
        }
        return boardDtoList;
    }

    @Transactional
    public BoardDto getPost(Long no) {
        Optional<BoardEntity> boardEntityWrapper = boardRepository.findById(no);
        BoardEntity boardEntity = boardEntityWrapper.get();

        BoardDto boardDTO = BoardDto.builder()
                .no(boardEntity.getNo())
                .title(boardEntity.getTitle())
                .writer(boardEntity.getWriter())
                .content(boardEntity.getContent())
                .createdDate(boardEntity.getCreatedDate())
                .build();

        return boardDTO;
    }

    @Transactional
    public Long savePost(BoardDto boardDto) {
        return boardRepository.save(boardDto.toEntity()).getNo();
    }

    @Transactional
    public void deletePost(Long no) {
        boardRepository.deleteById(no);
    }

}
