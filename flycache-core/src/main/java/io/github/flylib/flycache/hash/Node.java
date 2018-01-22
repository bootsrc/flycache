package io.github.flylib.flycache.hash;

import org.apache.commons.lang3.StringUtils;

/**
 * 节点的IP实现
 */
public class Node {
    private String ip;
    private String name;
    private String port;

    public Node() {
        this.port = "6379";
    }

    public Node(String name, String ip) {
        this();
        this.name = name;
        this.ip = ip;
    }

    public Node(String ip) {
        this.ip = ip;
    }

    public Node(String ip, String name, String port) {
        this.ip = ip;
        this.name = name;
        this.port = port;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    @Override
    public String toString() {
        return ip + "-" + name + ":" + port;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        Node nodeObj = (Node) o;
        if (StringUtils.isNotEmpty(ip) && StringUtils.isNotEmpty(name) && StringUtils.isNotEmpty(port)) {
            return ip.equals(nodeObj.getIp()) && name.equals(nodeObj.getName()) && port.equals(nodeObj.getPort());
        }

        return this.toString().equals(nodeObj.toString());
    }

    @Override
    public int hashCode() {
        int result = ip != null ? ip.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (port != null ? port.hashCode() : 0);
        return result;
    }
}
