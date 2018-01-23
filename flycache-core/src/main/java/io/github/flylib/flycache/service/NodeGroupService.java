package io.github.flylib.flycache.service;

import io.github.flylib.flycache.entity.NodeGroupEntity;
import io.github.flylib.flycache.repository.NodeRepositery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author liushaoming
 * @Package io.github.flylib.flycache.service
 * @Description:
 * @date 2018-1-23 17:14
 */
@Service
public class NodeGroupService {
    @Autowired
    private NodeRepositery nodeRepositery;

    public List<NodeGroupEntity> all() {
        List<NodeGroupEntity> entityList = nodeRepositery.all();

        return entityList;
    }
}
