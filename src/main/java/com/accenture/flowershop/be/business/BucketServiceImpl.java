package com.accenture.flowershop.be.business;

import com.accenture.flowershop.be.access.BucketDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BucketServiceImpl implements BucketService {
    @Autowired
    private BucketDao bucketDao;

    @Override
    @Transactional
    public void insertBucket(long odrders_id, long flower_id, long amount) {
        bucketDao.insertBucket(odrders_id,flower_id,amount);

    }
}
