package com.accenture.flowershop.be.business;

public interface BucketService {
    void insertBucket(long odrder_id, long flower_id, long amount);
}
