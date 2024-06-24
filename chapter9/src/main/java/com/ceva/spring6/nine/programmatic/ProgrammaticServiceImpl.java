package com.ceva.spring6.nine.programmatic;

import com.ceva.spring6.nine.repos.SingerRepo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.support.TransactionTemplate;

@Service
public class ProgrammaticServiceImpl implements ProgrammaticService {
    private final SingerRepo singerRepo;
    private final TransactionTemplate transactionTemplate;

    public ProgrammaticServiceImpl(SingerRepo singerRepo, TransactionTemplate transactionTemplate) {
        this.singerRepo = singerRepo;
        this.transactionTemplate = transactionTemplate;
    }

    @Override
    public Long countSingers() {
        return transactionTemplate.execute(transactionStatus -> singerRepo.countAllSingers());
        /*
         return transactionTemplate.execute(new TransactionCallback<Long>() {
            @Override
            public Long doInTransaction(TransactionStatus status) {
               return singerRepo.countAllSingers();
            }
        });
        */
    }
}
