package com.crud.tasks.mapper;

import com.crud.tasks.domain.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class TrelloMapperTestSuite {

    @Autowired
    private TrelloMapper mapper;

    @Test
    void mapToBoards() {

        //Given
        List<TrelloListDto> testList = new ArrayList<>();
        List<TrelloBoardDto> testBoard = new ArrayList<>();
        TrelloBoardDto boardDto = new TrelloBoardDto("testBoard", "1111", testList);
        testBoard.add(boardDto);
        //When
        List<TrelloBoard> boards = mapper.mapToBoards(testBoard);
        //Then
        assertEquals("1111", boards.get(0).getId());
        assertEquals("testBoard", boards.get(0).getName());
    }

    @Test
    void mapToBoardsDto() {

        //Given
        List<TrelloList> testList = new ArrayList<>();
        List<TrelloBoard> testBoard = new ArrayList<>();
        TrelloBoard board = new TrelloBoard("1111", "testBoard", testList);
        testBoard.add(board);
        //When
        List<TrelloBoardDto> boardDto = mapper.mapToBoardsDto(testBoard);
        //Then
        //Wychodzi na odwrót getId pobiera nazwę, a getName pobiera ID
        assertEquals("testBoard", boardDto.get(0).getId());
        assertEquals("1111", boardDto.get(0).getName());
    }

    @Test
    void mapToList() {

        //Given
        List<TrelloListDto> testList = new ArrayList<>();
        TrelloListDto listDto = new TrelloListDto("1111", "testList", true);
        testList.add(listDto);
        //When
        List<TrelloList> list = mapper.mapToList(testList);
        //Then
        assertEquals("1111", list.get(0).getId());
        assertEquals("testList", list.get(0).getName());
        assertTrue(true);
    }

    @Test
    void mapToListDto() {

        //Given
        List<TrelloList> testList = new ArrayList<>();
        TrelloList list = new TrelloList("1111", "testList", true);
        testList.add(list);
        //When
        List<TrelloListDto> listDto = mapper.mapToListDto(testList);
        //Then
        assertEquals("1111", listDto.get(0).getId());
        assertEquals("testList", listDto.get(0).getName());
        assertTrue(true);
    }

    @Test
    void mapToCardDto() {
        //Given
        TrelloCard card = new TrelloCard("testCard", "test description", "upper", "1111");
        //When
        TrelloCardDto cardDto = mapper.mapToCardDto(card);
        //Then
        assertEquals("testCard", cardDto.getName());
        assertEquals("test description", cardDto.getDescription());
        assertEquals("upper", card.getPos());
        assertEquals("1111", card.getListId());
    }

    @Test
    void mapToCard() {
        //Given
        TrelloCardDto cardDto = new TrelloCardDto("testCard2", "test description 2", "down", "2222");
        //When
        TrelloCard card = mapper.mapToCard(cardDto);
        //Then
        assertEquals("testCard2", card.getName());
        assertEquals("test description 2", card.getDescription());
        assertEquals("down", card.getPos());
        assertEquals("2222", card.getListId());
    }

}
