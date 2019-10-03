package com.app.services.usage;

import com.app.entity.Usage;

import java.util.List;
import java.util.Map;

public interface UsageService {
    public List<Usage> getAllUsage();

    public Map<String, Usage> registerUsage(int id, String email);
}
