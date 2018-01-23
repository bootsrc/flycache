package io.github.flylib.flycache.hash;

import org.apache.commons.lang3.StringUtils;

/**
 * 节点的IP实现
 */
public class Node {
    private String host;
    private String port;
    private String remark;

    public Node() {
        this.port = "6379";
        this.remark = "";
    }

    public Node(String host, String port, String remark) {
        this();
        this.host = host;
        this.port = port;
        this.remark = remark;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return host + ":" + port + "_" + remark;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        Node nodeObj = (Node) o;
        if (StringUtils.isNotEmpty(host) && StringUtils.isNotEmpty(remark) && StringUtils.isNotEmpty(port)) {
            return host.equals(nodeObj.getHost()) && remark.equals(nodeObj.getRemark()) && port.equals(nodeObj.getPort());
        }

        return this.toString().equals(nodeObj.toString());
    }

    @Override
    public int hashCode() {
        int result = host != null ? host.hashCode() : 0;
        result = 31 * result + (port != null ? port.hashCode() : 0);
        result = 31 * result + (remark != null ? remark.hashCode() : 0);
        return result;
    }
}
