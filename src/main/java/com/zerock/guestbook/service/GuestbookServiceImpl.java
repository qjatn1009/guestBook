package com.zerock.guestbook.service;

import com.zerock.guestbook.dto.GuestbookDTO;
import com.zerock.guestbook.entity.Guestbook;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class GuestbookServiceImpl implements GuestbookService{

    @Override
    public Long register(GuestbookDTO dto) {

        log.info("DTO-----------------");
        log.info(dto.toString());

        Guestbook entity = dtoToEntity(dto);

        log.info(entity.toString());
        return null;
    }
}
