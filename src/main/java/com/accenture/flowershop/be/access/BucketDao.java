package com.accenture.flowershop.be.access;

public interface BucketDao {

    void insertBucket(long odrders_id, long flower_id, long amount);
}
