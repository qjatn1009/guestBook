package com.zerock.guestbook.repository;

import com.zerock.guestbook.entity.Guestbook;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import javax.swing.text.html.Option;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

@Rollback
@SpringBootTest
public class GuestbookRepositoryTests {

    @Autowired
    private GuestbookRepository guestbookRepository;

    @Test
//    @Transactional
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

    @Test
    @Transactional
    public void updateContent(){

        Optional<Guestbook> result = guestbookRepository.findById(1200L);

        if(result.isPresent()){

            Guestbook guestbook = result.get();

            System.out.println("수정 전 : " + guestbook);

            guestbook.changeTitle("Changed Title...");
            guestbook.changeContent("Changed Content...");

            Guestbook changeGuestbook = guestbookRepository.save(guestbook);
            System.out.println("수정 후 : " + changeGuestbook);

        }
    }
}
