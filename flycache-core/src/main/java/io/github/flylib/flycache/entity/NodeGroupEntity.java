package io.github.flylib.flycache.entity;

import java.util.List;
import java.util.Map;

/**
 * @author liushaoming
 * @Package io.github.flylib.flycache.entity
 * @Description:
 * @date 2018-1-23 17:08
 */
public class NodeGroupEntity {
    private String id;
    private String creater;
    private String node;
    private String time;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCreater() {
        return creater;
    }

    public void setCreater(String creater) {
        this.creater = creater;
    }

    public String getNode() {
        return node;
    }

    public void setNode(String node) {
        this.node = node;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "NodeGroupEntity{" +
                "id='" + id + '\'' +
                ", creater='" + creater + '\'' +
                ", node=" + node +
                ", time='" + time + '\'' +
                '}';
    }
}
