package com.app.services.usage;

import com.app.dao.usage.UsageDao;
import com.app.entity.Usage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class UsageServiceImple implements UsageService {
    @Autowired
    UsageDao usageDao;

    public List<Usage> getAllUsage() {
        return usageDao.getAllUsage();
    }

    public Map<String, Usage> registerUsage(int id, String email) {
        Usage usage = usageDao.registerUsage(id, email);
        Map<String, Usage> map = new HashMap<String, Usage>();
        if (usage != null) {
            map.put("Succeeded", usage);
        } else {
            map.put("Failed", usage);
        }
        return map;
    }
}
