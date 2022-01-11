package com.zerock.guestbook.repository;

import com.zerock.guestbook.entity.Guestbook;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.IntStream;

@Rollback
@SpringBootTest
public class GuestbookRepositoryTests {

    @Autowired
    private GuestbookRepository guestbookRepository;

    @Test
    @Transactional
    public void insertDummies(){

        IntStream.rangeClosed(1, 300).forEach(i -> {

            Guestbook guestbook = Guestbook.builder()
                    .title("Title..." + i)
                    .content("Content..." + i)
                    .writer("user" + (i % 10))
                    .build();

            System.out.println(guestbookRepository.save(guestbook));
        });
        List<Guestbook> guestbooks = guestbookRepository.findAll();
        System.out.println(guestbooks.size());
    }
}
