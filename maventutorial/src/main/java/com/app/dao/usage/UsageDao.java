package com.app.dao.usage;

import com.app.entity.Usage;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface UsageDao {
    public List<Usage> getAllUsage();

    public Usage registerUsage(int id, String email);
}
