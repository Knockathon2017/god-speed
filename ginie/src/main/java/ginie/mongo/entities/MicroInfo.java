package ginie.mongo.entities;

import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dhruvr on 5/8/16.
 */

public class MicroInfo {

//    private String id;
    private String IP;
    private String port;
    private String url;
    private List<String> tags;
    private String logPath;
    private String status;

//    public String getId() {
//        return id;
//    }
//
//    public String getIP() {
//        return IP;
//    }

    public void setIP(String IP) {
        this.IP = IP;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public String getLogPath() {
        return logPath;
    }

    public void setLogPath(String logPath) {
        this.logPath = logPath;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    @Override
    public String toString() {
        return "MicroInfo{" +
                "IP='" + IP + '\'' +
                ", port='" + port + '\'' +
                ", url='" + url + '\'' +
                ", tags=" + tags +
                ", logPath='" + logPath + '\'' +
                ", status='" + status + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        MicroInfo MicroInfo = (ginie.mongo.entities.MicroInfo) o;

        if (!IP.equals(MicroInfo.IP)) return false;
        if (!port.equals(MicroInfo.port)) return false;
        if (url != null ? !url.equals(MicroInfo.url) : MicroInfo.url != null) return false;
        if (tags != null ? !tags.equals(MicroInfo.tags) : MicroInfo.tags != null) return false;
        if (logPath != null ? !logPath.equals(MicroInfo.logPath) : MicroInfo.logPath != null) return false;
        return status != null ? status.equals(MicroInfo.status) : MicroInfo.status == null;

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + IP.hashCode();
        result = 31 * result + port.hashCode();
        result = 31 * result + (url != null ? url.hashCode() : 0);
        result = 31 * result + (tags != null ? tags.hashCode() : 0);
        result = 31 * result + (logPath != null ? logPath.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        return result;
    }

    public static MicroInfo createDocument(Document document){
        MicroInfo microInfo = new MicroInfo();
        microInfo.setLogPath(document.getString("logPath"));
        microInfo.setStatus(document.getString("status"));
        microInfo.setTags((ArrayList<String>)document.get("tags"));
        microInfo.setPort(document.getString("port"));
        microInfo.setIP(document.getString("ip"));
        microInfo.setUrl(document.getString("url"));
        return microInfo;
    }

    public Document createDocumentInsert() {
        return new Document()
                .append("IP", IP)
                .append("port", port)
                .append("url", url)
                .append("tags", tags)
                .append("logPath", logPath)
                .append("status", status);
    }
}
