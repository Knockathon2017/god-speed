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
    private String url;
    private List<String> tags;
    private String logPath;
    private String status;
    private String methodUrl;
    private String serviceName;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MicroInfo microInfo = (MicroInfo) o;

        if (IP != null ? !IP.equals(microInfo.IP) : microInfo.IP != null) return false;
        if (!url.equals(microInfo.url)) return false;
        if (!tags.equals(microInfo.tags)) return false;
        if (logPath != null ? !logPath.equals(microInfo.logPath) : microInfo.logPath != null) return false;
        if (status != null ? !status.equals(microInfo.status) : microInfo.status != null) return false;
        if (methodUrl != null ? !methodUrl.equals(microInfo.methodUrl) : microInfo.methodUrl != null) return false;
        return !(serviceName != null ? !serviceName.equals(microInfo.serviceName) : microInfo.serviceName != null);

    }

    @Override
    public int hashCode() {
        int result = IP != null ? IP.hashCode() : 0;
        result = 31 * result + url.hashCode();
        result = 31 * result + tags.hashCode();
        result = 31 * result + (logPath != null ? logPath.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (methodUrl != null ? methodUrl.hashCode() : 0);
        result = 31 * result + (serviceName != null ? serviceName.hashCode() : 0);
        return result;
    }

    public Document createDocumentInsert() {
        return new Document()
                .append("IP", IP)
                .append("url", url)
                .append("tags", tags)
                .append("logPath", logPath)
                .append("status", status)
                .append("methodUrl", methodUrl)
                .append("serviceName", serviceName);
    }


    public String getIP() {
        return IP;
    }

    public void setIP(String IP) {
        this.IP = IP;
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

    public String getMethodUrl() {
        return methodUrl;
    }

    public void setMethodUrl(String methodUrl) {
        this.methodUrl = methodUrl;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }
}
