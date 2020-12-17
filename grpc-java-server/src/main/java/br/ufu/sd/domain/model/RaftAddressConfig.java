package br.ufu.sd.domain.model;

public class RaftAddressConfig {

    private String id;

    private String host;

    private Integer port;

    public RaftAddressConfig(String id, String host, Integer port) {
        this.id = id;
        this.host = host;
        this.port = port;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }
}
